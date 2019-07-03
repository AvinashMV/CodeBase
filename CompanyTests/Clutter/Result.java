package com.solution3;

import java.util.*;

/**
 * @author Avinash Vijayakumar
 * 2019-06-01
 */

public class Result {
    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    private static Map<List<Integer>,Integer> finalCost = new HashMap<>();

    //Constructor
    public Result(int vertices){

        //initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList()
    {
        adjList = new ArrayList[v];

        for(int i = 0; i < v; i++)
        {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        adjList[u].add(v);
        adjList[v].add(u);
    }

    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d))
        {
            finalCost.put(List.copyOf(localPathList),0);
            // System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[u]= false;
            return ;
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u])
        {
            if (!isVisited[i])
            {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }


    // Driver program
    public static void main(String[] args)
    {
        // Create a sample graph
        Integer[] starting = {1,1,1,2,2};
        Integer[] ending =   {2,3,4,3,4};
        Integer[] cost =     {1,1,1,1,1};

        classifyEdges(4,Arrays.asList(starting),Arrays.asList(ending),Arrays.asList(cost));
    }


    public static void classifyEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo,List<Integer> gWeight){

        Map<String,Integer> costMap = new HashMap<>();

        Result g = new Result(gNodes+1);

        for(int i=0;i<gFrom.size();i++){
            g.addEdge(gFrom.get(i),gTo.get(i));
            Integer[] t = {gFrom.get(i),gTo.get(i)};
            Arrays.sort(t);

            // to put it to map.
            StringBuilder sb = new StringBuilder();
            sb.append(t[0]);sb.append(t[1]);
            costMap.put(sb.toString(),gWeight.get(i));
        }

        System.out.println(costMap);
        // arbitrary source
        int s = 1;

        // arbitrary destination
        int d = gNodes;

        System.out.println("Following are all different paths from "+s+" to "+d);
        g.printAllPaths(s, d);

        System.out.println(finalCost);

        int minsum = Integer.MAX_VALUE;

        for(Map.Entry<List<Integer>,Integer> entry:finalCost.entrySet()){
                int sum = 0;
                int[] t = new int[2];
                List<Integer> list = entry.getKey();
                for(int i=0;i<list.size()-1;i++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(i));
                    sb.append(list.get(i+1));

                    if(costMap.containsKey(sb.toString()))
                        sum += costMap.get(sb.toString());
                    else if(costMap.containsKey(sb.reverse().toString()))
                        sum += costMap.get(sb.toString());

                }
                minsum = Math.min(minsum,sum);
                entry.setValue(sum);
        }

        // System.out.println(finalCost);

        // find out final set of edges.
        Set<String> edges = new HashSet<>();
        for(Map.Entry<List<Integer>,Integer> entry:finalCost.entrySet()){
            if(entry.getValue()==minsum){
                List<Integer> list = entry.getKey();
                for(int i=0;i<list.size()-1;i++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(list.get(i));
                    sb.append(list.get(i+1));
                    edges.add(sb.toString());
                }
            }
        }

        // System.out.println(edges);

        List<String> result = new ArrayList<>();
        for(int i=0;i<gFrom.size();i++){
            StringBuilder sb = new StringBuilder();
            sb.append(gFrom.get(i));
            sb.append(gTo.get(i));

            if(edges.contains(sb.toString()) || edges.contains(sb.reverse().toString())){
                result.add("YES");
            }else{
                result.add("NO");
            }
        }

        System.out.println(result);
        // return result;
    }
}


/*
Test Case 1:
int[] starting = {1,2,3,4,5,1,5};
int[] ending =   {2,3,4,5,1,3,3};
int[] cost =     {1,1,1,1,3,2,1};

Test case 2:
int[] starting = {1,2,1,3,1};
int[] ending =   {2,4,3,4,4};
int[] cost =     {1,1,1,2,2};


Test case 3:
Integer[] starting = {1,2,1,3,1};
Integer[] ending =   {2,4,3,4,4};
Integer[] cost =     {1,1,1,2,2};

Test case 4:
Integer[] starting = {1,2,3,1,4,3,2};
Integer[] ending =   {2,3,5,4,5,4,4};
Integer[] cost =     {1,1,1,1,2,2,4};




 */