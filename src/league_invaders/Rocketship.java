package league_invaders;

import java.awt.*;

public class Rocketship extends GameObject {
    private int speed;
    private int direction = LeagueInvaders.UNDEFINED;
    public Rocketship(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 5;
    }

    protected void setDirection(int direction){
            this.direction = direction;
    }

    protected int getDirection(){
        return direction;
    }

    protected void update(){
        if (direction == LeagueInvaders.LEFT) {
            if ((x-speed) <= 0)
                x = 0;
            else x -= speed;
        }

        if (direction == LeagueInvaders.RIGHT) {
            if ((x+speed) >= LeagueInvaders.WIDTH - width)
                x = LeagueInvaders.WIDTH - width;
            else x += speed;
        }

    }

    protected void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
