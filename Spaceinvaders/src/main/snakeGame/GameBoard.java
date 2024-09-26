package main.snakeGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Random.*;

public class GameBoard extends JPanel
{
    private Snake snake;
    public int gridSize;
    public int rows = 36;
    public int cols = 64;
    //Change this to public if needed later
    public int randint;
    Random random = new Random();

    public GridCell blueBoxCell;
    public GridCell apples;

    public GameBoard(int gridSize)
    {
        setBackground(Color.BLUE);
    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawBoard(g);
    }

    public void getGridSize(int gridSize)
    {
        this.gridSize = gridSize;
        setPreferredSize(new Dimension(cols * gridSize, rows * gridSize));
        revalidate();
        repaint();
    }


    public void componentResized(java.awt.event.ComponentEvent e)
    {
        int newWidth = getWidth();
        int newHeight = getHeight();
        int newGridSize = Math.min(newWidth / cols, newHeight / rows);
        getGridSize(newGridSize);
    }

    public void setBlueBoxCell(GridCell cell)
    {
        this.blueBoxCell = cell;
        repaint();
    }

    public void setApples(GridCell cell)
    {
        this.apples = cell;
        repaint();
    }

    public void drawBoard(Graphics g)
    {
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++) {
                int x = col * gridSize;
                int y = row * gridSize;

                if ((row + col) % 2 == 0)
                {
                    g.setColor(Color.BLACK);
                }
                else
                {
                    g.setColor(Color.BLACK);
                }

                g.fillRect(x, y, gridSize, gridSize);

                if (blueBoxCell != null && blueBoxCell.getRow() == row && blueBoxCell.getCol() == col)
                {
                    g.setColor(Color.getHSBColor(45, 100, 50));
                    g.fillRect(x, y, gridSize, gridSize);
                }
                    if (apples != null && apples.getRow() == row && apples.getCol() == col)
                    {
                        g.setColor(Color.RED);
                        g.fillRect(x, y, gridSize, gridSize);
                    }
            }
        }
    }

    public GridCell getGridCell(int row, int col)
    {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
        {
            return new GridCell(row, col);
        }
        else
        {
            return null;
        }
    }
    public Point getPixelCoords(GridCell cell)
    {
        int x = cell.getCol() * gridSize;
        int y = cell.getRow() * gridSize;
        return new Point(x, y);
    }
}


