/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Location> locations = new ArrayList<>();
        dfs(root, 0, 0, locations);

        Collections.sort(locations, (a, b) -> {
            if (a.x != b.x)
                return Integer.compare(a.x, b.x);
            if (a.y != b.y)
                return Integer.compare(a.y, b.y);
            return Integer.compare(a.val, b.val);
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevX = Integer.MIN_VALUE;

        for (Location loc : locations) {
            if (loc.x != prevX) {
                res.add(new ArrayList<>());
                prevX = loc.x;
            }
            res.get(res.size() - 1).add(loc.val);
        }

        return res;
    }

    private void dfs(TreeNode node, int x, int y, List<Location> locations) {
        if (node == null)
            return;
        locations.add(new Location(x, y, node.val));
        dfs(node.left, x - 1, y + 1, locations);
        dfs(node.right, x + 1, y + 1, locations);
    }

    private static class Location {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}