package sanforjr2021;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

public class GameGUI {
    private Integer x, y, width, height, lives, gold;
    public GameGUI(Integer x, Integer y, Integer width, Integer height, Integer lives, Integer gold) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lives = lives;
        this.gold = gold;
    }
    public void draw(Graphics2D g2){
        //store transforms for drawing
        AffineTransform originalTransform = g2.getTransform();
        AffineTransform text = new AffineTransform();
        g2.translate(x,y);
        g2.setColor(new Color(0x486A81));
        g2.fillRect(0,0,width,height);
        //Draw Text
        g2.setTransform(text);
        g2.translate(x,y);
        g2.setFont(new Font("impact", 1, 32));
        g2.setColor(Color.red);
        if(lives < 1){
            g2.drawString("Game Over", 10, 32);
        }
        else {
            g2.drawString("Lives: " + lives, 10, 32);
        }
        g2.setColor(Color.ORANGE);
        g2.drawString("Gold: " + gold, 10, 64);
        g2.setTransform(originalTransform);
    }
    //getters & setters
    public Integer getLives() {
        return lives;
    }

    public void subtractLives(Integer lives) {
        this.lives -= lives;
    }

    public Integer getGold() {
        return gold;
    }

    public void addGold(Integer gold) {
        this.gold += gold;
    }
    public void subtractGold(Integer gold){
        this.gold-= gold;
    }
}
