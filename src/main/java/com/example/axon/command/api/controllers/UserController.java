package com.example.axon.command.api.controllers;

import com.example.axon.command.api.dao.UserCommandDao;
import com.example.axon.common.model.UserRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/command")
public class UserController {
    private HttpStatus httpStatus = null;
    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private UserCommandDao userCommandDao;

    public UserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/save/user")
    public ResponseEntity<String> save(@RequestBody UserRestModel userRestModel) {
        return userCommandDao.save(userRestModel);
    }
}
