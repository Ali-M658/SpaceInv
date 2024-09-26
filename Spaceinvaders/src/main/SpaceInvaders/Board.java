package main.SpaceInvaders;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JFrame
{
    //Start parameters (add more for later)
    public ImagePanel imagePanel;
    public ImagePanel alienImagePanel;
    private int moveDirection;
    private Timer timer;
    private int spriteX = 50;
    private int spriteY = 50;
    private int deltaX = 0;
    private int deltaY = 0;

    //List what has lasers in it
    private ArrayList<Laser> lasers;

    public Board()
    {
        //Setting types for the board
        setTitle("Space Invaders");
        setBackground(Color.BLACK);
        setSize(540, 540);
        setLocation(480, 135);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make image panel and laser list

        imagePanel = new ImagePanel("C:\\Users\\dimao\\Downloads\\pixil-frame-0.png");
        alienImagePanel = new ImagePanel("C:\\Users\\dimao\\.jdks\\openjdk-22.0.2\\lib\\aliensprite.webp");
        lasers = new ArrayList<>();

        //Running imagePanel graphics
        add(imagePanel, BorderLayout.CENTER);
        //These bool values let you see the image and interact with it
        setVisible(true);
        setFocusable(true);


        timer = new Timer(10, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                moveSpaceShipAndLaser(deltaX, deltaY);
            }
        });
        timer.start();
        //Key inputs into movements

    }

    public void moveSpaceShipAndLaser(int dx, int dy)
    {
        timer.start();

        int movedX = spriteX + dx;
        int movedY = spriteY + dy;


        if (movedX >= 0 && movedX <= imagePanel.getWidth() - imagePanel.spaceshipSpriteWidth)
        {
            spriteX = movedX;
        }

        if (movedY >= 0 && movedY <= imagePanel.getHeight() - imagePanel.spaceshipSpriteWidth)
        {
            spriteY = movedY;
        }
        imagePanel.setSpaceShipPosition(spriteX, spriteY);
        updateLasers();
    }
    public void activateLaser()
    {
        lasers.add(new Laser(spriteX + 2*(imagePanel.spaceshipSpriteWidth /3), spriteY));
    }
    public void updateLasers()
    {
        for (int i = lasers.size()-1; i>= 0; i--)
        {
            Laser laser = lasers.get(i);
            laser.update();
            if (!laser.isActive)
            {
                lasers.remove(i);
            }
        }
        imagePanel.setLasers(lasers);
    }

    //Control movement direction
    public void setMoveDirection(int dx, int dy)
    {
        this.deltaX = dx;
        this.deltaY = dy;
    }

    //Running the code
    public static void main(String[] args)
    {
        Board board = new Board();
        board.addKeyListener(new java.awt.event.KeyAdapter()
                             {
                                 public void keyPressed(KeyEvent e)
                                 {
                                     switch (e.getKeyCode())
                                     {
                                         case KeyEvent.VK_W:
                                             board.setMoveDirection(0, -5);
                                             break;

                                         case KeyEvent.VK_A:
                                             board.setMoveDirection(-5, 0);
                                             break;

                                         case KeyEvent.VK_S:
                                             board.setMoveDirection(0, 5);
                                             break;

                                         case KeyEvent.VK_D:
                                             board.setMoveDirection(5, 0);
                                             break;
                                         case KeyEvent.VK_F:
                                             board.activateLaser();
                                             break;
                                     }
                                 }

                                 @Override
                                 public void keyReleased(java.awt.event.KeyEvent e)
                                 {
                                     board.setMoveDirection(0, 0);
                                 }
                             });
    }
}
