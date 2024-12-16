package com.taskflow.service5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer meetingId;

    @Column(name = "meeting_name")
    String meetingName;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @ElementCollection
    List<Integer> meetingMembers;

    @Column(name = "createdBy")
    Integer createdByUserId;

}
