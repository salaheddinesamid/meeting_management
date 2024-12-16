package com.taskflow.service5.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class MeetingDTO {

    private String topic;
    private String startTime;
    private Integer duration;

}
