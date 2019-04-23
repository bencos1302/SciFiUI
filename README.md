# SciFi UI Project

Name: Ben Cosgrave

Student Number: C17445274

# Description of the assignment
This assignment tasked me with creating a futuristic / SciFi user interface using Java and Processing. A lot of thought went into what sort of design I wanted do go with, and in the end I settled on something similar to what's found in the Iron Man video games. The UI found throughout that game is simplistic yet also interesting. It has a perfect balance of complexity and aesthetics, which is why I chose to base my design around it.

# Instructions
Once the program begins, not much of the UI is visible. The local time, power status bar and the left panel is all that shows until a button is clicked from the left panel.

1. Click on the Engine Information button.
   This will display several more screens: Oil Temperature, Turbo, Distance Travelled and Speedometer. These screens update by themselves using the update() function which is called 60 times per second. At the bottom of the screen now shown is a Fuel tank, which depletes slowly as the ship travels further. Once the fuel tank is emptied, it is refilled automatically.
   
2. Click on the Weapons Information button.
   This presents several displays: Weapons Systems & Status, Current & Total Ammo, and an Enemy Detection Radar. Weapons are displayed with a green background if they are currently active and usable, and red if inactive and unusable.
   
3. Click the Weather Information button.
   The screen will now display a grid of the current galaxy sector which the ship is flying in. The number below each circle corresponds to the danger level of that weather condition and the size of the circle surrounding them represents the area of space in which it effects. 
   
4. Click the System Information button.
   This screen shows a graphic of the ship's specifications and some information about it's origin and serial number.

# How it works
The buttons on the left panel are operated by the use of a Button class and several functions. The hovering method of the Button class detects whether the mouse pointer is currently within the button's boundaries and the mouseClicked() function checks whether the mouse has been clicked whilst hovering over any of the Buttons. This function sets the selection variable to an integer that corresponds to whichever button is clicked. If a button has already been toggled, it will toggle the selection off (set it to a value of 0).
```Java
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
	
engineButton = new Button(this, -5, 180, 485, 130, "Engine");
weaponsButton = new Button(this, -5, 310, 485, 130, "Weapons");
conditionsButton = new Button(this, -5, 440, 485, 130, "Weather");
detailsButton = new Button(this, -5, 570, 485, 130, "System");
```
For example, the weapon button, which operated in the same way to the rest of the buttons:
```Java
if(selection == 2) // The Weapons Information button
{
    weaponsAmmo.render();
    weaponsAmmo.update();

    weaponsRadar.render();
    weaponsRadar.update();

    weaponSystems.render();
    weaponSystems.update();
}
```

The time is updated using the text() and hour(), minute() and second() functions, which pulls the current system time from the computer which the program is running on. I placed them into variables which are updated every time the update() function runs - 60 times per second.
```Java
int s = second();
int m = minute();
int h = hour();

public void update()
{
    s = second();
    m = minute();
    h = hour();
}
```

The Power Bar which is diplayed at the top of the screen is a composition of two rectangles. One of which is a lot smaller and moves horizontally until it reaches the X-coordinate and Width value of the other. The speed may be set when declaring an instance of the object, in this case it is set at a speed of 4 pixels every 1/60th of a second.
```Java
public PowerBar(UI ui, float x, float y, float width, float height, int speed)
{
    this.ui = ui;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.speed = speed;
}

pbar = new PowerBar(this, 570, 40, 570, 40, 4);

public void update()
{
    // If travelling bar reaches right edge of power bar
    if(offset >= width - (width / 10))
    {
        direction = -1;
    }
    // If travelling bar reaches left edge of power bar
    if(offset <= 0)
    {
        direction = 1;
    }
    offset += direction * speed;
}
```

1. The Engine Button utilises 4 subclasses of the Monitor class; EngineOil, EngineTurbo, EngineDistance and EngineSpeed. Each comprises of a rectangular shape with room for large text and smaller text.

- EngineOil:

![oilTemp](/images/oilTemp.png)

```Java
public void update()
{
    if (i % 60 == 0)
    {
        Random r = new Random();
        random = min + r.nextFloat() * (max - min);
        temperature = random;
        i = 0;
    }
    i++;

    if(temperature > maxTemp)
    {
        maxTemp = temperature;
    }
}
```

- EngineTurbo:

![Turbo](/images/Turbo.png)

```Java
public void update()
{
    if (i % 60 == 0)
    {
        Random r = new Random();
        random = (int) (min + r.nextFloat() * (max - min));
        rpm = random;
        i = 0;
    }
    i++;
}
```

- EngineDistance:

![Distance](/images/Distance.png)

```Java
public void update()
{
    distance += 0.0001f;
    if(distance > maxDist)
    {
        maxDist = distance;
    }
}
```

- EngineSpeed:

![Speedometer](/images/Speedometer.png)

```Java
public void update()
{
    if (i % 120 == 0)
    {
        Random r = new Random();
        random = (int) (min + r.nextFloat() * (max - min));
        speed = random;
        i = 0;
    }
    i++;
}
```

```Java
public EngineOil(UI ui, float x, float y, float min, float max, String text)
{
    this.ui = ui;
    this.x = x;
    this.y = y;
    this.min = min;
    this.max = max;
    this.text = text;
}
```

Also included in this screen is a Fuel Tank, which operates by incrementing and subtracting a counter from the width of the bar until it reaches 0. Code as shown below:
```Java
public void render()
{
    ui.noFill();
    ui.stroke(255);
    ui.strokeWeight(3);
    ui.rect(x, y, width, height);

    ui.noStroke();
    ui.fill(204,204,0);
    ui.rect(x + 1, y + 1, (width - 1) - counter, height - 1);

    ui.fill(255);
    ui.textSize(40);
    ui.text(text, x + width / 2, y + height / 2);        
}

public void update()
{
    if (counter < (width - 1))
    {
        counter += 0.02f;
    }
    else
    {
        counter = 0f;
    }
}
```

2. The Weapons Information screen uses a for-loop to draw 5 bars representing each weapon system. Similar to how the Fuel tank worked on the Engine screen, a counter is incremented until it reaches the height of the bar and then is set back to 0, thus giving a pulsing effect representing that the system is connected to the ship. Two classes used on this screen are subclasses of Monitor; WeaponAmmo and WeaponSystem. A radar is also implemented by updating the destination co-ordinates of the line() function by changing the value of Theta. 

![WeaponSystems](/images/WeaponSystems.png)

The following code is what was used to draw the 5 weapon systems bars.
```Java
for(int i = 0; i < 5; i++)
{
    ui.stroke(0);
    ui.noFill();
    ui.rect(x - 1 + (i*120), y - 1, 101, 301);
    if (status[i] == "Active")
    {
        // Green
        ui.fill(60,179,113);
    }
    else
    {
        // Red
        ui.fill(139,0,0);
    }
    ui.rect(x + (i*120), y, 100, counter);
    ui.fill(255);
    ui.textSize(14);
    ui.text(status[i], x + 50 + (i * 120), y + 150);
    ui.textSize(10);
    ui.fill(255);
    ui.text(weapons[i], x + 50 + (i * 120), y + 320);
}
```

![Radar](/images/Radar.png)

x2, y2, the co-ordinates of the second point (which connects to the circle), are used as parameters of the line() function.
```Java
float x2 = pos.x + (float) Math.sin(theta) * radius;
float y2 = pos.y - (float) Math.cos(theta) * radius;

public void update()
{
    theta += PApplet.TWO_PI * timeDelta * frequency;
}
```

3. The Weather Information screen displays a grid with various space weather phenomena. Text below each circle shows the description and danger level of each event (with 5 being the highest).

![WeatherMap](/images/WeatherChart.png)

4. The System Information screen displays a diagram of the ship and information regarding it's origin and boot date. 

![SystemInfo](/images/SystemsInfo.png)

# What I am most proud of in the assignment
I feel as though over the course of this project I've gained a lot more of an understanding of the Java programming language aswell as how to use Processing to a decent level. Using github was also completely new to me and extremely helpful in breaking the project up into small stages that I could hack away at whenever I found the time. Finding something to base my project off was also a great source of inspiration and it was really enjoyable to design a working, futuristic User Interface for the first time.

Overall I would say the thing I'm most proud of coming out of this is how rewarding it was to see each of my commits to the repository add up over time to the complete item. I'm proud of how I managed my time and staggered each step so that it never felt like a chore. The project really felt more like a fun side-project rather than a grueling commitment and felt encouraging and left me with a hopeful outlook on future projects.

# Markdown Tutorial

A YouTube video of my UI in action:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

