package com.dubbo.order.component.changestate;

import com.dubbo.enmu.order.OrderStateEnum;
import org.springframework.stereotype.Component;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/10 下午5:08
 * @description
 */
@Component
public class CancelChangeStateComponent extends BaseChangeStateComponent {

    @Override
    public void setTargetOrderState() {
        this.targetOrderState = OrderStateEnum.CANCEL;
    }
}
