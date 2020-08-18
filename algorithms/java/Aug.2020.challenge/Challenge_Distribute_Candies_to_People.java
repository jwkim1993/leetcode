class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int numOfCandies = 1;
        int i = 0;
        
        while(candies > 0) {
            people[i] += numOfCandies;
            candies -= numOfCandies++;
            i = (i+1)%num_people;
            // System.out.println(candies);
        }
        
        people[(num_people + i-1)%num_people] += candies;
        
        return people;
    }
}
