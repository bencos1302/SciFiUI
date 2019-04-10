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
    Cursor cs;

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
        // Hide cursor
        noCursor();
        cs = new Cursor(this);

        img = loadImage("background.jpg");
        //mc = new MovingCircle(this, width / 2, height / 2, 100);
        ov = new Overlay(this);
        mono = createFont("batmfa__.ttf", 17);
        time = new Time(this);
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

        // Modular Elements
        cs.render();
        cs.update();

        radar.update();
        radar.render();

        sonar.update();
        sonar.render();

        ov.render();

        time.render();
        time.update();

        engineButton.render();
        engineButton.update();

        weaponsButton.render();
        weaponsButton.update();

        conditionsButton.render();
        conditionsButton.update();

        detailsButton.update();
        detailsButton.render();
        

        //mc.update();
        //mc.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

