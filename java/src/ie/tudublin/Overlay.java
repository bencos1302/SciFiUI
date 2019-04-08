package ie.tudublin;

import java.awt.Stroke;

import org.w3c.dom.Text;

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
        // Text
        ui.fill(255);
        ui.text("Diagnostic Analysis Console    13B", 25, 25);

        ui.textSize(22);
        ui.text("Radar 1", 545, 235);

        ui.text("Radar 2", 545, 460);

        // Left Panel
        ui.stroke(255);
        ui.strokeWeight(4);

        ui.line(0, 100, 40, 140);
        ui.line(40, 140, 440, 140);
        ui.line(440, 140, 480, 180);
        ui.line(480, 180, 480, 700);
        ui.line(480, 700, 440, 740);
        ui.line(40, 740, 440, 740);
        ui.line(40, 740, 0, 780);


        // 3 Boxes
        ui.strokeWeight(2);

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

        // Sensor Information
        ui.strokeWeight(4);
        ui.stroke(255);
        ui.line(720, 140, 830, 140);
        ui.line(830, 140, 850, 120);
        ui.line(850, 120, 1050, 120);
        ui.line(1050, 120, 1070, 140);
        ui.line(1070, 140, 1100, 140);
        ui.line(1100, 140, 1100, 300);
        ui.line(1100, 300, 1000, 300);
        ui.line(1000, 300, 980, 320);
        ui.line(980, 320, 800, 320);
        ui.line(800, 320, 780, 300);
        ui.line(780, 300, 720, 300);
        ui.line(720, 300, 720, 140);
        
        // Right Sidebar
        ui.noFill();
        ui.rect(1150, 50, 100, 700, 18);

        // Top Bar
        ui.rect(700, -50, 400, 100);

        // Graph Box
        ui.rect(740, 370, 350, 350);

        // Right Graph Box

        // ui.rect(0, 160, 430, 560);
        // ui.quad(430, 160, 460, 190, 460, 690, 430, 720);
        // ui.quad(0, 130, 30, 160, 30, 720, 0, 750);

        ui.fill(255);
    }

    public void update()
    {
        
    }
}