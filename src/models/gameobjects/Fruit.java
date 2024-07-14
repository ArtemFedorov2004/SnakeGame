package models.gameobjects;

public class Fruit implements Render {

  @Override
  public char[][] render() {
    char[][] fruitView = new char[1][1];
    fruitView[0][0] = '*';
    return fruitView;
  }
}
