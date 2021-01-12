package com.nvision.wats2.dto;

import lombok.Data;

@Data
public class BalanceErrorDto {

    String code;
    String reason;
    String message;
    String status;
    
}
