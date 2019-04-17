package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

public class UI extends PApplet
{
    public boolean power = true;

    Button engineButton;
    Button weaponsButton;
    Button conditionsButton;
    Button detailsButton;

    //MovingCircle mc;
    Base base;
    PImage backgroundImage;
    PFont mono;

    Time time;
    PowerBar pbar;

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
        // Set background and font
        backgroundImage = loadImage("background.jpg");
        mono = createFont("batmfa__.ttf", 17);

        // Initialising objects
        base = new Base(this);
        time = new Time(this, 105, 75);
        pbar = new PowerBar(this, 600, 40, 570, 40, 4);

        engineButton = new Button(this, -5, 180, 485, 130, "Engine");
        weaponsButton = new Button(this, -5, 310, 485, 130, "Weapons");
        conditionsButton = new Button(this, -5, 440, 485, 130, "Weather");
        detailsButton = new Button(this, -5, 570, 485, 130, "System");
    }

    public void draw() // Called 60 times a second
    {
        // Set up elements
        background(backgroundImage);
        textFont(mono);
        base.render();
        
        // Modular elements
        // Clock
        time.render();
        time.update();

        // Powerbar
        pbar.render();
        pbar.update();
        
        // Engine Information
        engineButton.render();
        engineButton.update();
        if (engineButton.hovering(-5, 180, 485, 130) == true)
        {
            if(mousePressed)
            {

            }
        }

        // Weapons Information
        weaponsButton.render();
        weaponsButton.update();
        if (weaponsButton.hovering(-5, 310, 485, 130) == true)
        {
            if(mousePressed)
            {

            }
        }

        // Weather Information
        conditionsButton.render();
        conditionsButton.update();
        if (conditionsButton.hovering(-5, 440, 485, 130) == true)
        {
            if(mousePressed)
            {
                
            }
        }

        // System Information
        detailsButton.update();
        detailsButton.render();
        if (detailsButton.hovering(-5, 570, 485, 130) == true)
        {
            if(mousePressed)
            {
                
            }
        }

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
}

