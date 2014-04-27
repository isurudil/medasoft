package com.medasoft.util;

import com.medasoft.model.dto.DoctorRegistrationDetails;

/**
 * Created by isurud on 4/28/14.
 */
public class Session {

    static DoctorRegistrationDetails sessionDetails = new DoctorRegistrationDetails();

    public static DoctorRegistrationDetails getSessionDetails() {
        return sessionDetails;
    }

    public static void setSessionDetails(DoctorRegistrationDetails sessionDetails) {
        Session.sessionDetails = sessionDetails;
    }


}
