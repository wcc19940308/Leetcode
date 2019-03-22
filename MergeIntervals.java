package LeetCode100;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.*;

public class MergeIntervals {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals.size() == 0 || intervals == null) {
            return list;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval index : intervals) {
            if (end >= index.start) {
                end = Math.max(end, index.end);
            } else {
                list.add(new Interval(start, end));
                start = index.start;
                end = index.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(4, 5);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        System.out.println(merge(list));
    }
}
