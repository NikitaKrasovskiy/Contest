import java.util.Scanner;

public class les2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = scanner.nextDouble();
        double m = scanner.nextDouble();
        double k = scanner.nextDouble();

        System.out.println((int)Math.round((k * n) / m));
    }
}
// n = 7
// m = 3
// k = 2

// k * n / m == к ближайщей целового числа