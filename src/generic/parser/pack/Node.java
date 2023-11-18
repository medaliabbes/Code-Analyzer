package generic.parser.pack;

import java.util.ArrayList;

public class Node {
	 	private ArrayList<Node> childNodes ;
	    private Node parentNode ;
	    private boolean Closed ;
	    private int level ;
	    private Index OpeningIndex ;
	    private Index ClosingIndex ;
	    
	    Node()
	    {
	        childNodes = new ArrayList<>() ;
	        parentNode = null ;
	    }    

	    /**
	     * @return boolean return the Closed
	     */
	    public boolean isClosed() {
	        return Closed;
	    }

	    /**
	     * @param Closed the Closed to set
	     */
	    public void setClosed(boolean Closed) {
	        this.Closed = Closed;
	    }


	    /**
	     * @return int return the level
	     */
	    public int getLevel() {
	        return level;
	    }

	    /**
	     * @param level the level to set
	     */
	    public void setLevel(int level) {
	        this.level = level;
	    }


	    /**
	     * @return ArrayList<Node> return the childNodes
	     */
	    public ArrayList<Node> getChildNodes() {
	        return childNodes;
	    }

	    /**
	     * @param childNodes the childNodes to set
	     */
	    public void setChildNodes(ArrayList<Node> childNodes) {
	        this.childNodes = childNodes;
	    }


	    /**
	     * @return Node return the parentNode
	     */
	    public Node getParentNode() {
	        return parentNode;
	    }

	    /**
	     * @param parentNode the parentNode to set
	     */
	    public void setParentNode(Node parentNode) {
	        this.parentNode = parentNode;
	    }


	    /**
	     * @return Index return the OpeningIndex
	     */
	    public Index getOpeningIndex() {
	        return OpeningIndex;
	    }

	    /**
	     * @param OpeningIndex the OpeningIndex to set
	     */
	    public void setOpeningIndex(Index OpeningIndex) {
	        this.OpeningIndex = OpeningIndex;
	    }

	    /**
	     * @return Index return the ClosingIndex
	     */
	    public Index getClosingIndex() {
	        return ClosingIndex;
	    }

	    /**
	     * @param ClosingIndex the ClosingIndex to set
	     */
	    public void setClosingIndex(Index ClosingIndex) {
	        this.ClosingIndex = ClosingIndex;
	    }

	    /*
	     * if the node is part of tree ot will return true,otherwise false
	     */
	    boolean isINaTree()
	    {
	        if(this.getParentNode() == null && this.childNodes.size() == 0)
	        {
	            return  false ;
	        }
	        return true ;
	    }

	    Node popChild()
	    {
	        int lastIndex = this.childNodes.size() - 1 ;

	        if(lastIndex >= 0){
	            return this.childNodes.remove(lastIndex);
	        }
	        else return null ;
	    }

	    int getChildListSize()
	    {
	        return this.childNodes.size() ;
	    }
}
