import java.util.*;

/**
 * @author linaluo
 * @date 2021/2/2 7:48 下午
 * 49. 字母异位词分组
 */
public class AnagramGroup {

    /**
     * 排序
     * 时间复杂度O(nklogk)
     * 空间复杂度O(nk)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List list = map.getOrDefault(key, new ArrayList());
            list.add(str);
            map.put(key, list);
        }
        result.addAll(map.values());
        return result;
    }

    /**
     * 计数
     * 时间复杂度O(n(k+26))
     * 空间复杂度O(n(k+26))
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] counts = new int[26];
            for(char ch: str.toCharArray()){
                counts[ch-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<26; i++){
                if(counts[i] != 0){
                    sb.append(i+'a');
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
