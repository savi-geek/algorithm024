import java.util.Arrays;

/**
 * @author linaluo
 * @date 2021/2/28 4:51 下午
 * 455. 分发饼干
 */
public class AssignCookies {

    /**
     * 贪心算法
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while (i<g.length && j<s.length){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
