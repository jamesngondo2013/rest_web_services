package com.niug.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.niug.restws.datamodel.Patient;

@Service
public class PatientServiceImpl implements PatientService {
    //create in-memory database for patients
    Map<Long, Patient> patients = new HashMap<>();
    long currentId = 123;

    public PatientServiceImpl ()
    {
        //initializing the map with a patient 
        init();
    }
    
    void init(){
        Patient patient = new Patient();
        patient.setId(currentId);
        patient.setName("James");
        patients.put(patient.getId(), patient);      
    }

    @Override
    public List<Patient> getPatients ()
    {
        //http://localhost:8080/restws/services/patientservice/patients
        
        Collection<Patient> results = patients.values();
        List<Patient> response = new ArrayList<>(results);
        return response;
    }

    @Override
    public Patient getPatient (Long id)
    {
        //http://localhost:8080/restws/services/patientservice/patients/123
        
        return patients.get(id);
    }

    @Override
    public Response createPatient (Patient patient)
    {
      //POST
       /* <Patient>  
        <name>Comfort</name>
         </Patient>*/
        
        patient.setId(++currentId);
        patients.put(patient.getId(), patient);
        return Response.ok(patient).build();
    }

    @Override
    public Response updatePatient (Patient patient)
    {
        Patient currentPatient = patients.get(patient.getId());
        
        Response response;
        if (currentPatient != null) {
            patients.put(patient.getId(), patient);
      
            response = Response.ok().build();
        }
        else{
            response = Response.notModified().build();
        }
        
        return response;
    }

    @Override
    public Response deletePatient (Long id)
    {
        Patient patient = patients.get(id);
        
        Response response;
        if (patient != null) {
            patients.remove(id);
      
            response = Response.ok().build();
        }
        else{
            response = Response.notModified().build();
        }
        return response;
    }

}
