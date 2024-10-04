package ex1HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {
        int[] array = {1, 5, 7, -1, 5};
        int targetSum = 6;
        List<int[]> result = findPairs(array, targetSum);

        for (int[] pair : result) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }

    public static List<int[]> findPairs(int[] array, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            int complement = targetSum - num;

            if (map.containsKey(complement)) {
                for (int i = 0; i < map.get(complement); i++) {
                    pairs.add(new int[]{complement, num});
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return pairs;
    }
}

