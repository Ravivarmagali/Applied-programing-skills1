import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return calculate(map, id);
    }

    private int calculate(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int total = e.importance;
        for (int subId : e.subordinates) {
            total += calculate(map, subId);
        }
        return total;
    }
}