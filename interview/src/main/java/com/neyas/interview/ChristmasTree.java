package com.neyas.interview;

public class ChristmasTree {
  public static void main(String[] args) {
    System.out.print("Enter the height of the tree: ");
    int height = Integer.parseInt(System.console().readLine());

    ChristmasTree christmasTree = new ChristmasTree();
    christmasTree.christmasTree(height);
  }

  public void christmasTree(int height) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < height - i - 1; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < (i * 2 + 1); j++) {
        System.out.print("*");
      }
      for (int j = 0; j < height - i - 1; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
    for (int i = 0; i < height / 2; i++) {
      for (int j = 0; j < height - 2; j++) {
        System.out.print(" ");
      }
      switch (height) {
        case 1:
        case 2:
        case 3:
          System.out.print("*");
          break;
        case 5:
          System.out.print("**");
          break;
        default:
          System.out.print("***");
          break;
      }
    }
  }
}
