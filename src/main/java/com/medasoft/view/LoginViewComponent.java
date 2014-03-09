package com.medasoft.view;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

public class LoginViewComponent extends CustomComponent{
	public static final String NAME = "login";

    private final TextField txtUser;

    private final PasswordField txtPass;

    private final Button btnLogin;

    public LoginViewComponent() {
        setSizeFull();
        
        ThemeResource resource = new ThemeResource("../images/banner.jpg");
        Embedded image = new Embedded("", resource);
        // Create the user input field
        txtUser = new TextField("User:");
        txtUser.setWidth("300px");
        txtUser.setRequired(true);
        txtUser.setInputPrompt("Your username");
      //  txtUser.addValidator(new EmailValidator("Username must be an email address"));
        txtUser.setInvalidAllowed(false);

        // Create the password input field
        txtPass = new PasswordField("Password:");
        txtPass.setWidth("300px");
        //password.addValidator(new PasswordValidator());
        txtPass.setRequired(true);
        txtPass.setValue("");
        txtPass.setNullRepresentation("");

        // Create login button
        btnLogin = new Button("Login");

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout();
        fields.addComponent(txtUser);
        fields.addComponent(txtPass);
        fields.addComponent(btnLogin);
       fields.setSpacing(true);
        //fields.setMargin(new MarginInfo(false, true, true, false));
        fields.setSizeUndefined();
        
        // Add the banner
        
     // Use the resource
     
     
        
         // The view root layout
        VerticalLayout viewLayout = new VerticalLayout();
        viewLayout.addComponent(image);
        viewLayout.addComponent(fields);
        viewLayout.setSizeFull();
        
        viewLayout.setComponentAlignment(fields, Alignment.TOP_CENTER);
        viewLayout.setComponentAlignment(image, Alignment.TOP_CENTER);
        viewLayout.setStyleName(Runo.LAYOUT_DARKER);
        setCompositionRoot(viewLayout);
    }

    public Button getBtnLogin(){

        return btnLogin;

    }

    public TextField getTxtUser(){

        return txtUser;

    }

    public PasswordField getTxtPass(){

        return txtPass;

    }

}
