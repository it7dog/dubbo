package com.dubbo.order.component.checkstock;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.context.OrderProcessContext;
import com.dubbo.entity.product.ProductEntity;
import com.dubbo.exception.CommonBizException;
import com.dubbo.exception.ExpCodeEnum;
import com.dubbo.facade.product.ProductService;
import com.dubbo.order.component.BaseComponent;
import com.dubbo.req.order.OrderInsertReq;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/7 下午1:17
 * @description 库存校验组件
 */
public class BaseCheckStockComponent extends BaseComponent {

    @Reference(version = "1.0.0")
    private ProductService productService;

    @Override
    public void handle(OrderProcessContext orderProcessContext) {
        preHandle(orderProcessContext);

        // 获取产品Entity的Map
        OrderInsertReq orderInsertReq = (OrderInsertReq) orderProcessContext.getOrderProcessReq().getReqData();
        Map<ProductEntity,Integer> prodEntityCountMap = orderInsertReq.getProdEntityCountMap();

        // 检查库存
        checkStock(prodEntityCountMap);

        afterHandle(orderProcessContext);
    }

    /**
     * 校验库存是否足够
     * @param prodEntityCountMap 产品-购买数量 集合
     */
    private void checkStock(Map<ProductEntity, Integer> prodEntityCountMap) {
        // 校验库存
        for (ProductEntity productEntity : prodEntityCountMap.keySet()) {
            // 获取购买量
            Integer count = prodEntityCountMap.get(productEntity);
            // 校验
            if (productEntity.getStock() < count) {
                throw new CommonBizException(ExpCodeEnum.STOCK_LOW);
            }
        }
    }

}
