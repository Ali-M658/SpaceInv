import javax.management.InvalidAttributeValueException;
import java.util.*;


public class AreSame
{
    public static boolean comp(int[] a, int[] b) throws InvalidAttributeValueException {
        Set<Integer> squaredSetA = new HashSet<Integer>();

        Set<Integer> squaredSetB = new HashSet<Integer>();

        if (a.length != b.length)
        {
            throw new InvalidAttributeValueException("Arrays a and b are not the same length");
        }
        for (int num : a)
        {
          squaredSetA.add(num*num);
        }
        for (int numB : b)
        {
            squaredSetB.add(numB);
        }
        if (squaredSetA.equals(squaredSetB))
        {
            return true;
        }
        return false;
    }
    public static void trueFalseChecker() throws InvalidAttributeValueException
    {
        int[] a = new int[]{3,6,2,6,7,2};
        int[] b = new int[]{9,36,4,36,49,4};
        System.out.print(comp(a,b));
    }
    public static void main(String[] args) throws InvalidAttributeValueException
    {
        trueFalseChecker();
    }
}
