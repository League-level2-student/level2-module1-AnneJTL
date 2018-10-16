package league_invaders;

import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener  {
    private Timer timerGame;

    @Override

    public void paintComponent(Graphics g){

        g.fillRect(10, 10, 100, 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        //System.out.println("In the GamePanel.ActionPerformed() method");
    }

    public GamePanel() {
        this.timerGame = new Timer(1000/60, this);
    }

    public void startGame(){
        timerGame.start();
    }
}
