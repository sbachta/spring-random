package com.example.springrandom.integration;

import com.example.springrandom.common.MessagePublisher;
import com.example.springrandom.messaging.TestMessage;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.function.Consumer;

import static com.example.springrandom.common.MessageConstants.MEMO_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RandomIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

//    @Mock
    @MockitoBean
    private MessagePublisher<TestMessage> sender;

    @Autowired
    @Qualifier(MEMO_INPUT)
    protected Consumer<Message<TestMessage>> memoQueue;

    @Test
    void ShouldReturnSomeInterestingDataAndPublishMessages() throws Exception {

        String randomData = mockMvc.perform(get("/somedata"))
                                   .andExpect(status().isOk())
                                   .andExpect(content().string("something"))
                                   .andReturn()
                                   .getResponse()
                                   .getContentAsString();

//        ArgumentCaptor<Message> argumentCaptor = ArgumentCaptor.forClass(TestMessage.class);

//        verify(sender).publish(randomData, argumentCaptor.capture());
//        verify(sender).sendDelay("This is a delay message");

//        Message<TestMessage> message = argumentCaptor.getValue();

//        assertThat(message.getPayload()).isEqualTo(randomData);
    }

    @Test
    void shouldDoSomethingWhenMessageIsRead() {
        memoQueue.accept(MessageBuilder
                                 .withPayload(TestMessage.builder().build())
                                 .setHeader("", "")
                                 .build()
        );



    }
}
