package com.example.axon.query.api.projection;

import com.example.axon.common.entity.User;
import com.example.axon.common.model.UserRestModel;
import com.example.axon.common.repository.UserRepository;
import com.example.axon.query.api.queries.GetUserQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserProjection {
    private UserRepository userRepository;

    public UserProjection(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryHandler
    public List<UserRestModel> handle(GetUserQuery getUserQuery) {
        List<User> userList = userRepository.findAll();
        List<UserRestModel> response = userList.stream()
                .map(u -> UserRestModel.builder()
                        .id(u.getId())
                        .name(u.getName())
                        .address(u.getAddress())
                        .email(u.getEmail())
                        .build())
                .collect(Collectors.toList());
        return response;
    }
}
