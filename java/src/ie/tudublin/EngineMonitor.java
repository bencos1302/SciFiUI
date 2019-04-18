package ie.tudublin;

import processing.core.PApplet;

public class EngineMonitor
{
    UI ui;
    float x, y;
    String text;

    public EngineMonitor(UI ui, float x, float y, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public void render()
    {
        ui.textSize(14);
        ui.fill(255);
        ui.text(text, x + 150, y - 20);
        
        ui.stroke(0);
        ui.strokeWeight(3);
        ui.fill(100);
        ui.rect(x, y, 300, 200);

        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(12);
        ui.text("Min: ", x + 50, y + 155);
        ui.text("Max: ", x + 50, y + 180);
    }

    public void update()
    {

    }
}
