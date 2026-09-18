class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =1;
        int count=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                 prod = prod*nums[i];
            }
            else{
                count++;
            }  
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0 && count==0){
                nums[i] = prod/nums[i];
            }
            else if(nums[i]==0 && count>0){
                if(count==1){
                     nums[i]=prod;
                }
                else{
                    nums[i]=0;
                }
            }
            else{
                nums[i]=0;
            }
        }
        return nums;
    }
}  
