import java.util.*;

public class kruskal
{
	static class edge implements Comparable<edge>
	{
		int source,dest,weight;
		edge(int s,int d,int w)
		{
			this.source=s;
			this.dest=d;
			this.weight=w;
		}
    	public int compareTo(edge other)
		{
			return this.weight - other.weight;
		}
	}
	static void insert_node(List<edge> graph,int u,int v,int w)
	{
		graph.add(new edge(u,v,w));
		System.out.println("successfully inserted in the graph");
	}
	static class Disjoint
	{
		int[] parent;
		Disjoint(int s)
		{
			parent=new int[s+1];
			Arrays.fill(parent,-1);
		}
		int find(int i)
		{
			if(parent[i]==-1)
			return i;
			return find(parent[i]);
		}
		void union(int x,int y)
		{
			int a=find(x);
			int b=find(y);
			parent[b]=a;
		}
	}
	static void kruskal(List<edge> graph,int v)
	{
		Collections.sort(graph);
		List<edge> result = new ArrayList<>();
		Disjoint ds=new Disjoint(v);
		int tot=0;
		for(edge e:graph)
		{
			int st=ds.find(e.source);
			int dt=ds.find(e.dest);
			if(st!=dt)
			{
				result.add(e);
				tot+=e.weight;
				ds.union(st,dt);
			}
		}
		System.out.println("total weight mst is:"+tot);
	}
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int num,op,node,u,v,weight;
		System.out.println("enter the number of the vertex for the Minimum Spanning Tree:");
		num=in.nextInt();
		List<edge> graph=new ArrayList<>();
		while(true)
		{
			System.out.println("1-> insert the node\n 2->Kruskal's Method");
			System.out.println("enter the option to be choosen:");
			op=in.nextInt();
			switch(op)
			{
				case 1:
					System.out.println("enter the source and destination for the graph:");
					u=in.nextInt();
					v=in.nextInt();
					System.out.println("enter the weight of the graph for the source and destination:");
					weight=in.nextInt();
					insert_node(graph,u,v,weight);
					break;
				case 2:
					System.out.println("Kruskal method for the given weighted graph:");
					kruskal(graph,num);
					break;
				default:
					System.out.println("invalid option");
			}
		}
	}
}
		
