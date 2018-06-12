package com.dubbo.exception;

import java.io.Serializable;

/**
 * @author: wangw
 * @date: 2018/6/10 22:35
 * @description: 通用系统异常
 */
public class CommonSysException extends RuntimeException implements Serializable {
  private ExpCodeEnum codeEnum;

  public CommonSysException(ExpCodeEnum codeEnum) {
    super(codeEnum.getMessage());
    this.codeEnum = codeEnum;
  }

  public CommonSysException() {

  }
}
