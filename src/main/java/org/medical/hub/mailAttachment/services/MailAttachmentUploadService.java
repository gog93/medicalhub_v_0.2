package org.medical.hub.mailAttachment.services;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface MailAttachmentUploadService {
    String uploadAttachment(MultipartFile file, UUID uuid);

    void deleteAttachment(Long attachmentId);

    List<MailAttachment> findAllaAttachments();


    List<MailAttachment> findByEmailIdAndStatus(Long emailId, UUID uuid);

    List<MailAttachment> findByUUId(UUID uuid);

    void changeStatus(Long id);
}
