import java.util.*;

public class Main {

	public static ArrayList<ArrayList<Aresta>> grafo;
	public static ArrayList<Aresta> arestaEscolhida;
	public static Queue<Aresta> fila = new LinkedList<>();
	public static long[] custo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextLong();
		grafo = new ArrayList<ArrayList<Aresta>>();
		arestaEscolhida = new ArrayList<Aresta>();
		arestaEscolhida.add(0, new Aresta(0, 0, 0));
		custo = new long[n];

		for (int i = 1; i < n; i++)
			arestaEscolhida.add(i, new Aresta(0,  Long.MAX_VALUE, Long.MAX_VALUE));

		for (int i = 0; i < n; i++) {
			grafo.add(i, new ArrayList<>());
		}

		for (long i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			long l = sc.nextLong();
			long c = sc.nextLong();
			grafo.get(a).add(new Aresta(b, l, c));
			grafo.get(b).add(new Aresta(a, l, c));
		}

		Aresta aresta = null;
		do {
			if (aresta == null)
				aresta = new Aresta(0, 0, 0);
			
			if (arestaEscolhida.get(aresta.b).melhor(aresta)) {
				aresta = fila.poll();
				continue;
			}
			for (Aresta b : grafo.get(aresta.b)) {
				if (new Aresta(b.b, aresta.l + b.l, b.c).melhor(arestaEscolhida.get(b.b))) {
					arestaEscolhida.set(b.b, new Aresta(b.b, aresta.l + b.l, b.c));
					custo[b.b] = b.c;
					fila.add(new Aresta(b.b, aresta.l + b.l, b.c));
				}
			}
			aresta = fila.poll();
		} while (aresta != null);

		long resp = 0;
		for(int i = 0; i < n; i++)
			resp += custo[i];
		System.out.println(resp);
	}

}

class Aresta {
	int b;
	long l;
	long c;

	public Aresta(int b, long l, long c) {
		this.b = b;
		this.l = l;
		this.c = c;
	}

	public boolean melhor(Aresta a) {
		if (l == a.l) {
			return c < a.c;
		}
		return l < a.l;
	}
}
