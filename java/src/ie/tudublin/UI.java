package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;

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
        size(1400, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        // fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 100);
        radar1 = new Radar(this, 1, 110, 690, 80);
        radar2 = new Radar(this, 1, 1290, 690, 80);
    }

    Radar radar1;
    Radar radar2;

    public void draw() // Called 60 times a second
    {
        background(0);

        // Underlay
        stroke(203, 52, 52);
        strokeWeight(4);
        fill(163, 41, 41);
        quad(0, 800, 18, 610, 210, 590, 190, 780);

        // Modular elements
        stroke(255);
        radar1.update();
        radar1.render();

        radar2.update();
        radar2.render();

        strokeWeight(1);
        b.render();

        mc.update();
        mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

