/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import com.vaadin.ui.Table;

import java.util.List;

/**
 * Created by hyamsj on 22/12/16.
 */
public class TableController extends AbstractController {
    private EndUserModel endUserModel = EndUserModel.getInstance();
    private Table table;

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public void init() {
        endUserModel.loadModel();
        List<EndUser> endUsers = endUserModel.getData();
        endUsers.forEach(e -> {
            table.addItem(new Object[] {e.getId(), e.getFirstName(), e.getLastName(), e.getMail()});
            //e.getFirstName();
        });


    }
}
