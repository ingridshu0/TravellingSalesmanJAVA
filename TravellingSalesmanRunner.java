package Graph;

import java.util.ArrayList;

public class TravellingSalesmanRunner {
	
	public static void main(String[] args)
	{
		Vertex<String> v1 = new Vertex<String>("LA");
		Vertex<String> v2 = new Vertex<String>("NYC");
		Vertex<String> v3 = new Vertex<String>("BASKING RIDGE");
		Vertex<String> v4 = new Vertex<String>("MORRISTOWN");
		
		v1.addPointer(v2, 5);
		v1.addPointer(v3, 10);
		v1.addPointer(v4, 15);
		v2.addPointer(v3, 4);
		v2.addPointer(v4, 3);
		v3.addPointer(v4, 1);
		
		ArrayList<Vertex<String>> list = new ArrayList<Vertex<String>>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		
		Integer distance = 0;
		Vertex<String> cur;
		for(int i = 0; i < list.size(); i++)
		{
			cur = list.get(i);
			
			// final index
			if(i == list.size() - 1)
			{
				distance += cur.visitOther(list.get(0));
				System.out.println(cur.getValue());
				System.out.println(cur.getDistance(list.get(0)));
			}
			
			// other indices
			else
			{
				distance += cur.visitOther(list.get(i+1));
				System.out.println(cur.getValue());
				System.out.println(cur.getDistance(list.get(i+1)));
			}
		}
		
		System.out.println("TOTAL DISTANCE: " + distance);
	}

}
