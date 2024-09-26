package main.SpaceInvaders;
import main.SpaceInvaders.Board;

public class Laser
{
    public Board board;
    public int x, y;
    public boolean isActive = true;

    public Laser(int startX, int startY)
    {
        this.x = startX;
        this.y = startY;
    }
    public void alienLaserUpdate()
    {
        y += 5;
        if (y > board.getHeight())
        {
            isActive = false;
        }
    }
    public void update()
    {
        y -= 5;
        if (y < 0) {
            isActive = false;
        }
    }
}
