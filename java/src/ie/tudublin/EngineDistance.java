package ie.tudublin;

public class EngineDistance extends EngineMonitor
{
    private float distance;
    private float minDist;
    private float maxDist;

    // Constructor
    public EngineDistance(UI ui, float x, float y, String text)
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
        ui.textSize(15);
        ui.text("Parsecs", x + 240, y + 110);
        ui.textSize(60);
        ui.text(ui.nf(distance, 0, 3), x + 170, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(12);
        ui.text("Min: " + ui.nf(minDist, 0, 4), x + 60, y + 160);
        ui.text("Max: " + ui.nf(maxDist, 0, 4), x + 60, y + 180);
    }

    public void update()
    {
        // if(distance > maxDist)
        // {
        //     maxDist = distance;
        // }
    }
}