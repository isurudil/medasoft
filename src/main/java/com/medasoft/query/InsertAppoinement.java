package com.medasoft.query;

import com.medasoft.config.MongoContextLoader;
import com.medasoft.model.dto.AppointmentDetails;

/**
 * Created by isurud on 4/28/14.
 */
public class InsertAppoinement {


    MongoContextLoader mongoContextLoader = new MongoContextLoader();
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(InsertAppoinement.class.getName());
    String details;

    public AppointmentDetails insertAppointmentDetails(AppointmentDetails appointmentDetails) {
            try {

                LOGGER.info("Details are set");
                mongoContextLoader.getMongoOperation().save(appointmentDetails);
                LOGGER.info("Save operation Executed, Getting updated details");
                LOGGER.info("Put Details to DB : " + details);
            } catch (Exception ex) {
                LOGGER.info(ex.getMessage());
                ex.printStackTrace();
            }

        return appointmentDetails;
    }

}
