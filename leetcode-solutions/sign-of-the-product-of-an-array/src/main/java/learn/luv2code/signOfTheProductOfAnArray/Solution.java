package learn.luv2code.signOfTheProductOfAnArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String inputFilePath = "leetcode-solutions/sign-of-the-product-of-an-array/src/main/resources/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> inputs = getInput();
        System.out.println(inputs);

        int[] intArray = new int[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            intArray[i] = inputs.get(i);
        }

        int result = new Solution().arraySign(intArray);
        System.out.println(result);
    }

    public static List<Integer> getInput () throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inputFilePath));
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNext()) {
            String numbers = scanner.next();
            numbers = numbers.substring(1, numbers.length()-1);
            List<String> individualNumbers = List.of(numbers.split(","));
            input = individualNumbers.stream().map(Integer::parseInt).toList();
        }
        return input;
    }

    public int arraySign(List<Integer> nums) {
        if(nums.contains(0))
            return 0;
        else if ((nums.stream().filter(input -> input<0).count()) % 2 == 0)
            return 1;
        else
            return -1;
    }

    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int num : nums) {
            if(num == 0)
                return 0;
             if (num < 0)
                negativeCount++;
        }
        return (negativeCount % 2 != 0) ? -1 : 1;
    }
}