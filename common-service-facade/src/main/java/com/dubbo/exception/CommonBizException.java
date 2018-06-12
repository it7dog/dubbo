package com.dubbo.exception;

import java.io.Serializable;

/**
 * @author: wangw
 * @date: 2018/6/10 22:34
 * @description: 通用业务异常（由异常状态码区分不同的业务异常）
 */
public class CommonBizException extends RuntimeException implements Serializable {
  private ExpCodeEnum codeEnum;

  public CommonBizException(ExpCodeEnum codeEnum){
    super(codeEnum.getMessage());
    this.codeEnum = codeEnum;
  }

  public CommonBizException(){}

  public ExpCodeEnum getCodeEnum() {
    return codeEnum;
  }
}
