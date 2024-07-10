package view;

import models.Scene;

public class SceneView {
  public static void display(Scene scene) {
    char[][] area = scene.getArea();
    int width = scene.getWidth();
    int height = scene.getHeight();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(area[i][j]);
      }
      System.out.print("\n");
    }
  }
}
