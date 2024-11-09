package com.neyas;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.util.List;
import java.util.stream.IntStream;

public class ListPartition {

  @Benchmark
  @Fork(value = 1, warmups = 2)
  @BenchmarkMode(Mode.Throughput)
  public void init() {
    // Do nothing
  }

  @Benchmark
  public void usingGuava() {
    List<Integer> intList = IntStream.rangeClosed(0, 10).boxed().toList();
    Lists.partition(intList, 3);
  }

  @Benchmark
  public void usingApache() {
    List<Integer> intList = IntStream.rangeClosed(0, 10).boxed().toList();
    ListUtils.partition(intList, 3);
  }

  public static void main(String[] args) {
    ListPartition listPartition = new ListPartition();
    listPartition.usingGuava();
    listPartition.usingApache();
  }
}
