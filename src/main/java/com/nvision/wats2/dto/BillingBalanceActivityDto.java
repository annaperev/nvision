package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BillingBalanceActivityDto {

    private String type;

    private String date;

    private String action;

    private BillingBalanceAmountDto amount;

    private String bucketCode;

    private String bucketBalance;

    private BillingBalanceAmountDto amountAfter;

    private String id;

    private String paymentAttributes;
}
