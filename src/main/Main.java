package main;

public class Main {
  private static void clearConsole() {
    System.out.print("\033\143");
    System.out.flush();
  }

  public static void main(String[] args) {
    clearConsole();
    Menu.show();  
  }
}