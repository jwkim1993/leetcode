class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numPR = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>();
        
        for(int i = 0 ; i < numCourses ; ++i) {
            courses.add(new ArrayList<>());
        }
        
        for(int[] c : prerequisites) {
            courses.get(c[1]).add(c[0]);
            ++numPR[c[0]];
        }
        
        int retPtr = 0;
        int[] retArr = new int[numCourses];
        Set<Integer> courseSet = new HashSet<>();
        
        for(int i = 0 ; i < numCourses ; ++i) {
            int minPR = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int idx = 0 ; idx < numCourses ; ++idx) {
                if(numPR[idx] < minPR && !courseSet.contains(idx)) {
                    minPR = numPR[idx];
                    minIdx = idx;
                }
            }
            
            if(minPR != 0)
                return new int[0];
            
            courseSet.add(minIdx);
            retArr[retPtr++] = minIdx;
            for(int postCourse: courses.get(minIdx)) {
                --numPR[postCourse];
            }
        }
        
        return retArr;
    }
}
