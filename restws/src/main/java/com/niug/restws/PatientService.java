package com.niug.restws;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.niug.restws.datamodel.Patient;

@Path("/patientservice")
public interface PatientService {

    //get all the patients
    @Path("/patients")
    @GET
    List<Patient> getPatients();
    
  //get a single patient by binding a url parameter with 
    @Path("/patients/{id}")
    @GET
    Patient getPatient(@PathParam(value = "id") Long id);
    
  //create a patient by binding a url parameter with 
    @Path("/patients")
    @POST
    Response createPatient(Patient patient);
    
  //update a patient by binding a url parameter with 
    @Path("/patients")
    @PUT
    Response updatePatient(Patient patient);
    
  //delet a patient by binding a url parameter with 
    @Path("/patients/{id}")
    @DELETE
    Response deletePatient(@PathParam(value = "id") Long id);
}
