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
        ui.textSize(48);

        if (h < 10)
        { 
            ui.text("0" + h, 105, 75);
        }
        else
        {
            ui.text(h, 105, 75);
        }
        
        if (m < 10)
        {
            ui.text("0" + m, 235, 75);
        }
        else
        {
            ui.text(m, 235, 75);
        }

        if (s < 10)
        {
            ui.text("0" + s, 365, 75);
        }
        else
        {
            ui.text(s, 365, 75);
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