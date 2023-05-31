package com.sharenow.interview.vehicleservice.vehicleservice.resources;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSockerController {

    @MessageMapping("/application")
    @SendTo("/all/messages")
    public String replyToMessageFromClient(@Payload String message) {
        return String.format("Broadcasting message");
    }
}
