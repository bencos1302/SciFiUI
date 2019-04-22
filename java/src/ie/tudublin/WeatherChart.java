package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class WeatherChart extends PApplet
{
    UI ui;
    float x, y, size;

    float border;
    
    ArrayList<Location> locations = new ArrayList<Location>();

    public WeatherChart(UI ui, float x, float y, float size)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
        border = size * 0.05f;
    }

    public void render()
    {
        ui.fill(255);
        ui.text("Andromeda Galaxy Sector B14", x + size / 2, y - 20);
    }

    public void update()
    {

    }

    public void loadData(Table table)
    {
        for (TableRow row : table.rows())
        {
            Location location = new Location(row);
            locations.add(location);
        }
    }

    public void printLocations()
    {
        for (Location location : locations)
        {
            System.out.println(location);
        }
    }

    public void drawGrid()
    {
        ui.fill(255);
        ui.fill(1, 4, 39);
        ui.stroke(20);
        ui.rect(x, y, size, size);
        for(int i = -5; i <= 5; i++)
        {
            ui.textAlign(CENTER, CENTER);
            float placement = map(i, -5, 5, border, size - border);
            ui.stroke(0, 0, 139);
            ui.line(placement + x, border + y, placement + x, size - border + y);
            ui.line(border + x, placement + y, size - border + x, placement + y);
        }
    }

    public void drawLocations()
    {
        ui.textAlign(CENTER, CENTER);
        for (Location location : locations)
        {
            float xLoc = location.getX();
            float yLoc = location.getY();

            // Circle
            ui.stroke(255, 239, 0);
            ui.noFill();
            ui.ellipse(xLoc, yLoc, location.getSize(), location.getSize());

            // Crosshair
            ui.line(xLoc, yLoc - 10, xLoc, yLoc + 5);
            ui.line(xLoc - 5, yLoc, xLoc + 5, yLoc);
            ui.fill(255);

            // Label
            ui.textSize(12);
            ui.text(location.getName(), xLoc, yLoc + 10);
            ui.text(location.getDanger(), xLoc, yLoc + 20);
        }
    }
}