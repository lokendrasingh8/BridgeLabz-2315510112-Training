package fullStack;
import java.util.*;
public class factor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("input : ");
		int num=sc.nextInt();
		int[] arr=new int[5];
		int x =0;
		for(int i=1;i<num;i++) {
			if(num%i==0) {
				arr[x]=i;
				x++;
			}
		}
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

}
