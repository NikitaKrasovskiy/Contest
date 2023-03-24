import java.util.*;

public class ConturTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE, tmp = 0;
        int size = sc.nextInt();
        int result = 0;
        Set<Long> maxElem = new HashSet<>();
        Set<Long> minElem = new HashSet<>();
        for (int i = 0; i < size; ++i) {
            tmp = sc.nextLong();
            if (tmp > max) {
                maxElem.clear();
                max = tmp;
                maxElem.add((long)i);
            } else if (tmp == max) {
                maxElem.add((long)i);
            }
            if (tmp < min) {
                minElem.clear();
                min = tmp;
                minElem.add((long)i);
            } else if (tmp == min) {
                minElem.add((long)i);
            }
        }
        if (Math.abs(maxElem.iterator().next()- lastElement(minElem) ) >
                Math.abs(lastElement(maxElem) - minElem.iterator().next())) {
            System.out.println((maxElem.iterator().next() + 1)
                    + " " +
                    (minElem.stream().mapToLong(Long::longValue).max().getAsLong() + 1));
        } else {
            System.out.println((maxElem.stream().mapToLong(Long::longValue).max().getAsLong() + 1)
                    + " " +
                    (minElem.iterator().next() + 1));
        }
    }
    static Long lastElement(Set<Long> last) {
        long result = 0;

        for (Long aLong : last) {
            result = aLong;
        }
        return result;
    }
}
//входные
// 6
// 1 2 1 3 1 3

//4
// 2 1 0 -1