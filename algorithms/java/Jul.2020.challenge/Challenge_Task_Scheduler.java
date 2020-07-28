class Solution {
    
    public static class Task implements Comparable<Task>{
        char task;
        int count;
        public Task(char task, int count) {
            this.task = task;
            this.count = count;
        }
        
        @Override
        public int compareTo(Task o) {
            return this.count - o.count;
        }
        
    }
    
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        else if(tasks.length == 1)
            return 1;
        
        int count = 1;
        char prev = tasks[0];
        PriorityQueue<Task> taskList = new PriorityQueue<>(Collections.reverseOrder());
        List<Task> tmpList = new ArrayList<>();
        
        Arrays.sort(tasks);
        for(int i = 1 ; i < tasks.length ; ++i) {
            if(tasks[i-1] == tasks[i]) {
                ++count;
                continue;
            }
            
            taskList.offer(new Task(tasks[i-1], count));
            count = 1;
            prev = tasks[i];
        }
        
        taskList.offer(new Task(tasks[tasks.length - 1], count));
        // taskList.stream().forEach(t -> System.out.printf("task %c: %d\n", t.task, t.count));
        
        int retTime = 0;
        int rr = n+1;
        while(!taskList.isEmpty()) {
            while(rr > 0 && !taskList.isEmpty()) {
                Task tmp = taskList.poll();
                ++retTime;
                --rr;
                if(--tmp.count > 0)
                    tmpList.add(tmp);
            }
            if(!taskList.isEmpty() || !tmpList.isEmpty()) {
                retTime += rr;
            }
            
            for(Task t: tmpList) {
                taskList.offer(t);
            }
            
            // System.out.printf("retTime: %d, rr: %d\n",retTime,rr);
            rr = n+1;
            tmpList = new ArrayList<>();
        }
        
        return retTime;
    }
}
