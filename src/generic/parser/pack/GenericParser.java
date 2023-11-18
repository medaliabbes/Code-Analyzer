package generic.parser.pack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author medali
 * this Class take a file descriptor input and output a parsing tree 
 * that represent the herarchie of the code 
 */
public class GenericParser {
	 //FileDescriptor file ;
    ArrayList<Node>   NodesTable ;
    final static char OpeningSeparator = '{' ;
    final static char ClosingSeparator = '}' ;

    public GenericParser(){
        NodesTable = new ArrayList<>() ;
    }

    public void parseFile(FileDescriptor file)
    {
        Stack<Index> stack = new Stack<Index>();

        String line = file.nextLine() ;

        Node rootNode = new Node() ;
        
        NodesTable.add(rootNode) ;
    
        int treeLevel = 0 ; 
    
        boolean Error = false ;

        while(line != null)
        {
            for(int i=0 ; i < line.length() ;i ++)
            {
                if( line.charAt(i) == OpeningSeparator )
                {
                    Index OpeningIndex = new Index(file.getLineNumber() -1 , i ) ;

                    stack.add(OpeningIndex) ;
                    
                    Node childNode = new Node() ;

                    childNode.setLevel(treeLevel);

                    childNode.setOpeningIndex(OpeningIndex);
                    childNode.setParentNode(rootNode);
                    rootNode.getChildNodes().add(childNode) ;
                    
                    treeLevel++ ;
                    rootNode = childNode ;
                }
                else if(line.charAt(i) == ClosingSeparator)
                {
                    stack.pop() ;
                    
                    if(treeLevel == 0){
                        System.out.println("Error Additional Closing bracket");
                        Error = true ;
                        break ;
                    }

                    rootNode.setClosingIndex(new Index(file.getLineNumber(), i));
                    
                    rootNode = rootNode.getParentNode() ;
                    
                    treeLevel--;
                    
                    if(rootNode.getParentNode() == null && stack.size() == 0)
                    {
                        //System.out.println("End Node");
                        rootNode = new Node() ;
                        NodesTable.add(rootNode) ;
                    }
                }
                else {

                }
            }

            line = file.nextLine() ;

            if(Error )
            {
                break ;
            }
        }

        Node lastNode = NodesTable.get(NodesTable.size() - 1) ;

        //last node not in a tree (just created before exiting the loop)
        if(!lastNode.isINaTree())
        {
            //System.out.println("Remove last node in table");
            NodesTable.remove(NodesTable.size()-1) ;
            lastNode = null ;
        }
    }

    public ArrayList<Node> getParseTrees()
    {
        return NodesTable ;
    }    

    void printTree(Node rootNode)
    {
        while(true)
        {
            if(rootNode.getChildNodes().size() > 0)
            {
                int lastNodeIndex = rootNode.getChildNodes().size() - 1 ;

                Node CNode = rootNode.getChildNodes().remove(lastNodeIndex);

                rootNode = CNode ;

                System.out.println(rootNode.getOpeningIndex().toString());
                System.out.println(rootNode.getClosingIndex().toString());
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
}
