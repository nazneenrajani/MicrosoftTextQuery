import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Textquery {
	public static void main(String[] args){
		BufferedReader br;
		boolean flag = false;
		try{			 
			String sCurrentLine,query;
			br = new BufferedReader(new FileReader("ActualInput.txt"));
			int total = Integer.parseInt(br.readLine());
			File fil = new File("queryResult.txt");
			FileWriter f = new FileWriter(fil,true);
			BufferedWriter b = new BufferedWriter(f);
			b.write(String.valueOf(total));
			b.write("\n");
			for(int i=0;i<total;i++) {
				flag = false;
				sCurrentLine=br.readLine();
				//System.out.println(sCurrentLine);
				query = br.readLine();
				if(!sCurrentLine.contains(" ")){
					String newQuery=query.replaceAll(" ","");
					System.out.println(newQuery.toLowerCase());
					String[] split = query.toLowerCase().split(" ");
					if(split.length>1 && sCurrentLine.toLowerCase().startsWith(split[1])&&query.contains(" "))
						flag = true;
					if(newQuery.toLowerCase().contains(sCurrentLine.toLowerCase())){
						System.out.println(newQuery+" "+flag+"this");
						if(newQuery.toLowerCase().startsWith(sCurrentLine.toLowerCase())||flag){
							b.write("true");
							b.write("\n");
						}
						else{
							b.write("false");
							b.write("\n");
						}
//							else {
//								for(int k=0;k<split.length;k++) {
//									if(split[k].startsWith(query.toLowerCase()))
//										b.write("true");
//										b.write("\n");
//									break;
//								}
//								b.write("false");
//								b.write("\n");
//							}
//						
					}
					else{
						b.write("false");
						b.write("\n");
					}
				}
				else{
					System.out.println(query.toLowerCase()+"+");
					if(query.toLowerCase().contains(sCurrentLine.toLowerCase())&&query.toLowerCase().startsWith(sCurrentLine.toLowerCase())){
						b.write("true");
						b.write("\n");
					}
					else{
						b.write("false");
						b.write("\n");
					}

				}

			}
			br.close();
			b.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
