import java.text.DecimalFormat;
import java.util.*;

public class Main {
	static List<Double> duration = new LinkedList<>();
	static List<Double> cost = new LinkedList<>();
	static HashMap<Integer, Double> partialCosts = new HashMap<>();
	static double[] discounts = { 1.00, 2.00, 4.00, 4.00, 4.00, 4.00 };
	static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double total = 0;
		int id = 0;
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			double dur = scan.nextDouble();
			double cos = scan.nextDouble();
			duration.add(dur);
			cost.add(cos);
			if (dur > 120 && ok) {
				total += cos;
				id = i;
			} else {
				ok = false;
			}
		}
		if (id == (n - 1))
			System.out.println(String.valueOf(df.format(total)).replace(",", "."));
		else {
			double minCost = total + getMinCost(id);
			System.out.println(String.valueOf(df.format(minCost)).replace(",", "."));
		}

	}

	public static double getMinCost(int index) {
		if (index > cost.size())
			return 0;
		if (partialCosts.get(index) != null) {
			return partialCosts.get(index);
		}
		double partialDuration = 0;
		double partialCost = 0;
		double min = Double.MAX_VALUE;
		for (int i = 0; i < 6 && partialDuration < 120 && index + i < duration.size(); i++) {
			partialCost += cost.get(index + i) / discounts[i];
			if (index + i + 1 < duration.size()) {
				min = Math.min(min, partialCost + getMinCost(index + i + 1));
			} else
				min = partialCost;
			partialDuration += duration.get(index + i);
		}
		partialCosts.put(index, min);
		return min;
	}
}
