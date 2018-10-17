package league_invaders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager {
    private Rocketship rocketship;
    private List<Projectile> allProjectiles;
    private List<Alien> allAliens;
    private long enemyTimer = 0;
    private int enemySpawnTime = 5000;
    private int score = 0;


    public ObjectManager(Rocketship rocketship) {
        this.rocketship = rocketship;
        allProjectiles = new ArrayList<>();
        allAliens = new ArrayList<>();
    }

    protected int getScore(){
        return score;
    }

    protected void update() {
        rocketship.update();
        for (Projectile projectile : allProjectiles) {
            projectile.update();
        }
        for (Alien alien : allAliens) {
            alien.update();
        }
    }

    protected void draw(Graphics g) {
        rocketship.draw(g);
        for (Projectile projectile : allProjectiles) {
            projectile.draw(g);
        }
        for (Alien alien : allAliens) {
            alien.draw(g);
        }
    }

    public void checkCollision(){
        for(Alien alien : allAliens){
            if(rocketship.collisionBox.intersects(alien.collisionBox)){
                rocketship.isAlive = false;
                alien.isAlive = false;
            }

            for(Projectile projectile : allProjectiles){
                if (projectile.collisionBox.intersects(alien.collisionBox)){
                    projectile.isAlive = false;
                    alien.isAlive = false;
                    score++;
                }
            }
        }


    }

    public void manageEnemies() {
        if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH-50), 0, 50, 50));

            enemyTimer = System.currentTimeMillis();
        }
    }

    protected void addProjectile(Projectile aProjectile) {
        allProjectiles.add(aProjectile);
    }

    protected void addAlien(Alien anAlien) {
        allAliens.add(anAlien);
    }

    protected void purgeObjects(){
        for (int i=0; i < allProjectiles.size(); i++){
            if (allProjectiles.get(i).isAlive == false)
                allProjectiles.remove(i);
        }
        for (int i=0; i < allAliens.size(); i++){
            if (allAliens.get(i).isAlive == false)
                allAliens.remove(i);
        }
    }
}
