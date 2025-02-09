package com.neyas.interview;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfAbsentCache {
  private final Map<Long, Long> factorialCache = new HashMap<>();

  public long computeFactorial(final long key) {
    return factorialCache.computeIfAbsent(key, this::factorial);
  }

  private long factorial(final long n) {
    if (n <= 1)
      return 1;

    if (factorialCache.containsKey(n))
      return factorialCache.get(n);

    return n * factorial(n - 1);
  }

  public static void main(final String... args) {
    ComputeIfAbsentCache cache = new ComputeIfAbsentCache();
    long startTime;
    for (long i = 5; i <= 150; i++) {
      startTime = System.nanoTime();
      System.out.println(cache.computeFactorial(i));
      System.out.println(i + " for Time taken: " + (System.nanoTime() - startTime) + " ns");
      startTime = System.nanoTime();
      System.out.println(cache.computeFactorial(i));
      System.out.println(i + " for Time taken: " + (System.nanoTime() - startTime) + " ns");
    }
    System.out.println("Cache: ");
  }
}
