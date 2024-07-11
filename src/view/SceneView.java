package view;

import models.gameobjects.GameObject;
import models.Scene;

import java.util.List;

public class SceneView {
  private static char[][] prepareScene(Scene scene) {
    int width = scene.getWidth();
    int height = scene.getHeight();
    char[][] area = new char[height][width];
    List<GameObject> objectsOnScene = scene.getObjects();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        area[i][j] = 'o';
      }
    }
    for (GameObject obj : objectsOnScene) {
      renderObjectOnArea(obj, area);
    }
    return area;
  }

  private static void renderObjectOnArea(GameObject obj, char[][] area) {
    char[][] objView = obj
            .getModel()
            .render();
    int areaWidth = area[0].length;
    int areaHeight = area.length;

    for (int i = 0; i < objView.length; i++) {
      int row = i + obj.getY();
      if (row >= areaHeight) break;
      if (row < 0) continue;
      for (int j = 0; j < objView[0].length; j++) {
        int col = j + obj.getX();
        if (col >= areaWidth) break;
        if (col < 0 || objView[i][j] == ' ') continue;
        area[row][col] = objView[i][j];
      }
    }
  }

  public static void display(Scene scene) {
    char[][] area = prepareScene(scene);

    for (int i = 0; i < scene.getHeight(); i++) {
      for (int j = 0; j < scene.getWidth(); j++) {
        System.out.print(area[i][j]);
      }
      System.out.print("\n");
    }
  }
}
//static methods???