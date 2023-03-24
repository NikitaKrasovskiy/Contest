import java.util.Scanner;

public class ConturTask3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        int l = 0, r = 0, cnt = 0, zeros = 0, sum = 0;
        while (r < n) {
            if (a[r] == 0) {
                zeros++;
            } else {
                sum += a[r];
            }

            while (zeros > 1 || sum > k) {
                if (a[l] == 0) {
                    zeros--;
                } else {
                    sum -= a[l];
                }
                l++;
            }
            if (zeros <= 1 && sum <= k) {
                cnt += r - l + 1;
            }
            r++;
        }
        System.out.println(cnt);
    }
}