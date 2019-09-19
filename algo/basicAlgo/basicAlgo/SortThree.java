package basicAlgo;

public class SortThree {
	static int[] arr = {1,0,1,2,0,1,2,1,2,0,1,0,2};
//	static int[] arr = {1,1,0,2,1,0,1,1,0,1,2,0,1,2,1,0,1,2,1,2,1,0,1,2,1,0,2,1,2,0,1,0,2};
	static int pos_least = -1;
	static int pos_max = arr.length;
	public static void main(String[] args) {
	for(int i=0;i<arr.length&&i<pos_max;i++) {
		if(arr[i]<1) {
			while(arr[i]==arr[++pos_least]&&pos_least<i);
//			System.out.println(pos_least);
			arr = swap(arr,i,pos_least);
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[j]);								
			}
			System.out.println();
		}
		else if(arr[i]>1){
			while(arr[i]==arr[--pos_max]&&pos_max>i);
//			System.out.println(pos_max);
			arr = swap(arr,i,pos_max);
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[j]);
				
				
			}
			System.out.println();
		}
		
	}
	for(int j=0;j<arr.length;j++) {
		System.out.print(arr[j]);
		
		
	}
	
}
static int[] swap(int[] a, int i, int right){
	int arr[] = swaporiginal(a, i, right);
	if(arr[i]<1) {
		while(arr[i]==arr[++pos_least]&&pos_least<i);
		arr = swaporiginal(arr,i,pos_least);
	} 
	return arr;
	
}
static int[] swaporiginal(int[] a, int left, int right) {
	if(left!=right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	return a;
}
}