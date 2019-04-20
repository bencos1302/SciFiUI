package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Radar
{
    private float x, y;
    private float radius;
    private PVector pos;
    private float frequency;
    private UI ui;
    private String text;
    private float theta = 0;

    public Radar(UI ui, float frequency, float x, float y, float radius, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
        this.text = text;
    }

    public void render()
    {
        ui.fill(0);
        ui.stroke(255);
        ui.strokeWeight(3);
        ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        float x2 = pos.x + (float) Math.sin(theta) * radius;
        float y2 = pos.y - (float) Math.cos(theta) * radius;
        ui.line(pos.x, pos.y, x2, y2);
        ui.strokeWeight(1);
        ui.fill(255);
        ui.textSize(16);
        ui.text(text, x, y + radius + 20);
    }

    float timeDelta = 1.0f / 240.0f;

    public void update()
    {
        theta += PApplet.TWO_PI * timeDelta * frequency;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    
}