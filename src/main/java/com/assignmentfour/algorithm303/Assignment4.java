package com.assignmentfour.algorithm303;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {

    private int adjMatrix[][];
    private int mazeSize;
    static int Vertex;
    public static int count = 0;//number of nodes

    static LinkedList<Integer>[] adjacency;
    public static Stack<Integer> stack;
    public static Queue<Integer> queue;

    // Matrix initilization
    public Graph(int mazeSize) {

        this.Vertex = Vertex;
        adjacency = new LinkedList[Vertex];
        this.mazeSize = mazeSize;
        adjMatrix = new int[mazeSize][mazeSize];

        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void printAdj() {//Printing matrix

        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void DFS(int index) {

        queue.add(index);

        boolean node[] = new boolean[15];

        while (!queue.isEmpty()) {
            index = queue.peek();
            queue.remove();

            if (node[index] == false) {

                node[index] = true;
            }

            for (int i = 0; i < adjacency[index].size(); i++) {
                count = adjacency[index].get(i);
                if (node[index] == false) {
                    queue.add(count);
                }

            }
        }

    }

    public static void BFS(int index) {

        boolean node[] = new boolean[Vertex];       //initialize boolean array for holding the data

        node[index] = true;
        stack.push(index);

        while (stack.size() != 0) {
            index = stack.pop();

            for (int i = 0; i < adjacency[index].size(); i++) {
                count = adjacency[index].get(i);
                if (node[count] == false) {

                    stack.push(count);
                    node[count] = true;
                }
            }
        }
    }
    }

    public class Assignment4 {

        public static void main(String args[]) {

            Graph mygraph = new Graph(15);

            int H[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
            {0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

            int V[][] = {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1}};

            Progress(H, V, mygraph);

        }

        public static boolean right(int v[][], int i, int j) {
            if (i < 15 && j < 16) {
                if (v[i][j + 1] == 0) {
                    // System.out.println("right");
                    return true;
                }
            }

            return false;
        }

        public static boolean left(int v[][], int i, int j) {
            if (i > 0 && j > 0) {
                if (v[i][j - 1] == 0) {
                    // System.out.println("left");
                    return true;
                }
            }

            return false;
        }

        public static boolean down(int h[][], int i, int j) {
            if (i < 16 && j < 15) {
                if (h[i + 1][j] == 0) {
                    // System.out.println("down");
                    return true;
                }
            }

            return false;
        }

        public static boolean up(int h[][], int i, int j) {
            if (i > 0 && j > 0) {
                if (h[i - 1][j] == 0) {
                    // System.out.println("up");
                    return true;
                }
            }

            return false;
        }

        public static void Progress(int h[][], int v[][], Graph g) {

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {

                    if (right(v, i, j) == true) {

                        g.addEdge(i, j + 1);

                    } else if (down(h, i, j) == true) {
                        g.addEdge(i + 1, j);
                    } else if (left(v, i, j) == true) {
                        g.addEdge(i, j - 1);
                    } else if (up(h, i, j) == true) {
                        g.addEdge(i - 1, j);
                    }

                }

            }
            g.printAdj();

        }
    }
