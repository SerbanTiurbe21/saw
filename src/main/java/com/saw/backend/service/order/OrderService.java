package com.saw.backend.service.order;

import com.saw.backend.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Integer orderId);
    void deleteOrder(Integer orderId);
}
