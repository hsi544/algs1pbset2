/**
 * Created by tsaidani on 25/03/2018.
 */
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;



public class Permutation {
    public static void main(String [] args) {
        //String filename = args[0];
        //StdOut.println("Permutation class Main");
        //StdOut.println(filename);
        int k = Integer.parseInt(args[0]);
        StdOut.println("argument: "+k);
        while (true) {
            String s = StdIn.readString();
            if(s.equals("q")){
                return;
            }
            StdOut.println(s);
        }
        //In input = new In(args[1]);
        //while (input.hasNextChar()) {
        //    char c = input.readChar();
        //    StdOut.println(c);
        //}
    }
}
