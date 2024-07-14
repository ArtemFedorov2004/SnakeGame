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

  private static void startGame() {
    Game game = new Game();
    game.display();
  }

  private static void exit() {
    System.exit(0);
  }

  private static void selectMenuItem() {
    int input = readInt();
    if (input == 1) {
      startGame();
    } else if (input == 2) {

    } else if (input == 3) {
      exit();
    } else {
      input = readInt();
    }
  }

  private static int readInt() {
    Scanner scanner = new Scanner(System.in);
    while (!scanner.hasNextInt()) {
      scanner.next();
    }
    int num = scanner.nextInt();
    return num;
  }

  public static void show() {
    // showStartMessage();
    // selectMenuItem();
    startGame();
  }
}
