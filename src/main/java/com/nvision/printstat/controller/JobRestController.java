package com.nvision.printstat.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nvision.printstat.entity.Job;
import com.nvision.printstat.service.JobService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/api/statistics", produces = MediaType.APPLICATION_JSON_VALUE)

    public @ResponseBody ResponseEntity<List<JSONObject>> getJob(@RequestParam(required = false) String user,
                            @RequestParam(required = false) String type,
                            @RequestParam(required = false) String device,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime timeFrom,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime timeTo) {

        List<Job> filteredJobList = jobService.findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore(user, type, device,
                timeFrom, timeTo);

        List<JSONObject> entities = new ArrayList<>();
        for (Job job : filteredJobList) {
            JSONObject entity = new JSONObject();
            entity.put("jobId", job.getId());
            entity.put("device", job.getDevice());
            entity.put("user", job.getUser());
            entity.put("type", job.getType());
            entity.put("amount", job.getAmount());
            entity.put("time", job.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            entities.add(entity);
        }

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }


    @PostMapping(value = "/api/jobs", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<JSONObject> saveJobs(@RequestBody List<Job> jobs) {
        Map<String, Integer> processedAmountSumGroupedByUser = jobService.saveAllJobs(jobs);

        JSONObject jsonObject = new JSONObject();
        processedAmountSumGroupedByUser.forEach(jsonObject::put);

        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }
}
