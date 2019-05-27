package LeetCode100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {

    class LinkNode {
        // 这里之所以还有个键是为了能够在map中找到相应的最后一个Node并且删除
        public int key;
        public int value;
        public LinkNode pre;
        public LinkNode next;

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity, count;
    LinkNode head, tail;
    Map<Integer, LinkNode> map;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new LinkNode(0, 0);
        tail = new LinkNode(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = tail;
        tail.next = null;
        map = new HashMap<>();
    }

    public void addToHead(LinkNode node) {

        LinkNode next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        if (pre != null)
            pre.next = next;
        if (next != null)
            next.pre = pre;
    }

    public void removeTail() {
        LinkNode pre = tail.pre.pre;
        if (pre != null)
            pre.next = tail;
        tail.pre = pre;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            node.value = value;
//            removeNode(node);
//            addToHead(node);
        } else {
            LinkNode node = new LinkNode(key, value);
            map.put(key, node);
            if (count == capacity) {
                map.remove(tail.pre.key); // 这里记得要删掉对应的键
                removeTail();
                addToHead(node);
            } else {
                addToHead(node);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LRUCache lruCache = new LRUCache(n);
        String s;
        while ((s = scanner.next()) != null) {
            if (s.equals("p")) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                lruCache.put(key, value);
            } else if (s.equals("g")) {
                int key = scanner.nextInt();
                int res = lruCache.get(key);
                System.out.println(res);
            }
        }
    }
}

