package com.shruthi.retail.service;

import com.shruthi.retail.exception.OrderNotFoundException;
import com.shruthi.retail.model.Order;
import com.shruthi.retail.repository.OrderRepository;
import java.time.Month;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public Order findById(long id) {
    return repository.findById(id)
        .orElseThrow(OrderNotFoundException::new);
  }

  public Collection<Order> findOrdersByCustomerId(long customerId) {
    return repository.getOrders(customerId);
  }

  public Collection<Order> findOrdersByCustomerIdAndMonth(long customerId, Month month) {
      return repository.getOrders(customerId, month.getValue());
    }

  public Order updateOrder(long id, Order order) {
    if (repository.findById(id).isPresent()) {
      repository.update(order);
    } else {
      repository.add(order);
    }
    return order;
  }

  public Order createOrder(Order order) {
    repository.add(order);
    return order;
  }

  public long deleteOrder(long id) {
    repository.remove(id);
    return id;
  }

}
