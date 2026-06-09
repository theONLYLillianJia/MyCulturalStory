/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author thech
 */
public class NPC extends Character{
    int speed;
    
    public NPC(PApplet p, String imagePath, int speed, int x, int y) {
        super(p, imagePath, x, y);
        this.speed = 0;
    }
}
