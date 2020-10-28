package pers.captain.algorithm.October;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CourseSchedule_207 {
    /**
     * 方法一： 广度优先遍历
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        if (prerequisites == null || numCourses < 0) return false;
        //  邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        //  节点入度数组
        int[] degrees = new int[numCourses];
        // 1. 初始化 邻接表和入度数组
        for (int[] requisites : prerequisites) {
            degrees[requisites[0]]++; // 入度加一
            adjacency.get(requisites[1]).add(requisites[0]);
        }
        // 遍历的队列（课程编号）
        Queue<Integer> queue = new LinkedList<>();
        // 2. 入度为0的节点（课程编号）
        for (int cour = 0; cour < numCourses; cour++) {
            if (degrees[cour] == 0) queue.add(cour);
        }
        // 3. BFS 广度优先遍历
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            List<Integer> nextList = adjacency.get(pre);
            for (int cur : nextList) {
                if (--degrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }

    @Test
    public void canFinish() {
        int[][] prerequisites = new int[2][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{0, 1};
        boolean result = canFinish(2, prerequisites);
        Assert.assertFalse(result);
    }
}
