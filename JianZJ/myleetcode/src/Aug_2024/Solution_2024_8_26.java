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

    public int getImportance(List<Employee> employees, int id) {
        ans = 0;
        this.employees = employees;
        dfs(id);
        return ans;
    }

    private void dfs(int x) {
        Employee employee = employees.get(x);
        System.out.println(x);
        ans += employee.importance;
        for (Integer i : employee.subordinates) {
            dfs(i);
        }
    }
}