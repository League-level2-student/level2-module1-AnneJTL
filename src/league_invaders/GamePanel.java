package league_invaders;

import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timerGame;
    private GameObject gameObject;

    public GamePanel() {
        this.timerGame = new Timer(1000 / 60, this);
        gameObject = new GameObject(10, 10, 100, 100);
    }

    protected void startGame() {
        timerGame.start();
    }

    // ActionListener
    @Override
    public void paintComponent(Graphics g) {
        gameObject.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameObject.update();
        repaint();
        //System.out.println("In the GamePanel.ActionPerformed() method");
    }

    // KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("In the GamePanel.keyTyped() method");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("In the GamePanel.keyPressed() method");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("In the GamePanel.keyReleased() method");

    }
}
