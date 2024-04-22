package com.realstate.core.service;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service class for sending messages to Slack channels using webhooks.
 * Author: [Aashish Karki]
 */
@Service
@Slf4j
public class SlackNotifierService {
    private final String webhookUrl;

    /**
     * Constructor to initialize the SlackNotifierService with the webhook URL.
     *
     * @param webhookUrl The webhook URL for sending messages to Slack channels.
     */
    public SlackNotifierService(@Value("${slack.webhookUrl}") String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    /**
     * Sends a message to a Slack channel using the configured webhook URL.
     *
     * @param message The message content to be sent.
     */
    public void sendMessage(String message) {
        try {
            Slack slack = Slack.getInstance();
            Payload payload = Payload.builder().text(message).build();
            log.debug("send request to slack with: {}", payload);
            WebhookResponse response = slack.send(webhookUrl, payload);
            log.debug("{}, code: {}, body: {}", response.getMessage(), response.getCode(), response.getBody());
        } catch (Exception e) {
            log.error("Error while sending message : {}", e.getMessage());
        }
    }
}
