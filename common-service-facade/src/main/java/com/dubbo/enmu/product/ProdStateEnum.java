package com.dubbo.enmu.product;

import com.dubbo.enmu.BaseEnum;

/**
 * @description 产品状态的枚举类
 */
public enum ProdStateEnum implements BaseEnum {

  OPEN(1, "上架"),
  CLOSE(2, "下架");

  private int code;
  private String msg;

  ProdStateEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
