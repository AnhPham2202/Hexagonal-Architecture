package anh.pham.iss.application.ports.output;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityOutput {
    Authentication getAuthentication();
}
