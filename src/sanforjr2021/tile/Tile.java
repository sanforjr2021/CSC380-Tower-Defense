package sanforjr2021.tile;


import java.awt.*;

public class Tile {
    private static final Integer WIDTH = 40;  //stick as a constant to reduce memory usage
    private static final Integer HEIGHT = 40;
    private Integer x, y;

    public Tile(Integer x, Integer y) {
        this.x = x*WIDTH;
        this.y = y*HEIGHT;
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void draw(Graphics2D g2){
        g2.setColor(new Color(0x343A39));
        g2.fillRect(x,y,WIDTH,HEIGHT);
        //set a border around the shape
        g2.setColor(new Color(0x3B595A));
        g2.drawRect(x,y,WIDTH,HEIGHT);
    }
}
