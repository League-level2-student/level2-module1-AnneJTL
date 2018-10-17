package league_invaders;

import java.awt.*;

public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean isAlive;
    protected Rectangle collisionBox;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
        this.collisionBox = new Rectangle(x, y, width, height);
    }

    protected void update(){
        collisionBox.setBounds(x, y, width, height);
    }

    protected void draw(Graphics g){
    }


}
