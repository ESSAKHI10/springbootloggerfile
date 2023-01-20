package com.example.logtestapi.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.example.logtestapi.ReturnStatement.ResponseData;
import com.example.logtestapi.ReturnStatement.ReturnStatement;

@ControllerAdvice
public class FileUploadExceptionAdvice {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<ReturnStatement> handleMaxSizeException(
      MaxUploadSizeExceededException exc,
      HttpServletRequest request,
      HttpServletResponse response) {

    System.out.println("error ctching");
    ReturnStatement returnStatement = new ReturnStatement();
    returnStatement.setStatuesCode("0002");
    returnStatement.setStatusLabel("Exception file to large!");
    ResponseData responseData = new ResponseData();
    responseData.setAuth(false);
    returnStatement.setResponseData(responseData);
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
        .body(returnStatement);
  }
}