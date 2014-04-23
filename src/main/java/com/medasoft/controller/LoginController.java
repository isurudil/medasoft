package com.medasoft.controller;

import com.google.gson.Gson;
import com.medasoft.model.response.UserLoginResponse;
import com.medasoft.util.Configuration;
import com.medasoft.view.LoginViewComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        Gson gson = new Gson();
        UserLoginResponse userLoginResponse;

        String url = "http://localhost:8080/meda/rest/user/get/";
        try {
            url = url + URLEncoder.encode(txtUserText, "UTF-8");
            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            mPost.addParameter("username", txtUserText);

            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/text");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            String output = mPost.getResponseBodyAsString();
            LOGGER.debug("Received Response : " + output);
            userLoginResponse = gson.fromJson(output, UserLoginResponse.class);
            LOGGER.debug("Query Success .... got password " + output + " for username " + txtUserText);
            mPost.releaseConnection();
            if (userLoginResponse.getStatus().equals(Configuration.SUCCESS_CODE_DEFAULT)) {

                if (userLoginResponse.getPassword().equals(txtPassText)) {
                    lblWarning.setCaption("Username or Password Valid");
                } else {
                    lblWarning.setCaption("Username or Password Invalid");
                }
            } else {
                lblWarning.setCaption("Username or Password Invalid");

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}