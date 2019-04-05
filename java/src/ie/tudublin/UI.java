package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

public class UI extends PApplet
{
    //Button b;
    //MovingCircle mc;
    Overlay ov;
    PImage img;
    PFont mono;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(1200, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        // fullScreen(); 
    }

    public void setup()
    {
        img = loadImage("background.png");
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 100);
        ov = new Overlay(this);
        mono = createFont("batmfa__.ttf", 17);
        //radar1 = new Radar(this, 1, 110, 690, 80);
    }

    //Radar radar1;

    public void draw() // Called 60 times a second
    {
        background(0);
        textFont(mono);

        // Modular elements
        
        //radar1.update();
        //radar1.render();

        ov.render();
        //b.render();

        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

