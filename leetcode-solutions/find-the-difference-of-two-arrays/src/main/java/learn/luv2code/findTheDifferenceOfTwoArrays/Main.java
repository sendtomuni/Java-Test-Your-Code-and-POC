package learn.luv2code.findTheDifferenceOfTwoArrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static String inputFilePath = "leetcode-solutions/find-the-difference-of-two-arrays/src/main/resources/input.txt";
    public static void main(String[] args) throws FileNotFoundException {
        List<List<Integer>> input = getArrays();

        int[] array1 = new int[input.get(0).size()];
        for (int i = 0; i < input.get(0).size(); i++) {
            array1[i] = input.get(0).get(i);
        }

        int[] array2 = new int[input.get(1).size()];
        for (int i = 0; i < input.get(1).size(); i++) {
            array2[i] = input.get(1).get(i);
        }
        Main main = new Main();
        List<List<Integer>> result = main.findDifference(array1, array2);
        System.out.println(result);

    }

    public static List<List<Integer>> getArrays() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(inputFilePath));
        int lineNumber = 0;
        List<List<Integer>> input = new ArrayList<>();
        while (scanner.hasNextLine()) {

            String numbers = scanner.nextLine();
            numbers = numbers.substring(1, numbers.length()-1);
            List<String> individualNumbers = List.of(numbers.split(","));
            input.add(individualNumbers.stream().map(Integer::parseInt).toList());
        }
        return input;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        Set<Integer> list2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());
        Set<Integer> list3 = new HashSet<>(Arrays.stream(nums1).boxed().toList());

        list1.forEach(list -> {
            if(list2.contains(list)) {
                list2.remove(list);
                list3.remove(list);
            }
        });

        return List.of(list3.stream().toList(), list2.stream().toList());
    }
}