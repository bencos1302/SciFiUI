package ie.tudublin;

public class WeaponSystem extends Monitor
{
    private String[] weapons = {"Machine Gun", "Rocket Launcher", "EMP Grenade", "Nuclear Warhead", "Orbital Bomb"};
    private String[] status = {"Active", "Active", "Active", "Inactive", "Active"};

    private int counter;

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
            ui.stroke(0);
            ui.noFill();
            ui.rect(x - 1 + (i*120), y - 1, 101, 301);
            if (status[i] == "Active")
            {
                // Green
                ui.fill(60,179,113);
            }
            else
            {
                // Red
                ui.fill(139,0,0);
            }
            ui.rect(x + (i*120), y, 100, counter);
            ui.fill(255);
            ui.textSize(14);
            ui.text(status[i], x + 50 + (i * 120), y + 150);
            ui.textSize(10);
            ui.fill(255);
            ui.text(weapons[i], x + 50 + (i * 120), y + 320);
        }
    }

    public void update()
    {
        if (counter >= 300)
        {
            counter = 0;
        }
        else
        {
            counter+=5;
        }

        
    }

    public void fire()
    {

    }
}