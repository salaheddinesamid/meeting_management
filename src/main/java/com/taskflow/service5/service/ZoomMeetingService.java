package com.taskflow.service5.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZoomMeetingService {

    @Value("${zoom.api.base-url}")
    private String zoomBaseUrl;

    @Value("${zoom.api.token}")
    private String zoomToken;

    public String createMeeting(String topic, String startTime, int duration) {
        RestTemplate restTemplate = new RestTemplate();

        // Set Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(zoomToken);

        // Set Body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("topic", topic);
        requestBody.put("type", 2); // Scheduled meeting
        requestBody.put("start_time", startTime);
        requestBody.put("duration", duration);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Call API
        ResponseEntity<String> response = restTemplate.postForEntity(
                zoomBaseUrl + "/users/me/meetings",
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody(); // Contains meeting details
        } else {
            throw new RuntimeException("Failed to create Zoom meeting");
        }
    }
}
