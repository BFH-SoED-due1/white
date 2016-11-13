package ch.bfh.ti.soed.hs16.srs.white.entities;

/**
 * Created by angelo on 11/13/16.
 */
public class Television implements Equipment{

    private String name;
    private int quantity;
    private int id;
    private String resolution;
    private int frameRate;

    public Television(String name, int quantity, int id, String resolution, int frameRate){
        this.name = name;
        this.quantity = quantity;
        this.id = id;
        this.resolution = resolution;
        this.frameRate = frameRate;
    }

    @Override
    public String getAttributes() {
        StringBuilder attr = new StringBuilder();
        attr.append(this.name);
        attr.append(this.quantity);
        attr.append(this.id);
        attr.append(this.resolution);
        attr.append(this.frameRate);
        return attr.toString();
    }


}
