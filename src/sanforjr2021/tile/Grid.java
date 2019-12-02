package sanforjr2021.tile;

import java.awt.*;

public class Grid {
    private Tile[][] tileArray;
    private Integer x,y;
    private Integer xSpawn, ySpawn, xEnd, yEnd;

    public Grid(Integer x, Integer y, Integer xSpawn, Integer ySpawn, Integer xEnd, Integer yEnd) {
        this.x = x;
        this.y = y;
        this.xSpawn = xSpawn;
        this.ySpawn = ySpawn;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        tileArray = new Tile[x][y];
        generateGrid();
    }

    public void generateGrid(){
        for(int x = 0; x <= this.x; x++){
            for(int y = 0; y <= this.y; y++){
                tileArray[x][y] = new Tile(x*40,y*40);
            }
        } 
    }

    public Integer getXSpawn() {
        return xSpawn;
    }

    public Integer getYSpawn() {
        return ySpawn;
    }

    public Integer getXEnd() {
        return xEnd;
    }

    public Integer getYEnd() {
        return yEnd;
    }

    public void draw(Graphics2D g2){
        for(int x = 0; x <= this.x; x++) {
            for (int y = 0; y <= this.y; y++) {
                tileArray[x][y].draw(g2);
            }
        }
    }
    public Tile getTile(int x, int y){
        return tileArray[x][y];
    }
    public void replaceTile(int x, int y, Tile tile){
        tileArray[x][y] = tile;
    }
}
