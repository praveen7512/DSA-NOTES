class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        int currSUM=0;
        int maxSUM=nums[0];

        for(int i =0; i<nums.length; i++){
            currSUM = currSUM + nums[i];
            maxSUM = Math.max(currSUM,maxSUM);
            if(currSUM<0){
                currSUM =0;
            }
        }

        return maxSUM;

        
    }
}