package tree.pack;

import java.util.ArrayList;

import language.listener.pack.ILanguageListener;
import generic.parser.pack.*;

public class TreeWalker {

	public TreeWalker(){
		
	}
	
	public ILanguageListener Walk(FileDescriptor file , ArrayList<Node> Trees ,
			ILanguageListener languagelistener) {
		
			for( Node rootNode : Trees) {
					
				while(true) {
					 if(rootNode.getChildNodes().size() > 0)
			            {
			                int lastNodeIndex = rootNode.getChildNodes().size() - 1 ;
	
			                Node CNode = rootNode.getChildNodes().remove(lastNodeIndex);
	
			                rootNode = CNode ;
			                //System.out.println(rootNode.getOpeningIndex().toString());
			                //System.out.println(rootNode.getClosingIndex().toString());
			                //if( languagelistener.getContextLevelParsing() == 1)
			                if(rootNode.getLevel() <= languagelistener.getContextLevelParsing() )
			                {
			                	Index parseIndex = rootNode.getOpeningIndex() ;
			                	//System.out.print("Level " + rootNode.getLevel() +":");
			                	//languagelistener.getContextDefinition(file, parseIndex);
			                	languagelistener.ExtractAndSaveContextDefinition(file, parseIndex) ;
			                }
			            }
			            else if(rootNode.getParentNode() != null)
			            {
			                rootNode = rootNode.getParentNode() ;
			            }
			            else if(rootNode.getParentNode() == null)
			            {
			                System.out.println("Tree Parsed") ;
	
			                break ;
			            }
				}
			}
			
		return languagelistener ;
	}
}
