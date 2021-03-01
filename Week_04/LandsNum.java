/**
 * @author linaluo
 * @date 2021/2/24 7:47 下午
 * 200. 岛屿数量
 */
public class LandsNum {

    /**
     * 深度优先搜索
     * 时间复杂度：O(MN)
     * 空间复杂度：O(MN)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int num_islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    num_islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        if(i<0 || j<0 || i>= rowCount || j>=colCount || grid[i][j] == 0){
            return;
        }
        grid[i][j]=0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
