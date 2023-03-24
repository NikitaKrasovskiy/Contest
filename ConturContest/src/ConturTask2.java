import java.util.*;

public class ConturTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
           x[i] = scanner.nextInt();
           y[i] = scanner.nextInt();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int a = Math.max(x[i], x[j]);
                        int b = Math.max(y[i], y[k]);
                        int c = Math.min(x[k], x[l]);
                        int d = Math.min(y[j], y[l]);
                        int area = Math.max(0, c - a) * Math.max(0, d - b);
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}


//8
//        0 0
//        1 1
//        0 2
//        5 0
//        5 2
//        0 4
//        3 0
//        3 4