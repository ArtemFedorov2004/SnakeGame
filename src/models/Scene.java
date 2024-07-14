package models;

import coordinates.Coordinates;
import models.gameobjects.GameObject;
import models.gameobjects.Render;

import java.util.ArrayList;
import java.util.List;

public class Scene {
  private final int width;
  private final int height;
  private List<GameObject> objectsOnScene;

  public Scene(int width, int height) {
    if (width < 1 || height < 1) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
    objectsOnScene = new ArrayList<>();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void addObject(Render object, Coordinates position) {
    GameObject obj = new GameObject(object, position);
    objectsOnScene.add(obj);
  }

  public void addObject(Render object, int x, int y) {
    GameObject obj = new GameObject(object, x, y);
    objectsOnScene.add(obj);
  }

  public void addObject(GameObject object) {
    objectsOnScene.add(object);
  }

  public List<GameObject> getObjects() {
    return objectsOnScene;
  }
}
