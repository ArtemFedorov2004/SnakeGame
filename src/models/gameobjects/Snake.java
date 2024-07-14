package models.gameobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;

import coordinates.Coordinates;

public class Snake implements Render, Serializable {
  private LinkedHashSet<Coordinates> nodes;

  private boolean canBeTail(int x, int y) {
    Coordinates tail = nodes.getLast();
    if ((x == tail.getX() + 1) && (y == tail.getY()) || (x == tail.getX() - 1) && (y == tail.getY())
        || (x == tail.getX()) && (y == tail.getY() + 1) || (x == tail.getX()) && (y == tail.getY() - 1))
      return true;
    else
      return false;
  }

  public Snake() {
    nodes = new LinkedHashSet<>();
  }

  public void addNode(Coordinates coordinates) {
    if (!nodes.isEmpty() && !canBeTail(coordinates.getX(), coordinates.getY()))
      throw new IllegalArgumentException();

    nodes.add(coordinates);
  }

  public void addNode(int x, int y) {
    if (!nodes.isEmpty() && !canBeTail(x, y))
      throw new IllegalArgumentException();

    nodes.add(new Coordinates(x, y));
  }

  @Override
  public char[][] render() {
    if (nodes.isEmpty())
      return new char[][] { { ' ' } };

    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;

    for (var node : nodes) {
      if (maxX < node.getX())
        maxX = node.getX();
      if (maxY < node.getY())
        maxY = node.getY();
      if (minX > node.getX())
        minX = node.getX();
      if (minY > node.getY())
        minY = node.getY();
    }

    int width = maxX - minX + 1;
    int height = maxY - minY + 1;
    char[][] snakeView = new char[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        snakeView[i][j] = ' ';
      }
    }
    for (var node : nodes) {
      snakeView[node.getY() + minY][node.getX() + minX] = '0';
    }

    return snakeView;
  }

  public void serialize(String filePath) {
    try {
      FileOutputStream file = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(this);

      out.close();
      file.close();
    } catch (IOException ex) {
      System.out.println("IOException was thrown");
    }
  }

  public static Snake deserialize(String filename) throws IOException, ClassNotFoundException {

    FileInputStream file = new FileInputStream(filename);
    ObjectInputStream in = new ObjectInputStream(file);

    var snake = (Snake) in.readObject();

    in.close();
    file.close();

    return snake;
  }
}
