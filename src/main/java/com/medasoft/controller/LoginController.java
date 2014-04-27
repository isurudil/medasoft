package com.medasoft.controller;

import com.medasoft.model.dto.DoctorRegistrationDetails;
import com.medasoft.query.GetDoctorDetails;
import com.medasoft.view.AddAppointmentViewComponent;
import com.medasoft.view.LoginViewComponent;
import com.vaadin.ui.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    LoginViewComponent loginViewComponent;

    TextField txtUser;
    PasswordField txtPass;
    Button btnLogin;
    String txtUserText;
    String txtPassText;
    Label lblWarning;


    public LoginController(LoginViewComponent loginViewComponent) {
        this.loginViewComponent = loginViewComponent;
    }


    public void setDetails() {

        txtPass = loginViewComponent.getTxtPass();
        txtUser = loginViewComponent.getTxtUser();
        btnLogin = loginViewComponent.getBtnLogin();
        lblWarning = loginViewComponent.getLblWarning();
        this.txtUserText = (String) txtUser.getValue();
        this.txtPassText = (String) txtPass.getValue();

        LOGGER.debug("Got text from Username " + txtUserText);
        LOGGER.debug("Got text from Password " + txtPassText);
    }

    public void authUser() {
//        Gson gson = new Gson();
//        UserLoginResponse userLoginResponse;
//        HashMap parameterHashMap = new HashMap();
//
//        String url = "http://localhost:8080/meda/rest/user/get/";
//        try {
//            url = url + URLEncoder.encode(txtUserText, "UTF-8");
//            parameterHashMap.put("username", txtUserText);
//            String output = new RestClient().post(url,parameterHashMap);
//            userLoginResponse = gson.fromJson(output, UserLoginResponse.class);
//            if (userLoginResponse.getStatus().equals(Configuration.SUCCESS_CODE_DEFAULT)) {
//
//                if (userLoginResponse.getPassword().equals(txtPassText)) {
//                    lblWarning.setCaption("Username or Password Valid");
//                } else {
//                    lblWarning.setCaption("Username or Password Invalid");
//                }
//            } else {
//                lblWarning.setCaption("Username or Password Invalid");
//
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        DoctorRegistrationDetails doctorRegistrationDetails = new GetDoctorDetails(txtUserText,txtPassText).findDoctor();
        if(doctorRegistrationDetails != null){
            AddAppointmentViewComponent viewComponent = new AddAppointmentViewComponent();
            lblWarning.setCaption("Username or Password Valid");
            System.out.println("sent dr name"+doctorRegistrationDetails.getdName());
            Window window = loginViewComponent.getApplication().getMainWindow();
            window.removeComponent(loginViewComponent);
            window.addComponent(viewComponent);
        }else {
            lblWarning.setCaption("Username or Password Invalid");
//
        }

    }
}