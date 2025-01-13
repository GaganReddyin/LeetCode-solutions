class Solution {
    public int scheduleCourse(int[][] courses) {
        
        int n = courses.length;

        // sorting the courses based on last day, we want to check if sequentially early ending courses can be taken
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        Queue<int[]> maxh = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        int curTotalTime = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            if (duration > lastDay) continue;

            curTotalTime += duration;

            if (curTotalTime <= lastDay) maxh.add(course);
            else {
                // till now taken course which has longest duration.
                int[] longestDurationCourseTaken = maxh.peek();


                // if we get a course which has smaller duration then we will replace the longest duration course which is alredy taken and this is not causing any harm as we are going though courses sorted by last day, instead this swap is creating more opportunity (greedy approach) to taken more courses in future as we are replacing couses with smaller duraiton, mean less curTotalTime -> more opportunity to fit a future course in the to do list.
                if (longestDurationCourseTaken[0] >= duration) {
                    maxh.poll();
                    curTotalTime -= longestDurationCourseTaken[0];
                    maxh.add(course);
                } else {
                    curTotalTime -= duration;
                }
            }
        }

        return maxh.size();
    }
}