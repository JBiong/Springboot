package com.acadzen.acadzen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acadzen.acadzen.Entity.AcadzenEntity;
import com.acadzen.acadzen.Service.AcadzenService;


@RestController
@RequestMapping("/api/acadzen")
@CrossOrigin(origins = "http://localhost:3000")
public class AcadzenController {
    
    @Autowired
    AcadzenService aserv;

    //C - Create and Insert
    @PostMapping("/insert")
    public AcadzenEntity insertAcadzen(@RequestBody AcadzenEntity acadzen){
        return aserv.insertAcadzen(acadzen);
    }

    //R -Read
    @GetMapping("/getAll")
    public List<AcadzenEntity> getAllAcadzen(){
        return aserv.getAllAcadzen();
    }


    //U - Update
    @PutMapping("/update/{userno}")
    public AcadzenEntity updateAcadzen(@RequestParam int userno, @RequestBody AcadzenEntity newAcadzenDetails){
        return aserv.updateAcadzen(userno, newAcadzenDetails);
    }

    //D - Delete
    @DeleteMapping("/delete/{userno}")
    public String deleteAcadzen(@PathVariable int userno){
        return aserv.deleteAcadzen(userno);
    }

    // Update the method signature
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody AcadzenEntity request) {
        String username = request.getUsername();
        String password = request.getPassword();

        // Your authentication logic here
        boolean isAuthenticated = aserv.authenticateUser(username, password);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
