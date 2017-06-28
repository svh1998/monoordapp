package com.example.svanh.testproject.api;
import com.example.svanh.testproject.api.ApiTest;
/**
 * Created by svanh on 5/17/2017.
 */

public class ApiDriver implements BackgroundTaskListener{

    public int checklogin(){
       new BackgroundTask(this, "http://api.hostdalem.nl/json_get_data.php").execute();
    return 1;
    }

    @Override
    public void onTaskComplete() {

    }
}
