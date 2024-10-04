package org.example;

import java.util.*;

public class TreeMapEx {
    public static void main(String[] args) {
        String text = "the day is sunny the the the sunny is is";
        int k = 2;
        List<String> topWords = topKFrequent(text, k);
        System.out.println(topWords);
    }

    public static List<String> topKFrequent(String text, int k) {
        String[] words = text.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            String word = entry.getKey();
            sortedMap.computeIfAbsent(frequency, x -> new ArrayList<>()).add(word);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
            for (String word : entry.getValue()) {
                result.add(word);
                if (result.size() == k) {
                    return result;
                }
            }
        }
        return result;
    }
}


