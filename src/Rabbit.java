import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Rabbit {
	public static final int MAX = 100;
	public static void main(String[] args) {
		
		System.out.println("Hello!");
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[][] graph = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				graph[i][j] = MAX;
			}
		}
		
		for(int i = 0; i < n - 1; i++) {
			int v1 = in.next().charAt(0) - 'A';
			int e = in.nextInt();
			for(int j = 0; j < e; j++) {
				int v2 = in.next().charAt(0) - 'A';
				int weight = in.nextInt();
				graph[v1][v2] = weight;
				graph[v2][v1] = weight;
			}
		}
		in.close();
		prim(graph, n);
				
	}
	
	public static void prim(int[][] graph, int n) {
		char[] c = new char[n];    
		char x = 'A';
		for(int i = 0; i < n; i++) {
			c[i] = x;
			x += 1;
		}
		
		
        int[] lowcost = new int[n];  //到新集合的最小权   
        int[] mid= new int[n];//存取前驱结点  
        ArrayList<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序  
        int i, j, min, minid , sum = 0;  
        //初始化辅助数组  
        for(i=1;i<n;i++)  
        {  
            lowcost[i]=graph[0][i];  
            mid[i]=0;  
        }  
        list.add(c[0]);  
        //一共需要加入n-1个点  
        for(i=1;i<n;i++)  
        {  
             min=MAX;  
             minid=0;  
             //每次找到距离集合最近的点  
             for(j=1;j<n;j++)  
             {  
                 if(lowcost[j]!=0&&lowcost[j]<min)  
                 {  
                     min=lowcost[j];  
                     minid=j;  
                 }  
             }  
               
             if(minid==0) return;  
             list.add(c[minid]);  
             lowcost[minid]=0;  
             sum+=min;  
            
             //加入该点后，更新其它点到集合的距离  
             for(j=1;j<n;j++)  
             {  
                 if(lowcost[j]!=0&&lowcost[j]>graph[minid][j])  
                 {  
                     lowcost[j]=graph[minid][j];  
                     mid[j]=minid;  
                 }  
             }  
        }  
        System.out.println(sum);  
          
    }  
	
}
