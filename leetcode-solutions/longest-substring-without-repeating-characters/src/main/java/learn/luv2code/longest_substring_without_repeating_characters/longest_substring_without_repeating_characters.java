package learn.luv2code.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
       longest_substring_without_repeating_characters characters = new longest_substring_without_repeating_characters();
       int result = characters.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> wordMap = new HashSet<>();
        int maxLength = 0, maxSubstringStartIndex = 0, currentSubstringLength=0, currentSubstringStartIndex = 0;

        char[] letters = s.toCharArray();
        for (char c : letters) {
            if(wordMap.contains(c)) {
                if (currentSubstringLength > maxLength && (s.length() < 2*currentSubstringLength || s.substring(maxSubstringStartIndex, currentSubstringLength+1).equalsIgnoreCase(s.substring(currentSubstringLength, (2*currentSubstringLength))))) {
                    maxLength = currentSubstringLength;
                    maxSubstringStartIndex = currentSubstringStartIndex;
                    currentSubstringLength = 1;
                    currentSubstringStartIndex += maxLength;
                }
            } else {
                wordMap.add(c);
                currentSubstringLength++;
            }
        }

        return Math.max(maxLength, currentSubstringLength);
    }


    public int lengthOfLongestSubstring_2(String s) {
        Map<String, Integer> wordMap = new HashMap<>();
        int startIndex = 0, currentIndex = 0;

        for (char temp : s.toCharArray()) {
             String subString = s.substring(startIndex, currentIndex+1);
            if(wordMap.containsKey(String.valueOf(temp))) {
                startIndex++;
                subString = s.substring(startIndex, currentIndex+1);
            }
            wordMap.put(subString, subString.length());
            currentIndex++;
        }
        return wordMap.values().stream().toList().stream().max(Integer::compare).get();
    }
}