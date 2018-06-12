package com.dubbo.enmu.order;

import com.dubbo.enmu.BaseEnum;

public enum PayModeEnum  implements BaseEnum {

  ALIPAY(1,"支付宝"),
  WECHAT(2,"微信支付"),
  UNIONPAY(3,"银联支付"),
  ;

  private int code;
  private String msg;

  PayModeEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }


  @Override
  public int getCode() {
    return 0;
  }

  @Override
  public String getMsg() {
    return null;
  }
}
