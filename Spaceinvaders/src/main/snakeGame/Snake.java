package main.snakeGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JFrame
{
    // Calling the classes
    private GameBoard board;
    public GridCell startCell;
    public Timer timerMove;
    public int moveDirection;
    public Random random = new Random();
    public ArrayList<GridCell> appleslist = new ArrayList<>();


    public Snake ()
    {
        int screenWidth = 800;
        int screenHeight = 600;
        int gridSize = Math.min(screenWidth / 64, screenHeight/ 36);

        //Initializing the board
        board = new GameBoard(gridSize);
        startCell = board.getGridCell(18,32);
        board.setBlueBoxCell(startCell);

        // Making the apple position
        generateApple();

        //This is the Board
        setTitle("Snake Game");
        setSize(540,540);
        setLocation(480,135);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(board, BorderLayout.CENTER);
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e) {
                board.componentResized(e);
            }
        });

        // Keys move the snake
        addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                        moveDirection = 1;
                        startMovement();
                        break;

                    case KeyEvent.VK_S:
                        moveDirection = 2;
                        startMovement();
                        break;

                    case KeyEvent.VK_D:
                        moveDirection = 3;
                        startMovement();
                        break;

                    case KeyEvent.VK_A:
                        moveDirection = 4;
                        startMovement();
                        break;
                }
            }

            public ArrayList addToLimitedList(ArrayList<Point> applesList, Point element)
            {
                if (applesList.size() > 2)
                {
                    applesList.remove(0);
                }
                applesList.add(element);
                return applesList;
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_A:
                        break;
                }
            }
        });
        setVisible(true);
        setFocusable(true);
    }

    //Timer to keep moving the snake
    private void startMovement()
    {
        if (timerMove == null)
        {
            timerMove = new Timer(50, new ActionListener()
            {
                public void  actionPerformed(ActionEvent e)
                {
                    moveBlueBox();
                    board.repaint();
                }
            });
            timerMove.start();
        }
    }

    //It changes the snakes position
    private void moveBlueBox()
    {
        int row = startCell.getRow();
        int col = startCell.getCol();
        switch (moveDirection)
        {
            case 1:
                row--;
                break;
            case 2:
                row++;
                break;
            case 3:
                col++;
                break;
            case 4:
                col--;
                break;
        }

        //If out of the border it closes the application
        if (row < 0 || row >= board.rows || col < 0 || col >= board.cols)
        {
            System.exit(1);
        }
        if (startCell.equals(board.apples))
        {
            for (GridCell apples : appleslist)
            {
                appleslist.remove(apples);
                generateApple();
                break;
            }
        }
        if (row >= 0 && row < board.rows && col >= 0 && col < board.cols)
        {
            startCell = board.getGridCell(row, col);
            board.setBlueBoxCell(startCell);
        }
    }

    public void generateApple()
    {
        boolean firstTime = true;
        int randCol, randRow;
        do
        {
            randCol = random.nextInt(board.cols);
            randRow = random.nextInt(board.rows);
        }
        while (startCell.getRow() == randRow && startCell.getCol() == randCol);
        GridCell newApple = board.getGridCell(randRow, randCol);
        appleslist.add(newApple);

        if (appleslist.size() > 2)
        {
            appleslist.remove(0);
        }
        if (firstTime)
        {
            board.setApples(appleslist.get(0));
        }
        else
        {
            board.setApples(appleslist.get(1));
        }
    }


    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(Snake::new);
    }
}
