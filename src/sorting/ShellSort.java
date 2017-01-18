package sorting;

import java.util.Comparator;

public class ShellSort {
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

	public static void sort(Comparable[] a, Comparable[] b, Comparator comparator) {
		int n = a.length;

		int h = 1;
		while (h < n / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h; j -= h)
					if (less(comparator, a[j], a[j - h])) {
						exch(a, j, j - h);
						exch(b, j, j - h);
					} else
						break;
			}
			h = h / 3;
		}
	}
}
