import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DuplicateRemover {
	private ArrayList<String> uniqueWords = new ArrayList<String>();
	private String newWord = "";
	private int count = 0;
	private int flag = 0;
	public void remove(FileInputStream dataFile ) throws IOException{
		Scanner inFS = new Scanner(dataFile);
		while(inFS.hasNext()) {
			newWord = inFS.next();
			if(count == 0) {
				uniqueWords.add(newWord);
				count += 1;
			}
			else {
				for(int i = 0; i < uniqueWords.size(); i++) {
					if(uniqueWords.get(i).compareTo(newWord) == 0) {
						flag = 1;
					}
				}
				if(flag == 0) {
					uniqueWords.add(newWord);
				}
				flag = 0;
			}
		}
		inFS.close();
	}




	public void write(File outputFile) throws IOException {
		FileWriter fw = new FileWriter(outputFile);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; i < uniqueWords.size(); i++) {
			pw.print(uniqueWords.get(i) + " ");
		}
		pw.close();
	}	
}