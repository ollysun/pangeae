package com.challenge.pangaea.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PublishMessage {
    @NotBlank(message="Please enter the message")
    private String message;
}
