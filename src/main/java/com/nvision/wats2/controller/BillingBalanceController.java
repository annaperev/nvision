package com.nvision.wats2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvision.wats2.dto.BillingBalanceHistoryResponse;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;
import java.time.LocalDateTime;

@Slf4j
@RestController
public class BillingBalanceController {
//2020-01-23T12:21:08.306Z

    @GetMapping(value = "/fbf.facade.billing/balancemanager/release/api/BalanceManagement/balanceActivity", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<JSONObject> getJob(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String identificationType,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'") LocalDateTime startDateTime,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'") LocalDateTime endDateTime,
            @RequestParam(required = false) String balanceActivityType) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            BillingBalanceHistoryResponse balanceHistory = mapper.readValue(Paths.get(
                    "/home/anna/Projects/nvision/src/main/resources/billingBalanceResponse.json").toFile(),
                    BillingBalanceHistoryResponse.class);

            JSONObject entity = new JSONObject();
            entity.put("balanceActivity", balanceHistory.getBalanceActivity());

            log.info(entity.toJSONString());

            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            JSONObject entity = new JSONObject();
            entity.put("что-то пошло не так", null);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
}
