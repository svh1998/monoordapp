package com.example.svanh.testproject.profiel;

/**
 * Created by David on 18-5-2017.
 */

public class Validator {
    String email;
    int valid;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }


    public Validator (String arg1) {
        this.email = arg1;
    }

    public int isEmail(String arg1) {

        if(email = ){
            this.setValid(1);
        }else{
            this.setValid(0);
        }


        return this.getValid();
    }
}

