package generic.parser.pack;

public class Index {
	private int line ; 
    private int columnPosition ;

    Index(int line, int columnPosition){
        this.line = line ;
        this.columnPosition = columnPosition ;
    }

    

    /**
     * @return int return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(int line) {
        this.line = line;
    }

    /**
     * @return int return the columnPosition
     */
    public int getColumnPosition() {
        return columnPosition;
    }

    /**
     * @param columnPosition the columnPosition to set
     */
    public void setColumnPosition(int columnPosition) {
        this.columnPosition = columnPosition;
    }

    public String toString()
    {
        return "Line "+this.getLine() +" ,Column "+this.getColumnPosition() ;
    }
}
