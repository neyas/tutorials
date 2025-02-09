package com.neyas;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
  private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  private int data;

  public void writeData(int data) {
    readWriteLock.writeLock().lock();
    try {
      this.data = data;
    } finally {
      readWriteLock.writeLock().unlock();
    }
  }

  public int readData() {
    readWriteLock.readLock().lock();
    try {
      return data;
    } finally {
      readWriteLock.readLock().unlock();
    }
  }
}
