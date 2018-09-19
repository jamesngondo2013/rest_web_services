package com.niug.restws.datamodel;

import javax.xml.bind.annotation.XmlRootElement;

/*This is a model class that will hold data
 * This class is a Bean that will be serialized and de-serialized into json, xml etc
    -when the request comes in, it will be de-serialized
    -when the response goes out, it will be serialized on to the wire - to the client
*/
@XmlRootElement(name="Patient")
public class Patient {

    private long id;
    private String name;
    
    
    
    public long getId ()
    {
        return id;
    }
    public void setId (long id)
    {
        this.id = id;
    }
    public String getName ()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }
}
