class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0,direction = 0,x = 0,y = 0;
        int[][] Direction = {{0,1},{1,0},{0,-1},{-1,0}};

        HashSet<String> set = new HashSet<>();
        for (int[] arr : obstacles) set.add(arr[0]+"，"+arr[1]);

        for (int com : commands){
            int next_x = 0,next_y = 0;
            if (com >= 0 ){
                for(int i = 0; i < com; i++){
                    next_x = x + Direction[direction][0];
                    next_y = y + Direction[direction][1];
                    if(set.contains(next_x+"，"+next_y)) break;
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x*x + y*y);
                }
            }else{
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }
}