package Apr_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/4/14 14:20
 */
public class Solution_2024_4_14 {
    class MyHashSet {

        private static final int BASE = 769;
        private List<Integer>[] data;

        public MyHashSet() {
            data = new List[BASE];
            Arrays.setAll(data, i -> new LinkedList<>());
        }

        public void add(int key) {
            int h = hash(key);
            List<Integer> list = data[h];
            for (var i : list) {
                if (i == key) {
                    return;
                }
            }
            list.add(key);
        }

        public void remove(int key) {
            int h = hash(key);
            List<Integer> list = data[h];
            for (var i : list) {
                if (i == key) {
                    list.remove(i);
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int h = hash(key);
            List<Integer> list = data[h];
            for (var i : list) {
                if (i == key) {
                    return true;
                }
            }
            return false;
        }

        private int hash(int key) {
            return key % BASE;
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
}
