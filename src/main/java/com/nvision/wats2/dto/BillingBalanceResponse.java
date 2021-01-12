package com.nvision.wats2.dto;

import lombok.Data;

import java.util.List;

@Data
public class BillingBalanceResponse {

    List<BillingBalanceBucketDto> bucket;
    BalanceErrorDto error;
}
