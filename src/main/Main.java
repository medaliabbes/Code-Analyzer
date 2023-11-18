package main;

import generic.parser.pack.FileDescriptor;
import generic.parser.pack.GenericParser;
import language.listener.pack.CListener;
import language.listener.pack.ILanguageListener;
import tree.pack.TreeWalker;

public class Main {
	public static void main(String[] args)
	{
		String filename = "C:\\Users\\medali\\Desktop\\java-workspace\\CodeAnalyser\\src\\generic\\parser\\pack\\main.c" ;
		FileDescriptor fd = new FileDescriptor(filename) ;
		
		GenericParser GParser = new GenericParser() ;
		
		GParser.parseFile(fd) ;
		
		TreeWalker walker = new TreeWalker() ;
		
		ILanguageListener listener = new CListener() ;
		
		walker.Walk(fd, GParser.getParseTrees(), listener) ;
		System.out.println("Exit") ;
	}
}

