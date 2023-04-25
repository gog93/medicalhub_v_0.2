package org.medical.hub.mailAttachment.controller;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.medical.hub.mailAttachment.services.MailAttachmentUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping
public class AttachmentUploadController {

    @Autowired
    private MailAttachmentUploadService attachmentService;


    @PostMapping("/fileUpload")
    @ResponseBody
    public ResponseEntity<String> uploadAttachment(@RequestPart MultipartFile file) {

        return ResponseEntity.ok(attachmentService.uploadAttachment(file));
    }


    @GetMapping("/remove-attachment/{id}")
    public ResponseEntity<String> removeAttachment(@PathVariable(name = "id") Long id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/change/status/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable(name = "id") Long id) {
        attachmentService.changeStatus(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/attachments")
    public @ResponseBody
    List<MailAttachment> attachments() {
        return attachmentService.findAllaAttachmentsByStatus();

    }

    @GetMapping("/{emailId}/attachments")
    public @ResponseBody
    List<MailAttachment> findByUserEmailId(@PathVariable("emailId") Long emailId) {
        return attachmentService.findByEmailIdAndStatus(emailId);

    }

}
