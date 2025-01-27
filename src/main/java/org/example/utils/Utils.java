package org.example.utils;

public class Utils {
    // ლოგირება - ყველა მოქმედების ამსახველი რეპორტში
    public static void log(String message){

        if(ExtentReportManager.getTest() != null){
            ExtentReportManager.getTest().info(message);

        }
    }
}
