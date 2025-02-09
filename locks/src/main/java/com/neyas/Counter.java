package com.neyas;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
  private final AtomicInteger count = new AtomicInteger(0);

  public int increment() {
    return count.incrementAndGet();
  }

  public int getCount() {
    return count.get();
  }
}
