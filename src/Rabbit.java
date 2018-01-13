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
		
		
        int[] lowcost = new int[n];  //���¼��ϵ���СȨ   
        int[] mid= new int[n];//��ȡǰ�����  
        ArrayList<Character> list=new ArrayList<Character>();//�����洢�������˳��  
        int i, j, min, minid , sum = 0;  
        //��ʼ����������  
        for(i=1;i<n;i++)  
        {  
            lowcost[i]=graph[0][i];  
            mid[i]=0;  
        }  
        list.add(c[0]);  
        //һ����Ҫ����n-1����  
        for(i=1;i<n;i++)  
        {  
             min=MAX;  
             minid=0;  
             //ÿ���ҵ����뼯������ĵ�  
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
            
             //����õ�󣬸��������㵽���ϵľ���  
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
