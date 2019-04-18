package ie.tudublin;

import java.util.Random;

public class EngineSpeed extends EngineMonitor
{
    private int speed, i, random;
    private float topSpeed = 300;
    private float acceleration = 0.004f;

    public EngineSpeed(UI ui, float x, float y, int min, int max, String text)
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
        ui.textSize(15);
        ui.text("PS/H", x + 200, y + 110);
        ui.textSize(70);
        ui.text(speed, x + 160, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(14);
        ui.text("Top Speed: " + topSpeed + " PS/H", x + 125, y + 160);
        ui.text("Acceleration: " + acceleration + " PS/s", x + 140, y + 180);
    }

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
}