
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        Arrays.sort(numbers, Comparator.comparing(String::length));
        System.out.println(numbers[0] + " has length: " + numbers[0].length() + "\n"
                + numbers[numbers.length-1] + " has length: " + numbers[numbers.length-1].length());
    }
}
