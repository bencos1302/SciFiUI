package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

public class UI extends PApplet
{
    Button engineButton;
    Button weaponsButton;
    Button conditionsButton;
    Button detailsButton;

    //MovingCircle mc;
    Overlay ov;
    PImage img;
    PFont mono;
    Time time;
    Radar radar;
    Radar sonar;

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
    }

    public void setup()
    {
        img = loadImage("background.jpg");

        ov = new Overlay(this);

        mono = createFont("batmfa__.ttf", 17);
        time = new Time(this, 100, 75);
        radar = new Radar(this, 1, 600, 150, 60);
        sonar = new Radar(this, 2, 600, 350, 80);
        engineButton = new Button(this, -5, 180, 485, 130, "Engine");
        weaponsButton = new Button(this, -5, 310, 485, 130, "Weapons");
        conditionsButton = new Button(this, -5, 440, 485, 130, "Weather");
        detailsButton = new Button(this, -5, 570, 485, 130, "System");
    }

    public void draw() // Called 60 times a second
    {
        background(img);
        textFont(mono);

        ov.render();

        // Modular Elements
        // radar.update();
        // radar.render();

        // sonar.update();
        // sonar.render();

        time.render();
        time.update();

        engineButton.render();
        engineButton.update();
        if (engineButton.hovering(-5, 180, 485, 130) == true)
        {
            if(mousePressed)
            {

            }
        }

        weaponsButton.render();
        weaponsButton.update();
        if (weaponsButton.hovering(-5, 310, 485, 130) == true)
        {
            if(mousePressed)
            {

            }
        }

        conditionsButton.render();
        conditionsButton.update();
        if (conditionsButton.hovering(-5, 440, 485, 130) == true)
        {
            if(mousePressed)
            {
                
            }
        }

        detailsButton.update();
        detailsButton.render();
        if (detailsButton.hovering(-5, 570, 485, 130) == true)
        {
            if(mousePressed)
            {
                
            }
        }
        

        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

