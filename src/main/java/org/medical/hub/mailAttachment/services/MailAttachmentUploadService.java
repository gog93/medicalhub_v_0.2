package org.medical.hub.mailAttachment.services;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface MailAttachmentUploadService {
    String uploadAttachment(MultipartFile file);

    void deleteAttachment(Long attachmentId);

    List<MailAttachment> findAllaAttachments();
    List<MailAttachment> findAllaAttachmentsByStatus();

    Optional<MailAttachment> findStudentById(Long Id);
    List<MailAttachment> findByEmailIdAndStatus(Long emailId);
    void changeStatus(Long id);
}
