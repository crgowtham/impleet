/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
*/

class WordDistance {
    
    Map<String, List<Integer>> map=new HashMap<>();
    public WordDistance(String[] words) {
        for(int i=0; i<words.length; i++){
            String word=words[i];
            map.putIfAbsent(word, new ArrayList<Integer>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1=map.get(word1);
        List<Integer> l2=map.get(word2);
        int min=Integer.MAX_VALUE;
        for(int i:l1){
            for(int j:l2){
                min=Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
