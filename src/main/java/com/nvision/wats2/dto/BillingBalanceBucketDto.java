package com.nvision.wats2.dto;

import lombok.Data;

@Data
public class BillingBalanceBucketDto {

    String id;
    String name;
    String bucketType;
    BillingBalanceAmountDto remainedAmount;
    String formattedCounterAmount;
}
