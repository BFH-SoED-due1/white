package ch.bfh.ti.soed.hs16.srs.white.controller;

import com.vaadin.ui.*;

/**
 * Created by arauzca on 24.10.16.
 */
public class MyUIController {
    private UI myUI;
    LogInController logInController;

    public MyUIController(UI myUI) {
        this.myUI = myUI;
        logInController = new LogInController(this.myUI);
        initSystem();

    }

    public void initSystem() {
        logInController.loadView();
    }


}
