package controller;

import form.MyUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyFileUploadController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == MyUploadForm.class) {
            // Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }

    @GetMapping("/uploadOneFile")
    public String uploadOneFileHandler(Model model) {
        model.addAttribute("myUploadForm", new MyUploadForm());
        return "uploadOneFile";
    }

    @GetMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(Model model) {
        model.addAttribute("myUploadForm", new MyUploadForm());
        return "uploadMultiFile";
    }

    // POST: Xử lý Upload
    @PostMapping("/uploadOneFile")
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        return this.doUpload(request, model, myUploadForm);
    }

    // POST: Xử lý Upload
    @PostMapping("/uploadMultiFile")
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        return this.doUpload(request, model, myUploadForm);
    }

    private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        String name = myUploadForm.getName();
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] files = myUploadForm.getFiles();
        Map<File, String> uploadedFiles = new HashMap();
        for (CommonsMultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + fileName);
                    // Luồng ghi dữ liệu vào file trên Server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(file.getBytes());
                    stream.close();
                    uploadedFiles.put(serverFile, fileName);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        model.addAttribute("name", name);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";
    }
}