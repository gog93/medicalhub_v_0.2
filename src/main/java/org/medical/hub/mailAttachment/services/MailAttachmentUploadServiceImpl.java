package org.medical.hub.mailAttachment.services;


import org.medical.hub.mail.WorkflowEmailService;
import org.medical.hub.mailAttachment.exceptions.AttachmentDoesNotExistException;
import org.medical.hub.mailAttachment.exceptions.NullAttachmentException;
import org.medical.hub.mailAttachment.model.MailAttachment;
import org.medical.hub.mailAttachment.repository.MailAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MailAttachmentUploadServiceImpl implements MailAttachmentUploadService {
    private final String upload = System.getProperty("user.home") + "/img/";

    @Autowired
    private MailAttachmentRepository mailAttachmentRepository;
    @Autowired
    WorkflowEmailService emailService;

    @Override
    public String uploadAttachment(MultipartFile file, UUID uuId) {
        try {
            if (file.isEmpty()) {
                throw new NullAttachmentException("File or emailId is null");
            }
            String fileName = file.getOriginalFilename();
            byte[] uploadedFile = file.getInputStream().readAllBytes();
            MailAttachment savedMailAttachment = mailAttachmentRepository.save(new MailAttachment( fileName, uploadedFile, "draft", uuId));

            return "File id: " + savedMailAttachment.getId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<MailAttachment> findAllaAttachments() {
        return mailAttachmentRepository.findAll();
    }

    @Override
    public void deleteAttachment(Long attachmentId) {
        MailAttachment mailAttachment = mailAttachmentRepository.findById(attachmentId).orElseThrow(() -> new AttachmentDoesNotExistException("File not found"));
        mailAttachmentRepository.delete(mailAttachment);
    }

    @Override
    public void changeStatus(Long id) {
        MailAttachment byId = mailAttachmentRepository.findById(id).get();
        byId.setStatus("canceled");
        mailAttachmentRepository.save(byId);
    }

    public List<MailAttachment> findByEmailIdAndStatus(Long emailId, UUID uuid) {

        List<MailAttachment> mailAttachment = new ArrayList<>();
        List<MailAttachment> allaAttachmentsByStatus = findByUUId(uuid);
        for (MailAttachment attachment : emailService.findById(emailId).get().getMailAttachment()) {
            if (attachment.getStatus().equals("sent")) {
                mailAttachment.add(attachment);
            }
        } for (MailAttachment attachment : allaAttachmentsByStatus) {
            if (attachment.getStatus().equals("draft")) {
                mailAttachment.add(attachment);
            }
        }
        return mailAttachment;
    }

    @Override
    public List<MailAttachment> findByUUId(UUID uuid) {
        return mailAttachmentRepository.findByUuid(uuid);
    }

}
