package sanforjr2021.tile;

import java.awt.*;

public class RoadTile extends Tile{
    private String type; //3 States: spawn, home, road. Default is road
    public RoadTile(Integer x, Integer y, String type){
        super(x, y);
        this.type = type;
        setName(type + " Tile");
    }
    public RoadTile(Integer x, Integer y){
        super(x,y);
        type = "road";
        setName(type + " Tile");
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(0x606070));
        g2.fillRect(getX(),getY(),getWIDTH(),getHEIGHT());
        g2.setColor(new Color(0x59898A));
        g2.drawRect(getX(),getY(),getWIDTH(),getHEIGHT());
        switch(type){
            case "spawn":
                g2.setColor(new Color(0x8F1800));
                g2.fillRect(getX()+4,getY()+4,getWIDTH()-8,getHEIGHT()-8);
                break;
            case "home":
                g2.setColor(new Color(0x248F1E));
                g2.fillOval(getX()+4,getY()+4,getWIDTH()-8,getHEIGHT()-8);
                break;
            default:
                //do nothing. This is a normal road
                break;
        }
    }
}
