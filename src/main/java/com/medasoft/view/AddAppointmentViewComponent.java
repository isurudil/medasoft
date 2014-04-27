package com.medasoft.view;

import com.medasoft.util.Session;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

/**
 * Created by isurud on 4/27/14.
 */
public class AddAppointmentViewComponent extends CustomComponent {

    private final TextField txtId = new TextField("Appointment ID");
    private final TextField txtClinicType = new TextField("Clinic Type");
    private final TextField txtDoctorCode = new TextField("Doctor Code");
    private final TextField txtDoctorName = new TextField("Doctor Name");
    private final TextField txtPatientName = new TextField("Patient Name");
    private final ComboBox comboBox = new ComboBox("Patient Title");
    private final Button btnAddAppoinment = new Button("Add Appointment");
    private final Button btnClearDetails = new Button("Clear Details");
    private final Button btnSignOut = new Button("Sign Out");
    public final Label txtWelcome = new Label("Welcome ");
    private String dName="";

    public void setdName(String dName) {
        this.dName = dName;
    }

    public TextField getTxtDoctorCode() {
        return txtDoctorCode;
    }

    public TextField getTxtDoctorName() {
        return txtDoctorName;
    }

    public Label getTxtWelcome() {
        return txtWelcome;
    }

    private final TextField txtAppointmentDate = new TextField();

    public AddAppointmentViewComponent() {

        ThemeResource resource = new ThemeResource("../images/banner.jpg");
        Embedded image = new Embedded("", resource);

        comboBox.addItem("Mr.");
        comboBox.addItem("Mrs.");

        txtId.setWidth("300px");
//        txtAppointmentDate.setWidth("300px"); should be selectable
        txtClinicType.setWidth("300px");
      //  txtDoctorCode.setWidth("300px"); should be set internally
//        txtDoctorName.setWidth("300px"); should be set internally
        txtPatientName.setWidth("300px");
        comboBox.setWidth("300px");
        comboBox.setValue("Mr.");
        comboBox.setInvalidAllowed(false);

        VerticalLayout form = new VerticalLayout();
        form.addComponent(txtId);
        form.addComponent(txtClinicType);
        form.addComponent(txtPatientName);
        form.addComponent(comboBox);
        form.setSizeUndefined();
        form.setSpacing(true);


        form.setMargin(new Layout.MarginInfo(false, true, true, false));

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addComponent(btnAddAppoinment);
        buttonLayout.addComponent(btnClearDetails);

        VerticalLayout emptyLayout = new VerticalLayout();
        emptyLayout.setHeight("100px");
        String welcomeText = "Welcome Dr."+ Session.getSessionDetails().getdName();
        System.out.println("Welcome Dr."+ Session.getSessionDetails().getdName());
        txtWelcome.setValue(welcomeText);
        VerticalLayout containerLayout = new VerticalLayout();
        containerLayout.addComponent(image);
        containerLayout.addComponent(txtWelcome);
        containerLayout.addComponent(btnSignOut);
        containerLayout.addComponent(emptyLayout);
        containerLayout.addComponent(form);
        containerLayout.addComponent(buttonLayout);

        containerLayout.setSizeUndefined();
        containerLayout.setComponentAlignment(form, Alignment.TOP_CENTER);
        containerLayout.setComponentAlignment(image, Alignment.TOP_CENTER);
        containerLayout.setComponentAlignment(buttonLayout, Alignment.TOP_CENTER);
        containerLayout.setComponentAlignment(txtWelcome, Alignment.TOP_LEFT);
        containerLayout.setStyleName(Runo.LAYOUT_DARKER);
        containerLayout.addStyleName(Runo.PANEL_LIGHT);
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.addComponent(containerLayout);
        mainLayout.setComponentAlignment(containerLayout, Alignment.TOP_CENTER);
        setCompositionRoot(mainLayout);

    }

    public void setButtonListners(final AddAppointmentViewComponent viewComponent,final LoginViewComponent loginViewComponent){
        btnAddAppoinment.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                System.out.println("Add");

            }
        });
        btnClearDetails.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                System.out.println("Clear");
            }
        });
        btnSignOut.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Window window= viewComponent.getApplication().getMainWindow();
                if(window != null){
                    window.removeComponent(viewComponent);
                    window.addComponent(loginViewComponent);

                    System.out.println("Window is null");
                }else {
                    System.out.println("Window is not null");
                }

            }
        });
    }
}
