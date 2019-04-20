package ie.tudublin;

import java.util.Random;

public class EngineOil extends Monitor
{
    private float temperature;
    private float maxTemp;
    private float random;
    private int i;

    // Constructor
    public EngineOil(UI ui, float x, float y, float min, float max, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.min = min;
        this.max = max;
        this.text = text;
    }

    public void render()
    {
        // Header
        ui.textSize(14);
        ui.fill(255);
        ui.text(text, x + 150, y - 20);

        // Box
        ui.stroke(20);
        ui.strokeWeight(3);
        ui.fill(100);
        ui.rect(x, y, 300, 200);

        ui.fill(255);
        ui.textSize(30);
        //ui.text("°C", x + 200, y + 110);
        ui.textSize(70);
        ui.text(ui.nf(temperature, 0, 1) + "°C", x + 150, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(16);
        ui.text("Highest: " + ui.nf(maxTemp, 0, 1) + "°C", x + 100, y + 167);
    }

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
}