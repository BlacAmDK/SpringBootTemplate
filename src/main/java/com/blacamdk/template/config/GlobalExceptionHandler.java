package com.blacamdk.template.config;

import com.blacamdk.template.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(RuntimeException.class)
  public Result runtimeExceptionHandle(RuntimeException e) {
    if (Arrays.stream(e.getStackTrace())
        .parallel()
        .anyMatch(
            stackTraceElement ->
                stackTraceElement.getClassName().equals("com.google.common.base.Preconditions"))) {
      return Result.fail(e.getMessage());
    }
    LOGGER.error(e.getLocalizedMessage(), e);
    return Result.fail("未知错误");
  }
}
