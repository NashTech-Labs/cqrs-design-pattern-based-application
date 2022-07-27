package com.example.axon.command.api.commands;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserCommand {
    @TargetAggregateIdentifier
    private String id;
    private String name;
    private String address;
    private String email;

}
