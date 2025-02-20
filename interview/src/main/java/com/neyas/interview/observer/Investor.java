package com.neyas.interview.observer;

public class Investor implements StockObserver {
  private String name;

  public Investor(String name) {
    this.name = name;
  }

  @Override
  public void update(String stockName, double price) {
    System.out.println(name + " received an update: The current stock " + stockName +  " price is " + price);
  }
}
