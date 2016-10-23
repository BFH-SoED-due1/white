package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */
public class Role {

    private String name;
    Set<Rights> rights;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rights> getRights() {
        return rights;
    }

    public void setRights(Set<Rights> rights) {
        this.rights = rights;
    }
}
