package com.projectincremental.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ErrorMessage", description = "Message explaining the error")
public class ErrorMessage {

    @ApiModelProperty(value = "error message")
    private String message;

    @ApiModelProperty(value = "error code")
    private String code;

    public ErrorMessage() {}

    public ErrorMessage(String message, String code) {
        super();
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
