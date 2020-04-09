package com.shruthi.retail.controller;

import com.shruthi.retail.service.RewardsService;
import java.time.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

  final RewardsService rewardsService;

  public RewardsController(RewardsService rewardsService) {
    this.rewardsService = rewardsService;
  }

  @GetMapping("/{orderId}")
  public long findByOrderId(@PathVariable long orderId) {
    return rewardsService.findByOrderId(orderId);
  }


  @GetMapping("/{customerId}")
  public long findByCustomerId(@PathVariable long customerId) {
    return rewardsService.findByCustomerId(customerId);
  }

  @GetMapping("/{customerId}/{month}")
  public long findByCustomerIdAndMonth(@PathVariable long customerId,@PathVariable Month month) {
    return rewardsService.findByCustomerIdAndMonth(customerId, month);
  }

 }
