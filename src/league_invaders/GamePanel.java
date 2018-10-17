package league_invaders;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final int MENU_STATE = 0;
    private final int GAME_STATE = 1;
    private final int END_STATE = 2;
    private int currentState = MENU_STATE;
    private Timer timerGame;
    private Font titleFont;
    private Font textFont;
    //private int nbEnemies = 0;
    private Rocketship rocketship;
    private ObjectManager objectManager;

    // images
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;


    public GamePanel() {
        timerGame = new Timer(1000 / 60, this);
        titleFont =  new Font("Arial", Font.PLAIN, 48);
        textFont =  new Font("Arial", Font.PLAIN, 20);
        rocketship = new Rocketship(250, 700, 50, 50);
        objectManager = new ObjectManager(rocketship);


        try {
            alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
            rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
            bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
            spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void startGame() {
        timerGame.start();
    }

    // States
    private void updateMenuState(){

    }

    private void updateGameState(){
        //System.out.println("In GamePanel.updateGameState(): " + rocketship.getDirection());
        objectManager.update();
        objectManager.manageEnemies();
        objectManager.checkCollision();
        objectManager.purgeObjects();
        if (!rocketship.isAlive){
            currentState = END_STATE;
        }
    }

    private void updateEndState(){

    }

    // Drawing states
    private void drawMenuState(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("LEAGUE INVADERS", 20, 150);
        g.setFont(textFont);
        g.drawString("Press ENTER to start", 150, 400);
        g.drawString("Press SPACE for instructions", 130, 600);


    }

    private void drawGameState(Graphics g){
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

        objectManager.draw(g);
    }

    private void drawEndState(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(titleFont);
        g.drawString("Game Over", 120, 150);
        g.setFont(textFont);
        g.drawString("You killed " + objectManager.getScore() + " enemies", 150, 400);
        g.drawString("Press ENTER to restart", 135, 600);
    }

    // ActionListener
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);

        if(currentState == MENU_STATE){
            drawMenuState(g);
        }else if(currentState == GAME_STATE){
            drawGameState(g);
        }else if(currentState == END_STATE){
            drawEndState(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentState == MENU_STATE){
            updateMenuState();
        }else if(currentState == GAME_STATE){
            updateGameState();
        }else if(currentState == END_STATE){
            updateEndState();
        }

        repaint();
    }

    // KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("In the GamePanel.keyTyped() method");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("In the GamePanel.keyPressed() method");
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            if (currentState == END_STATE){
                rocketship = new Rocketship(250, 700, 50, 50);
                objectManager = new ObjectManager(rocketship);
            }
            currentState++;
            if (currentState > END_STATE){
                currentState = MENU_STATE;
            }


        }
        //System.out.println("e.getKeyCode()=" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            rocketship.setDirection(LeagueInvaders.LEFT);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            rocketship.setDirection(LeagueInvaders.RIGHT);
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            objectManager.addProjectile
                    (new Projectile
                            (rocketship.x + rocketship.width/2, rocketship.y, 10, 10));

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("In the GamePanel.keyReleased() method");
        rocketship.setDirection(LeagueInvaders.UNDEFINED);
    }
}
