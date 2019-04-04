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

        // Overhead bar
        noStroke();
        fill(60);
        quad(250, 0, 320, 0, 400, 130, 350, 130);
        quad(860, 0, 930, 0, 850, 130, 800, 130);
        rect(350, 100, 500, 30);

        // Window Sidebars
        noStroke();
        quad(0, 350, 120, 400, 100, 420, 0, 380);
        quad(120, 400, 180, 600, 150, 580, 100, 420);
        quad(180, 600, 140, 680, 120, 690, 150, 580);

        quad(width - 0, 350, width - 120, 400, width - 100, 420, width - 0, 380);
        quad(width - 120, 400, width - 180, 600, width - 150, 580, width - 100, 420);
        quad(width - 180, 600, width - 140, 680, width - 120, 690, width - 150, 580);

        // Main Dashboard
        rect(0, 700, 100, 20);
        quad(100, 700, 280, 600, 280, 620, 100, 720);
        quad(280, 600, 350, 530, 350, 545, 280, 620);

        rect(width - 100, 700, 100, 20);
        quad(width - 100, 700, width - 280, 600, width - 280, 620, width - 100, 720);
        quad(width - 280, 600, width - 350, 530, width - 350, 545, width - 280, 620);
        
        rect(350, 530, 250, 15);
        rect(600, 530, 250, 15);

        // Crosshair
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

