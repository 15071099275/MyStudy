package com.ab.family.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

@RequestMapping("/family")
@RestController
public class FamilyService {

    @RequestMapping("/getFishInfo")
    @ResponseBody
    public byte[] getFishInfo(){
        File file = new File("src/main/resources/img/IMG_1829.JPG");
        byte[] data = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("img/IMG_1829.JPG");
            InputStream inputStream= classPathResource.getInputStream();
            data=image2byte(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;//"fish love mother";
    }

    public byte[] image2byte(InputStream inputStream){
        byte[] data = null;
        try {

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = inputStream.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            inputStream.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
}
