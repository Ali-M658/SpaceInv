package main.SpaceInvaders;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel
{
    private Image spaceshipImage;
    private int spriteX = 400;
    private int spriteY = 400;
    public int spaceshipSpriteWidth = getWidth()/20;
    public int spaceshipSpriteHeight = getHeight()/20;
    private int laserWidth = 5;
    private int laserHeight = 10;
    private Image alienImage;
    public int alienSpriteWidth = getWidth()/30;
    public int alienSpriteHeight = getHeight()/30;
    private ArrayList<Laser> lasers; //Laser holding list

    public ImagePanel(String imagePath)
    {
        try
        {
            //Height is relative to the image that's why the size isn't fixed
            spaceshipImage = ImageIO.read(new File(imagePath));
            spaceshipSpriteWidth = spaceshipImage.getWidth(this);
            spaceshipSpriteHeight = spaceshipImage.getHeight(this);
            lasers = new ArrayList<>(); // Initialize the list of lasers
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void imagePanelAlien(String imagePath)
    {
        //Making the alien
        try
        {
            alienImage = ImageIO.read(new File(imagePath));
            alienSpriteWidth = alienImage.getWidth(this);
            alienSpriteHeight = alienImage.getHeight(this);
        }
    }

    public void setSpaceShipPosition(int x, int y)
    {
        spriteX = x;
        spriteY = y;
        repaint();

    }

    public void setLasers(ArrayList<Laser> lasers)
    {
        this.lasers = lasers;
        repaint();
    }
    @Override

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (spaceshipImage != null)
        {
            g.drawImage(spaceshipImage, spriteX , spriteY, this.getWidth()/20, this.getHeight()/20, this);
        }
        g.setColor(Color.red);
        for (Laser laser : lasers)
        {
            g.fillRect(laser.x, laser.y, laserWidth, laserHeight);
        }
    }
}
