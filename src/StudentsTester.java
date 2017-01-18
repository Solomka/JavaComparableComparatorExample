/*
 * MergeSort.sort() ³ Insertion.sort()-ñò³éê³;
 * Selection.sort() ³ Shell.sort()-íåñò³éê³;
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import org.junit.Test;

import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.SelectionSort;
import sorting.ShellSort;



public class StudentsTester {
	
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

	
	@Test
	public void testStudentsTesterConstructor() throws Exception {
		Students tester = new Students("Anna", 23);
		assertNotNull(tester);
	}
	

		
	@Test
	public void testStudentsMergeSort_ByName() throws Exception {
		int n=8;
		Students[] list = new Students[n];
		list[0] = new Students("Anna", 23 );
		list[1] = new Students("Anna", 23);
		list[2] = new Students("Barabara", 67);
		list[3] = new Students("Barabara", 67);
		list[4] = new Students("Inesa", 17);
		list[5] = new Students("Rita", 12);
		list[6] = new Students("Rita", 12);
		list[7] = new Students("Sofiya", 20);
		

		Students[] people = new Students[n];
		people[0] = new Students("Anna", 23);
		people[1] = new Students("Inesa", 17);
		people[2] = new Students("Anna", 23);
		people[3] = new Students("Rita", 12);
		people[4] = new Students("Sofiya", 20);
		people[5] = new Students("Barabara", 67);
		people[6] = new Students("Rita", 12);
		people[7] = new Students("Barabara", 67);
		
		

		writeInFile(people);
		readPeople(n);
		
		keys=new Integer[stds.length];
		for(int i=0; i<stds.length; i++){
			keys[i]=i;
		}
		//Comparator<Students> c = Students.BY_NAME;
		MergeSort.sort(stds, keys, Students.BY_NAME);
		writePeople(stds,keys);
		assertEquals(true, compareArrays(list, stds));

	}
	@Test
	public void testStudentsMergeSort_ByAge() throws Exception {
		int n=8;
		Students[] list = new Students[n];
		list[0] = new Students("Rita", 12);
		list[1] = new Students("Rita", 12);
		list[2] = new Students("Inesa", 17);
		list[3] = new Students("Sofiya", 20);
		list[4] = new Students("Anna", 23);
		list[5] = new Students("Anna", 23);
		list[6] = new Students("Barabara", 67);
		list[7] = new Students("Barabara", 67);
		

		Students[] people = new Students[n];
		people[0] = new Students("Anna", 23);
		people[1] = new Students("Inesa", 17);
		people[2] = new Students("Anna", 23);
		people[3] = new Students("Rita", 12);
		people[4] = new Students("Sofiya", 20);
		people[5] = new Students("Barabara", 67);
		people[6] = new Students("Rita", 12);
		people[7] = new Students("Barabara", 67);
		
		

		writeInFile(people);
		readPeople(n);
		
		keys=new Integer[stds.length];
		for(int i=0; i<stds.length; i++){
			keys[i]=i;
		}
		//Comparator<Students> c = Students.BY_AGE;
		MergeSort.sort(stds, keys, Students.BY_AGE);
		writePeople(stds,keys);
		assertEquals(true, compareArrays(list, stds));
	

	}
	@Test
	public void testStudentsInsertionSortByName() throws Exception {
		int n=8;
		
		Students[] people = new Students[n];
		people[0] = new Students("Anna", 23);
		people[1] = new Students("Inesa", 17);
		people[2] = new Students("Anna", 23);
		people[3] = new Students("Rita", 12);
		people[4] = new Students("Sofiya", 20);
		people[5] = new Students("Barabara", 67);
		people[6] = new Students("Rita", 12);
		people[7] = new Students("Barabara", 67);
		
		

		writeInFile(people);
		readPeople(n);
		
		keys=new Integer[stds.length];
		for(int i=0; i<stds.length; i++){
			keys[i]=i;
		}
		Comparator<Students> c = Students.BY_NAME;
		InsertionSort.sort(stds, keys, Students.BY_NAME);
		writePeople(stds,keys);
		assertEquals(true, InsertionSort.isSorted(stds,c));

	}
	@Test
	public void testStudentsInsertionSortByAge() throws Exception {
		int n=8;
		
		Students[] people = new Students[n];
		people[0] = new Students("Anna", 23);
		people[1] = new Students("Inesa", 17);
		people[2] = new Students("Anna", 23);
		people[3] = new Students("Rita", 12);
		people[4] = new Students("Sofiya", 20);
		people[5] = new Students("Barabara", 67);
		people[6] = new Students("Rita", 12);
		people[7] = new Students("Barabara", 67);
		
		

		writeInFile(people);
		readPeople(n);
		
		keys=new Integer[stds.length];
		for(int i=0; i<stds.length; i++){
			keys[i]=i;
		}
		Comparator<Students> c = Students.BY_AGE;
		InsertionSort.sort(stds, keys, Students.BY_AGE);
		writePeople(stds,keys);
		assertEquals(true, InsertionSort.isSorted(stds,c));

	}

@Test
	public void testStudentsSelectinoSortByName() throws Exception {
		int n=8;
		
		Students[] people = new Students[n];
		people[0] = new Students("Anna", 23);
		people[1] = new Students("Inesa", 17);
		people[2] = new Students("Anna", 23);
		people[3] = new Students("Rita", 12);
		people[4] = new Students("Sofiya", 20);
		people[5] = new Students("Barabara", 67);
		people[6] = new Students("Rita", 12);
		people[7] = new Students("Barabara", 67);
		

		writeInFile(people);
		readPeople(n);
		
		keys=new Integer[stds.length];
		for(int i=0; i<stds.length; i++){
			keys[i]=i;
		}
		Comparator<Students> c = Students.BY_NAME;
		SelectionSort.sort(stds, keys, Students.BY_NAME);
		
		writePeople(stds,keys);
		assertEquals(true, SelectionSort.isSorted(stds,c));

	}
@Test
public void testStudentsSelectinoSortByAge() throws Exception {
	int n=8;
	
	Students[] people = new Students[n];
	people[0] = new Students("Anna", 23);
	people[1] = new Students("Inesa", 17);
	people[2] = new Students("Anna", 23);
	people[3] = new Students("Rita", 12);
	people[4] = new Students("Sofiya", 20);
	people[5] = new Students("Barabara", 67);
	people[6] = new Students("Rita", 12);
	people[7] = new Students("Barabara", 67);
	

	writeInFile(people);
	readPeople(n);
	
	keys=new Integer[stds.length];
	for(int i=0; i<stds.length; i++){
		keys[i]=i;
	}
	Comparator<Students> c = Students.BY_AGE;
	SelectionSort.sort(stds, keys, Students.BY_AGE);
	
	writePeople(stds,keys);
	assertEquals(true, SelectionSort.isSorted(stds,c));

}

@Test
public void testStudentsShellSortByName() throws Exception {
	int n=8;
	
	

	Students[] people = new Students[n];
	people[0] = new Students("Anna", 23);
	people[1] = new Students("Inesa", 17);
	people[2] = new Students("Anna", 23);
	people[3] = new Students("Rita", 12);
	people[4] = new Students("Sofiya", 20);
	people[5] = new Students("Barabara", 67);
	people[6] = new Students("Rita", 12);
	people[7] = new Students("Barabara", 67);
	
	
	

	writeInFile(people);
	readPeople(n);
	
	keys=new Integer[stds.length];
	for(int i=0; i<stds.length; i++){
		keys[i]=i;
	}
	Comparator<Students> c = Students.BY_AGE;
	ShellSort.sort(stds, keys, Students.BY_AGE);
	writePeople(stds,keys);
	assertEquals(true, ShellSort.isSorted(stds,c));

}
@Test
public void testStudentsShellSortByAge() throws Exception {
	int n=8;
	
	Students[] people = new Students[n];
	people[0] = new Students("Anna", 23);
	people[1] = new Students("Inesa", 17);
	people[2] = new Students("Anna", 23);
	people[3] = new Students("Rita", 12);
	people[4] = new Students("Sofiya", 20);
	people[5] = new Students("Barabara", 67);
	people[6] = new Students("Rita", 12);
	people[7] = new Students("Barabara", 67);
	
	writeInFile(people);
	readPeople(n);
	
	keys=new Integer[stds.length];
	for(int i=0; i<stds.length; i++){
		keys[i]=i;
	}
	Comparator<Students> c = Students.BY_NAME;
	ShellSort.sort(stds, keys, Students.BY_NAME);
	writePeople(stds,keys);
	assertEquals(true, ShellSort.isSorted(stds,c));

}
@Test
public void testStudentsTesterCompare() throws Exception {
	Students[] list = new Students[4];
	list[0] = new Students("Anna", 23);
	list[1] = new Students("Inesa", 17);
	list[2] = new Students("Nick", 20);
	list[3] = new Students("Sofiya", 18);

	Students[] people = new Students[4];
	people[0] = new Students("Inesa", 17);
	people[1] = new Students("Anna", 23);
	people[2] = new Students("Nick", 20);
	people[3] = new Students("Sofiya", 18);

	writeInFile(people);
	readPeople(4);
	Arrays.sort(stds);
	writePeople(stds);
	assertEquals(true, compareArrays(list, stds));

}


@Test
public void testStudentsTesterCompare2() throws Exception {
	Students[] list = new Students[4];
	list[0] = new Students("Anna", 18);
	list[1] = new Students("Anna", 23);
	list[2] = new Students("Inesa", 17);
	list[3] = new Students("Sofiya", 20);

	Students[] people = new Students[4];
	people[0] = new Students("Inesa", 17);
	people[1] = new Students("Anna", 23);
	people[2] = new Students("Anna", 18);
	people[3] = new Students("Sofiya", 20);

	writeInFile(people);
	readPeople(4);
	Arrays.sort(stds);
	writePeople(stds);
	assertEquals(true, compareArrays(list, stds));

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


	private boolean compareArrays(Students[] a, Students[] b) {
		int n = a.length;
		if (n != b.length)
			return false;
		for (int i = 0; i < n; i++) {
			if((a[i].getAge()!=b[i].getAge())&&(!a[i].getName().equals(b[i].getName()))){
				return false;
					}
			}
		return true;
	}
	private void writeInFile(Students[] peopleLists) throws IOException {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("in.txt"));
			for (int i = 0; i < peopleLists.length; i++) {
				bw.write(peopleLists[i].toString() );
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

	 
		
