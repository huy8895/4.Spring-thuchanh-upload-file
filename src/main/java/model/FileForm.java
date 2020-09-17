package model;

import org.springframework.web.multipart.MultipartFile;

public class FileForm {
    private String id;
    private MultipartFile image;

    public FileForm() {
    }

    public FileForm(String id, MultipartFile image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
