package sanforjr2021.enemy;

public class Projectile {
    private Double damage;
    private Integer speed, x, y;

    public Projectile(Double damage, Integer x, Integer y) {
        this.damage = damage;
        this.x = x;
        this.y = y;
        speed = 3;
    }

    public Double getDamage() {
        return damage;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    public boolean findEnemy(int enemyX, int enemyY) {
        if (x > enemyX) {
            x -= speed;
        } else if (x < enemyX) {
            x += speed;
        }
        if (y > enemyY) {
            y -= speed;
        } else if (y < enemyY) {
            y += speed;
        }
        //TODO:calculate if projectile is on target
        if (y > enemyY){
            //return true
        }
        return false;
    }
}
