
import java.util.*;

public class Maino {

    public static List listDifference(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < a.size(); i++) {

            for (int x = 0; x < b.size(); x++) {
                //Iterates over a and b with x and i

                while (a.contains(b.get(x))) {
                // does a contain method
                    a.remove(b.get(x));
                }
            }
        }
        return a;
    }
    public static void listPrinter() {
        List<Integer> a = Arrays.asList(1,3,5,5,5,3,4,5,7);
        List<Integer> b = Arrays.asList(1,3,5);

        System.out.println("This is list b: "+ b +" - list a: " + a + ": "+listDifference(new ArrayList<>(a), b));
    }
    public static void main(String[] args) {
        listPrinter();
    }
}
