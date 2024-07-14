package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import coordinates.Coordinates;
import models.Scene;
import models.gameobjects.*;
import view.SceneView;

public class Game {
  private static final int WIDTH_AREA = 20;
  private static final int HEIGHT_AREA = 8;

  private final Scene scene;

  private List<GameObject> initGameObjects() {
    var objects = new ArrayList<GameObject>();

    Wall wall = new Wall(WIDTH_AREA, HEIGHT_AREA);

    Fruit fruit = new Fruit();

    Snake snake = new Snake();
    snake.addNode(0, 0);
    snake.addNode(0, 1);
    snake.addNode(0, 2);

    Coordinates wallPosition = new Coordinates(0, 0);
    Coordinates fruitPosition = generateFruitPosition(wallPosition.getX() + 1,
        wallPosition.getX() + wall.getWidth() - 2, wallPosition.getY() + 1, wallPosition.getY() + wall.getHeight() - 2);
    Coordinates snakePosition = new Coordinates(3, 3);

    objects.add(new GameObject(wall, wallPosition));
    objects.add(new GameObject(fruit, fruitPosition));
    objects.add(new GameObject(snake, snakePosition));

    return objects;
  }

  private void addObjectsOnScene() {
    var objects = initGameObjects();

    for(var object : objects){
      scene.addObject(object);
    }
  }

  private Snake loadSnakeFromFile() {
    Snake snake = null;
    final String filePath = "src/fileswithserializeddata/serializedSnake";

    try {
      snake = Snake.deserialize(filePath);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }

    return snake;
  }

  private Coordinates generateFruitPosition(int fromX, int toX, int fromY, int toY) {
    if (toX < fromX || toY < fromY)
      throw new IllegalArgumentException();

    Random rand = new Random();
    int x = rand.nextInt(toX - fromX + 1) + fromX;
    int y = rand.nextInt(toY - fromY + 1) + fromY;
    return new Coordinates(x, y);
  }

  public Game() {
    scene = new Scene(WIDTH_AREA, HEIGHT_AREA);
    addObjectsOnScene();
  }

  public void display() {
    SceneView.display(scene);
  }
}
