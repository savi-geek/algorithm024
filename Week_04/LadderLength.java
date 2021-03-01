import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author linaluo
 * @date 2021/2/28 6:23 下午
 * 127. 单词接龙
 */
public class LadderLength {
    /**
     * 双向bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        Set<String> visited = new HashSet();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet();
        endVisited.add(endWord);
        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()){
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if(beginVisited.size() > endVisited.size()){
                Set<String> tmp = new HashSet<>();
                tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = beginVisited;
            }
        }

        // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
        Set<String> nextLevelVisited = new HashSet<>();
        for(String word: beginVisited){
            boolean isChangeWord = changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited);
            if(isChangeWord){
                step++;
            }
        }
        return step;
    }

    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     * @param word
     * @param endVisited
     * @param visited
     * @param wordSet
     * @param nextLevelVisited
     * @return
     */
    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited, Set<String> visited,
                                             Set<String> wordSet, Set<String> nextLevelVisited) {
        char[] charArr = word.toCharArray();
        for(int i=0; i< charArr.length; i++){
            char originChar = charArr[i];
            for(char c='a'; c<'z';c++){
                if( c == originChar){
                    continue;
                }else{
                    charArr[i] = c;
                    String nextWord = charArr.toString();
                    if(wordSet.contains(nextWord)){
                        if(endVisited.contains(nextWord)){
                            return true;
                        }
                        if(!visited.contains(nextWord)){
                            nextLevelVisited.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            charArr[i] = originChar;
        }
        return false;
    }

}
