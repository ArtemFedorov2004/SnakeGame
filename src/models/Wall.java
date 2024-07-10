package models;

public class Wall extends GameObject {
  private final int width;
  private final int height;

  public Wall(int width, int height) {
    if (width < 1 || height < 1) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public char[][] render() {
    char[][] wallView = new char[height][width];
    int i, j;

    wallView[0][0] = '+';
    wallView[0][width - 1] = '+';
    for (i = 1; i < width - 1; i++) {
      wallView[0][i] = '-';
    }

    for (i = 1; i < height - 1; i++) {
      wallView[i][0] = '|';
      wallView[i][width - 1] = '|';
    }

    wallView[height - 1][0] = '+';
    wallView[height - 1][width - 1] = '+';
    for (i = 1; i < width - 1; i++) {
      wallView[height - 1][i] = '-';
    }

    for (i = 1; i < height - 1; i++) {
      for (j = 1; j < width - 1; j++) {
        wallView[i][j] = ' ';
      }
    }

    return wallView;
  }
}
