package LeetCode100;

import java.util.*;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index : nums) {
            map.put(index, map.getOrDefault(index, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int index : map.keySet()) {
            queue.offer(index);
            if (queue.size() > k) queue.poll();
        }

        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            resList.add(queue.poll());
        }
        return resList;
    }
}
