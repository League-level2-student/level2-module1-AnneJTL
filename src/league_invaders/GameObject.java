package league_invaders;

import java.awt.*;

public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void update(){
        x++;
        y++;

    }

    protected void draw(Graphics g){
        g.fillRect(x, y, 100, 100);

    }
}
