package services;

import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest request);
}