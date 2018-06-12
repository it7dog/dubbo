package com.dubbo.order.processor;

import com.dubbo.order.annotation.InjectComponents;
import com.dubbo.order.component.BaseComponent;
import com.dubbo.order.component.changestate.CancelChangeStateComponent;
import com.dubbo.order.component.checkparam.NoPrivateCheckParamComponent;
import com.dubbo.order.component.idempotent.CancelOrderIdempotentComponent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/10 下午4:59
 *
 * @description 取消订单
 */
@Component
public class CancelOrderProcessor extends Processor {

    @InjectComponents({
            // 参数校验
            NoPrivateCheckParamComponent.class,
            // 幂等检查
            CancelOrderIdempotentComponent.class,
            // 状态流转
            CancelChangeStateComponent.class
    })
    /** 业务组件列表(当前处理器需要处理的组件列表) */
    protected List<BaseComponent> componentList;

    @Override
    protected void overrideSuperComponentList() {
        super.componentList = this.componentList;
    }
}
