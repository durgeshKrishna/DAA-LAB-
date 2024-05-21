
import java.util.*;


public class activity {
    static  class act
    {
        int start,finish;
        act(int s,int f)
        {
            this.start=s;
            this.finish=f;
        }

    }
    static void maxact(act a[],int n)
    {
        System.out.println("Following activity selected:");
        int i;
        i=0;
        System.out.print(i+" ");
        for (int j = 1; j < n; j++) {
            if(a[j].start>=a[i].finish)
            {
                System.out.print(j+" ");
                i=j;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n,s,f;
        System.out.println("Enter the number of the activity to proceed with:");
        n=in.nextInt();
        act arr[]=new act[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the start time and end time:");
            s=in.nextInt();
            f=in.nextInt();
            arr[i]=new act(s,f);
        }
        maxact(arr,n);
    }
}
