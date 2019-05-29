package com.solution1;

import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-05-17
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {1, 2}, {0, 1}};
        int numCoureses = 3;
        Solution solution = new Solution();
        boolean res = solution.canFinish(numCoureses, arr);
        System.out.println(res);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // stores dep as key and courese it depends on as values.
        Map<Integer, List<Integer>> dependency = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // build dependency array and indegree map.
        for(int[] course:prerequisites){
            inDegree[course[0]]++;

            if(dependency.containsKey(course[1])){
                dependency.get(course[1]).add(course[0]);
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(course[0]);
                dependency.put(course[1],t);
            }
        }

        // start with initial course whose inDegree is 0.
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) {
                queue.add(i);
                break;
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            // get the list of courses dependent on this course.
            List<Integer> courselist = dependency.get(x);
            // adjust inDegree of these courses.
            if(courselist!=null && courselist.size()>0){
                for(int i:courselist){
                    inDegree[i]--;
                    if(inDegree[i]==0)
                        queue.add(i);
                }
            }

        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]!=0)
                return false;
        }

        return true;
    }
}



/*
Test Cases:
int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
int numCoureses = 4;


int[][] arr = {{1,0},{0,1}};
int numCoureses = 2;


 */