package league_invaders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private Rocketship rocketship;
    private List<Projectile> allProjectiles;

    public ObjectManager(Rocketship rocketship) {
        this.rocketship = rocketship;
        allProjectiles = new ArrayList<>();
    }

    protected void update(){
        rocketship.update();
        for (Projectile projectile : allProjectiles) {
            projectile.update();
        }
    }

    protected void draw(Graphics g){
        rocketship.draw(g);
        for (Projectile projectile : allProjectiles) {
            projectile.draw(g);
        }
    }

    protected void addProjectile(Projectile aProjectile){
        allProjectiles.add(aProjectile);
    }
}
