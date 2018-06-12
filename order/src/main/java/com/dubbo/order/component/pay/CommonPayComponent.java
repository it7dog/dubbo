package com.dubbo.order.component.pay;

import com.dubbo.context.OrderProcessContext;
import com.dubbo.enmu.order.PayModeEnum;
import com.dubbo.exception.CommonBizException;
import com.dubbo.exception.CommonSysException;
import com.dubbo.exception.ExpCodeEnum;
import com.dubbo.order.component.BaseComponent;
import com.dubbo.req.order.OrderInsertReq;
import com.dubbo.utils.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/7 下午1:20
 *
 * @description 通用支付组件
 * 它会根据请求中的"支付类型"，选择相应的支付组件
 */
@Component
public class CommonPayComponent extends BaseComponent {

    @Autowired
    private AlipayComponent alipayComponent;
    @Autowired
    private WechatPayComponent wechatPayComponent;
    @Autowired
    private UnionPayComponent unionPayComponent;

    @Override
    public void handle(OrderProcessContext orderProcessContext) {
        preHandle(orderProcessContext);

        // 处理支付请求
        doPay(orderProcessContext);

        afterHandle(orderProcessContext);
    }


    /**
     * 处理支付请求
     * @param orderProcessContext 订单受理上下文
     */
    private void doPay(OrderProcessContext orderProcessContext) {
        // 获取支付方式
        PayModeEnum payModeEnum = getPayModeEnum(orderProcessContext);

        switch (payModeEnum) {
            case ALIPAY:
                alipayComponent.handle(orderProcessContext);
                break;
            case WECHAT:
                wechatPayComponent.handle(orderProcessContext);
                break;
            case UNIONPAY:
                unionPayComponent.handle(orderProcessContext);
                break;
        }

    }

    /**
     * 获取支付方式
     * @param orderProcessContext
     * @return
     */
    private PayModeEnum getPayModeEnum(OrderProcessContext orderProcessContext) {
        // 获取OrderInsertReq
        OrderInsertReq orderInsertReq = (OrderInsertReq) orderProcessContext.getOrderProcessReq().getReqData();

        // 获取支付方式Code
        Integer payModeCode = orderInsertReq.getPayModeCode();
        if (payModeCode == null) {
            throw new CommonSysException(ExpCodeEnum.PAYMODE_NULL);
        }

        // 获取支付方式
        PayModeEnum payModeEnum = EnumUtil.codeOf(PayModeEnum.class, payModeCode);
        if (payModeEnum == null) {
            throw new CommonBizException(ExpCodeEnum.PAYMODECODE_ERROR);
        }
        return payModeEnum;
    }

}
