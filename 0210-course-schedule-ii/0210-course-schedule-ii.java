class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
                List<List<Integer>> adj = new ArrayList<>();
                        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

                                // Build adjacency list and in-degree array
                                        for (int[] pre : prerequisites) {
                                                    adj.get(pre[1]).add(pre[0]);
                                                                inDegree[pre[0]]++;
                                                                        }

                                                                                Queue<Integer> queue = new LinkedList<>();
                                                                                        for (int i = 0; i < numCourses; i++) {
                                                                                                    if (inDegree[i] == 0) queue.offer(i);
                                                                                                            }

                                                                                                                    int[] result = new int[numCourses];
                                                                                                                            int index = 0;

                                                                                                                                    while (!queue.isEmpty()) {
                                                                                                                                                int curr = queue.poll();
                                                                                                                                                            result[index++] = curr;

                                                                                                                                                                        for (int neighbor : adj.get(curr)) {
                                                                                                                                                                                        inDegree[neighbor]--;
                                                                                                                                                                                                        if (inDegree[neighbor] == 0) {
                                                                                                                                                                                                                            queue.offer(neighbor);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                        // If index == numCourses, we found a valid path for all courses
                                                                                                                                                                                                                                                                                return (index == numCourses) ? result : new int[0];
    }
}