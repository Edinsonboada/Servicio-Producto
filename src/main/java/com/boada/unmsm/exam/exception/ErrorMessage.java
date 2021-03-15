package com.boada.unmsm.exam.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ErrorMessage {

    private int statusCode;
    private String errorMessage;
}
