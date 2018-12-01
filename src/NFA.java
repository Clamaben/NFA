import java.io.*;

public class NFA {
	
	@SuppressWarnings("null")
	public static void main( String args[]) {
		String fileName = "C:\\Users\\zzy\\data\\input.txt";
		File input = new File(fileName);
		BufferedReader reader = null;
		try {
		reader =new BufferedReader(new FileReader(input));
		String string = null;
		int line =0;
		 while ((string = reader.readLine()) != null) {  
            	
             line++;
            
         }  
         reader.close();  
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
	
	
	}
	
	
}
