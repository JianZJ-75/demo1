package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/21 20:22
 */
public class Solution_2024_3_21 {
    class FrequencyTracker {
        private static final int N = 100001;
        private int[] freq;
        private int[] freqCnt;

        public FrequencyTracker() {
            freq = new int[N];
            freqCnt = new int[N];
        }

        public void add(int number) {
            --freqCnt[freq[number]];
            ++freq[number];
            ++freqCnt[freq[number]];
        }

        public void deleteOne(int number) {
            if (freq[number] == 0) {
                return;
            }
            --freqCnt[freq[number]];
            --freq[number];
            ++freqCnt[freq[number]];
        }

        public boolean hasFrequency(int frequency) {
            return freqCnt[frequency] > 0;
        }
    }

    /**
     * Your FrequencyTracker object will be instantiated and called as such:
     * FrequencyTracker obj = new FrequencyTracker();
     * obj.add(number);
     * obj.deleteOne(number);
     * boolean param_3 = obj.hasFrequency(frequency);
     */
}
