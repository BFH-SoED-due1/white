package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView {
    LogInController controller;

    public LogInView(LogInController controller) {
        this.controller = controller;
    }

    public void load(UI myUI) {
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button1 = new Button("Click Me");
        button1.addClickListener( e -> {
            controller.ClickMe(layout, name);
        });

        layout.addComponents(name, button1);
        layout.setMargin(true);
        layout.setSpacing(true);

        myUI.setContent(layout);
    }
}
