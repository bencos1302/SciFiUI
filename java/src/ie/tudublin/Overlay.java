package ie.tudublin;

import processing.core.PApplet;

public class Overlay
{
    UI ui;
    private int colour;

    public Overlay(UI ui, int colour)
    {
        this.ui = ui;
        this.colour = colour;
    }

    public void render()
    {
        ui.fill(colour);
        ui.rect(0, 800, 200, 600);
    }
}