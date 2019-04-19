package ie.tudublin;

public class FuelTank
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    private float counter;

    public FuelTank(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.noFill();
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.rect(x, y, width, height);

        ui.noStroke();
        ui.fill(204,204,0);
        ui.rect(x + 1, y + 1, (width - 1) - counter, height - 1);

        ui.fill(255);
        ui.textSize(40);
        ui.text(text, x + width / 2, y + height / 2);        
    }

    public void update()
    {
        if (counter < (width - 1))
        {
            counter += 0.02f;
        }
        else
        {
            counter = 0f;
        }
    }
}