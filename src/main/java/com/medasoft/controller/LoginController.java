package com.medasoft.controller;

import com.medasoft.view.LoginViewComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    LoginViewComponent loginViewComponent;

    TextField txtUser;
    PasswordField txtPass;

    String txtUserText;
    String txtPassText;


    public LoginController(LoginViewComponent loginViewComponent) {
        this.loginViewComponent = loginViewComponent;
    }

    public void getDetails(){

        txtPass = loginViewComponent.getTxtPass();
        txtUser =  loginViewComponent.getTxtUser();

        txtUserText = (String) txtUser.getValue();
        txtPassText = (String) txtPass.getValue();

        LOGGER.debug("Got text from Username"+txtUserText);
        LOGGER.debug("Got text from Password"+txtPassText);
        txtUser.setCaption(txtUserText);
        txtPass.setCaption(txtPassText);



    }
}