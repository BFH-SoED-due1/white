package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.view.RegistrationView;
import com.vaadin.ui.UI;

/**
 * Created by joni on 08/12/16.
 */
public class RegistrationController implements Controller {
    private UI myUI;
    private RegistrationView regView;

    public RegistrationController(UI regUI){
        myUI = regUI;
    }

    @Override
    public void init() {
        regView = new RegistrationView(this);
    }

    @Override
    public void loadView(){
        regView.load(myUI);
    }

    public void register(){
      String fName = regView.getFirstName().getValue();
      String lName = regView.getLastName().getValue();
      String pass1 = regView.getPassword1().getValue();
      String pass2 = regView.getPassword2().getValue();

      if(pass1.equals(pass1)){
          regView.getLabel().setValue("Passwords match");
          //TODO database update
      }else{
          regView.getLabel().setValue("Password don't match");
      }
    }
}
