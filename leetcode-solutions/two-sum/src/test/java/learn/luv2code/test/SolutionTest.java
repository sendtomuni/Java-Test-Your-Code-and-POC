package learn.luv2code.test;

import learn.luv2code.main.Solution;
import learn.luv2code.main.SolutionTwopass;

public class SolutionTest {

	public static void main(String[] args) {
		
//		Solution solution = new Solution();
//		int[] result = solution.twoSum(new int[] {-18,12,3,0}, -6);
//		for (int i = 0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
		
		SolutionTwopass solution = new SolutionTwopass();
		int[] result = solution.twoSum(new int[] {3,3}, 6);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
