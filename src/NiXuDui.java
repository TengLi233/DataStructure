import java.util.*;

public class NiXuDui {
	public static int num = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
	
		int N = in.nextInt();

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		mergeSort(arr, 0, arr.length - 1);
			
		System.out.println(num);
		num = 0;

	
	
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int middle = (l + r) / 2;
		mergeSort(arr, l, middle);
		mergeSort(arr, middle + 1, r);
		merge(arr, l, r, middle);
	}
	public static void merge(int[] arr, int l, int r, int middle) {
		int[] tempArray = arr.clone();
		int index1 = l;
		int index2 = middle + 1;
		int i = l;
		
		while(index1 <= middle && index2 <= r) {
			if(tempArray[index1] <= tempArray[index2]) {
				arr[i++] = tempArray[index1++];
			}else {
				arr[i++] = tempArray[index2++];
				num += middle - index1 + 1;
			}
		}
		while(index1 <= middle) {
			arr[i++] = tempArray[index1++];
		}
		while(index2 <= r) {
			arr[i++] = tempArray[index2++];
		}
	}	
		

}
