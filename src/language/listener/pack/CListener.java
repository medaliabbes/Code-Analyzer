package language.listener.pack;

import java.util.ArrayList;
import java.util.Stack;

import generic.parser.pack.FileDescriptor;
import generic.parser.pack.Index;

public class CListener implements ILanguageListener {

	ArrayList<String> ContextDefinitonList ;
	final static int C_LEVEL_PARSING = 0 ; //C level parsing 
	public CListener() {
		// TODO Auto-generated constructor stub
		ContextDefinitonList = new ArrayList<String>() ;
	}
	@Override
	public ContextDefinition getContextDefinition(FileDescriptor fd, Index index) {
		// TODO Auto-generated method stub
		System.out.println("getContextDefinition impl");
	return null ;	
	}

	@Override
	public void appendContextDefinition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getContextLevelParsing() {
		// TODO Auto-generated method stub
		return C_LEVEL_PARSING ;
	}
	@Override
	public void ExtractAndSaveContextDefinition(FileDescriptor fd , Index index) {
		// TODO Auto-generated method stub
		//System.out.println("ExtractAndSaveContextDefinition Imp :" + fd.getLine(index.getLine() - 1)) ; ;
		int lineNumber = index.getLine() ;
		int column	   = index.getColumnPosition() ;
		String line	   = fd.getLine(lineNumber) ;
		
		Stack<Char> rev = new Stack<Char>() ;
		boolean firstRun = true ; //To do not exit on the first run cause of the '{'
		ArrayList<Char> arr = new ArrayList<Char>() ;
		System.out.println(index.toString());
		//System.out.println (column );
		
		while(lineNumber >= 0 )
		{
			Char CurrentChar = new Char(line.charAt(column)) ;
			//
			//System.out.print(line.charAt(column));
			rev.push(CurrentChar) ;
			arr.add(CurrentChar) ;
			if((line.charAt(column) == '}' || 
				line.charAt(column) == ';' ||
				line.charAt(column) == '"' ) && !firstRun)
			{
				System.out.println("break 1");
				break ;
			}
			
			
			firstRun = false ;
			column-- ;
			if(column < 0)
			{
				//System.out.println("if");
				if(lineNumber <= 0)
				{
					System.out.println("break 2");
					break ;
				}
				line = fd.getLine(--lineNumber);
				
				if(line != null && line.length() != 0)
				{
					column = line.length() - 1 ;
					//System.out.println("line :"+line) ;
					//System.out.println((column));
				}
				else {
					System.out.println("break 2");
					break ;
				}
				
				
				
			}
		}
		
		System.out.println("") ;
		
		//System.out.println(line.charAt(column));
		System.out.print("Context def :") ;
		while( arr.size()>0) /*rev.size()*/ 
		{
			//System.out.print(rev.pop().c) ;
			System.out.print(arr.remove(arr.size()-1).c );
		}
		System.out.println("") ;
		
	}
	
	private class Char {
		public char c ;
		
		Char(char c)
		{
			this.c = c ;
		}
		
	}
	
}
