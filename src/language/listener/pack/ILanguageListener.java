package language.listener.pack;

import generic.parser.pack.FileDescriptor;
import generic.parser.pack.Index;

public interface ILanguageListener {

	//This function should implement the logic to finding the definition of structures ,functions ,classes etc
	public ContextDefinition getContextDefinition(FileDescriptor fd , Index index) ;
	
	public void ExtractAndSaveContextDefinition(FileDescriptor fd , Index index) ;
	
	//This function to store the definition found  
	public void appendContextDefinition() ;
	/**
	 * this should return the tree level of definition to be parsed 
	 * for c language the level is 1 , for java the level is 2 
	 * @return
	 */
	public int getContextLevelParsing() ;
	
}
