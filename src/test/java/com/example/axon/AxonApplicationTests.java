package com.example.axon;

import com.example.axon.command.api.aggregate.UserAggregate;
import com.example.axon.command.api.commands.UserCommand;
import com.example.axon.command.api.events.UserEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AxonApplicationTests {

    private FixtureConfiguration<UserAggregate> fixture;

    @BeforeEach
    public void setUp() {
        fixture = new AggregateTestFixture<>(UserAggregate.class);
    }

    @Test
    public void testFirstFixture() {
        fixture.given(new UserEvent())
                .when(new UserCommand("3f312e39-03ce-4cc5-ae8e-861b3162e424", "abc", "xyz", "abc@xyz.com"))
                .expectEvents(new UserEvent("3f312e39-03ce-4cc5-ae8e-861b3162e424", "abc", "xyz", "abc@xyz.com"));
    }
}

