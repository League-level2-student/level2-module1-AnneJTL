package league_invaders;

import java.awt.*;

public class Alien extends GameObject {
    public Alien(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    protected void update() {
        super.update();
        y++;
        if (y >= LeagueInvaders.HEIGHT)
            isAlive = false;
    }

    protected void draw(Graphics g){
        g.drawImage(GamePanel.alienImg, x, y, width, height, null);

    }
}
