package com.example.axon.query.api.controller;

import com.example.axon.common.model.UserRestModel;
import com.example.axon.query.api.queries.GetUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/query")
public class UserQueryController {

    private QueryGateway queryGateway;

    public UserQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }


    @GetMapping("get/user")
    public List<UserRestModel> get() {
        GetUserQuery getUserQuery = new GetUserQuery();
        return queryGateway.query(getUserQuery, ResponseTypes.multipleInstancesOf(UserRestModel.class)).join();
    }
}
