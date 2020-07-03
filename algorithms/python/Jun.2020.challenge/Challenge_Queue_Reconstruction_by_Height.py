class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        retList = [];
        
        for person in people:
            retList.insert(person[1], person)
        
        return retList
