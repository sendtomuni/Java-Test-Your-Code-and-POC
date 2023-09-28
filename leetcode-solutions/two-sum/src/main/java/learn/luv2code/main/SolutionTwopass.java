package learn.luv2code.main;

import java.util.HashMap;

public class SolutionTwopass {
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> complement = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (complement.containsKey(target-nums[i]) && complement.get(target-nums[i]) != i)
				return new int[] {i, complement.get(target-nums[i])};
			complement.put(nums[i], i);
		}
		
//		for (int i = 0; i < nums.length; i++) {
//			if (complement.containsKey(target-nums[i]) && complement.get(target-nums[i]) != i)
//				return new int[] {i, complement.get(target-nums[i]), i};
//		}
		
		return null;
	}

}
