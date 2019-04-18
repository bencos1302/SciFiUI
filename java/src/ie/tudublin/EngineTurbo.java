package ie.tudublin;

import java.util.Random;

public class EngineTurbo extends EngineMonitor
{
    private int rpm;
    private int i, random;

    public EngineTurbo(UI ui, float x, float y, int min, int max, String text)
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
        ui.text("RPM", x + 200, y + 110);
        ui.textSize(60);
        ui.text(rpm, x + 160, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(14);
        ui.text("Pressure: 120 PSI", x + 110, y + 160);
        ui.text("Oil: Mixed", x + 70, y + 180);
    }

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
}