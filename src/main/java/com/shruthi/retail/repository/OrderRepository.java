package com.shruthi.retail.repository;

import com.shruthi.retail.model.Order;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

  private Map<Long, Order> orders = new HashMap<>();

  public Optional<Order> findById(long id) {
    return Optional.ofNullable(orders.get(id));
  }

  public void add(Order order) {
    orders.put(order.getOrderId(), order);
  }

  public void update(Order order) {
    orders.put(order.getOrderId(), order);
  }

  public void remove(long id) {
    orders.remove(id);
  }

  //instead of map will fetch records from database by customerId
  public Collection<Order> getOrders(long customerId) {
    return orders.values();
  }

  //instead of map will fetch records from database by customerId and monthValue
  public Collection<Order> getOrders(long customerId, long monthValue) {
    return orders.values();
  }

}
