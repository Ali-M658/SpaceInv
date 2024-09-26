import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static List<Integer>
    generateRowNumbers (int startNumber, int n)
    {
        List<Integer> rowNumbers = new ArrayList<> ();
        for (int i = 0; i < n; i++)
        {
            rowNumbers.add (startNumber + 2 * i);
        }
        return rowNumbers;
    }
    public static String
    joinAndSum (List<Integer> numbers)
    {
        StringBuilder sb = new StringBuilder ();
        int sum = 0;

        int fall = 0;

        for (int i = 0; i < numbers.size (); i++)
        {
            if (i > 0)
            {
                sb.append (", ");
            }
            sb.append (numbers.get (i));
            sum += numbers.get (i);
        }

        return "Numbers: [" + sb.toString () + "] (Sum: " + sum + ")";
    }
    public static void
    main (String[] args)
    {
        int targetrow = 4;
        int startNumber = 1;
        int numRows = 5;

        List<Integer> rowNumbers = generateRowNumbers (startNumber, targetrow);
        String result = joinAndSum (rowNumbers);
        int resulte = targetrow*targetrow*targetrow;
        System.out.println ("Row " + targetrow + ": " + result);
    }
}
