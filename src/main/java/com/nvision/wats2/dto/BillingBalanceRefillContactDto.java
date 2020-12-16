package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingBalanceRefillContactDto {

    @JsonProperty("$type")
    private String type;
    private String emailAddress;

}
