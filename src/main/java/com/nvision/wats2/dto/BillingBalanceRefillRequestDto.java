package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingBalanceRefillRequestDto {

    @JsonProperty("$type")
    private String type;
    private BillingBalanceRefillRelatedPartyDto relatedParty;
    private List<BillingBalanceRefillDocumentCharacteristicDto> documentCharacteristics;
    private String format;
    private Integer validFor;
    private boolean streaming;
    private String deliveryType;
    private BillingBalanceRefillContactDto contact;
    private BillingBalanceAmountDto amount;

}
