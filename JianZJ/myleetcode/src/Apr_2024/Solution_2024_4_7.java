package Apr_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/4/7 14:17
 */
public class Solution_2024_4_7 {
    class ThroneInheritance {

        String king;
        Map<String, List<String>> edges;
        Map<String, Boolean> dead;

        public ThroneInheritance(String kingName) {
            edges = new HashMap<>();
            dead = new HashMap<>();
            king = kingName;
        }

        public void birth(String parentName, String childName) {
            edges.computeIfAbsent(parentName, s -> new ArrayList<>()).add(childName);
        }

        public void death(String name) {
            dead.put(name, false);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
            preorder(king, res);
            return res;
        }

        private void preorder(String name, List<String> res) {
            if (dead.getOrDefault(name, true))
                res.add(name);
            for (var child : edges.computeIfAbsent(name, s -> new ArrayList<>())) {
                preorder(child, res);
            }
        }
    }

    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
}
