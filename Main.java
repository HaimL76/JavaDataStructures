import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    //private Stack<int> stack = new Stack<int>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(345);
        list.add(35);
        list.add(1345);
        list.add(3245);
        list.add(3);
        list.add(345);
        list.add(4);
        list.add(45);
        list.add(5);
        list.add(34);
        list.add(3450);

        list = MergeSort.sort(list);

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+",");

        int i = 0;

        if (false) {
            System.out.println("Hello world!");

            long num = 8;

            long factorial = factorial2(num, 1);

            System.out.println("factorial of " + num + "=" + factorial);

            long fibonacci = Fibonacci1(num);

            System.out.println("fibonacci of " + num + "=" + fibonacci);

            //int count = PrintPermutations(666);
        }
    }

    private static long Fibonacci1(long n)
    {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        long fib = Fibonacci1(n - 1) + Fibonacci1(n - 2);

        System.out.println("Fib["+n+"]="+fib);

        return fib;
    }

    private static long Fibonacci2(long n, long acc)
    {
        if (n == 0)
            return acc;

        if (n == 1)
            return acc+1;

        long fib = 0;

        System.out.println("Fib["+n+"]="+fib);

        return fib;
    }

    private static long factorial1(long n)
    {
        if (n == 1)
            return 1;

        long fact = n * factorial1(n - 1);

        System.out.println("fact["+n+"]="+fact);

        return fact;
    }

    private static long factorial2(long n, long acc)
    {
        if (n == 1)
            return acc;

        long fact = factorial2(n - 1, acc * n);

        System.out.println("fact["+n+"]="+fact);

        return fact;
    }

    private static int PrintPermutations(int num) {
        int[] arr = new int[num];
        Arrays.fill(arr, -1);

        return PrintPermutations(num, arr, 0, 0, 0);
    }

    private static int PrintPermutations(int num, int[] arr, int index, int counter, int the_i) {
        if (index < num) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    arr[i] = index + 1;

                    counter = PrintPermutations(num, arr, index + 1, counter, i);

                    arr[i] = -1;
                }
            }
        } else {
            counter++;

            System.out.print("Permutation["+counter+"]: ");

            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    System.out.print(",");

                System.out.print(arr[i]);
            }

            System.out.print(", the_i: "+the_i);

            System.out.println();
        }

        return counter;
    }
}