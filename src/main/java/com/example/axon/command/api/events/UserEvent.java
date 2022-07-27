package com.example.axon.command.api.events;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEvent {
    private String id;
    private String name;
    private String address;
    private String email;

}
