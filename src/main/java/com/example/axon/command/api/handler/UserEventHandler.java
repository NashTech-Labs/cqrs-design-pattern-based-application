package com.example.axon.command.api.handler;

import com.example.axon.command.api.events.UserEvent;
import com.example.axon.common.repository.UserRepository;
import com.example.axon.common.entity.User;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    private UserRepository userRepository;

    public UserEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(UserEvent userEvent) {
        User user = new User();
        BeanUtils.copyProperties(userEvent, user);
        userRepository.save(user);
    }
}
