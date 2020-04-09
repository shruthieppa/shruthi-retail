package com.shruthi.retail.model;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Order {

  private long orderId;

  private long customerId;

  private LocalDate date;

  private double amount;


}
