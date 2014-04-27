package com.medasoft.query;

import com.google.gson.Gson;
import com.medasoft.config.MongoContextLoader;
import com.medasoft.model.dto.DoctorRegistrationDetails;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.logging.Logger;

/**
 * Created by isurud on 4/27/14.
 */
public class GetDoctorDetails {

    String dCode;
    String password;

    private static final Logger LOGGER = Logger.getLogger(GetDoctorDetails.class.getName());
    MongoContextLoader mongoContextLoader = new MongoContextLoader();


    public GetDoctorDetails(String dCode,String password) {
        this.dCode = dCode;
        this.password = password;

    }

    public DoctorRegistrationDetails findDoctor() {

        String details;
        Gson gson = new Gson();

        Query findDoctorQuery = new Query(Criteria.where("_id").is(dCode).andOperator(Criteria.where("password").is(password)));
        DoctorRegistrationDetails doctorRegistrationDetails = null;
        try {

            MongoOperations mongoOperations = mongoContextLoader.getMongoOperation();
            LOGGER.info("Finding doctor with id" + dCode);
            doctorRegistrationDetails = mongoOperations.findOne(findDoctorQuery, DoctorRegistrationDetails.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorRegistrationDetails;

    }
}
