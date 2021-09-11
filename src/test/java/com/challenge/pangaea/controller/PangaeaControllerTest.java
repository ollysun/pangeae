package com.challenge.pangaea.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

import com.challenge.pangaea.model.PublishMessage;
import com.challenge.pangaea.services.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PangaeaController.class})
@ExtendWith(SpringExtension.class)
public class PangaeaControllerTest {
    @Autowired
    private PangaeaController pangaeaController;

    @MockBean
    private Publisher publisher;

    @Test
    public void testSendPublishMessage() throws Exception {
        doNothing().when(this.publisher).sendMessage((PublishMessage) any(), (String) any());

        PublishMessage publishMessage = new PublishMessage();
        publishMessage.setMessage("Not all who wander are lost");
        String content = (new ObjectMapper()).writeValueAsString(publishMessage);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pangaea/publish/{topicId}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.pangaeaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

