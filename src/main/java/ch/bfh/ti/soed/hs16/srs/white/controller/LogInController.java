package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController {
    private UI mainUI;
    private LogInView logInView;

    public LogInController(UI mainUI) {
        this.mainUI = mainUI;
        logInView = new LogInView(this);
    }

    public void loadView() {
        logInView.load(mainUI);
    }

    public void ClickMe(AbstractLayout layout, TextField name) {
        layout.addComponent(new Label("Thanks " + name.getValue()
                + ", it works! "));
    }
}
