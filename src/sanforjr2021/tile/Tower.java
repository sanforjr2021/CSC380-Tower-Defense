package sanforjr2021.tile;

import sanforjr2021.enemy.Projectile;

import java.awt.*;

public class Tower extends Tile{
    private Integer level, upgradeCost;
    private Double damage, radius;
    private Integer centerX, centerY;

    public Tower(Integer x, Integer y) {
        super(x, y);
        this.damage = 1.0; //damage dealt to a target
        this.radius = 2.5; //radius it can attack a target in tiles
        this.level = 1; //overall level
        this.upgradeCost = 25;
        centerX = this.getX()+getWIDTH()/2;
        centerY = this.getY()+getHEIGHT()/2;
        setName("Tower(Level "+ level + ")");
    }
    public Projectile createProjectile(){
        return new Projectile(damage, centerX, centerY);
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getUpgradeCost() {
        return upgradeCost;
    }

    public Double getDamage() {
        return damage;
    }

    public Double getRadius() {
        return radius;
    }

    public Integer getCenterX() {
        return centerX;
    }

    public Integer getCenterY() {
        return centerY;
    }

    public void upgradeTower(){
        level++;
        this.damage *=1.67;
        this.radius *= 1.34;
        upgradeCost = (int)(upgradeCost*1.25);
        setName("Tower(Level "+ level + ")");
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.setColor(Color.magenta);
        g2.fillOval(getX()+2,getY()+2,getWIDTH()-4,getHEIGHT()-4);
    }

    @Override
    public void drawAsSelected(Graphics2D g2) {
        super.drawAsSelected(g2);
        g2.setColor(new Color(255, 250, 0, 51));
        g2.fillOval(centerX-(int)(getWIDTH()*radius), centerY-(int)(getHEIGHT()*radius), (int)(getWIDTH()*radius*2), (int)(getHEIGHT()*radius*2));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDamage:"+ damage +
                "\nRadius:" + radius+
                "\nUpgrade Cost:" + upgradeCost;
    }
}
