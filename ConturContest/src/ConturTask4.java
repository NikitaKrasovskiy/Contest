import java.util.*;

public class ConturTask4 {
    private static final  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int cubesCount = scanner.nextInt();

        Set<Integer> sums = new HashSet<>();
        int[] currentCombination = new int[cubesCount];
        int[][] matrix = new int[cubesCount][6];

        fillArrNumbers(cubesCount, matrix);

        findSums(matrix, sums, 0, currentCombination, 0, new HashMap<>(), new boolean[matrix.length][matrix[0].length]);

        System.out.println(sums.size());
    }

    private static void findSums(int[][] matrix, Set<Integer> sums, int row, int[] currentCombination, int currentSum,
                                 Map<String, Integer> memo, boolean[][] isUsed) {
        if (row == matrix.length) {
            sums.add(currentSum);
            return;
        }

        // Check memoization map
        String key = row + "," + currentSum;
        if (memo.containsKey(key)) {
            currentSum += memo.get(key);
            sums.add(currentSum);
            return;
        }

        for (int i = 0; i < matrix[row].length; i++) {
            if (!isUsed[row][i]) {
                int cube = matrix[row][i];
                currentCombination[row] = cube;
                isUsed[row][i] = true;
                findSums(matrix, sums, row + 1, currentCombination, currentSum + cube, memo, isUsed);
                currentCombination[row] = 0;
                isUsed[row][i] = false;
            }
        }

        // Memoize result
        memo.put(key, sums.size() - currentSum);
    }

    private static void fillArrNumbers(int countCubes, int[][] cubesVariants) {
        for (int i = 0; i < countCubes; i++) {
            for (int j = 0; j < 6; j++) {
                cubesVariants[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
}