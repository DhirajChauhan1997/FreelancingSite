/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.Part;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Dhiraj Chauhan
 */
@ManagedBean(name = "fmbdhiraj")
@RequestScoped
public class TestMB {

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    void upload() {
        try {
            Part uploadedFile = getFile();

            final Path destination = Paths.get("D://Projects/Java Enterprise Project/ProLancer/ProLancer-war/web/userimg/" + file.getSubmittedFileName());

            InputStream input = null;

            if (uploadedFile != null) {
                input = uploadedFile.getInputStream();

                //Copies  to destination.
                Files.copy(input, destination);
            }
        } catch (Exception e) {
            System.out.println("error = " + e.getMessage());
        }
    }

    public TestMB() {
    }

}
