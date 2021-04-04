/*
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
*/

public int[] findOrder(int numCourses, int[][] prerequisites) { 
    if (numCourses == 0) return null;
    // Convert graph presentation from edges to indegree of adjacent list.
    int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
    for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
        indegree[prerequisites[i][0]]++;    

    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) 
        if (indegree[i] == 0) {
            // Add the course to the order because it has no prerequisites.
            order[index++] = i;
            queue.offer(i);
        }

    // How many courses don't need prerequisites. 
    while (!queue.isEmpty()) {
        int prerequisite = queue.poll(); // Already finished this prerequisite course.
        for (int i = 0; i < prerequisites.length; i++)  {
            if (prerequisites[i][1] == prerequisite) {
                indegree[prerequisites[i][0]]--; 
                if (indegree[prerequisites[i][0]] == 0) {
                    // If indegree is zero, then add the course to the order.
                    order[index++] = prerequisites[i][0];
                    queue.offer(prerequisites[i][0]);
                }
            } 
        }
    }

    return (index == numCourses) ? order : new int[0];
