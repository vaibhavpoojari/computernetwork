package smvitm.cnlab;
import java.util.Scanner;
public class Bellmandemofinal {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    int v, e = 0, checkNegative;
    int[][] w;
    int[][] edge;
    System.out.print("Enter number of vertices: ");
    v = in.nextInt();
    w = new int[v][v];  
    edge = new int[50][2];  
    System.out.println("Enter the weight matrix (0 for no edge):");
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {
        w[i][j] = in.nextInt();
        if (w[i][j] != 0) {
          edge[e][0] = i;
          edge[e][1] = j;
          e++;
        }
      }
    }
    checkNegative = bellmanFord(w, v, e, edge);
    if (checkNegative == 1)
      System.out.println("\nNo negative weight cycle");
    else
      System.out.println("\nNegative weight cycle exists");
  }
  public static int bellmanFord(int[][] w, int v, int e, int[][] edge) {
    int u, v1, s, flag = 1;
    int[] distance = new int[v];
    int[] parent = new int[v];
    for (int i = 0; i < v; i++) {
      distance[i] = Integer.MAX_VALUE;
      parent[i] = -1;
    }
    System.out.print("Enter the source vertex: ");
    s = in.nextInt();
    distance[s] = 0;
    for (int i = 1; i <= v - 1; i++) {
      for (int k = 0; k < e; k++) {
        u = edge[k][0];
        v1 = edge[k][1];
        if (distance[u] != Integer.MAX_VALUE && distance[u] + w[u][v1] < distance[v1]) {
          distance[v1] = distance[u] + w[u][v1];
          parent[v1] = u;
        }
      }
    }
    for (int k = 0; k < e; k++) {
      u = edge[k][0];
      v1 = edge[k][1];
      if (distance[u] != Integer.MAX_VALUE && distance[u] + w[u][v1] < distance[v1]) {
        flag = 0;
      }
    }
    if (flag == 1) {
      for (int i = 0; i < v; i++) {
        if (distance[i] == Integer.MAX_VALUE) {
          System.out.println("Vertex " + i + " -> No path");
        } else {
          System.out.println("Vertex " + i + " -> Cost = " + distance[i] + ", Parent = " + parent[i]);
        }
      }
    }
    return flag;
  }
}

