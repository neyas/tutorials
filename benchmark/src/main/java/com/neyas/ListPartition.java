package com.neyas;

import com.google.common.collect.Lists;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

public class ListPartition {

  @Benchmark
  public void givenList_whenPartitionIntoNSubLists_thenCorrect() {
    List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    Lists.partition(intList, 3);
  }
}
