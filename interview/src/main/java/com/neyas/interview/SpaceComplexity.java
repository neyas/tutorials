package com.neyas.interview;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SpaceComplexity {
  public static void main(String[] args) {
    List<Customer> customers = new ArrayList<>();
    Random random = new Random();
    IntStream.rangeClosed(1, 100_000_000).forEach(i -> {
      Status status = random.nextBoolean() ? Status.ACTIVE : Status.INACTIVE;
      customers.add(new Customer(status));
    });
    System.out.println(customers.size());
    System.out.println("efficient approach");
    benchmark(() -> removeInactiveCustomersEfficiently(customers));
    System.out.println("existing approach");
    benchmark(() -> removeInactiveCustomers(customers));
  }

  private static List<Customer> removeInactiveCustomersEfficiently(List<Customer> customers) {
    int leftPointer = 0;
    for (int rightPointer = 0; rightPointer < customers.size(); rightPointer++) {
      if (customers.get(rightPointer).status() != Status.INACTIVE) {
        customers.set(leftPointer, customers.get(rightPointer));
        leftPointer++;
      }
    }
    customers = customers.subList(0, leftPointer);
    return customers;
  }

  private static List<Customer> removeInactiveCustomers(List<Customer> customers) {
    return customers.stream().filter(customer -> !customer.status().equals(Status.INACTIVE)).toList();
  }

  private static void benchmark(Runnable task) {
    Instant start = Instant.now();
    Runtime runtime = Runtime.getRuntime();
    runtime.gc();
    long beforeMemory = runtime.totalMemory();
    task.run();
    long afterMemory = runtime.totalMemory();
    Instant end = Instant.now();

    Duration duration = Duration.between(start, end);
    long execTime = duration.toMillis();
    double memoryUsage = (afterMemory - beforeMemory) / (1024.0 * 1024.0);

    System.out.println("exec time in millis " + execTime);
    System.out.println("total memory in gb " + memoryUsage);
  }

  record Customer(Status status) {
  }


  enum Status {
    ACTIVE,
    INACTIVE
  }
}
