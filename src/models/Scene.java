package models;

public class Scene {
  private final int width;
  private final int height;
  private char[][] area;

  public Scene(int width, int height) {
    if (width < 1 || height < 1) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
    area = new char[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        area[i][j] = ' ';
      }
    }
  }

  public char[][] getArea() {
    return area;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
