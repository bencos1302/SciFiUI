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
    Time time;
    // Radar radar;
    // Radar sonar;

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
        img = loadImage("background.jpg");
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 100);
        ov = new Overlay(this);
        mono = createFont("batmfa__.ttf", 17);
        time = new Time(this);
        //radar = new Radar(this, 1, 600, 150, 60);
        //sonar = new Radar(this, 30, 600, 350, 80);
    }

    public void draw() // Called 60 times a second
    {
        background(img);
        textFont(mono);

        // Modular Elements
        // radar.update();
        // radar.render();

        // sonar.update();
        // sonar.render();

        ov.render();

        time.render();
        time.update();

        //b.render();

        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

