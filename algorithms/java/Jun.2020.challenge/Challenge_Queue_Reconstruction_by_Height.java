class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt((int[] p) -> -p[0]).thenComparingInt(p -> p[1]));
        List<int[]> retList = new ArrayList<>(); 
        for(int[] person: people){
            retList.add(person[1], person);
        }
        
        return retList.toArray(new int[retList.size()][2]);
    }
}
