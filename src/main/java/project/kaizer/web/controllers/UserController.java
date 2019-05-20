package project.kaizer.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.kaizer.domain.models.binding.UserRegisterBindingModel;
import project.kaizer.domain.models.service.UserServiceModel;
import project.kaizer.service.UserService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity register(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) throws URISyntaxException {
        boolean result = this.userService
                .createUser(this.modelMapper
                        .map(userRegisterBindingModel, UserServiceModel.class));

        return ResponseEntity.created(new URI("/users/register")).body(result);
    }

}
