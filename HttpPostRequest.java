/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.httppostrequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPostRequest {

    public static void main(String[] args) {
       
          try {
            URL myUrl = new URL("https://fakestoreapi.com/products");
            HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            String postedString = "{\"title\":\"test product\", \"price\":13.5, \"description\":\"lorem ipsum set\", \"image\":\"https://i.pravatar.cc\", \"category\":\"electronic\"}";
            
            try (OutputStream out = conn.getOutputStream()) {
                byte[] input = postedString.getBytes("utf-8");
                out.write(input, 0, input.length);
                out.flush(); 
            }
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + conn.getResponseMessage());
           
            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("POST Request Successful!");
            } else {
                System.out.println("POST Request Failed: " + responseCode);
            }
            
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = buffer.readLine()) != null) {
                    response.append(line).append(System.lineSeparator());
                }
                System.out.println("Response Content: \n" + response);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
