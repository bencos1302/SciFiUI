package ie.tudublin;

public class Time
{
    private UI ui;
    int s = ui.second();
    int m = ui.minute();
    int h = ui.hour();
    char[] seconds;
    char[] minutes;
    char[] hours;

    public Time(UI ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        // Current Time
        ui.textSize(50);

        if (h < 10)
        {
            
            ui.text("0" + h, 60, 95);
        }
        else
        {
            ui.text(h, 60, 95);
        }
        
        if (m < 10)
        {
            ui.text("0" + m, 190, 95);
        }
        else
        {
            ui.text(m, 190, 95);
        }

        if (s < 10)
        {
            ui.text("0" + s, 320, 95);
        }
        else
        {
            ui.text(s, 320, 95);
        }
    }

    public void update()
    {
        s = ui.second();
        seconds = ("" + s).toCharArray();

        m = ui.minute();
        minutes = ("" + m).toCharArray();

        h = ui.hour();
        hours = ("" + h).toCharArray();
    }
}