class Solution {
    public int jump(int[] nums) {
        int count =0;
        int curr  = 0;
        int next = 0;
        for(int i=0;i<nums.length;i++){
            if(curr >= nums.length-1){
                return count;
            }
            next = Math.max(next , i+ nums[i]);
            if(i == curr){
                count++;
                curr = next;
            }
        }
        return count;
    }
}
