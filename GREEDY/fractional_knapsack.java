import java.util.*;

public class fractional_knapsack
{
	static class items
	{
		int weight,profit;
		items(int w,int p)
		{
			this.weight=w;
			this.profit=p;
		}
	}
	static class itemcomparator implements Comparator<items>
	{
		public int compare(items a,items b)
		{
			double r1=(double)a.profit/(double)a.weight;
			double r2=(double)b.profit/(double)b.weight;
			if(r1<r2)
			return 1;
			else if(r1>r2)
			return -1;
			else return 0;
		}
	}
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int p,w,c;
		ArrayList<items> arr=new ArrayList<>();
		do{
			System.out.println("Enter the profit of the items:");
			p=in.nextInt();
			System.out.println("Enter the weight of the items:");
			w=in.nextInt();
			arr.add(new items(w,p));
			System.out.println("Do you want to continue?:");
		c=in.nextInt();
		}while(c==1);
		Collections.sort(arr,new itemcomparator());
		int capacity;
		System.out.println("Enter the capacity for the knapsack:");
		capacity=in.nextInt();
		int currw=0;
		double finalp=0.0;
		for(items a:arr)
		{
			if(currw+a.weight<=capacity)
			{
				currw+=a.weight;
				finalp+=a.profit;
			}
			else
			{
				int rw=capacity-currw;
				finalp+=((double)a.profit/(double)a.weight)*rw;
				break;
			}
		}
		System.out.println("the final profit for the knapsack is:"+finalp);
	}
}
