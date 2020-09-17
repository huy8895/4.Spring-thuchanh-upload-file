package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.FileDemo;
import model.FileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class FileController {
    @Autowired
    private Environment environment;

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("fileForm",new FileForm());

        return "/index";
    }

    @PostMapping
    public String addFile(FileForm fileForm, Model model){
        MultipartFile image=fileForm.getImage();
        String imageName = image.getOriginalFilename();
        FileDemo fileDemo = new FileDemo(fileForm.getId(),imageName );
        String fileUpload = environment.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(fileUpload.getBytes(),new File(fileUpload + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("fileDemo",fileDemo);

        return "/list";
    }
}
