package com.nvision.printstat.service;

import com.nvision.printstat.entity.Job;
import com.nvision.printstat.repository.JobRepository;
import com.nvision.printstat.repository.JobRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore(String user, String type, String device,
                                                LocalDateTime timeFrom, LocalDateTime timeTo) {
        return jobRepository.findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore(user,type,device,timeFrom,timeTo);
    }


    public Map<String, Integer> saveAllJobs(List<Job> jobs) {

        for (Job job : jobs) {
            job.setTime(LocalDateTime.now());
        }
        jobRepository.saveAll(jobs);

        return jobs.stream().collect(
                Collectors.groupingBy(Job::getUser,
                        Collectors.summingInt(Job::getAmount))
        );
    }
}
