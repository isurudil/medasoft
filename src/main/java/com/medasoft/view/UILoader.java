/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.medasoft.view;

import com.medasoft.controller.LoginController;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Window;

import javax.ws.rs.Path;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Path("/login")
public class UILoader extends Application
{
    private Window window;
    Button btnLogin;
    LoginController loginController;
    @Override
    public void init()
    {
        window = new Window("MEDA");
        setMainWindow(window);
        LoginViewComponent loginViewComponent = new LoginViewComponent();
        loginController = new LoginController(loginViewComponent);
        btnLogin = loginViewComponent.getBtnLogin();
        btnLogin.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                loginController.getDetails();
            }
        });

        window.getContent().setSizeFull();
        window.addComponent(loginViewComponent);

       
    }
    
}
