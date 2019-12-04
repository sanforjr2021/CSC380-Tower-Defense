package sanforjr2021.enemy;

import sanforjr2021.tile.Tile;

import java.awt.*;
import java.util.ArrayList;

public class EnemyList {
    private Integer xSpawn, ySpawn, xEnd, yEnd;
    private ArrayList<Enemy> enemies;

    public EnemyList(Integer xSpawn, Integer ySpawn, Integer xEnd, Integer yEnd) {
        this.xSpawn = xSpawn*Tile.getWIDTH();
        this.ySpawn = ySpawn*Tile.getHEIGHT();
        this.xEnd = xEnd*Tile.getWIDTH();
        this.yEnd = yEnd*Tile.getHEIGHT();
        enemies = new ArrayList<Enemy>();
    }
    public void generateEnemies(int num, int health){
        enemies.add(new Enemy(xSpawn, ySpawn, health));
    }
    public Integer checkForCapture(){
        int damageTaken = 0;
        for(int i = 0; i > enemies.size(); i++){
            if((xEnd < enemies.get(i).getX() && yEnd < enemies.get(i).getY()) ||
                    (xEnd + Tile.getWIDTH() > enemies.get(i).getX() && yEnd + Tile.getHEIGHT()> enemies.get(i).getY())){
                enemies.remove(i);
                damageTaken++;
            }
        }
        return damageTaken;
    }
    public void moveEnemies(){
        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getY() < yEnd + 10){
                enemies.get(i).addY(-1);
            }
            else if(enemies.get(i).getX() < xEnd + 10){
                enemies.get(i).addX(1);
            }
        }
    }
    public void draw(Graphics2D g2){
        for( int i = 0; i < enemies.size(); i++){
            enemies.get(i).draw(g2);
        }
    }

}
