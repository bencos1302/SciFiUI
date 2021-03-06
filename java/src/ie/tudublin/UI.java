package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.core.PFont;

public class UI extends PApplet {
    public int selection;
    public boolean loaded;

    Button engineButton;
    Button weaponsButton;
    Button conditionsButton;
    Button detailsButton;

    Base base;
    PImage backgroundImage;
    PFont mono;
    Table table;

    Time time;
    PowerBar pbar;
    FuelTank fuel;

    Monitor engineOil;
    Monitor engineDist;
    Monitor engineTurbo;
    Monitor engineSpeed;

    Monitor weaponsAmmo;
    Radar weaponsRadar;
    Monitor weaponSystems;

    WeatherChart weatherChart;

    SystemInfo sysInfo;

    boolean[] keys = new boolean[1024];

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c) {
        return keys[c] || keys[Character.toUpperCase(c)];
    }

    public void settings() {
        size(1200, 800);
    }

    public void setup() {
        // Set background and font
        backgroundImage = loadImage("background.jpg");
        table = loadTable("weather.csv", "header");
        mono = createFont("batmfa__.ttf", 17);

        // Initialising objects
        base = new Base(this);
        time = new Time(this, 105, 75);
        pbar = new PowerBar(this, 570, 40, 570, 40, 4);
        fuel = new FuelTank(this, 530, 650, 600, 100, "Fuel Tank");

        engineButton = new Button(this, -5, 180, 485, 130, "Engine");
        engineOil = new EngineOil(this, 540, 140, 80, 90, "Oil Temperature");
        engineDist = new EngineDistance(this, 540, 400, "Distance Travelled");
        engineTurbo = new EngineTurbo(this, 860, 140, 23500, 24500, "Turbo");
        engineSpeed = new EngineSpeed(this, 860, 400, 195, 205, "Speedometer");

        weaponsButton = new Button(this, -5, 310, 485, 130, "Weapons");
        weaponsAmmo = new WeaponAmmo(this, 1050, 220, 60, 2400);
        weaponsRadar = new Radar(this, 1, 675, 250, 120, "Enemy Detection");
        weaponSystems = new WeaponSystem(this, 550, 450);

        conditionsButton = new Button(this, -5, 440, 485, 130, "Weather");
        weatherChart = new WeatherChart(this, 520, 130, 630);

        detailsButton = new Button(this, -5, 570, 485, 130, "System");
        sysInfo = new SystemInfo(this, 530, 140, 630, 600);
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
        if(selection == 1)
        {
            engineOil.render();
            engineOil.update();
            engineDist.render();
            engineDist.update();
            engineTurbo.render();
            engineTurbo.update();
            engineSpeed.render();
            engineSpeed.update();
            fuel.render();
            fuel.update();
        }
        
        // Weapons Information
        weaponsButton.render();
        weaponsButton.update();
        if(selection == 2)
        {
            weaponsAmmo.render();
            weaponsAmmo.update();

            weaponsRadar.render();
            weaponsRadar.update();

            weaponSystems.render();
            weaponSystems.update();
        }
        
        // Weather Information
        conditionsButton.render();
        conditionsButton.update();
        if(selection == 3)
        {
            if (loaded == false)
            {   
                weatherChart.loadData(table);
                weatherChart.printLocations();
                loaded = true;
            }
            else
            {
                weatherChart.render();
                weatherChart.drawGrid();
                weatherChart.drawLocations();
            }
        }

        // System Information
        detailsButton.update();
        detailsButton.render();
        if(selection == 4)
        {
            sysInfo.render();
            sysInfo.update();
        }
    }

    public void mouseClicked()
    {
        if(engineButton.hovering(-5, 180, 485, 130) == true)
        {
            if (selection == 1)
            {
                selection = 0;
            }
            else
            {
                selection = 1;
            }
        }

        if(weaponsButton.hovering(-5, 310, 485, 130) == true)
        {
            if (selection == 2)
            {
                selection = 0;
            }
            else
            {
                selection = 2;
            }
        }
        if(conditionsButton.hovering(-5, 440, 485, 130) == true)
        {
            if (selection == 3)
            {
                selection = 0;
            }
            else
            {
                selection = 3;
            }
        }
        if(detailsButton.hovering(-5, 570, 485, 130) == true)
        {
            if (selection == 4)
            {
                selection = 0;
            }
            else
            {
                selection = 4;
            }
        }
    }
}

