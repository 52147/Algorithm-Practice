import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public static int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int mostFrequent = nums[0];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > frequencyMap.get(mostFrequent)) {
                mostFrequent = entry.getKey();
            }
        }
        
        return mostFrequent;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 4, 3, 5};
        System.out.println(mostFrequentElement(nums)); // Output: 3
    }
}
