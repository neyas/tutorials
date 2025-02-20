package com.neyas.interview.observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements StockSubject {
  private double price;
  private final String name;
  private final List<StockObserver> observers = new ArrayList<>();

  public Stock(String name, double price) {
    this.price = price;
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
    notifyObservers();
  }

  @Override
  public void register(StockObserver observer) {
    observers.add(observer);
  }

  @Override
  public void unregister(StockObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (StockObserver observer : observers) {
      observer.update(name, price);
    }
  }
}
