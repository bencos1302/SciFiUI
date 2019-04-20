package ie.tudublin;

public class WeaponAmmo extends Monitor
{
    private int clipSize;
    private int totalAmount;

    private float radius = 180;

    // Constructor
    public WeaponAmmo(UI ui, float x, float y, int clipSize, int totalAmount)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.clipSize = clipSize;
        this.totalAmount = totalAmount;
    }

    public void render()
    {
        ui.fill(0);
        ui.stroke(255);
        ui.ellipse(x, y, radius, radius);
        ui.ellipse(x - 130, y + 120, radius * 3 / 4, radius * 3 / 4);
        
        ui.textSize(40);
        ui.fill(255);
        ui.text(totalAmount, x, y);
        ui.textSize(60);
        ui.text(clipSize, x - 130, y + 115);
        ui.textSize(16);
        ui.text("Ammo:", x, y - 110);
    }

    public void update()
    {
        
    }

}