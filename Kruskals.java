import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskals {

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\\\5343.001 - Data Structures\\\\Project 5\\\\assn9_data.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s;
		@SuppressWarnings("rawtypes")
		List<ArrayList> csvList = new ArrayList<>();
		List<String> cityList = new ArrayList<>();
		int noOfVertices=0;
		while((s = br.readLine()) != null) {
			noOfVertices++;
			String[] citiesAndDistances = s.split(",");
			cityList.add(citiesAndDistances[0]);
			ArrayList<String> splitValueList = new ArrayList<String>();
			for(int i=1;i<citiesAndDistances.length;i++) {
				if(i%2!=0 && cityList.contains(citiesAndDistances[i])) {
					i++;
					continue;
				}
				splitValueList.add(citiesAndDistances[i]);
			}
			csvList.add(splitValueList);
		}			
		br.close();
		System.out.println("Number of Vertices :" + noOfVertices);
		ArrayList<Edge> edgeList = new ArrayList<>();
		try {
			for(int i=0;i<cityList.size();i++) {
				for(int j=0;j<csvList.get(i).size();j+=2) {
					int v = cityList.indexOf(csvList.get(i).get(j));
					int distance = Integer.valueOf((String) csvList.get(i).get(j+1));
					Edge edge = new Edge(i,v, distance);
					edgeList.add(edge);
				}
			}
		} catch(Exception e) {
			System.out.println("Please check the format of the file uploaded for any missing commas");
		}
		DisjSets ds = new DisjSets(cityList.size());
		PriorityQueue<Edge> p = new PriorityQueue<Edge>(new DistanceComparator());
		p.addAll(edgeList);
		List<Edge> mst = new ArrayList<>();
		while(mst.size()!= cityList.size()-1) {
			Edge edge = p.remove();
			int i = ds.find(edge.getU());
			int j = ds.find(edge.getV());
			
			if(i!=j) {
				mst.add(edge);
				ds.union(i, j);
			}
		}
		Iterator<Edge> iterator = mst.iterator();
		int minCost = 0;
		while (iterator.hasNext()){
			Edge edge = iterator.next();
			minCost += edge.getDistance();
			System.out.print("U: " + cityList.get(edge.getU()) + " ");
			System.out.print("V: " + cityList.get(edge.getV()) + " ");
			System.out.print("Distance: " + edge.getDistance() + " ");
			System.out.println();
		}
		System.out.println("Minimum Distance: " + minCost);
	}
}
