package problems.monotonicArray;

class Solution {
    public boolean isMonotonic(int[] nums) {
        String temp="norm";
        int count = 1;
        if(nums.length == 1) return  true;
        if(nums[1]-nums[0] > 0) {
            temp = "asc";
        } else if (nums[1]-nums[0] == 0) {
            while (temp == "norm" && count < nums.length-1){
                if(nums[count+1]-nums[count] > 0) temp = "asc";
                else if (nums[count+1]-nums[count] == 0) temp = "norm";
                else temp = "desc";

                count ++;
            }
        } else{
            temp = "desc";
        }

        for (int i = count,j=count+1; i < nums.length-1; i++,j++) {

            if((temp == "asc") && (nums[j]-nums[i] < 0) ){
                return  false;
            }
            if((temp == "desc") && (nums[j]-nums[i] > 0) ){
                return  false;
            }
        }
        return true;
    }
}