package com.neyas;

import io.vavr.control.Try;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExceptionHandling {
  public static void main(String[] args) {
    List<String> data = Arrays.asList("1", "2", "three", "4");

    List<Integer> result = data.stream()
        .map(s -> Try.of(() -> Integer.parseInt(s)).getOrElse(-1))
        .collect(Collectors.toList());

    System.out.println(result);
  }
}
