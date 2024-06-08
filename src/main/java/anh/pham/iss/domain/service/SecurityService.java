package anh.pham.iss.domain.service;

import anh.pham.iss.application.ports.output.SecurityOutput;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityService implements SecurityOutput {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
