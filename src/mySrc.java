import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mySrc {
	public static void main(String[] args) throws IOException{
		
		String fileName = "hskim.data";
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line;
		ArrayList<String> lists = new ArrayList<String>();
		ArrayList<String> lists2 = new ArrayList<String>();
		
		while((line = br.readLine()) != null){
			if(line.contains("a href=\"/watch?")){
				if(line.contains("amp") && line.contains("index") && !line.contains("vve-check thumb-link spf-link")){
					lists.add(line);					
				}
			}
		}
		
		for(int i = 0; i < lists.size(); i++){
			StringTokenizer st = new StringTokenizer(lists.get(i), " ");
			st.nextToken();
			String add = st.nextToken();
			add = add.replace("href=\"", "youtube-dl http://youtube.com");
			add = add + " &";
			lists2.add(add);
		}
		
		for(int i=0; i < lists.size(); i++){
			System.out.println(lists2.get(i));
		}

		br.close();
	}
}
