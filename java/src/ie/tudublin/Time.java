package ie.tudublin;

import processing.core.PApplet;

public class Time extends PApplet
{
    private UI ui;
    float x;
    float y;

    int s = second();
    int m = minute();
    int h = hour();

    public Time(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        ui.textSize(48);
        ui.strokeWeight(2);
        ui.stroke(255);

        // Hour
        ui.line(x - 50, y - 35, x - 50, y + 45);
        ui.line(x - 50, y - 35, x - 40, y - 35);
        ui.line(x - 50, y + 45, x - 40, y + 45);
        if (h < 10)
        { 
            ui.text("0" + h, x, y);
        }
        else
        {
            ui.text(h, x, y);
        }
        ui.line(x + 50, y - 35, x + 50, y + 45);
        ui.line(x + 50, y - 35, x + 40, y - 35);
        ui.line(x + 50, y + 45, x + 40, y + 45);

        // Minute
        ui.line(x + 80, y - 35, x + 80, y + 45);
        ui.line(x + 80, y - 35, x + 90, y - 35);
        ui.line(x + 80, y + 45, x + 90, y + 45);
        if (m < 10)
        {
            ui.text("0" + m, x + 130, y);
        }
        else
        {
            ui.text(m, x + 130, y);
        }
        ui.line(x + 180, y - 35, x + 180, y + 45);
        ui.line(x + 180, y - 35, x + 170, y - 35);
        ui.line(x + 180, y + 45, x + 170, y + 45);

        // Second
        ui.line(x + 210, y - 35, x + 210, y + 45);
        ui.line(x + 210, y - 35, x + 220, y - 35);
        ui.line(x + 210, y + 45, x + 220, y + 45);
        if (s < 10)
        {
            ui.text("0" + s, x + 260, y);
        }
        else
        {
            ui.text(s, x + 260, y);
        } 
        ui.line(x + 310, y - 35, x + 310, y + 45);
        ui.line(x + 310, y - 35, x + 300, y - 35);
        ui.line(x + 310, y + 45, x + 300, y + 45); 
    }

    public void update()
    {
        s = second();
        m = minute();
        h = hour();
    }
}