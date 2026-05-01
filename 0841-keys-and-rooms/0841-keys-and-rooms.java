class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
     boolean[] visited = new boolean[rooms.size()];
             visited[0] = true;

                             Stack<Integer> stack = new Stack<>();
                                     stack.push(0);

                                                     int count = 1; // We've visited room 0

                                                                     while (!stack.isEmpty()) {
                                                                                 int currentRoom = stack.pop();

                                                                                                         // Look at all keys available in the current room
                                                                                                                     for (int key : rooms.get(currentRoom)) {
                                                                                                                                     if (!visited[key]) {
                                                                                                                                                         visited[key] = true;
                                                                                                                                                                             stack.push(key);
                                                                                                                                                                                                 count++;
                                                                                                                                                                                                                 }
                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                     }

                                                                                                                                                                                                                                                     return count == rooms.size();
                                                                                                                                                                                                                                                         }   
    }
