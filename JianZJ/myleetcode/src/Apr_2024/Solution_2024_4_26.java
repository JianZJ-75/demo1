package Apr_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/4/26 18:37
 */
public class Solution_2024_4_26 {
    class SnapshotArray {

        private int curSanpId = 0;

        private Map<Integer, List<int[]>> map = new HashMap<>();

        public SnapshotArray(int length) {

        }

        public void set(int index, int val) {
            map.computeIfAbsent(index, i -> new ArrayList<>()).add(new int[]{curSanpId, val});
        }

        public int snap() {
            return curSanpId++;
        }

        public int get(int index, int snap_id) {
            if (!map.containsKey(index)) {
                return 0;
            }
            List<int[]> list = map.get(index);
            int l = -1, r = list.size();
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (list.get(mid)[0] <= snap_id) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            return l == -1 ? 0 : list.get(l)[1];
        }
    }

    /**
     * Your SnapshotArray object will be instantiated and called as such:
     * SnapshotArray obj = new SnapshotArray(length);
     * obj.set(index,val);
     * int param_2 = obj.snap();
     * int param_3 = obj.get(index,snap_id);
     */
}
