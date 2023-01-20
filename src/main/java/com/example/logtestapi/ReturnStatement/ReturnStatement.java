package com.example.logtestapi.ReturnStatement;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ReturnStatement {
    private String statuesCode;
    private String statusLabel;
    private ResponseData responseData;

}
