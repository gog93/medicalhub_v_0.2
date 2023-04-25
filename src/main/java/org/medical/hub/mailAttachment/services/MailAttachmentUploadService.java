package org.medical.hub.mailAttachment.services;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MailAttachmentUploadService {
    String uploadAttachment(MultipartFile file);

    void deleteAttachment(Long attachmentId);

    List<MailAttachment> findAllaAttachments();

    List<MailAttachment> findAllaAttachmentsByStatus();

    List<MailAttachment> findByEmailIdAndStatus(Long emailId);

    void changeStatus(Long id);
}
