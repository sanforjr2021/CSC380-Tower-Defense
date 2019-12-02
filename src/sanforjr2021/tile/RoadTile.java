package sanforjr2021.tile;

import java.awt.*;

public class RoadTile extends Tile{
    private String type; //3 States: spawn, home, road. Default is road
    public RoadTile(Integer x, Integer y, String type){
        super(x, y);
        this.type = type;
    }
    public RoadTile(Integer x, Integer y){
        super(x,y);
        type = "road";
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(0x3E3F3D));
        g2.fillRect(getY(),getX(),getWIDTH(),getHEIGHT());
        switch(type){
            case "spawn":
                g2.setColor(new Color(0x8F1800));
                g2.fillOval(getX(),getY(),getWIDTH(),getHEIGHT());
                break;
            case "home":
                g2.setColor(new Color(0x248F1E));
                g2.fillOval(getX(),getY(),getWIDTH(),getHEIGHT());
                break;
            default:
                break;
        }
    }
}
