package com.taskflow.service5.service;

import com.taskflow.service5.dto.MeetingDTO;
import com.taskflow.service5.model.Meeting;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    public ResponseEntity<Object> createMeeting(MeetingDTO meetingDTO){
        Meeting meeting = new Meeting();
        meeting.setMeetingName(meetingDTO.getMeetingName());
        meeting.setMeetingMembers(meetingDTO.getMembers());
        meeting.setCreatedByUserId(meeting.getCreatedByUserId());
        meeting.setStartDate(meetingDTO.getStartDate());
        meeting.setEndDate(meetingDTO.getEndDate());
        return new ResponseEntity<>("Meeting created", HttpStatus.OK);
    }
}
