import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DuplicateCounter {
	private ArrayList<Integer> wordCounter = new ArrayList<Integer>();
	private ArrayList<Integer> wordCounter2 = new ArrayList<Integer>();
	private ArrayList<String> word = new ArrayList<String>();
	private ArrayList<String> hold = new ArrayList<String>();
	private int flag = 0;
	private String holder = "";
	private int counter = 0;
	public void count(FileInputStream dataFile) throws IOException {
		Scanner inFs = new Scanner(dataFile);
		while(inFs.hasNext()) {
			word.add(inFs.next());
		}
		for(int j = 0; j < word.size(); j++) {
			holder = word.get(j);
			for(int i = 0; i < word.size(); i++) {
				if(word.get(i).compareTo(holder) == 0) {
					counter += 1;
					flag = counter;

				}
			}

			wordCounter.add(counter);
			counter = 0;
			
		}
		for(int i = 0; i < word.size(); i++) {
		System.out.println(word.get(i) + " " + wordCounter.get(i));
		}
		inFs.close();
	}
	
	
	
	public void write(File outputFile) throws IOException{
		FileWriter fw = new FileWriter(outputFile);
		PrintWriter pw = new PrintWriter(fw);
		int count = 0;
		for(int i = 0; i < word.size(); i++) {
			if(count == 0) {
				System.out.println("THE WORD: " + word.get(i));
			hold.add(word.get(i));
			wordCounter2.add(wordCounter.get(i));
			count = 1;
			//continue;
			}
			else {
				for(int j = 0; j < hold.size(); j++) {
					if(hold.get(j).compareTo(word.get(i)) == 0) {
						count = 2;
					}
				}
				if(count == 1) {
					hold.add(word.get(i));
					wordCounter2.add(wordCounter.get(i));
				}
				count = 1;
			}
		}

		for(int i = 0; i < hold.size(); i++) {
			pw.println(hold.get(i) + " " + wordCounter2.get(i));
		}
		pw.close();
		}
	
}
