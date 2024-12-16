package com.taskflow.service5.controller;

import com.taskflow.service5.dto.MeetingDTO;
import com.taskflow.service5.service.ZoomMeetingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meeting")
public class MeetingController {

    private final ZoomMeetingService zoomMeetingService;

    public MeetingController(ZoomMeetingService zoomMeetingService) {
        this.zoomMeetingService = zoomMeetingService;
    }

    @PostMapping("/new_meeting")
    public String createMeeting(@RequestBody MeetingDTO meetingDTO){
        return zoomMeetingService.createMeeting(meetingDTO.getTopic(),meetingDTO.getStartTime(),meetingDTO.getDuration());
    }
}
