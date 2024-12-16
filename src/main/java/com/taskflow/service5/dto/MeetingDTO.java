package com.taskflow.service5.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MeetingDTO {

    Integer meetingId;
    String meetingName;
    Date startDate;
    Date endDate;
    List<Integer> members;
    Integer createdByUserId;
    public MeetingDTO(
            Integer meetingId,
            String meetingName,
            Date startDate,
            Date endDate,
            List<Integer> members,
            Integer createdByUserId
    ){
        this.meetingId = meetingId;
        this.meetingName =meetingName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.members = members;
        this.createdByUserId = createdByUserId;
    }
}
