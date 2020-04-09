package com.shruthi.retail.controller;

import com.shruthi.retail.model.Order;
import com.shruthi.retail.service.OrderService;
import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Order findById(@PathVariable long id) {
    return service.findById(id);
  }

  @GetMapping("/customerId")
  public Collection<Order> findOrdersByCustomerId(@PathVariable("customerId") final long customerId) {
    return service.findOrdersByCustomerId(customerId);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Order updateOrder(@PathVariable("id") final long id, @RequestBody final Order order) {
    service.updateOrder(id,order);
    return order;
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public Order createOrder(@NotNull @Valid @RequestBody final Order order) {
    service.createOrder(order);
    return order;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public long deleteOrder(@PathVariable final long id) {
    service.deleteOrder(id);
    return id;
  }


}
