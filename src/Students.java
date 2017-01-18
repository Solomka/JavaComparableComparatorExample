
import java.util.Comparator;

public class Students implements Comparable<Students> {
	private String name;
	private Integer age;

	public Students(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static final Comparator<Students> BY_NAME = new SortedByName();

	public static final Comparator<Students> BY_AGE = new SortedByAge();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	/*
	 * public void setAge(Integer age) { this.age = age; }
	 */

	public String toString() {
		return name + " " + age + "\n";
	}

	/**
	 * COMPARE BY NAME
	 * 
	 * @author Solomka
	 *
	 */
	private static class SortedByName implements Comparator<Students> {

		public int compare(Students st1, Students st2) {
			return st1.name.compareTo(st2.name);

		}
	}
	
	/**
	 * COMPARE BY AGE
	 * 
	 * @author Solomka
	 *
	 */
	private static class SortedByAge implements Comparator<Students> {

		public int compare(Students st1, Students st2) {

			return st1.age.compareTo(st2.age);

		}
	}

	public int compareTo(Students st) {
		Students people = st;

		int result = name.compareTo(people.name);
		if (result != 0) {
			return result;
		}

		result = age - people.age;
		if (result != 0) {
			return (int) result / Math.abs(result);
		}
		return 0;
	}
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Students[] stds=new Students[k];
	 * 
	 * MergeSort.sort(tst.getStds(), keys, Students.BY_AGE);
	 * //InsertionSort.sort(tst.getStds(), keys, Students.BY_AGE);
	 * //SelectionSort.sort(tst.getStds(), keys, Students.BY_AGE);
	 * //ShellSort.sort(tst.getStds(), keys, Students.BY_AGE);
	 * 
	 * //MergeSort.sort(tst.getStds(), keys, Students.BY_NAME);
	 * //InsertionSort.sort(tst.getStds(), keys, Students.BY_NAME);
	 * //SelectionSort.sort(tst.getStds(), keys, Students.BY_NAME);
	 * //ShellSort.sort(tst.getStds(), keys, Students.BY_NAME);
	 * 
	 * 
	 * 
	 * }
	 */

}
