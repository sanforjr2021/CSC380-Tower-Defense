package sanforjr2021.tile;

import java.awt.*;

public class Tower extends Tile{
    private Integer level, upgradeCost;
    private Double damage, radius, fireRate;
    private Integer centerX, centerY;

    public Tower(Integer x, Integer y) {
        super(x, y);
        this.damage = 1.0; //damage dealt to a target
        this.radius = 2.5; //radius it can attack a target in tiles
        this.fireRate = 1.0; //shots per second
        this.level = 0; //overall level
        this.upgradeCost = 25;
        centerX = this.getX()+getWIDTH()/2;
        centerY = this.getY()+getHEIGHT()/2;
        setName("Tower(Level "+ level + ")");

    }

    public void upgradeTower(){
        level++;
        this.damage *=1.34;
        this.fireRate *= 1.1;
        this.radius *= 1.34;
        upgradeCost = (int)(upgradeCost*1.34);
        setName("Tower(Level "+ level + ")");
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.setColor(Color.magenta);
        g2.fillOval(getX(),getY(),getWIDTH(),getHEIGHT());
    }

    @Override
    public void drawAsSelected(Graphics2D g2) {
        super.drawAsSelected(g2);
        g2.setColor(new Color(255, 250, 0, 51));
        g2.fillOval(centerX-(int)(getWIDTH()*radius/2), centerY-(int)(getHEIGHT()*radius/2), (int)(getWIDTH()*radius), (int)(getHEIGHT()*radius));
    }
}
