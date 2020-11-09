package form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MyUploadForm {
    private String name;
    // Upload files.
    private CommonsMultipartFile[] files;

    public MyUploadForm() {
    }

    public String getName() {
        return name;
    }

    public CommonsMultipartFile[] getFiles() {
        return files;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFiles(CommonsMultipartFile[] files) {
        this.files = files;
    }
}
