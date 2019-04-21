package ie.tudublin;

import processing.data.TableRow;

public class Location
{
    private String name;
    private float xCoord;
    private float yCoord;
    private float size;
    private int danger;

    // Set and Get Name
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    // Set and Get X co-ordinate
    public void setX(float xCoord)
    {
        this.xCoord = xCoord;
    }

    public float getX()
    {
        return xCoord;
    }

    // Set and Get Y co-ordinate
    public void setY(float yCoord)
    {
        this.yCoord = yCoord;
    }   

    public float getY()
    {
        return yCoord;
    }

    // Set and Get size
    public void setSize(float size)
    {
        this.size = size;
    }

    public float getSize()
    {
        return size;
    }

    // Set and Get danger
    public void setDanger(int danger)
    {
        this.danger = danger;
    }

    public int getDanger()
    {
        return danger;
    }

    // To print location details together
    public String toString()
    {
        return name + "\t" + xCoord + "\t" + yCoord + "\t" + size + "\t" + danger;
    }

    public Location(TableRow row)
    {
        name = row.getString("name");
        xCoord = row.getFloat("x");
        yCoord = row.getFloat("y");
        size = row.getFloat("size");
        danger = row.getInt("danger");
    }

    public Location()
    {

    }
}