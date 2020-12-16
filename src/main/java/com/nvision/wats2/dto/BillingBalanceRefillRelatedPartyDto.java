package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingBalanceRefillRelatedPartyDto {

    private String action;
    private BillingBalanceRefillAdditionalPartyIdentificationDto additionalPartyIdentification;
}
