package main;

import models.Scene;
import models.gameobjects.Wall;
import view.SceneView;

public class Main {
  private static final int WIDTH_GAME_AREA = 20;
  private static final int HEIGHT_GAME_AREA = 8;

  public static void main(String[] args) {
    Menu.show();
    Wall wall = new Wall(10, 5);
    Scene scene = new Scene(20, 8);
    scene.addObject(wall,0,0);
    //DISPLAY_MODELS(wall);
    SceneView.display(scene);

  }

}

//what is package in java??