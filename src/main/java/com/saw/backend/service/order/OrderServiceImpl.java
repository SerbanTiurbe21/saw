package com.saw.backend.service.order;

import com.saw.backend.dto.OrderDTO;
import com.saw.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO saveOrder(OrderDTO order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        return orderRepository.findById(Math.toIntExact(orderId)).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(Math.toIntExact(orderId));
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Integer userId) {
        return orderRepository.findOrderDTOByUser_UserId(Math.toIntExact(userId));
    }
}
