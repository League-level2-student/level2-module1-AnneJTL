package league_invaders;

import java.awt.*;

public class ObjectManager {
    private Rocketship rocketship;

    public ObjectManager(Rocketship rocketship) {
        this.rocketship = rocketship;
    }

    protected void update(){
        rocketship.update();
    }

    protected void draw(Graphics g){
        rocketship.draw(g);
    }
}
