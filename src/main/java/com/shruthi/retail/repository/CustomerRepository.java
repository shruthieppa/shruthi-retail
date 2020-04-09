package com.shruthi.retail.repository;

import com.shruthi.retail.model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

  private Map<Long, Customer> customers = new HashMap<>();

  public Optional<Customer> findById(long id) {
    return Optional.ofNullable(customers.get(id));
  }

  public void add(Customer customer) {
    customers.put(customer.getCustomerId(), customer);
  }

  public void update(Customer customer) {
    customers.put(customer.getCustomerId(), customer);
  }

  public void remove(long id) {
    customers.remove(id);
  }

  public Collection<Customer> getCustomers() {
    return customers.values();
  }


}
