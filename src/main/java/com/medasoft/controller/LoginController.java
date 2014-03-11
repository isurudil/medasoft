package com.medasoft.controller;

import com.medasoft.view.LoginViewComponent;
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

    String txtUserText;
    String txtPassText;


    public LoginController(LoginViewComponent loginViewComponent) {
        this.loginViewComponent = loginViewComponent;
    }


    public void setDetails() {

        txtPass = loginViewComponent.getTxtPass();
        txtUser = loginViewComponent.getTxtUser();

        this.txtUserText = (String) txtUser.getValue();
        this.txtPassText = (String) txtPass.getValue();

        LOGGER.debug("Got text from Username " + txtUserText);
        LOGGER.debug("Got text from Password " + txtPassText);
    }

    public void authUser(){

        String url = "http://localhost:8080/meda/rest/user/get/";
        try {
            url = url + URLEncoder.encode(txtUserText, "UTF-8");
            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            mPost.addParameter("username",txtUserText);

            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/text");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            String output = mPost.getResponseBodyAsString( );
            LOGGER.debug("Query Success .... got password "+output+" for username "+txtUserText);
            mPost.releaseConnection( );

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}