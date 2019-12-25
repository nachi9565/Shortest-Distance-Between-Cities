
public class Edge {
	private int u;
	private int v;
	private int distance;
	
	public Edge(int first, int second, int dist) {
		u = first;
		v = second;
		distance = dist;
	}
	
	public int getU() {
		return u;
	}
	
	public int getV() {
		return v;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setU(int first) {
		u = first;
	}
	
	public void setV(int second) {
		v = second;
	}
	
	public void setDistance(int dist) {
		distance = dist;
	}
	
}
