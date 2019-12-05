package sanforjr2021.enemy;

import java.awt.*;

public class Enemy {
    private Integer x,y, gold;
    private Double health, totalHealth;
    private static final Integer WIDTH = 20;
    private static final Integer HEIGHT= 20;

    public Enemy(Integer x, Integer y, Double health) {
        this.x = x;
        this.y = y;
        this.health = health;
        totalHealth = health;
        gold = (int)(totalHealth/5);
    }
    //other methods
    public void draw(Graphics2D g2){
        g2.setColor(new Color(0xff4444));
        g2.fillOval(x,y,WIDTH, HEIGHT);
        //Health bar
        g2.setColor(Color.RED);
        g2.fillRect(x,y+ HEIGHT, WIDTH,4);
        g2.setColor(Color.GREEN);
        int healthBarWidth = (int)(WIDTH* (health/totalHealth));
        g2.fillRect(x, y+HEIGHT, healthBarWidth, 4);
    }
    //getters and setters
    public Integer getX() {
        return x;
    }

    public void addX(Integer x) {
        this.x += x;
    }

    public Integer getY() {
        return y;
    }

    public void addY(Integer y) {
        this.y += y;
    }

    public Double getHealth() {
        return health;
    }

    public void loseHealth(Double health) {
        this.health -= health;
    }

    public Integer getGold() {
        return gold;
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }
}
