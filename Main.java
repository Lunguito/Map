import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Dado un ArrayList donde se le cargan al menos 15 numeros (como mínimo).
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer[] numeros = { 1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 7, 7, 10, 10, 10, 10, 10 };
		for (Integer num : numeros) {
			lista.add(num);
		}

		// Hacer un procedimiento que se llame Busco5Max(ArrayList<Integer> listaInt )
		// que devuelva los 5 números mas repetidos de la lista (en un ArrayList

		Busco5Max(lista);

	}

	private static void Busco5Max(ArrayList<Integer> lista) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer num : lista) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		// System.out.println(map);

		List<Map.Entry<Integer, Integer>> listaNumeros = new ArrayList<>(map.entrySet());
		Collections.sort(listaNumeros, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		System.out.println("Los 5 números más repetidos son:");
		int contador = 0;
		for (Map.Entry<Integer, Integer> entry : listaNumeros) {
			if (contador < 5) {
				System.out.println(entry.getKey() + " se repite " + entry.getValue() + " veces.");
				contador++;
			} else {
				break;
			}
		}
	}

}
