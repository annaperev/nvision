package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BillingBalanceHistoryPaymentAttributes {

    private String name;
    private String value;

}
