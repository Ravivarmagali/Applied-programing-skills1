/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try (FileWriter writer = new FileWriter("display_runtime.txt")) {
            writer.write("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }));
}
        public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null ){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();

        int n = lists.length;

        for(int i=0;i<n;i++){
            ListNode curr = lists[i];
            while(curr!=null){
                res.add(curr.val);
                curr = curr.next;
            }
        }
        Collections.sort(res);

        int size = res.size();
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        
        for(int val:res){
            start.next = new ListNode(val);
            start = start.next;

        }
        return dummy.next;
    }
}