package com.taskflow.service5.repository;

import com.taskflow.service5.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting,Integer> {
}
