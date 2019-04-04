package ie.tudublin;

import java.awt.Stroke;

import processing.core.PApplet;

public class Overlay
{
    UI ui;

    public Overlay(UI ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        ui.text("Diagnostic Console", 30, 20);
        ui.text("V6.24", 300, 20);

        ui.fill(255); // Light Gray
        ui.noStroke();
        ui.rect(0, 120, 440, 600);


        ui.triangle(0, 660, 0, 710, 50, 660);

        ui.fill(255);
    }
}