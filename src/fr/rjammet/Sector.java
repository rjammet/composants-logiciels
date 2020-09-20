package fr.rjammet;

import java.util.ArrayList;
import java.util.List;

public class Sector {

    private final int idSector;
    private final String nameSector;
    private final boolean greenSpace;
    private final List<Counter> counters;

    /**
     * Constructor Sector
     * @param idSector - ID of the Sector
     * @param nameSector - Name of the Sector
     * @param greenSpace - Sector Green Space
     * @param commune - Commune of the Sector
     */
    public Sector(int idSector, String nameSector, boolean greenSpace, Commune commune) {
        this.idSector = idSector;
        this.nameSector = nameSector;
        this.greenSpace = greenSpace;
        this.counters = new ArrayList<>();
    }

    /**
     * Adding a new Counter
     * @param counter - A counter to adding
     */
    public void addCounter(Counter counter){
        this.counters.add(counter);
    }

    /**
     * Get ID Sector
     * @return Integer - ID
     */
    public int getIdSector() {
        return idSector;
    }

    /**
     * Get name of the Sector
     * @return String - name
     */
    public String getNameSector() {
        return nameSector;
    }

    /**
     * If Sector is green space
     * @return boolean - greenSpace
     */
    public boolean isGreenSpace() {
        return greenSpace;
    }

    /**
     * Get a List of Counters
     * @return List Counters
     */
    public List<Counter> getCounters() {
        return counters;
    }
}
