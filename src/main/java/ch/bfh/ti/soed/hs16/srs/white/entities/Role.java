package main.java.ch.bfh.ti.soed.hs16.srs.white.entities;

/**
 * Created by angelo on 10/20/16.
 */
public class Role {

    private stirng name;
    Set<Rights> rights;

    public stirng getName() {
        return name;
    }

    public void setName(stirng name) {
        this.name = name;
    }

    public Set<Rights> getRights() {
        return rights;
    }

    public void setRights(Set<Rights> rights) {
        this.rights = rights;
    }
}
