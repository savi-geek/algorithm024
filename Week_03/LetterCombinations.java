import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linaluo
 * @date 2021/2/19 6:43 下午
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backTrack(0, digits, map, res, sb);
        return res;
    }

    private void backTrack(int index, String digits, Map<Character, String> map, List<String> res,StringBuffer sb) {
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char oneDigit = digits.charAt(index);
        String letters = map.get(oneDigit);
        for(char letter: letters.toCharArray()){
            sb.append(letter);
            backTrack(index+1, digits, map, res, sb);
            sb.deleteCharAt(index);
        }
    }
}
