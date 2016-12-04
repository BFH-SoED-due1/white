package ch.bfh.ti.soed.hs16.srs.white.view;

import com.vaadin.ui.*;

/**
 * Created by joni on 04/12/16.
 */
public class RegistrationView {

    private VerticalLayout layout = new VerticalLayout();


    public VerticalLayout register() {
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        PasswordField password = new PasswordField("Password");
        PasswordField password2 = new PasswordField("Repeat Password");


        Button submit = new Button("Submit");
        submit.addClickListener(e -> {
            if(password.getValue().contentEquals(password2.getValue())) {
                layout.addComponent(new Label("Data has been sent"));
            }else{
                layout.addComponent(new Label("Passwords don't match"));
            }
        });

        layout.addComponents(firstName, lastName, password, password2, submit);

        return layout;
    }
}
