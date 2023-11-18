package generic.parser.pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDescriptor {

	private int index = 0 ;

    ArrayList<String> fileContent ;
    String fileName ;

    public FileDescriptor()
    {
        fileContent = new ArrayList<>() ;
    }

    public FileDescriptor(String filename)
    {
        this.fileName = filename ;
        fileContent = new ArrayList<>() ;
        this.loadFile(filename);
    }

    void loadFile(String filename) 
    {   
        index = 0 ;
        try{
            File file = new File(filename) ;
            Scanner Reader = new Scanner(file) ;
            while(Reader.hasNextLine()){
                String line = Reader.nextLine() ;
                fileContent.add(line) ;
            }
            Reader.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
    }
    
    void printContent()
    {
        for( int i = 0 ; i<fileContent.size() ; i++)
        {
            System.out.println(fileContent.get(i));
        }
        
    }
    
    String nextLine()
    {
        if(index < fileContent.size()){
            index++;
            return fileContent.get(index-1);
        }
        return null ;
    }

    /*String previousLine()
    {
        if(index > 0){
            index-- ;
            return fileContent.get(index);
        }
        return null ;
    }**/

    int getLineNumber(){
        return index  ; 
    }

    /** mint to be used when navigating the file*/
    void setLineNumber(int i){
        //index can only be set when file is loaded
        if(fileContent.size() > 0)
        {
            index = i ;
        }
    }  
    
    public String getLine(int lineIndex)
    {
    	if(index > 0)
    	return fileContent.get(lineIndex) ;
    	else return null ;
    }
}
