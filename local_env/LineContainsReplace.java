import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * replace a line in a file
 * @author robert.diers
 *
 */
public class LineContainsReplace {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage LineContainsReplace file contains replacement");
			System.out.println(args);
		} else {
			try {
				String file = args[0];
				String contains = args[1];
				String replacement = args[2];
				//read file
				ArrayList<String> lines = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));  
			    String linein;
			    while ((linein = br.readLine()) != null) {
			    	lines.add(linein);
			    }
			    br.close();
				//write file
				FileWriter fw = new FileWriter(file);		 
				for (String line : lines) {
					if (line.contains(contains)) {
						line = replacement;
					}
					fw.write(line+"\n");
				}		 
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
