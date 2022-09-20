package excercise.array;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//nums = [3,2,4], target = 6
//        Output: [1,2]
//        nums[1]+nums[2]=target

public class SumOfTwoAndTarget {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if((nums[i]+nums[j]==target)&&(i!=j)){
                    temp[0]=i;
                    temp[1]=j;
                }


            }
        }
        return temp;
    }

}

