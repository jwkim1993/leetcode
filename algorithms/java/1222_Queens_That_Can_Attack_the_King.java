class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int i = king[0];
        int j = king[1];
        
        int[][] retList = {{i,-1},{-1,-1},{-1,j},{-1,8},{i,8},{8,8},{8,j},{8,-1}};
        
        
        Set<Integer> idxSet = new HashSet<Integer>();
        
        for(int[] cordi : queens) {
            if(i == cordi[0]) {
                if(j < cordi[1] && cordi[1] < retList[4][1]) {// 4
                    retList[4][1] = cordi[1]; idxSet.add(4);
                } else if(j > cordi[1] && cordi[1] > retList[0][1]) { //0
                    retList[0][1] = cordi[1]; idxSet.add(0);
                }
            } else if(j == cordi[1]) {
                if(i < cordi[0] && cordi[0] < retList[6][0]) { //6
                    retList[6][0] = cordi[0]; idxSet.add(6);
                } else if(i > cordi[0] && cordi[0] > retList[2][0]) { //2
                    retList[2][0] = cordi[0]; idxSet.add(2);
                }
            } else if(i - cordi[0] == j - cordi[1]) { //1 or 5
                if(i > cordi[0] && cordi[0] > retList[1][0]) { //1
                    retList[1][0] = cordi[0];
                    retList[1][1] = cordi[1]; idxSet.add(1);
                } else if(i < cordi[0] && cordi[0] < retList[5][0]) {
                    retList[5][0] = cordi[0];
                    retList[5][1] = cordi[1]; idxSet.add(5);
                }
            } else if(cordi[0] - i == j - cordi[1]) { //3 or 7
                if(i > cordi[0] && cordi[0] > retList[3][0]) {
                    retList[3][0] = cordi[0];
                    retList[3][1] = cordi[1]; idxSet.add(3);
                } else if(i < cordi[0] && cordi[0] < retList[7][0]) {
                    retList[7][0] = cordi[0];
                    retList[7][1] = cordi[1]; idxSet.add(7);
                }
            }
        }
        List<List<Integer>> realRetList = new ArrayList<>();
        for(int idx : idxSet) {
            realRetList.add(new ArrayList<>(List.of(retList[idx][0], retList[idx][1])));
        }
        return realRetList;
    }
}
