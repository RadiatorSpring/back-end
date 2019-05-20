package project.kaizer.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import project.kaizer.domain.models.service.UserServiceModel;

import java.util.Set;

public interface UserService extends UserDetailsService {
    boolean createUser(UserServiceModel userServiceModel);

    Set<UserServiceModel> getAll();
}
