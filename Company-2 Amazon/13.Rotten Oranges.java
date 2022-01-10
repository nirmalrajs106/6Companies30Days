class Solution {
    //Pair class which stores row and col data
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q=new LinkedList<Pair>();
        int dir[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //variable to store the fresh oranges count
        int freshOranges=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)q.add(new Pair(i,j));
                else if(grid[i][j]==1)freshOranges++;
            }
        }
		//if there are no oranges, then we dont spend any time. so return 0
        if(freshOranges==0)return 0;
        int minutes=-1;
        while(!q.isEmpty()){
            int size=q.size();
            minutes++;
            while(size-->0){
                Pair p=q.remove();
                for(int i=0;i<dir.length;i++){
                    int x=p.i+dir[i][0];
                    int y=p.j+dir[i][1];
                    if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length&&grid[x][y]==1){
                        freshOranges--;
                        grid[x][y]=2;//changing to 2 bcoz this got rotten
                        q.add(new Pair(x,y));
                    }
                }
            }
        }
		//if there are freshOranges even after the traversal, that means we are unable to rotten few of them. hence we return -1;
        if(freshOranges>0)return -1;
        return minutes;
    }
}