package Apr_2024;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/15 17:25
 */
public class Solution_2024_4_15 {
    class MyHashMap {

        private class Pair {

            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private static final int BASE = 769;
        List<Pair>[] data;

        public MyHashMap() {
            data = new List[BASE];
            Arrays.setAll(data, i -> new LinkedList<>());
        }

        public void put(int key, int value) {
            int h = hash(key);
            Iterator<Pair> it = data[h].iterator();
            while (it.hasNext()) {
                Pair pair = it.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            data[h].add(new Pair(key, value));
        }

        public int get(int key) {
            int h = hash(key);
            Iterator<Pair> it = data[h].iterator();
            while (it.hasNext()) {
                Pair pair = it.next();
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Pair> it = data[h].iterator();
            while (it.hasNext()) {
                Pair pair = it.next();
                if (pair.getKey() == key) {
                    data[h].remove(pair);
                    return;
                }
            }
        }

        private int hash(int key) {
            return key % 769;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}
