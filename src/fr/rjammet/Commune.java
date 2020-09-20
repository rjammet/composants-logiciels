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
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
