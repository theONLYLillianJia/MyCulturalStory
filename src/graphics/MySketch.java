/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 343244042
 */
package graphics;
import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {
    private Frog frog;
    private Background startBackdrop;
    private Button start;
    private NPC turtle;
    
    int stage = 0;
    
    private PApplet app;
    private PImage bg;
    private PImage bg1;
    
    public void settings(){
        size (874,684);
    }
    
    public void setup(){
        bg = loadImage("images/MainMenuBackground.PNG");
        bg1 = loadImage("images/BottomOfWell.PNG");
        
        fill(0);
        textSize(22);
        
        start = new Button (this, "images/StartButton.png", 285, 110);
        frog = new Frog(this, "images/Frog.png", 5, 400, 450);
        turtle = new NPC(this, "images/Turtle.png", 200, 200);
    }
    
    public void draw(){
        background(255, 255, 255);

        if (stage == 0) {
            image(bg, 0, 0, width, height);
            start.draw();
            text("PRESS ENTER TO START", 320, 75);
        } else if (stage ==1) {
            image(bg1, 0, 0, width, height);
            //turtle.draw();
            textSize(30);
            text("INSIDE THE WELL", 625, 75);
            frog.draw();
            
            if (keyPressed) {
                if (keyCode == LEFT){
                    frog.move(-5, 0);
                } else if (keyCode == RIGHT) {
                    frog.move(5, 0);
                } else if (keyCode == UP) {
                    frog.move(0, -5);
                } else if (keyCode == DOWN) {
                    frog.move(0, 5);
                }
            }
        }
    }
    
    public void keyPressed() {
        if (stage == 0){
            if (keyCode == ENTER){
                stage =1;
            }
        }
    }
}
