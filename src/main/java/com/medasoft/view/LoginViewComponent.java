package com.medasoft.view;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

public class LoginViewComponent extends CustomComponent {
	
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
        txtUser.addValidator(new EmailValidator("Username must be an email address"));
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
    
//    @Override
//    public void enter(ViewChangeEvent event) {
//        // focus the username field when user arrives to the login view
//        user.focus();
//    }
//
//    //
//    // Validator for validating the passwords
//    //
//    private static final class PasswordValidator extends
//            AbstractValidator<String> {
//
//        public PasswordValidator() {
//            super("The password provided is not valid");
//        }
//
//        @Override
//        protected boolean isValidValue(String value) {
//            //
//            // Password must be at least 8 characters long and contain at least
//            // one number
//            //
//            if (value != null
//                    && (value.length() < 8 || !value.matches(".*\\d.*"))) {
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        public Class<String> getType() {
//            return String.class;
//        }
//    }
//
//    @Override
//    public void buttonClick(ClickEvent event) {
//
//         //
//         // Validate the fields using the navigator. By using validors for the
//         // fields we reduce the amount of queries we have to use to the database
//         // for wrongly entered passwords
//         //
//        if (!user.isValid() || !password.isValid()) {
//            return;
//        }
//
//        String username = user.getValue();
//        String password = this.password.getValue();
//
//         //
//         // Validate username and password with database here. For examples sake
//         // I use a dummy username and password.
//         //
//        boolean isValid = username.equals("test@test.com")
//                && password.equals("passw0rd");
//
//        if(isValid){
//            // Store the current user in the service session
//            getSession().setAttribute("user", username);
//
//            // Navigate to main view
//            getUI().getNavigator().navigateTo(SimpleLoginMainView.NAME);
//
//        } else {
//
//            // Wrong password clear the password field and refocuses it
//            this.password.setValue(null);
//            this.password.focus();
//        }
//    }

}
