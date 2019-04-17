package ie.tudublin;

public class Overlay
{
    UI ui;

    public Overlay(UI ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        // Text
        ui.fill(255);
        ui.text("Diagnostic Analysis Console", 250, 20);

        // Left Panel
        ui.stroke(255);
        ui.strokeWeight(2);

        ui.line(0, 100, 40, 140);
        ui.line(40, 140, 440, 140);
        ui.line(440, 140, 480, 180);
        ui.line(480, 180, 480, 700);
        ui.line(480, 700, 440, 740);
        ui.line(40, 740, 440, 740);
        ui.line(40, 740, 0, 780);
    }

    public void update()
    {
        
    }
}