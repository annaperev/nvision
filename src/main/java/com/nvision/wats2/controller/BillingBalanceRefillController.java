package com.nvision.wats2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvision.wats2.dto.BillingBalanceRefillRequestDto;
import com.nvision.wats2.dto.BillingBalanceRefillResponse;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;


@Slf4j
@RestController
public class BillingBalanceRefillController {

    @PostMapping(value = "/fbf.facade.billing/documentmanager/api/DocumentManagement/document",
            consumes = MediaType.ALL_VALUE)
    public ResponseEntity<BillingBalanceRefillResponse> balanceRefill(@RequestBody BillingBalanceRefillRequestDto dto) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            BillingBalanceRefillResponse response = mapper.readValue(Paths.get(
                    "/home/anna/Projects/nvision/src/main/resources/billingRefillResponse.json").toFile(),
                    BillingBalanceRefillResponse.class);

            JSONObject entity = new JSONObject();
            entity.put("requestId", response.getRequestId());
            entity.put("docLink", response.getDocLink());
            entity.put("error", response.getError());
            entity.put("state", response.getState());

            log.info(entity.toJSONString());

            return new ResponseEntity(entity, HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            JSONObject entity = new JSONObject();
            entity.put("что-то пошло не так",null);
            return new ResponseEntity(entity, HttpStatus.OK);
        }
    }
}
