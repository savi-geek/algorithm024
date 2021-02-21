import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linaluo
 * @date 2021/2/2 6:18 下午
 * 242. 有效的字母异位词
 */
public class Anagram {

    /**
     * 排序
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] temp = new int[26];
        for(char sChar: s.toCharArray()){
            temp[sChar-'a']++;
        }
        for(char tChar: t.toCharArray()){
            temp[tChar-'a']--;
            if(temp[tChar-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希
     * 时间复杂度O(n)
     * 空间复杂度O(26)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char sch: s.toCharArray()){
            map.put(sch,map.getOrDefault(sch, 0)+1);
        }
        for(char tch: t.toCharArray()){
            map.put(tch, map.getOrDefault(tch, 0)-1);
            if(map.get(tch) < 0){
                return false;
            }
        }
        return true;
    }

}
