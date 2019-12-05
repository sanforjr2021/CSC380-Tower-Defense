package sanforjr2021.tile;

import java.awt.*;

public class Tower extends Tile{
    private Integer shots, level, upgradeCost;
    private Double damage, radius, fireRate;

    public Tower(Integer x, Integer y) {
        super(x, y);
        this.damage = 1.0; //damage dealt to a target
        this.radius = 2.0; //radius it can attack a target.
        this.fireRate = 1.0; //shots per second
        this.shots = 1; //shots shot when shooting
        this.level = 0; //overall level
        this.upgradeCost = 25;
        setName("Tower(Level "+ level + ")");

    }

    public void upgradeTower(){
        level++;
        if(level%2 == 0){
            shots++;
        }
        this.damage *=1.3;
        this.fireRate *= 1.1;
        this.radius *= 1.2;
        upgradeCost = (int)(upgradeCost*1.34);
        setName("Tower(Level "+ level + ")");
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.setColor(Color.magenta);
        g2.fillOval(getX()+2,getY()-2,getWIDTH()-4,getHEIGHT()-4);
    }
}
