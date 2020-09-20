package fr.rjammet;

public class Counter {

    private final int id;
    private final char type;
    private int indexPrevious;
    private int indexNew;
    
    /**
     * Constructor of the Counter
     * @param id - ID of the Counter
     * @param type - Type of the Counter
     */
    public Counter(int id, char type){
        this.id = id;
        this.type = type;
    }

    /**
     * Updates indexes. The index on the
     * counter is passed in parameter
     * @param indexRelief - Index Counter
     */
    public void relief(int indexRelief){
        this.indexPrevious = indexNew;
        this.indexNew = indexRelief;
    }

    /**
     * Calculate and return the consumption in m3
     * for the counter
     * @return a consumption
     */
    public int consumption(){
        return indexNew - indexPrevious;
    }

    public int getId() {
        return id;
    }

    public char getType() {
        return type;
    }
}
