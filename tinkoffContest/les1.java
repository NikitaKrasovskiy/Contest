import java.util.Scanner;

public class les1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        int h4 = scanner.nextInt();
        boolean b = (h1 <= h2 && h2 <= h3 && h3 <= h4) || (h1 >= h2 && h2 >= h3 && h3 >= h4);
        System.out.println(b ? "YES":"NO");
    }
}
