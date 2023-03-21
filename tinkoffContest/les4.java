import java.util.*;

public class les4 {
    static final int N = 200010;
    static int[] a = new int[N];
    static int n;

    static void read() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void solver() {
        int[] cnt = new int[N];
        TreeSet<Pair<Integer, Integer>> st = new TreeSet<>();
        int ans = -1;
        for (int l = 1; l <= n; l++) {
            st.remove(new Pair<>(cnt[a[l]], a[l]));
            cnt[a[l]]++;
            st.add(new Pair<>(cnt[a[l]], a[l]));

            int mn = st.first().getKey();
            int mx = st.last().getKey();
            if (mn == mx) {
                ans = l;
                continue;
            }
            int cntMN = 1, cntMX = 1;
            if (st.size() > 1) {
                Iterator<Pair<Integer, Integer>> it = st.iterator();
                it.next();
                if (it.next().getKey() == mn) {
                    cntMN = 2;
                }
                it = st.descendingIterator();
                it.next();
                if (it.next().getKey() == mx) {
                    cntMX = 2;
                }
            }
            if (mn + 1 == mx && cntMX == 1) {
                ans = l;
            }
            if (mn == 1 && cntMN == 1) {
                Iterator<Pair<Integer, Integer>> it = st.iterator();
                Pair<Integer, Integer> p = it.next();
                if (p.getKey() == mn && it.hasNext() && it.next().getKey() == mx) {
                    ans = l;
                }
            }
        }
        System.out.println(ans);
    }

    static void solve() {
        read();
        solver();
    }

    public static void main(String[] args) {
        solve();
    }

    static class Pair<K extends Comparable<K>, V> implements Comparable<Pair<K, V>> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int compareTo(Pair<K, V> o) {
            return this.key.compareTo(o.key);
        }
    }
}