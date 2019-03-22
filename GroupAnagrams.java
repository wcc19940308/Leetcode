package LeetCode100;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return list;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                List<String> midList = new ArrayList<>();
                midList.add(string);
                map.put(s, midList);
            } else {
                List<String> midList = map.get(s);
                midList.add(string);
            }
        }
        System.out.println(map.values());

        return new ArrayList<>(map.values());
    }
}
