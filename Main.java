import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static final String INPUT_FILE_ADDRESS = "input.txt";
	private static final String OUTPUT_FILE_ADDRESS = "output.txt";

	int N;

	private Main() {
		try {
			N = getInputN();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getInputN() throws IOException {
		FileReader reader = new FileReader(INPUT_FILE_ADDRESS);
		Scanner sc = new Scanner(reader);
		if (sc.hasNextLine()) {
			N = Integer.valueOf(sc.nextLine());
		}
		sc.close();
		reader.close();
		return N;
	}

	public static void main(String[] args) {

		Main obj = new Main();
		ArrayList<Integer> array = obj.getArray();
		System.out.println(array);
		try {
			obj.createOutputFile(array.get(obj.N - 1));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void createOutputFile(int number) throws IOException {
		FileWriter writer = new FileWriter(OUTPUT_FILE_ADDRESS, false);
		writer.write(Integer.toString(number));
		writer.close();
	}

	private ArrayList<Integer> getArray() {

		ArrayList<Integer> array = new ArrayList<Integer>();
		int i = 1;
		for (; i < 11; i++) {
			array.add(i);
		}
		while (array.size() <= N) {
			char[] temp = Integer.toString(i).toCharArray();
			boolean bol = true;
			for (int j = 0; j < temp.length - 1; j++) {
				for (int k = j + 1; k < temp.length; k++) {
					if (temp[j] == temp[k]) {
						bol = false;
						break;
					}
				}
				if (!bol) {
					break;
				}
			}
			if (bol) {
				array.add(i);
			}
			i++;
		}
		return array;
	}

}
