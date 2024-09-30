package Sept_2024;

import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/9/30 15:44
 */
public class Solution_2024_9_30 {
    // TODO
    class SeatManager {
        private final PriorityQueue<Integer> available = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                available.add(i);
            }
        }

        public int reserve() {
            return available.poll();
        }

        public void unreserve(int seatNumber) {
            available.add(seatNumber);
        }
    }

    /**
     * Your SeatManager object will be instantiated and called as such:
     * SeatManager obj = new SeatManager(n);
     * int param_1 = obj.reserve();
     * obj.unreserve(seatNumber);
     */
}