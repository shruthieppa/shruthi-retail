package com.shruthi.retail.service;

import com.shruthi.retail.model.Order;
import java.time.Month;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class RewardsService {

  OrderService orderService;

  public RewardsService(OrderService orderService) {
    this.orderService = orderService;
  }

  public long findByOrderId(long orderId) {
    return getRewardsByOrder(orderService.findById(orderId));
  }

  public long findByCustomerIdAndMonth(long customerId, Month month) {
    long rewards = 0;
    Collection<Order> orders = orderService.findOrdersByCustomerIdAndMonth(customerId, month);
    for (Order ord : orders) {
      rewards = rewards + getRewardsByOrder(ord);
    }
    return rewards;
  }

  public long findByCustomerId(long customerId) {
    long rewards = 0;
    Collection<Order> orders = orderService.findOrdersByCustomerId(customerId);
    for (Order ord : orders) {
      rewards = rewards + getRewardsByOrder(ord);
    }
    return rewards;
  }


  private long getRewardsByOrder(Order order) {
    long points = 0;
    if (order.getAmount() <= 50) {
      return points;
    }
    if (order.getAmount() > 50 && order.getAmount() <= 100) {
      points = Math.round(Math.ceil(order.getAmount()) - 50);
      return points;
    }
    points = Math.round(Math.ceil(order.getAmount()) - 100) * 2;
    points = points + 50;
    return points;
  }


}
