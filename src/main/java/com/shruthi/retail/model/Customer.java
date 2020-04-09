package com.shruthi.retail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class Customer {

  private long customerId;

  private String firstName;

  private String lastName;

  private long phoneNumber;

}
