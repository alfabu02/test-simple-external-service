package com.example.testsimpleexternalservice.component;

import com.example.testsimpleexternalservice.util.PrincipalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Auditing implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            return Optional.ofNullable(PrincipalUtil.getCurrentUser().getId());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
