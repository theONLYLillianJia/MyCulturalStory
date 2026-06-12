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
public class Button {
    
    private int x, y;
    private PApplet app;
    private PImage image;
    
    public Button(PApplet p, String imagePath, int x, int y) {
        this.x = x;
        this.y = y;
        this.app = p;
        this.image = app.loadImage(imagePath);
    }
    
    public void draw(){
        app.image(image, x, y);
    }
    
    public boolean isClicked(float mx, float my){
        return (mx >= x && mx <= x + image.width && my >= y && my <= y + image.height);
    }
    
    public boolean isHovered(int mx, int my){
        return mx >= x && mx <= x + image.width &&
               my >= y && my <= y + image.height;
    }
}
