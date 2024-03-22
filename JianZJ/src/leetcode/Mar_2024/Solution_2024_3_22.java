package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/22 11:39
 */
public class Solution_2024_3_22 {
    public int minimumVisitedCells(int[][] grid) {

    }

    class Solution {
        public int minimumVisitedCells(int[][] grid) {
            // 获取网格的行数和列数
            int m = grid.length, n = grid[0].length, mn = 0;
            // 为每一列创建一个栈,用于存储访问该列所需的最小步数和对应的行号
            List<int[]>[] colStack = new ArrayList[n];
            // 创建一个栈,用于存储访问每一行所需的最小步数和对应的列号
            List<int[]> rowStack = new ArrayList<>();
            // 初始化每一个列栈
            Arrays.setAll(colStack, i -> new ArrayList<int[]>());
            // 从最后一行开始倒叙遍历
            for (int i = m - 1; i >= 0; i--) {
                // 清空行栈,因为每一行都是从新开始计算
                rowStack.clear();
                // 从最后一列开始倒序遍历
                for (int j = n - 1; j >= 0; j--) {
                    int g = grid[i][j];
                    List<int[]> colSt = colStack[j];
                    // 如果是第一行第一列,则只需访问一个单元格
                    mn = i < m - 1 || j < n - 1 ? Integer.MAX_VALUE : 1;
                    // 如果当前单元格的值大于0,则需要从相邻的单元格移动过来
                    if (g > 0) {
                        // 在行栈中查找距离当前单元格最近的合法单元格
                        int k = bs(rowStack, j + g);
                        if (k < rowStack.size()) mn = rowStack.get(k)[0] + 1;

                        // 在列栈中查找距离当前单元格最近的合法单元格
                        k = bs(colSt, i + g);
                        if (k < colSt.size()) mn = Math.min(mn, colSt.get(k)[0] + 1);
                    }
                    // 如果找到了合法的相邻单元格,则更新行栈和列栈
                    if (mn < Integer.MAX_VALUE) {
                        // 从行栈中移除所有步数大于等于mn的元素
                        while (!rowStack.isEmpty() && mn <= rowStack.get(rowStack.size() - 1)[0]) {
                            rowStack.remove(rowStack.size() - 1);
                        }
                        // 将当前单元格的信息添加到行栈
                        rowStack.add(new int[]{mn, j});
                        // 从列栈中移除所有步数大于等于mn的元素
                        while (!colSt.isEmpty() && mn <= colSt.get(colSt.size() - 1)[0]) {
                            colSt.remove(colSt.size() - 1);
                        }
                        // 将当前单元格的信息添加到列栈
                        colSt.add(new int[]{mn, i});
                    }
                }
            }
            // 如果找到了合法的路径,则返回最小步数,否则返回-1
            return mn < Integer.MAX_VALUE ? mn : -1;
        }

        // 二分查找,返回第一个大于等于target的下标
        private int bs(List<int[]> rowStack, int target) {
            int left = -1, right = rowStack.size();
            while (left + 1 < right) {
                int middle = left + (right - left) / 2;
                if (rowStack.get(middle)[1] <= target) right = middle;
                else left = middle;
            }
            return right;
        }
    }
}
