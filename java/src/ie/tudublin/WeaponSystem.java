package ie.tudublin;

public class WeaponSystem extends Monitor
{
    private String[] weapons = {"Machine Gun", "Rocket Launcher", "EMP Grenade", "Nuclear Warhead", "Orbital Bomb"};
    private String[] status = {"Active", "Active", "Active", "Inactive", "Active"};

    public WeaponSystem(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        for(int i = 0; i < 5; i++)
        {
            ui.noFill();
            ui.rect(x + (i*120), y, 100, 300);
            ui.fill(255);
            ui.textSize(10);
            ui.text(weapons[i], x + 50 + (i * 120), y + 320);
            if (status[i] == "Active")
            {
                ui.fill(0,128,0);
            }
            else
            {
                ui.fill(139,0,0);
            }
            ui.text(status[i], x + 50, y + 150);
        }
    }

    public void update()
    {

    }
}