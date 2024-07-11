package models.gameobjects;

import coordinates.Coordinates;

public class GameObject {
  private Coordinates position;
  private Render model;

  public GameObject(Render model, Coordinates position) {
    this.model = model;
    this.position = position;
  }

  public GameObject(Render model, int x, int y) {
    this.model = model;
    this.position = new Coordinates(x, y);
  }

  public Render getModel() {
    return model;
  }

  public int getX() {
    return position.getX();
  }

  public int getY() {
    return position.getY();
  }
}
