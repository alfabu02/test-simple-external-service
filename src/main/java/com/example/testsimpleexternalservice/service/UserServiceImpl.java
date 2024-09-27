package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.exception.MyConflictException;
import com.example.testsimpleexternalservice.exception.MyForbiddenException;
import com.example.testsimpleexternalservice.exception.MyNotFoundException;
import com.example.testsimpleexternalservice.mapper.UserMapper;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.user.CreateUserDto;
import com.example.testsimpleexternalservice.payload.user.LoginDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import com.example.testsimpleexternalservice.repository.UserRepository;
import com.example.testsimpleexternalservice.security.JwtProvider;
import com.example.testsimpleexternalservice.util.FileUtil;
import com.example.testsimpleexternalservice.util.PrincipalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MyUserDetailsService myUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse<UserDto> createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByEmailIgnoreCase(createUserDto.email()))
            throw new MyConflictException("This email address is already in use");

        User user = userMapper.toDocument(createUserDto);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(createUserDto.password()));

        if (createUserDto.image() != null) {
            String writeFileUniqueName = FileUtil.writeFile(createUserDto.image());
            user.setImageUrl(writeFileUniqueName);
        }

        userRepository.save(user);
        UserDto userDto = userMapper.toDto(user);

        return ApiResponse.success(userDto);
    }

    @Override
    public ApiResponse<List<UserDto>> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = userMapper.toDtoList(users);
        return ApiResponse.success(userDtoList);
    }

    @Override
    public ApiResponse<String> login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password()));

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginDto.email());

        String email = userDetails.getUsername();
        String token = jwtProvider.createToken(email);

        return ApiResponse.success(token);
    }
}
