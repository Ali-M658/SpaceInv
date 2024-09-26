package main.snakeGame;

public class GridCell
{
    public int row;
    public int col;

    public GridCell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }
    public java.awt.Point pointIntCol(GridCell cell)
    {
        int e = cell.getCol();
        int f = cell.getRow();
        return new java.awt.Point(e,f);
    }

}
