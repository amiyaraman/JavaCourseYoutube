import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class TestJava {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            b[i]=i+1;
        }
        int c[]=b.clone();

        int count=0;
        while(true){
            int d[]=new int[n];
            count++;
            for (int i = 0; i < n; i++) {
                d[a[i]-1]=c[i];
            }
            if(Arrays.equals(b,d)){
                System.out.println(count);
                break;
            }
            c=d.clone();
        }

    }
}
