package org.softuni.kaizer.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.kaizer.domain.models.binding.UserRegisterBindingModel;
import org.softuni.kaizer.domain.models.service.UserServiceModel;
import org.softuni.kaizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
