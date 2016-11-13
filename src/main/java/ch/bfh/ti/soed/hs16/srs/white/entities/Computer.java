package ch.bfh.ti.soed.hs16.srs.white.entities;

/**
 * Created by angelo on 11/13/16.
 */
public class Computer implements Equipment{

    private String name;
    private int quantity;
    private int id;
    private String resolution;
    private String operatingSystem;

    public Computer(String name, int quantity, int id, String resolution, String operatingSystem){
        this.name = name;
        this.quantity = quantity;
        this.id = id;
        this.resolution = resolution;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String getAttributes() {
        StringBuilder attr = new StringBuilder();
        attr.append(this.name);
        attr.append(this.quantity);
        attr.append(this.id);
        attr.append(this.resolution);
        attr.append(this.operatingSystem);
        return attr.toString();
    }

}
