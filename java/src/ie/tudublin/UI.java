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
        size(1200, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        // fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 100);
        //radar1 = new Radar(this, 1, 110, 690, 80);
    }

    //Radar radar1;

    public void draw() // Called 60 times a second
    {
        background(0);

        // Dashboard
        noStroke();
        fill(255);
        quad(250, 0, 350, 0, 400, 130, 350, 130);
        quad(850, 0,   950, 0,   850, 130,   800, 130);
        rect(350, 90, 500, 40);

        strokeWeight(2);
        stroke(255);
        noFill();
        ellipse(width / 2, height / 2, 30, 30);
        ellipse(width / 2, height / 2, 2, 2);

        noStroke();
        strokeWeight(1);
        // Modular elements
        
        //radar1.update();
        //radar1.render();

        b.render();

        mc.update();
        mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

