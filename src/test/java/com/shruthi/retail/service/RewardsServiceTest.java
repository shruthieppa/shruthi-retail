package com.shruthi.retail.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

import com.shruthi.retail.model.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest {

  @InjectMocks
  RewardsService rewardsService;

  @Mock
  private OrderService mockOrderService;

  @Test
  void findByCustomerId_whenAmountIsGreaterThan100() {
    List<Order> orders = new ArrayList<>();
    Order order = new Order();
    order.setCustomerId(123);
    order.setAmount(120);
    orders.add(order);
    doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
    long points = rewardsService.findByCustomerId(123L);
    assertEquals(90, points);
  }

  @Test
  void findByCustomerId_whenAmountIsBetween50And100() {
    List<Order> orders = new ArrayList<>();
    Order order = new Order();
    order.setCustomerId(123);
    order.setAmount(80);
    orders.add(order);
    doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
    long points = rewardsService.findByCustomerId(123L);
    assertEquals(30, points);
  }

  @Test
  void findByCustomerId_whenAmountIsLessThan50() {
    List<Order> orders = new ArrayList<>();
    Order order = new Order();
    order.setCustomerId(123);
    order.setAmount(40);
    orders.add(order);
    doReturn(orders).when(mockOrderService).findOrdersByCustomerId(anyLong());
    long points = rewardsService.findByCustomerId(123L);
    assertEquals(0, points);
  }
}
