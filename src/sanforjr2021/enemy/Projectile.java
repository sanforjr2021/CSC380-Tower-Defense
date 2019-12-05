package sanforjr2021.enemy;

import java.awt.*;

public class Projectile {
    private Double damage;
    private Integer speed, x, y;

    public Projectile(Double damage, Integer x, Integer y) {
        this.damage = damage;
        this.x = x;
        this.y = y;
        speed = 2;
    }
    public Double getDamage() {
        return damage;
    }

    public boolean findEnemy(int enemyX, int enemyY) {
        if (y > enemyY-1  && y < enemyY + Enemy.getHEIGHT()+1 && enemyX-1 < x && enemyX + Enemy.getHEIGHT()+1 > x){
            return true;
        }
        if (x > enemyX) {
            x -= speed;
        } else if (x < enemyX+Enemy.getWIDTH()) {
            x += speed;
        }
        if (y > enemyY) {
            y -= speed;
        } else if (y < enemyY + Enemy.getHEIGHT()) {
            y += speed;
        }
        return false;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.ORANGE);
        g2.fillOval(x-1,y-1,3,3);
    }
}
