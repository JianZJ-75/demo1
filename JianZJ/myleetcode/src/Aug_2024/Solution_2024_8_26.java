package Aug_2024;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/8/26 23:45
 */
public class Solution_2024_8_26 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private int ans;
    private List<Employee> employees;
    private int[] pos;

    public int getImportance(List<Employee> employees, int id) {
        ans = 0;
        pos = new int[2001];
        this.employees = employees;
        for (int i = 0; i < employees.size(); i++) {
            pos[employees.get(i).id] = i;
        }
        dfs(pos[id]);
        return ans;
    }

    private void dfs(int x) {
        Employee employee = employees.get(x);
        ans += employee.importance;
        for (Integer i : employee.subordinates) {
            dfs(pos[i]);
        }
    }
}