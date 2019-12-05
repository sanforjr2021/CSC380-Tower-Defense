package sanforjr2021.enemy;

import java.awt.*;
import java.util.ArrayList;

public class Enemy {
    private Integer x,y, gold;
    private Double health, totalHealth;
    private static final Integer WIDTH = 20;
    private static final Integer HEIGHT= 20;
    private ArrayList<Projectile> projectiles;

    public Enemy(Integer x, Integer y, Double health) {
        this.x = x;
        this.y = y;
        this.health = health;
        totalHealth = health;
        gold = (int)(totalHealth/5)+1;
        projectiles = new ArrayList<Projectile>();

    }
    //other methods
    public void draw(Graphics2D g2){
        //Draw projectiles
        for(Projectile projectile: projectiles){
            projectile.draw(g2);
        }
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


    public Integer getGold() {
        return gold;
    }

    public static Integer getWIDTH() {
        return WIDTH;
    }

    public static Integer getHEIGHT() {
        return HEIGHT;
    }

    public void addProjectile(Projectile projectile){
        projectiles.add(projectile);
    }
    public void moveProjectiles(){
        if(projectiles.size() == 0){
            return;
        }
        for(int i = 0; i < projectiles.size(); i++){
            if(projectiles.get(i).findEnemy(x,y)){
                health -= projectiles.get(i).getDamage();
                projectiles.remove(projectiles.get(i));
            }
        }
    }
}
