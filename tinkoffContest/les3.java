import java.util.Scanner;

public class les3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String str = scanner.next();
        int posA = -1, posB = -1, posC = -1, posD = -1;

        int ans = -1;
        for (int i = 0; i < n; i++) {
            switch (str.charAt(i)) {
                case 'a' -> posA = i;
                case 'b' -> posB = i;
                case 'c' -> posC = i;
                case 'd' -> posD = i;
            }
            int l = getMinPos(posA, posB, posC, posD);
            ans = getAns(ans, i, l);
        }
        System.out.println(ans);
    }

    private static int getMinPos(int posA, int posB, int posC, int posD) {
        return Math.min(Math.min(posA, posB), Math.min(posC, posD));
    }
    private static int getAns(int ans, int i, int l) {
        if (l != -1) {
            int len = i - l + 1;
            if (ans == -1 || ans > len) {
                ans = len;
            }
        }
        return ans;
    }
}

//12
//aabbccddbadd

//16
//aaaabbbbccccdddd

// 7
// dbbccca

// 7
// abcabac