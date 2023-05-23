package org.medical.hub.generator;

import lombok.RequiredArgsConstructor;
import org.medical.hub.generator.model.Generator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/generator")
@RequiredArgsConstructor
public class GeneratorController {
    private final UtilGenerator utilGenerator;
    private final FormsGenerator formsGenerator;
    private final ZipUploadService zipUploadService;


    @GetMapping
    public String generator(Model model) {
        model.addAttribute("generator", new Generator());
        return "generator/create";
    }

    @PostMapping
    public String generator1(Model model, Generator generator, @ModelAttribute(value = "file") MultipartFile file,
                             @RequestParam(value = "zip") MultipartFile zip) throws Exception {
       zipUploadService.uploadAndExtractFiles(zip);
utilGenerator.changeHtmlHeader(generator.getHtmlHeader());
        if (!file.isEmpty()) {
            // Get the file name
            String fileName = file.getOriginalFilename();

            // Specify the directory to save the file
//            String directory = "C:\\myProjects\\medicalhub_v_0.2\\exel";
            String directory = generator.getPathForExel();
            String path = directory + "\\" + fileName;
            // Create the destination file
            File destinationFile = new File(path);

            // Transfer the multipart file to the destination file
            file.transferTo(new File(directory + File.separator + fileName));
            // Rest of your code...
//            String folderLocation = "C:\\myProjects\\medicalhub_v_0.2\\generatedProject\\src\\main\\resources\\templates\\";
            String folderLocation = generator.getThymeleafTemplateFolder();
            formsGenerator.ecrf_generation(1, true, destinationFile, folderLocation);
            utilGenerator.write(generator);
            model.addAttribute("generator", generator);
            ZipExample.zip();
        }

        return "redirect:/generator";
    }


    @GetMapping("/download")
    public ResponseEntity<FileSystemResource> downloadFiles() throws IOException {
        String filePath = "generatedProject.zip";

        // Create a FileSystemResource with the file path
        FileSystemResource fileResource = new FileSystemResource(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"generatedProject.zip\"");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileResource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileResource);

    }

    @GetMapping("/upload")
    public String up() {
        return "generator/upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("zip") MultipartFile file) {
        boolean uploadSuccess = zipUploadService.uploadAndExtractFiles(file);
        if (uploadSuccess) {
            // Handle successful file upload
            return "redirect:/uploadPage?success";
        } else {
            // Handle file upload errors
            return "redirect:/uploadPage?error=io";
        }
    }


}
