package com.medasoft.view;

import com.medasoft.controller.LoginController;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

public class LoginViewComponent extends CustomComponent {
    public static final String NAME = "login";

    private final TextField txtUser;

    private final PasswordField txtPass = new PasswordField("Password");

    private final Button btnLogin;

    private final Label lblWarning;

    public Label getLblWarning() {
        return lblWarning;
    }

    public LoginViewComponent() {
        setSizeFull();
        ThemeResource resource = new ThemeResource("../images/banner.jpg");
        Embedded image = new Embedded("", resource);
        // Create the user input field
        txtUser = new TextField("User");
        txtUser.setWidth("300px");
        txtUser.setRequired(true);
        txtUser.setInputPrompt("Your Doctor Code");
        txtPass.setInputPrompt("Your Password");
        //  txtUser.addValidator(new EmailValidator("Username must be an email address"));
        txtUser.setInvalidAllowed(false);

        // Create the password input field
        txtPass.setWidth("300px");
        //password.addValidator(new PasswordValidator());
        txtPass.setRequired(true);
        txtPass.setValue("");
        txtPass.setNullRepresentation("");

        // Create login button
        btnLogin = new Button("Login");

        //Create Warning Text
        lblWarning = new Label();
        lblWarning.setWidth("300px");
        lblWarning.setValue("");


        // Add both to a panel
        VerticalLayout fields = new VerticalLayout();
        fields.addComponent(lblWarning);
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

        setListners();

    }

    public void clearFields() {
        this.txtUser.setValue("");
        this.txtPass.setValue("");
        this.lblWarning.setValue("");
    }

    public Button getBtnLogin() {

        return btnLogin;

    }

    public TextField getTxtUser() {

        return txtUser;

    }

    public PasswordField getTxtPass() {

        return txtPass;

    }

    public void setListners(){
        final LoginController loginController = new LoginController(this);
        btnLogin.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                loginController.setDetails();
                loginController.authUser();
                clearFields();
            }
        });
    }

}
