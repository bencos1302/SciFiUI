package ie.tudublin;

public class EngineDistance extends EngineMonitor
{
    private float distance;
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
        ui.text("Parsecs", x + 200, y + 110);
        ui.textSize(70);
        ui.text(ui.nf(distance, 0, 3), x + 160, y + 70);

        // Lower Box
        ui.fill(40);
        ui.rect(x, y + 140, 300, 60);
        ui.fill(255);
        ui.textSize(14);
        ui.text("Destination: ", x + 80, y + 160);
        ui.text("Longest Journey: " + ui.nf(maxDist, 0, 3) + " P", x + 140, y + 180);
    }

    public void update()
    {
        distance += 0.0001f;
        if(distance > maxDist)
        {
            maxDist = distance;
        }
    }
}