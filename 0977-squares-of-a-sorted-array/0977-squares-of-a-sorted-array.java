class Solution {
    public int[] sortedSquares(int[] nums) 
    {
      int[] result=new int[nums.length];
      for(int i=0;i<nums.length;i++){
        nums[i]=nums[i]*nums[i];
      }
      int head=0;
      int tail=nums.length-1;
      for(int j=nums.length-1;j>=0;j--){
        if(nums[head]>nums[tail]){
            result[j]=nums[head];
            head++;
        }
        else{
            result[j]=nums[tail];
            tail--;
        }
      }
 
    return result;  
    }
}