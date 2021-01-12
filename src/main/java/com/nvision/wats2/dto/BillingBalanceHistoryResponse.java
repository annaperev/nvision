package com.nvision.wats2.dto;

import lombok.*;

import java.util.List;

@Data
public class BillingBalanceHistoryResponse {

    List<BillingBalanceActivityDto> balanceActivity;
    String error;
}
