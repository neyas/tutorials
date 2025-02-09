package com.neyas;

import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {
  private final int[] numbers;
  private final int start, end;
  private static final int THRESHOLD = 10;

  public ForkJoinExample(int[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Integer compute() {
    if (end - start < THRESHOLD) {
      int sum = 0;
      for (int i = start; i < end; i++) {
        sum += numbers[i];
      }
      return sum;
    }
    else {
      int middle = (start + end) / 2;
      ForkJoinExample left = new ForkJoinExample(numbers, start, middle);
      ForkJoinExample right = new ForkJoinExample(numbers, middle, end);
      invokeAll(left, right);
      return left.join() + right.join();
    }
  }

  public static void main(String[] args) {
    int[] numbers = new int[8000];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }
    ForkJoinExample forkJoinExample = new ForkJoinExample(numbers, 0, numbers.length);
    System.out.println(forkJoinExample.compute());
  }
}
