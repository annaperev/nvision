package com.nvision.wats2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvision.wats2.dto.BillingBalanceResponse;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
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

    @GetMapping(value = "/fbf.facade.billing/balancemanager/api/BalanceManagement/bucket", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<JSONObject> getJob(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String identificationType) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            BillingBalanceResponse balance = mapper.readValue(Paths.get(
                    "src/main/resources/billingBalanceResponse.json").toFile(),
                    BillingBalanceResponse.class);

            JSONObject entity = new JSONObject();
        entity.put("bucket", balance.getBucket());
        entity.put("error",balance.getError());

            log.info("BillingBalanceController is like: " + entity.toJSONString());

            return new ResponseEntity<>(entity, HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            JSONObject entity = new JSONObject();
            entity.put("что-то пошло не так", ex);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
}
