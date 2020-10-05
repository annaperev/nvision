package com.nvision.printstat.service;

import com.nvision.printstat.entity.Job;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface JobService {

    public List<Job> findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore(String user, String type, String device,
                                          LocalDateTime timeFrom, LocalDateTime timeTo);

    public Map<String, Integer> saveAllJobs(List<Job> jobs);
}
