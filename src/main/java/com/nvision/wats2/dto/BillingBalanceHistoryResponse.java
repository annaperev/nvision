package com.nvision.wats2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingBalanceHistoryResponse {

    @Getter
    @Setter
    private List<BillingBalanceActivityDto> balanceActivity = new ArrayList<>();
}
