package trie;


// auto complete system:
// a system when input the prefix will returun the top three word that contisn this prefix in previous input history

// for exmaple:

// searching history:

// hello word: freq  10
// heap sort: freq 5
// healing procsee: freq 3
// heating soup: freq 2

// normal case:
// input: he
// output:
// 1. hello word
// 2. heap sort
// 3. healing procsee

// only one matching prefix
// input: hell
// output:
// 1. hello word

// implementation
// 1. create a trie node class
// 2. constructor initialize the system
// 3. add node method
// 4. handle the user input
// 5. search the prfix in trie
// 6. reetun top 3 freq

import java.util.*;

import javax.swing.tree.TreeNode;
public class AutoCompleteSystem{
    private class TrieNode{
        Map<Character, TrieNode> children;
        Map<String, Integer> count;
        public TrieNode(){
            children = new HashMap<>();
            count = new HashMap<>();
        }
    }

    private TrieNode root;
    private String currentInput;

    public AutoCompleteSystem(String[] sentences, int[] times){
        root = new TrieNode();
        currentInput = "";
        //O(n⋅k)
        for(int i = 0; i < sentences.length; i++){
            addSentence(sentences[i], times[i]);
        }
    }
    public void addSentence(String sentence, int time){
        TrieNode node = root;
        for(char c: sentence.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count.put(sentence, node.count.getOrDefault(sentence, 0) + time);
        }
    }
    // m * O(n + m/k)
    public List<String> input(char c){
        if(c == '#'){
            addSentence(currentInput, 1);
            currentInput = "";
            return new ArrayList<>();
        }else{
            currentInput += c;
            return search(currentInput); 
        }
    }
    // // O(n + m/k)
    private List<String> search(String prefix){
        TrieNode node = root;

        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return new ArrayList<>();
            }
            node = node.children.get(c);
        }
        return getTop3Sentences(node);
    }
    // O(n + m/k)
    private List<String> getTop3Sentences(TrieNode node){
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry : node.count.entrySet()) {
            System.out.println("entry" +entry);
            pq.offer(entry);
        }
        List<String> result = new ArrayList<>();

        int k = 3;
        while (!pq.isEmpty() && k > 0) {
            result.add(pq.poll().getKey());
            k--;
        }
        return result;

    }


}
// n number of word, k  number of char in each word, m is input time(new char)

// time:
// initiaize tire:  O(n⋅k)
// input:
// old sentence #: n
// new sentence #: m/k
// total sentence # => n + m/k

// call m time => m (n + m/k)

// tottal time:  O(n⋅k + m (n + m/k))

// SPACE:
// total node O(n * k)
// space per node O(k)
//  => O(n * k) * O(k)

// input call m times
//  => (m⋅k)
 
// total space: O(n * k^2 + m * k) => O(k⋅(n⋅k+m))