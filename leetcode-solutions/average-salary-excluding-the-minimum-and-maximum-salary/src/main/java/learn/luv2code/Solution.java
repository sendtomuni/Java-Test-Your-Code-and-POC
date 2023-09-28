package learn.luv2code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static String inputFilePath = "leetcode-solutions/average-salary-excluding-the-minimum-and-maximum-salary/src/main/resources/input.txt";
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> input = getSalaries();
        System.out.println(input);

        int[] intArray = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            intArray[i] = input.get(i);
        }

        Solution solution = new Solution();
        double result = solution.average(intArray);
        System.out.println(result);
    }

    public static List<Integer> getSalaries () throws FileNotFoundException {
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
    public double average(int[] salary) {
        int min = salary[0], max = salary[0], sum = 0;
        for (int i=0; i<salary.length; i++) {
            if(salary[i] < min) {
                min = salary[i];
            } else if(salary[i] > max){
                max = salary[i];
            }
            sum += salary[i];
        }

        return (double) (sum - (min + max)) / (salary.length - 2);
    }
}