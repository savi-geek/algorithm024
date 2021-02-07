import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author linaluo
 * @date 2021/2/1 7:33 下午
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
         int len = s.length();
         if(len%2 == 1){
             return false;
         }
        Map<Character,Character> pairs = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for(Character c: s.toCharArray()){
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != pairs.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
