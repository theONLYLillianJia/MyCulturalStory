/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 343244042
 */
public class Frog {
  private int x, y;
  private int speed;
  private PApplet app;
  private PImage image;
  
  public Frog(PApplet p, String imagePath, int speed, int x, int y) {
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.app = p;
    this.image = app.loadImage(imagePath);
  }
  
  public void move(int dx, int dy){
      x += dx;
      y += dy;
  }
  
  public void draw(){
      app.image(image, x, y);
  }
}

