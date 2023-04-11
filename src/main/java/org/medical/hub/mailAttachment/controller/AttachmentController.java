package org.medical.hub.mailAttachment.controller;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.medical.hub.mailAttachment.services.MailAttachmentUploadService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class AttachmentController {
    private final MailAttachmentUploadService mailAttachmentUploadService;
    private final String upload = System.getProperty("user.home") + "/img/";

    public AttachmentController(MailAttachmentUploadService mailAttachmentUploadService) {
        this.mailAttachmentUploadService = mailAttachmentUploadService;
    }

    @GetMapping("/attachment/{id}")
    public String uploadFile(@PathVariable("id") long emailId, Model model) {
        model.addAttribute("emailId", emailId);
        return "attachment";
    }

    @GetMapping("/image")
    public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<MailAttachment> attachment)
            throws ServletException, IOException {

        attachment = (mailAttachmentUploadService.findStudentById(id));
//        response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
        response.getOutputStream().write(attachment.get().getFile());
        response.getOutputStream().close();
    }

    @GetMapping("/downloadfile")
    public void downloadFile(@Param("id") Long id, HttpServletResponse response) throws IOException {
        Optional<MailAttachment> temp = mailAttachmentUploadService.findStudentById(id);
        if (temp != null) {
            MailAttachment mailAttachment = temp.get();
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename = " + mailAttachment.getFileName();
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(mailAttachment.getFile());
            outputStream.close();
        }
    }
    @GetMapping("/attachment/{id}/delete")
    public String removeAttachment(@PathVariable(name = "id") Long id, @RequestParam("emailId") long emailId) {
        mailAttachmentUploadService.deleteAttachment(id);
        return "redirect:/attachment/"+ emailId;
    }
}

