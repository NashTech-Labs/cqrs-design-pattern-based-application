package com.example.axon.command.api.aggregate;

import com.example.axon.command.api.commands.UserCommand;
import com.example.axon.command.api.events.UserEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String address;
    private String email;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(UserCommand userCommand) {
        UserEvent userEvents = new UserEvent();
        BeanUtils.copyProperties(userCommand, userEvents);
        AggregateLifecycle.apply(userEvents);
    }

    @EventSourcingHandler
    public void on(UserEvent userEvents) {
        this.id = userEvents.getId();
        this.name = userEvents.getName();
        this.address = userEvents.getAddress();
        this.email = userEvents.getEmail();

    }
}
