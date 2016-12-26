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
import com.vaadin.ui.Component;

import java.util.List;

/**
 * Created by arauzca on 24.12.16.
 */
public class AdminController extends AbstractController {
    // Models
    private EndUserModel endUserModel;

    // View components
    private Component updatebleComponent;

    @Override
    public void init() {
        endUserModel = EndUserModel.getInstance();
        endUserModel.loadModel();
    }

    public void setUpdatebleComponent(Component updatebleComponent) {
        this.updatebleComponent = updatebleComponent;
    }

    public List<EndUser> loadUsers() {
        return (List<EndUser>) endUserModel.getData();
    }
}
