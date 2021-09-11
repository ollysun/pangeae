package com.challenge.pangaea.controller;

import com.challenge.pangaea.model.PublishMessage;
import com.challenge.pangaea.services.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pangaea")
@Validated
public class PangaeaController {

    private final Publisher publisher;

    @PostMapping(value = "/publish/{topicId}")
    @ResponseStatus(HttpStatus.OK)
    public void sendPublishMessage(@PathVariable String topicId,  @RequestBody @Valid PublishMessage publishMessage) {
        publisher.sendMessage(publishMessage, topicId);
    }


}
