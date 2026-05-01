class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
                List<List<Integer>> adj = new ArrayList<>();
                        
                                for (int i = 0; i < numCourses; i++) {
                                            adj.add(new ArrayList<>());
                                                    }
                                                            
                                                                    // Build the graph and count in-degrees
                                                                            for (int[] pre : prerequisites) {
                                                                                        adj.get(pre[1]).add(pre[0]);
                                                                                                    inDegree[pre[0]]++;
                                                                                                            }
                                                                                                                    
                                                                                                                            Queue<Integer> queue = new LinkedList<>();
                                                                                                                                    // Add all courses with no prerequisites to the queue
                                                                                                                                            for (int i = 0; i < numCourses; i++) {
                                                                                                                                                        if (inDegree[i] == 0) {
                                                                                                                                                                        queue.offer(i);
                                                                                                                                                                                    }
                                                                                                                                                                                            }
                                                                                                                                                                                                    
                                                                                                                                                                                                            int processedCourses = 0;
                                                                                                                                                                                                                    while (!queue.isEmpty()) {
                                                                                                                                                                                                                                int curr = queue.poll();
                                                                                                                                                                                                                                            processedCourses++;
                                                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                                    for (int neighbor : adj.get(curr)) {
                                                                                                                                                                                                                                                                                    inDegree[neighbor]--;
                                                                                                                                                                                                                                                                                                    if (inDegree[neighbor] == 0) {
                                                                                                                                                                                                                                                                                                                        queue.offer(neighbor);
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                                                            // If we processed all courses, no cycle exists
                                                                                                                                                                                                                                                                                                                                                                                    return processedCourses == numCourses;
    }
}