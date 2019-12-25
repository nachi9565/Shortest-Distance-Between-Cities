import java.util.Comparator;

class DistanceComparator implements Comparator<Edge>{
	public int compare( Edge x, Edge y )
    {
        return x.getDistance() - y.getDistance();
    }
}