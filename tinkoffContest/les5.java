import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class les5 {
    private static final int N = 10000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<>(N);
        ArrayList<Integer> arrP = new ArrayList<>(N);
//        int[] arr = new int[N];
//        int[] arrP = new int[N];

        for (int i = 1; i <= n; i++) {
            arr.add(scanner.nextInt());
        }
        for (int i = 1; i <= n; i++) {
//            arrP.add(i, arrP.add(i - 1, arr.get(i)));
//            arrP.add(i, arrP.add(i - 1, arr.get(i)));
        }
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        int lastI = 0;

        int ans = 0;
        for (int j = 1; j <= n ; j++) {
            if (!map.containsKey(arrP.get(j))) {
                map.put(arrP.get(j), j);
                continue;
            }
            int i = map.get(arrP.get(j)) + 1;

            int cntL = (i - lastI);

            int cntR = (n - j + 1);

            ans += cntL * cntR;

            lastI = i;

            map.put(arrP.get(j), j);
        }
        System.out.println(ans);
    }
}
