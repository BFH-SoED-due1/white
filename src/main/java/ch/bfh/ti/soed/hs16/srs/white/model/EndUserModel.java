/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.entities.EndUserImpl;
import ch.bfh.ti.soed.hs16.srs.white.helpers.JAXBHelper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arauzca on 21.10.16.
 */
@XmlRootElement(name = "EndUsers", namespace = "http://ch.bfh.ti.soed.hs16.srs.white")
public class EndUserModel {
    private List<EndUser> endUsers;

    public EndUserModel() {
        endUsers = new ArrayList<>();
    }

    @XmlElement(name = "enduser", type = EndUserImpl.class)
    public List<EndUser> getEndUsers() {
        return endUsers;
    }

    /**
     * This function loads the users from the Database
     */
    public boolean loadEndUsers(String fileName) {
        EndUserModel endUserModel;
        boolean b = false;

        try {
            ClassLoader cl = this.getClass().getClassLoader();
            File f = new File(cl.getResource(fileName).getFile());

            if ( f.exists() ) {
                FileInputStream is  = new FileInputStream(f);
                endUserModel        = (EndUserModel) JAXBHelper.loadInstance(is, this.getClass());
                this.endUsers = endUserModel.getEndUsers();
                b = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return b;
    }

    // TODO this needs more specifications
    public void createEndUser(EndUser e) {
        endUsers.add(e);
        saveUsers();
    }

    /*public void deleteEndUserById(Integer id) {
        endUsers.remove(id);
    }

    public EndUser getEndUserById(Integer id) {
        EndUser e = endUsers.getOrDefault(id, null);
        return e;
    }*/

    public void saveUsers() {
        try (FileOutputStream os=new FileOutputStream(new File("./src/main/resources/users.xml"))){
            JAXBHelper.saveInstance(os, this);
            ClassLoader cl = this.getClass().getClassLoader();
            JAXBHelper.saveSchema(new File("."), EndUserModel.class);

            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
