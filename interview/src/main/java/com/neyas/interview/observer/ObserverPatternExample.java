package com.neyas.interview.observer;

public class ObserverPatternExample {
  public static void main(String[] args) {
    Stock stock = new Stock("Reliance", 100.0);
    Investor investor1 = new Investor("Neyas");
    Investor investor2 = new Investor("John");
    stock.register(investor1);
    stock.register(investor2);

    System.out.println("============================");
    stock.setPrice(105.0);
    System.out.println("============================");
    stock.unregister(investor1);
    stock.setPrice(110.0);
  }
}
