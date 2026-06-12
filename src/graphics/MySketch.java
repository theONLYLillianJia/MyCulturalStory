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
    private Button rottenFruit;
    private Button ripeFruit;
    private Button you;
    private Button flySwatter;
    private Button electricSwatter;
    private Button laserSwatter;
    private Button feed;
    
    //PFont myfont;
    
    private Character frog;
    private NPC turtle;
    private Character hitBlock;
    private NPC fatFrog;
    
    private static int stage = 0;
    long flyCount = 0;
    long flyAdd = 1;
    long cost[] = new long[7];
    long ncost[] = new long [7];
    
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
        ncost[0] = 10;
        ncost[1] = 250;
        ncost[2] = 5000;
        ncost[3] = 5;
        ncost[4] = 24;
        ncost[5] = 230;
        ncost[6] = 10000;
        
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
        rottenFruit = new Button (this, "images/RottenFruitButton.png", 635, 80);
        ripeFruit = new Button (this, "images/RipeFruitButton.png", 635, 167);
        you = new Button (this, "images/YouButton.png", 635, 254);
        flySwatter = new Button (this, "images/FlySwatterButton.png", 635, 341);
        electricSwatter = new Button (this, "images/ElectricSwatterButton.png", 635, 428);
        laserSwatter = new Button (this, "images/LaserSwatterButton.png", 635, 515);
        feed = new Button (this, "images/Feed.png", 415, 515);
        
        frog = new Character(this, "images/Frog.png", 5, 400, 450);
        turtle = new NPC(this, "images/Turtle.png",0,  200, 200);
        fatFrog = new NPC(this, "images/FatFrog.png",0,  0, 0);
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
            rottenFruit.draw();
            ripeFruit.draw();
            you.draw();
            flySwatter.draw();
            electricSwatter.draw();
            laserSwatter.draw();
            feed.draw();
            
            text("+" + flyAdd() + " flies", 200, 500);
            text("Flies: " + flyCount, 100, 75);
            
            if (rottenFruit.isHovered(mouseX, mouseY)){
                //cost(cost);
                text("Desc: 2x Flies", 136, 540);
                text("Cost: " + ncost[0], 136, 570);
            } else if (ripeFruit.isClicked(mouseX, mouseY)){
                text("Desc: 25x Flies", 136, 540);
                text("Cost: " + ncost[1], 136, 570);
            } else if (you.isClicked(mouseX, mouseY)){
                text("Desc: 100x Flies", 136, 540);
                text("Cost: " + ncost[2], 136, 570);
            } else if (flySwatter.isClicked(mouseX, mouseY)){
                text("Desc: +1 Flies", 136, 540);
                text("Cost: " + ncost[3], 136, 570);
            } else if (electricSwatter.isClicked(mouseX, mouseY)){
                text("Desc: +10 Flies", 136, 540);
                text("Cost: " + ncost[4], 136, 570);
            } else if (laserSwatter.isClicked(mouseX, mouseY)){
                text("Desc: +100 Flies", 136, 540);
                text("Cost: " + ncost[5], 136, 570);
            } else if (feed.isHovered(mouseX, mouseY)){
                text("Desc: Feed and end game", 136, 540);
                text("Cost: " + ncost[6], 36, 570);
            }
            
        } else if (stage == 7) {
            fatFrog.draw();
            text("Frog Fed, will add image later" , 36, 570);
        }
    }
    
    public long flyAdd () {

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
            
            if (rottenFruit.isClicked(mouseX, mouseY)){

                if (flyCount >= ncost[0]){
                    flyAdd = flyAdd * 2;
                    flyCount = flyCount - ncost[0];
                    ncost[0] = (ncost[0] + cost[0])*2;
                }
            } else if (ripeFruit.isClicked(mouseX, mouseY)){
                if (flyCount >= ncost[1]){
                    flyAdd = flyAdd * 10;
                    flyCount -= ncost[1];
                    ncost[1] = (ncost[1] + cost[1])*2;
                }
            } else if (you.isClicked(mouseX, mouseY)){
                if (flyCount >= ncost[2]){
                    flyAdd = flyAdd * 100;
                    flyCount -= ncost[2];
                    ncost[2] = (ncost[2] + cost[2])*2;
                }
            //} else if (flySwatter.isClicked(mouseX, mouseY)){
                //ncost[3] += (cost[3]*5);
            //} else if (electricSwatter.isClicked(mouseX, mouseY)){
                //ncost[4] += (cost[4]*5);
            //} else if (laserSwatter.isClicked(mouseX, mouseY)){
                //ncost[5] += (cost[5]*5);
            }
            
            if (feed.isClicked(mouseX, mouseY)) {
                if (flyCount >= ncost[6]){
                    flyCount -= ncost[6];
                    stage++;
                }
            }
        }
    }
    
    //public int cost (int cost) {
        //if (rottenFruit.isClicked(mouseX, mouseY)){
                //ncost += cost;
        //}

        //return ncost;
    //}
    
    public void buy () {
        
    }
}
