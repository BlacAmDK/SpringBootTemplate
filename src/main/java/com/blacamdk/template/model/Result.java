package com.blacamdk.template.model;

public class Result {

  private int code;
  private String message;
  private Object data;

  public static Result ok() {
    return ok(null);
  }

  public static Result ok(String msg) {
    return createResultAndData(200, msg, null);
  }


  public static Result ok(Object data) {
    return createResultAndData(200, "请求成功", data);
  }

  public static Result ok(Object data, String msg) {
    return createResultAndData(200, msg, data);
  }

  public static Result fail(String msg) {
    return createResultAndData(500, msg, null);
  }

  public static Result fail(int code, String msg) {
    return createResultAndData(code, msg, null);
  }

  public static boolean checkOk(Result result) {
    if (result == null) {
      return false;
    }
    return result.getCode() == 200;
  }

  public static boolean checkFail(Result result) {
    return !checkOk(result);
  }

  private static Result createResultAndData(int code, String result, Object data) {
    return new Result(code, result, data);
  }

  private Result(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }


  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
