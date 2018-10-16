package league_invaders;

import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final int MENU_STATE = 0;
    private final int GAME_STATE = 1;
    private final int END_STATE = 2;
    private int currentState = MENU_STATE;
    private Timer timerGame;
    private Font titleFont;
    //private GameObject gameObject;

    public GamePanel() {
        timerGame = new Timer(1000 / 60, this);
        titleFont =  new Font("Arial", Font.PLAIN, 48);
        //gameObject = new GameObject(10, 10, 100, 100);
    }

    protected void startGame() {
        timerGame.start();
    }

    // States
    private void updateMenuState(){

    }

    private void updateGameState(){

    }

    private void updateEndState(){

    }

    // Drawing states
    private void drawMenuState(Graphics g){
        this.setForeground(Color.WHITE);
        g.setFont(titleFont);
       // g.setColor(Color.WHITE);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
        System.out.println("Avant Text");
        g.drawString("TEXT", 100, 100);

    }

    private void drawGameState(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }

    private void drawEndState(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }

    // ActionListener
    @Override
    public void paintComponent(Graphics g) {
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
            currentState++;
            if (currentState > END_STATE){
                currentState = MENU_STATE;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("In the GamePanel.keyReleased() method");

    }
}
