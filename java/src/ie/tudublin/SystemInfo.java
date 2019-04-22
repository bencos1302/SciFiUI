package ie.tudublin;

public class SystemInfo
{
    UI ui;
    float x, y, width, height;
    String build;

    int counter;

    float offset = 240;
    float size = 400;

    public SystemInfo(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        build = Float.toString(x + y);
    }

    public void render()
    {
        ui.fill(0);
        ui.stroke(255);
        ui.rect(x, y, width, height, 30);
        drawShip();
        displayDetails();
    }

    public void update()
    {

    }

    public void drawShip()
    {
        ui.noFill();
        for(int i = 0; i < 3; i++)
        {
            // Body
            ui.fill(20);
            ui.ellipse(x + offset, y + offset, size, size);
            ui.ellipse(x + offset, y + offset, size - 15, size - 15);

            // Left leg
            ui.rect(x + 80, y + 300, 50, 160);
            // Right leg
            ui.rect(x + 350, y + 300, 50, 160);

            // Guns
            ui.rect(x + 110, y + 40, 40, 120);
            ui.rect(x + 120, y + 35, 20, 5);    // Left
            ui.rect(x + 320, y + 40, 40, 120);
            ui.rect(x + 330, y + 35, 20, 5);    // Right
        
            // Inner Body
            ui.ellipse(x + offset, y + offset, size - 30, size - 30);
            ui.ellipse(x + offset, y + offset, size - 45, size - 45);
            ui.strokeWeight(3);
            ui.line(x + 64, y + offset, x + 415, y + offset);
            ui.strokeWeight(2);

            // Middle leg
            ui.rect(x + offset - 25, y + 360, 50, 160);

            // Window
            ui.fill(220);
            ui.ellipse(x + offset, y + offset - 100, 200, 100);
        }
    }

    public void displayDetails()
    {
        int gap = 50;
        String s = "Originally built as an effort to combat the ongoing space race between Terran and Alien planets, this model established itself quickly as one of the safest and most efficient ships among the stars.";

        ui.textSize(20);
        ui.fill(255);
        ui.text("CosTech Model B13 \"IRIS\"", x + offset, y + 550);
        
        ui.textSize(16);
        ui.text("Version: VB1.0", x + offset * 2, y + gap);
        ui.text("21 April 2093", x + offset * 2 + 30, y + gap * 2);

        ui.text(s, x + offset + 220, y + 130, 150, 440);
    }
}