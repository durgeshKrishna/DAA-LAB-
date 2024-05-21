import java.util.*;

public class minimumcoin
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int v;
		System.out.println("Enter the Coin Amount:");
		v=in.nextInt();
		Vector<Integer> ans=new Vector<>();
		int[] deno={1,2,5,10,20,50,100,500,1000};
		int n=deno.length;
		for(int i=n-1;i>=0;i--)
		{
			while(v>=deno[i])
			{
				v-=deno[i];
				ans.add(deno[i]);
			}
		}
		for(int i=0;i<ans.size();i++)
		{
			System.out.println(" "+ans.elementAt(i));
		}
	}
}

