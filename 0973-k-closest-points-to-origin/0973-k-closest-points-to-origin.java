class Solution {
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                    (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
                            );

                                    for (int[] point : points) {
                                                maxHeap.add(point);
                                                            // If heap size exceeds k, remove the farthest point
                                                                        if (maxHeap.size() > k) {
                                                                                        maxHeap.poll();
                                                                                                    }
                                                                                                            }

                                                                                                                    // Extract the k closest points from the heap
                                                                                                                            int[][] result = new int[k][2];
                                                                                                                                    while (k > 0) {
                                                                                                                                                result[--k] = maxHeap.poll();
                                                                                                                                                        }
                                                                                                                                                                
                                                                                                                                                                        return result;
       
    }
}