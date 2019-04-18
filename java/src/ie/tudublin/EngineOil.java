package ie.tudublin;

public class EngineOil extends EngineMonitor
{
    private float temperature;
    private float minTemp = temperature;
    private float maxTemp;

    // Constructor
    public EngineOil(UI ui, float x, float y, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
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
        ui.textSize(24);
        ui.text("°C", x + 30, y + 30);
        ui.textSize(80);
        ui.text(ui.nf(temperature, 0, 1), x + 180, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(12);
        ui.text("Min: " + ui.nf(minTemp, 0, 1), x + 50, y + 160);
        ui.text("Max: " + ui.nf(maxTemp, 0, 1), x + 50, y + 180);
    }

    public void update()
    {
        if(temperature < minTemp)
        {
            minTemp = temperature;
        }
        if(temperature > maxTemp)
        {
            maxTemp = temperature;
        }
    }
}