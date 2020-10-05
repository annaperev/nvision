package com.nvision.printstat.repository;

import com.nvision.printstat.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JobRepositoryCustom {
    List<Job> findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore (String user, String type, String device,
                                          LocalDateTime timeFrom,LocalDateTime timetTo);

}
