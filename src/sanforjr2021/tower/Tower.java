package sanforjr2021.tower;

import java.awt.*;

public class Tower {
    private Integer x,y, shots, level, cost;
    private Double damage, radius, fireRate;



    public Tower(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.damage = 1.0; //damage dealt to a target
        this.radius = 2.0; //radius it can attack a target.
        this.fireRate = 1.0; //shots per second
        this.shots = 1; //shots shot when shooting
        this.level = 0; //overall level
    }
    public void upgradeTower(){
        level++;
        if(level%2 == 0){
            shots++;
        }
        this.damage *=1.3;
        this.fireRate *= 1.1;
        this.radius *= 1.2;
        cost = (int)(cost*1.34);
    }
    public void draw (Graphics2D g2){
        g2.setColor(Color.magenta);
    }
}
