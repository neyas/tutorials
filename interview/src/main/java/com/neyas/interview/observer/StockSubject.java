package com.neyas.interview.observer;

public interface StockSubject {

  void register(StockObserver observer);

  void unregister(StockObserver observer);

  void notifyObservers();

}
