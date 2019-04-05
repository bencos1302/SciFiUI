package ie.tudublin;

import java.awt.Stroke;

import org.w3c.dom.Text;

import processing.core.PApplet;

public class Overlay
{
    UI ui;
    int s = ui.second();
    int m = ui.minute();
    int h = ui.hour();

    public Overlay(UI ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        // Top-left screen text
        ui.text("Diagnostic Analysis Console    13B", 25, 25);

        // Left Panel
        ui.fill(225);
        ui.noStroke();
        ui.quad(0, 100, 40, 140, 40, 740, 0, 780); // Pointy Edges
        ui.rect(0, 140, 440, 600); // Main Panel        
        ui.quad(440, 140, 480, 180, 480, 700, 440, 740); // Chamfered Edges

        // 3 Boxes
        ui.stroke(255);

        ui.line(50, 40, 50, 120);
        ui.line(50, 40, 60, 40);
        ui.line(50, 120, 60, 120);

        ui.line(150, 40, 150, 120);
        ui.line(150, 40, 140, 40);
        ui.line(150, 120, 140, 120);

        ui.line(180, 40, 180, 120);
        ui.line(180, 40, 190, 40);
        ui.line(180, 120, 190, 120);

        ui.line(280, 40, 280, 120);
        ui.line(280, 40, 270, 40);
        ui.line(280, 120, 270, 120);

        ui.line(310, 40, 310, 120);
        ui.line(310, 40, 320, 40);
        ui.line(310, 120, 320, 120);

        ui.line(410, 40, 410, 120);
        ui.line(410, 40, 400, 40);
        ui.line(410, 120, 400, 120);

        // Current Time
        ui.textSize(50);
        ui.text(ui.hour(), 75, 95);
        ui.text(ui.minute(), 190, 95);
        if (ui.second() < 10)
        {
            ui.text("0" + ui.second(), 320, 95);
        }
        else
        {
            ui.text(ui.second(), 320, 95);
        }

        // ui.rect(0, 160, 430, 560);
        // ui.quad(430, 160, 460, 190, 460, 690, 430, 720);
        // ui.quad(0, 130, 30, 160, 30, 720, 0, 750);

        ui.fill(255);
    }
}