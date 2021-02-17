/*
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/

public class lengthOfLongestSubstringWORepeating {
  public int lengthOfLongestSubstring(String s) {
          if (s.length()==0) return 0;
          HashMap<Character, Integer> map = new HashMap<Character, Integer>();
          int max=0;
          for (int i=0, j=0; i<s.length(); ++i){
              if (map.containsKey(s.charAt(i))){
                  j = Math.max(j,map.get(s.charAt(i))+1);
              }
              map.put(s.charAt(i),i);
              max = Math.max(max,i-j+1);
          }
          return max;
      }
    }
