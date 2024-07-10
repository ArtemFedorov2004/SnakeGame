import models.GameObject;
import models.Scene;
import models.Wall;

public class Main {
  private static final int WIDTH_GAME_AREA = 20;
  private static final int HEIGHT_GAME_AREA = 8;

  private static void DISPLAY_MODELS(GameObject obj) {
    char[][] modelView = obj.render();

    for (char[] row : modelView) {
      for (char col : row) {
        System.out.print(col);
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    Wall wall = new Wall(WIDTH_GAME_AREA, HEIGHT_GAME_AREA);
    Scene scene = new Scene(WIDTH_GAME_AREA, HEIGHT_GAME_AREA);
    //SceneView.display(scene);
    DISPLAY_MODELS(wall);

  }

}

//what is package in java??