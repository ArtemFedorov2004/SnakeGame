package main;

import java.util.Scanner;

public class Menu {
  private static void showStartMessage() {
    System.out.println("Welcome to snake game");
    System.out.println("Press: ");
    System.out.println("1: Start game");
    System.out.println("2: Admin mode");
    System.out.println("3: Exit");
  }

  private static void readSymbol(){
    Scanner scanner = new Scanner(System.in);
    if(scanner.hasNextInt()){
      int num = scanner.nextInt();
      System.out.println(num);
    }
  }

  public static void show() {
    showStartMessage();
    readSymbol();
  }
}
