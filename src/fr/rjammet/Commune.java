package fr.rjammet;

import java.util.ArrayList;
import java.util.List;

public class Commune {

    private final int id;
    private final String name;
    private final List<Sector> lesSectors;

    /**
     * Constructor Commune
     * @param id - Id of commune
     * @param name - Name of the commune
     */
    public Commune(int id, String name) {
        this.id = id;
        this.name = name;
        this.lesSectors = new ArrayList<>();
    }

    /**
     * Add a new Sector
     * @param idSector - A id of the Sector
     * @param nameSector - A name of the Sector
     * @param greenSpace - A boolean Green Space
     */
    public void addSector(int idSector, String nameSector, boolean greenSpace){
        Sector sector = new Sector(idSector, nameSector, greenSpace, this);
        this.lesSectors.add(sector);
    }

    /**
     * Get a Sector by id
     * @param id - ID of the Sector
     * @return a Object Sector
     */
    public Sector getSectorById(int id){
        return this.lesSectors.get(id);
    }

    /**
     * List of the Sectors contains a Green Space
     * @return List of Sectors
     */
    public List<Sector> sectorsGreensSpaces(){
        List<Sector> greenSector = new ArrayList<>();
        this.lesSectors.forEach(sector -> { if(sector.isGreenSpace()) greenSector.add(sector); });
        return greenSector;
        //return lesSectors.stream().filter(Sector::isEspaceVert).collect(Collectors.toCollection(this::secteurEVerts));
    }

    /**
     * Returns the volume dispensed by the counters of the
     * common for the specified meter type
     * @param typeCounter - a type of counter
     * @return the volume dispensed
     */
    public int volumeDispensed(char typeCounter){
        int capacity = 0;

        if(typeCounter == 'A' || typeCounter == 'V'){
            for(Sector sector : this.lesSectors){
                for(Counter counter : sector.getCounters()){
                    if(counter.getType() == typeCounter) capacity += counter.consumption();
                }
            }
        }
        return capacity;
    }

    /**
     * Returns the difference between the total volume delivered by the valves and the
     * subscriber consumption
     * @return Integer of loss consumption
     */
    public int loss(){
        int capacityA = 0, capacityV = 0;

        for(Sector sector : this.lesSectors){
            for(Counter counter : sector.getCounters()){
                if(counter.getType() == 'A') capacityA += counter.consumption();
                if(counter.getType() == 'V') capacityV += counter.consumption();
            }
        }
        return  capacityV - capacityA;
    }

    /**
     * Calculates the percentage of losses compared to the volume dispensed
     * by the valves
     * @return Integer of type Anomaly
     */
    public int anomaly(){
        int valves = this.volumeDispensed('A') + this.volumeDispensed('V');
        int percent = 100 * (this.loss() / valves);
        if(percent < 10) return 1;
        if(percent <= 15) return 2;
        return 3;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
