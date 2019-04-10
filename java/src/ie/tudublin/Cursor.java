package ie.tudublin;

import processing.core.PApplet;

public class Cursor
{
    UI ui;

    float size;

    public Cursor(UI ui, float size)
    {
        this.ui = ui;
        this.size = size;
    }

    float x = ui.mouseX;
    float y = ui.mouseY;

    float centerX = ui.width / 2;
    float centerY = ui.height / 2;

    public void render()
    {
        ui.noFill();
        ui.strokeWeight(2);
        ui.stroke(255);

        ui.ellipse(centerX, centerY, x, y);
        ui.line(centerX - size, centerY, centerX + size, centerY);
        ui.line(centerX, centerY + size, centerY - size, centerX);
    }

    public void update()
    {
        x = ui.mouseX;
        y = ui.mouseY;
    }
}