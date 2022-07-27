package com.example.axon.command.api.dao;

import com.example.axon.command.api.commands.UserCommand;
import com.example.axon.common.model.UserRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserCommandDao {

    @Autowired
    private CommandGateway commandGateway;
    private HttpStatus httpStatus = null;

    public UserCommandDao(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public ResponseEntity<String> save(UserRestModel userRestModel) {
        UserCommand userCommand = UserCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(userRestModel.getName())
                .address(userRestModel.getAddress())
                .email(userRestModel.getEmail())
                .build();
        String result = commandGateway.sendAndWait(userCommand);
        if (Objects.nonNull(result)) {
            httpStatus = HttpStatus.CREATED;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, httpStatus);
    }

}
