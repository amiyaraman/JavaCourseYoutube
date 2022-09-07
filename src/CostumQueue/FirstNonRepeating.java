package CostumQueue;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));

    }
    public static int firstUniqChar(String s) {
        int ans = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i< s.length();i++){
            if(map.containsKey(s.charAt(i))){
               map.put( s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0 ; i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }

        return ans;

    }
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
