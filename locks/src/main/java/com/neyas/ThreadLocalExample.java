package com.neyas;

public class ThreadLocalExample {
  private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

  public void increment() {
    threadLocal.set(threadLocal.get() + 1);
  }

  public int get() {
    return threadLocal.get();
  }
}
