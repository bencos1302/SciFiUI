package ie.tudublin;

public class PowerBar
{
    UI ui;
    float x, y, width, height;
    float offset = 0;
    int direction = 1;
    int speed;

    public PowerBar(UI ui, float x, float y, float width, float height, int speed)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void render()
    {
        ui.strokeWeight(2);
        ui.stroke(255);

        //Status text
        ui.textSize(16);
        ui.text("Power Status: ", x + 90, y - height / 2);
        if(ui.power == true)
        {
            ui.fill(127,255,0);
            ui.text("ON", x + 200, y - height / 2);
        }
        else
        {
            ui.fill(139,0,0);
            ui.text("ON", x + 200, y - height / 2);
        }

        // Rectangle
        ui.noFill();
        ui.rect(x, y, width, height);
        
        // Travelling Bar
        ui.fill(255);
        ui.noStroke();
        ui.rect(x + offset, y, width / 10, height);
    }

    public void update()
    {
        if (ui.power == true)
        {
            // If travelling bar reaches right edge of power bar
            if(offset >= width - (width / 10))
            {
                direction = -1;
            }
            // If travelling bar reaches left edge of power bar
            if(offset <= 0)
            {
                direction = 1;
            }
            offset += direction * speed;
        }
        else
        {
            offset = 0;
        }
    }
}