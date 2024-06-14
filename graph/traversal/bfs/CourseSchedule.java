package graph.traversal.bfs;

import java.util.*;

public class CourseSchedule {

    // Function to determine if you can finish all courses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize the adjacency list and in-degree array
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list and fill the in-degree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        // Queue to store courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;

        // Process courses in the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            for (int nextCourse : adjacencyList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If we were able to take all the courses, return true
        return coursesTaken == numCourses;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish all courses: " + solution.canFinish(numCourses1, prerequisites1)); // Output: true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish all courses: " + solution.canFinish(numCourses2, prerequisites2)); // Output: false
    }
}

