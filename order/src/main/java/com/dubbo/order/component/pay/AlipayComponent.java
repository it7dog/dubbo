package com.dubbo.order.component.pay;

import com.dubbo.context.OrderProcessContext;
import com.dubbo.order.component.BaseComponent;
import org.springframework.stereotype.Component;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/9 下午3:29
 * @description
 */
@Component
public class AlipayComponent extends BaseComponent {

    @Override
    public void preHandle(OrderProcessContext orderProcessContext) {

    }

    @Override
    public void handle(OrderProcessContext orderProcessContext) {
        // TODO
    }

    @Override
    public void afterHandle(OrderProcessContext orderProcessContext) {

    }
}
