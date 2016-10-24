package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */
public class Role {

    private String name;
    Set<Rights> rights = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rights> getRole() {
        Set<Rights> readOnlyRights = Collections.unmodifiableSet(this.rights);
        return readOnlyRights;
    }

    public void removeRights(Rights rights){
        this.rights.remove(rights);
    }

    public void setRights(Rights rights) {
        this.rights.add(rights);
    }
}
