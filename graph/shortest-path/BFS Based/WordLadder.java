package graph.shortest-path.BFS Based;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return length;
                }
                for (String neighbor : getNeighbors(currentWord, wordSet)) {
                    queue.offer(neighbor);
                }
            }
            length++;
        }

        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    continue;
                }
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.remove(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = originalChar;
        }

        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();

        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Ladder Length: " + solution.ladderLength(beginWord1, endWord1, wordList1)); // Output: 5

        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Ladder Length: " + solution.ladderLength(beginWord2, endWord2, wordList2)); // Output: 0
    }
}

