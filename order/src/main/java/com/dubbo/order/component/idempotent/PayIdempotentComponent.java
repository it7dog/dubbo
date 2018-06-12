package com.dubbo.order.component.idempotent;

import com.dubbo.enmu.order.OrderStateEnum;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/10 下午4:32
 *
 * @description 支付前的幂等性检查
 */
@Component
public class PayIdempotentComponent extends BaseIdempotencyComponent {
    @Override
    protected void setAllowStateList() {
        // 订单为INIT才允许支付
        this.allowStateList = Arrays.asList(OrderStateEnum.INIT);
    }
}
