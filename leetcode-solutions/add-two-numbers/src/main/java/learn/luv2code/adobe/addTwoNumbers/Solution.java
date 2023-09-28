package learn.luv2code.adobe.addTwoNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {
    static String inputFilePath = "leetcode-solutions/add-two-numbers/src/main/resources/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<List<Integer>> inputs = getArrays();
        List<ListNode> listNodes = new ArrayList<>();
        inputs.forEach(input -> {
            AtomicReference<ListNode> previousNode = new AtomicReference<>(new ListNode());
            ListNode head = previousNode.get();
            head.setNext(previousNode.get());
            input.forEach(node -> {
                if(previousNode.get().next == null) {
                    previousNode.get().setVal(node);
                    previousNode.get().setNext(new ListNode());
                } else {
                    ListNode currentNode = previousNode.get().next;
                    currentNode.setVal(node);
                    currentNode.setNext(new ListNode());
                    previousNode.set(currentNode);
                }
            });
            previousNode.get().setNext(null);
            listNodes.add(head);
        });

        Solution solution = new Solution();
        solution.addTwoNumbers(listNodes.get(0), listNodes.get(1));
        System.out.println(listNodes);
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode previousNode = new ListNode();
        ListNode head = previousNode;
        head.next = previousNode;
        boolean carryforward = false;

        do {
            int sum = carryforward ? 1 : 0;
            carryforward = false;
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
            if(sum > 9) {
                carryforward = true;
                sum -= 10;
            }

            ListNode currentNode = previousNode.next;
            currentNode.val = sum;
            currentNode.next = new ListNode();
            previousNode = currentNode;

            if(l1 != null)
            l1 = l1.next;
            if(l2 != null)
            l2 = l2.next;
        } while ((l1 != null || l2 != null) || carryforward);

        previousNode.next = null;
        return head;
    }
}