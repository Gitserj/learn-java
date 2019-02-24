package main.Kata;

/** A digital root is the recursive sum of all the digits
 * in a number. Given n, take the sum of the digits of n.
 * If that value has more than one digit, continue reducing
 * in this way until a single-digit number is produced.
 * This is only applicable to the natural numbers.
 */
public class DRoot {

    public static int digital_root(int n) {
        return (n >= 10) ? digital_root(n % 10 + n / 10) : n;
    }

    public static void main(String[] args) {

        System.out.println(digital_root(11111));  //5
        System.out.println(digital_root(112233)); //3
        System.out.println(digital_root(132189)); //6

    }
}