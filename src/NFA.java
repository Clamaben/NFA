import java.io.*;

public class NFA 
{
	 public static void output(String fileName,char content) 
	 {
   	  try{  
             //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
             FileWriter writer = new FileWriter(fileName, true);  
             writer.write(content);  
             writer.close();  
   	  	  } catch (IOException e) 
   	  		{  
             e.printStackTrace();  
   	  		}  
   }
	public static void main( String args[]) 
	{
		String fileName = "src//input.txt";
		String outfileName = "src//output.txt";
		File input = new File(fileName);
		BufferedReader reader = null;
		Para para[] = new Para[10];
		for (int i = 0; i < para.length; i++) 
		{
			para[i]=new Para();
		}
		int line =0;
		try 
		{
		reader =new BufferedReader(new FileReader(input));
		String string = null;
		 while ((string = reader.readLine()) != null)
		 {  
            	String strs[] = string.split("\\=");
            	para[line].left = strs[0];
            	para[line].right = strs[1];
            	para[line].strings = para[line].right.split("\\|");
             line++;
         }  
         reader.close();  
		}catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{  
            if (reader != null)
            {  
                try 
                {  
                    reader.close();  
                } catch (IOException e1) 
                {  
                }  
            }  
        } 
		String AString = new String();
		String aString = new String();
		for (int i = 0; i < line; i++) 
		{
			if (!AString.contains(para[i].left)) 
			{
				AString = AString + para[i].left;
			}
			for (int j = 0; j < para[i].strings.length; j++) 
			{
				if (para[i].strings[j].length()>1&&!aString.contains(""+para[i].strings[j].charAt(0)))
				{
					aString = aString + para[i].strings[j].charAt(0);
				}
			}
		}
		for (int i = -1; i < AString.length(); i++) {
			for (int j = -1; j < aString.length(); j++) {
				if (i==-1&&j==-1) {
					output(outfileName,'*');
				}else {
					if (i==-1) {
						output(outfileName,aString.charAt(j));
						
					} else {
						if (j==-1) {
							output(outfileName,AString.charAt(i));
						} else {
							for (int j2 = 0; j2 < line; j2++) {
								if (para[j2].left.charAt(0)==AString.charAt(i)) {
									for (int k = 0; k < para[j2].strings.length; k++) {
										if (para[j2].strings[k].charAt(0)==aString.charAt(j)) {
											output(outfileName,para[j2].strings[k].charAt(1));
										}
									}
								}
							}
						}
					}
				}
			}
			output(outfileName,'\n');
		}
		
	
	}
	
	
}
