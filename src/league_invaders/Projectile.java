package league_invaders;

import java.awt.*;

public class Projectile extends GameObject {
    private int speed;

    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 10;
    }

    protected void update() {
        super.update();
        y--;
        if (y <= 0)
            isAlive = false;
    }

    protected void draw(Graphics g){
        g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

    }
}
