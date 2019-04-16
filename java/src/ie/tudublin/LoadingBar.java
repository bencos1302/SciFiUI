package ie.tudublin;

public class LoadingBar
{
    UI ui;
    float x, y, width, height;

    public LoadingBar(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setup()
    {
        ui.stroke(255);
        ui.noFill();
    }

    public void render()
    {
        
    }

    public void update()
    {

    }
}