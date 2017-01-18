/*
 * MergeSort.sort() і Insertion.sort()-стійкі;
 * Selection.sort() і Shell.sort()-нестійкі;
 * для перевірки певного алгоритму сортування, розкоментуйте відповідний виклик методу в методі main().
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.SelectionSort;
import sorting.ShellSort;

public class TesterSt {

	private String name;
	private Integer age;

	private Students[] stds;
	private static Integer[] keys;
	private BufferedReader red;

	public Students[] getStds() {
		return stds;
	}

	public void setStds(Students[] stds) {
		this.stds = stds;
	}

	protected void readPeople(int k) throws Exception {
		stds = new Students[k];
		int counter = 0;
		String line;
		String data[];
		red = new BufferedReader(new FileReader("in.txt"));
		StringTokenizer sT;

		while (counter != k) {
			data = new String[2];

			line = red.readLine();

			if ((line) != null) {
				sT = new StringTokenizer(line);
				for (int i = 0; i < 2; i++) {
					if (sT.hasMoreTokens()) {
						data[i] = sT.nextToken();
						//System.out.println(data[i]);
					} else {
						throw new Exception("Wrong input!");
					}
				}

				if (rightString(data[0])) {
					name = data[0];

				}

				if (!rightNumer(data[1]) && Integer.parseInt(data[1]) < 14
						&& Integer.parseInt(data[1]) > 60) {

					throw new Exception("Wrong input!");
				} else {
					age = Integer.parseInt(data[1]);
				}

				
				Students st = new Students(name, age);
				stds[counter] = st;
				counter++;
			} else {
				throw new Exception("Wrong input!");
			}
		}
		red.close();
	}

	protected void writePeople(Students[] students) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
			for (int i = 0; i < students.length; i++) {
				bw.write(students[i].toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writePeople(Students[] peopleLists, Integer[] integer) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
			for (int i = 0; i < peopleLists.length; i++) {
				bw.write(peopleLists[i].toString() + " " + integer[i]);
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean rightString(String n1) {
		if (n1 != null && !n1.equals("")) {
			for (int i = 0; i < n1.length(); i++)
				if (!Character.isDigit(n1.charAt(i)))
					return true;
			return false;
		} else
			return false;
	}

	private boolean rightNumer(String n1) {
		if (n1 != null && !n1.equals("")) {
			for (int i = 0; i < n1.length(); i++)
				if (!Character.isDigit(n1.charAt(i)))
					return false;
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws Exception {
		TesterSt tst = new TesterSt();

		tst.readPeople(8);

		keys = new Integer[tst.getStds().length];
		for (int i = 0; i < tst.getStds().length; i++) {
			keys[i] = i;
		}
		// USE COMPARABLE => COMPAREtO()
		//Arrays.sort(tst.getStds());
		
		// USE CONCRETE COMPARATOR
		Arrays.sort(tst.getStds(), Students.BY_AGE);
		//MergeSort.sort(tst.getStds(), keys, Students.BY_AGE);
		//InsertionSort.sort(tst.getStds(), keys, Students.BY_AGE);
		//SelectionSort.sort(tst.getStds(), keys, Students.BY_AGE);
		//ShellSort.sort(tst.getStds(), keys, Students.BY_AGE);

		//MergeSort.sort(tst.getStds(), keys, Students.BY_NAME);
		//InsertionSort.sort(tst.getStds(), keys, Students.BY_NAME);
		//SelectionSort.sort(tst.getStds(), keys, Students.BY_NAME);
		//ShellSort.sort(tst.getStds(), keys, Students.BY_NAME);

		tst.writePeople(tst.getStds(), keys);

	}

}
