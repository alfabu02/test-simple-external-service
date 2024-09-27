package com.example.testsimpleexternalservice.util;

import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.security.MyUserDetails;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class PrincipalUtil {

    public static User getCurrentUser() {
        return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

}
