package com.acadzen.acadzen.Service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acadzen.acadzen.Entity.AcadzenEntity;
import com.acadzen.acadzen.Repository.AcadzenRepository;

@Service
public class AcadzenService {
    
    @Autowired
    AcadzenRepository arepo;

    // C
    public AcadzenEntity insertAcadzen(AcadzenEntity acadzen){
        return arepo.save(acadzen);
    }

    //R
    public List<AcadzenEntity> getAllAcadzen(){
        return arepo.findAll();
    }

    //U
    @SuppressWarnings("finally")
    public AcadzenEntity updateAcadzen(int userno, AcadzenEntity newAcadzenDetails){
        AcadzenEntity acadzen = new AcadzenEntity();
        try{
            // 1. Search the id number of the user that will be updated
            acadzen = arepo.findById(userno).get();

            // 2. Update
            acadzen.setUsername(newAcadzenDetails.getUsername());
            acadzen.setPassword(newAcadzenDetails.getPassword());
            acadzen.setEmail(newAcadzenDetails.getEmail());
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("User " + userno + " does not exist!");
        }
        finally {
            return arepo.save(acadzen);
        }
    }

    //D
    public String deleteAcadzen(int userno){
        String msg = "";

        if (arepo.findById(userno) != null) {
            arepo.deleteById(userno);
            msg = "User " + userno + " is successfully deleted";
        }
        else{
            msg = "User " + userno + " does not exist";
        }
        return msg;
    }

    // New method for authentication
    public boolean authenticateUser(String username, String password) {
        AcadzenEntity user = arepo.findByUsernameAndPassword(username, password);
        return user != null; // Return true if user is found, indicating successful authentication
    }
    
}
