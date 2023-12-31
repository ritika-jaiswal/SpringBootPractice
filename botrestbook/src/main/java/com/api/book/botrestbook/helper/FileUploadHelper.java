package com.api.book.botrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
//    For static file uploading

//    public final String UPLOAD_DIR="C:\\Users\\DELL\\Desktop\\SpringBootPractice\\botrestbook\\src\\main\\resources\\static\\image";

//    For Dynamic Upload file
    public final String UPLOAD_DIR= new ClassPathResource("static/image").getFile().getAbsolutePath();
    public FileUploadHelper()throws IOException
    {

    }
    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean f = false;
        try {
//            InputStream is = multipartFile.getInputStream();]
//            byte data[] = new byte[is.available()];
//            is.read(data);
//
//            //write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//            fos.write(data);
//
//            fos.flush();
//            fos.close();
//            f=true;

//            Alternate Option of above code
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;

        }catch(Exception e){
            e.printStackTrace();
        }



        return f;
    }
}
