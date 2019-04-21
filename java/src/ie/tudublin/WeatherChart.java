package ie.tudublin;

public class WeatherChart
{
    UI ui;
    float x, y, size;
    

    public WeatherChart(UI ui, float x, float y, float size)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void render()
    {
        ui.fill(1, 4, 39);
        ui.stroke(20);
        ui.rect(x, y, size, size);
    }

    public void update()
    {

    }
}