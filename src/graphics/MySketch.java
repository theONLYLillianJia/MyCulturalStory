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
    private Button start;
    private Button chatBox;
    private Button next;
    private Button fly;
    
    //PFont myfont;
    
    private Character frog;
    private NPC turtle;
    private Character hitBlock;
    
    private static int stage = 0;
    int flyCount = 0;
    int flyAdd = 1;
    
    private PApplet app;
    private PImage bg;
    private PImage bg1;
    private PImage bg2;
    private PImage bg3;
    private PImage bg4;
    private PImage bg5;
    private PImage bg6;
    
    public void settings(){
        size (874,684);
    }
    
    public void setup(){
        bg = loadImage("images/MainMenuBackground.PNG");
        bg1 = loadImage("images/BottomOfWell.PNG");
        bg2 = loadImage("images/BottomOfWell(1).PNG");
        bg3 = loadImage("images/Road.PNG");
        bg4 = loadImage("images/GameTutorial.png");
        bg5 = loadImage("images/GameTutorial(1).png");
        bg6 = loadImage("images/GameBackdrop.png");
        
        fill(0);
        textSize(22);
        
        start = new Button (this, "images/StartButton.png", 285, 110);
        chatBox = new Button (this, "images/Chat1.png", 10, 500);
        next = new Button (this, "images/Next.png", 660, 610);
        fly = new Button (this, "images/Fly.png", 120, 250);
        
        frog = new Character(this, "images/Frog.png", 5, 400, 450);
        turtle = new NPC(this, "images/Turtle.png",0,  200, 200);
        hitBlock = new Character(this, "images/HitBlockTeal.PNG", 0, 380, 135);
    }
    
    public void draw(){
        background(255, 255, 255);

        if (stage == 0) {
            image(bg, 0, 0, width, height);
            start.draw();
            text("PRESS ENTER TO START", 320, 75);
        } else if (stage == 1) {
            image(bg1, 0, 0, width, height);
            textSize(30);
            text("INSIDE THE WELL", 625, 75);
            
            frog.draw();
            hitBlock.draw();
            movement();
            
            if (hitBlock.isCollidingWith(frog)){
                stage++;
            }
        } else if (stage == 2) {
            image(bg2, 0, 0, width, height);
            chatBox.draw();
            movement();
            
            frog = new Character(this, "images/Frog.png", 5, 400, 600);
            turtle = new NPC(this, "images/Turtle.png",0,  365, 285);
        } else if (stage == 3) {
            image(bg3, 0, 0, width, height);
            frog.draw();
            turtle.draw();
            movement();
            if (turtle.isCollidingWith(frog)){
                stage++;
            }
        } else if (stage == 4) {
            image(bg4, 0, 0, width, height);
            next.draw();
        } else if (stage == 5) {
            image(bg5, 0, 0, width, height);
            next.draw();
        } else if (stage == 6) {
            image(bg6, 0, 0, width, height);
            fly.draw();
            text("+" + flyAdd() + " flies", 200, 500);
            text("Flies: " + flyCount, 100, 75);
            
        }
    }
    
    public int flyAdd () {

        return flyAdd;
    }
    
    public void keyPressed() {
        if (stage == 0){
            if (keyCode == ENTER){
                stage =1;
            }
        }
    }
    
    public void movement () {
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
    
    public void mousePressed(){
        System.out.println("x: " + mouseX + " | y: " + mouseY);
        
        if (stage == 0) {
            if (start.isClicked(mouseX, mouseY)){
                stage = 1;
            }
        } else if (stage == 2) {
            if (chatBox.isClicked(mouseX, mouseY)){
                stage = 3;
            }
        } else if (stage == 4 || stage == 5) {
            if (next.isClicked(mouseX, mouseY)){
                stage++;
            }
        } else if (stage == 6) {
            if (fly.isClicked(mouseX, mouseY)){
                flyCount += flyAdd;
            }
        }
    }
}
