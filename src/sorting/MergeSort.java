package sorting;

import java.util.Comparator;

public class MergeSort {

	private static final int CUTOFF = 7;

	/*private static void merge(Object[] a, Object[] aux, Object[] b,
			Object[] bux, int lo, int mid, int hi,Comparator comparator) {
		assert isSorted(a, lo, mid, comparator); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid + 1, hi, comparator); // precondition: a[mid+1..hi] sorted
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
			bux[k] = b[k];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
				b[k] = bux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
				b[k] = bux[i++];
			} else if (less(comparator, aux[j], aux[i])) {
				a[k] = aux[j++];
				b[k] = bux[j++];
			} else {
				a[k] = aux[i++];
				b[k] = bux[i++];
			}
		}
		assert isSorted(a, lo, hi, comparator); // postcondition: a[lo..hi] sorted
	}*/

	private static void sort(Object[] a, Object[] aux, Object[] b,
			Object[] bux, int lo, int hi,Comparator comparator) {
		if (hi <= lo)
			return;
		if (hi <= lo + CUTOFF - 1)
			InsertionSort.sort(a, b, lo, hi, comparator);
		else {
			int mid = lo + (hi - lo) / 2;
			sort(a, aux, b, bux, lo, mid, comparator);
			sort(a, aux, b, bux, mid + 1, hi, comparator);
			if (!less(comparator, a[mid + 1], a[mid]))
				return;
			//merge(a, aux, b, bux, lo, mid, hi, comparator);
		}
	}

	public static void sort(Object[] a, Object[] b,Comparator comparator) {
		Object[] aux = new Object[a.length];
		Object[] bux = new Object[b.length];
		sort(a, aux, b, bux, 0, a.length - 1, comparator);
	}

	public static boolean isSorted(Object[] a, int l, int m, Comparator comparator) {
		for (int i=l;i<=m;i++)
			if (less(comparator, a[i],a[i-1])) return false;
		return true;
	}
	
	
	private static boolean less(Comparator comparator, Object v,
			Object w) {
		return comparator.compare(v, w) < 0;
	}
}
