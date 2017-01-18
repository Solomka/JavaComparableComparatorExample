package sorting;

import java.util.Comparator;

public class SelectionSort {

	private static boolean less(Comparator comparator, Object v, Object w) {
		return comparator.compare(v, w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static boolean isSorted(Object[] a, Comparator comparator) {
		for (int i = 1; i < a.length; i++)
			if (less(comparator, a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void sort(Object[] a, Object[] b, Comparator comparator) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (less(comparator, a[j], a[min]))
					min = j;
			exch(a, i, min);
			exch(b, i, min);
		}
	}

}
