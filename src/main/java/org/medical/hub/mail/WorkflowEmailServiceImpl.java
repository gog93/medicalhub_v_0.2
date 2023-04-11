package org.medical.hub.mail;

import lombok.AllArgsConstructor;
import org.medical.hub.mailAttachment.model.MailAttachment;
import org.medical.hub.mailAttachment.repository.MailAttachmentRepository;
import org.medical.hub.workflow.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WorkflowEmailServiceImpl implements WorkflowEmailService {

    private static final Logger logger = LoggerFactory.getLogger(WorkflowEmailServiceImpl.class);

    private final MailRepository mailRepository;
    private final WorkflowService workflowService;
    private final MailAttachmentRepository attachmentService;
//    private final LoggedinUser loggedinUser;

    @Override
    public void save(Long workflowId, CreateMailRequest request) throws ParseException {
        List<MailAttachment> draft = attachmentService.findByStatus("draft");

        logger.info("Saving the mail details for workflow.", request);
//
//        String pattern = "MM/dd/yyyy hh:mm a";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date parse = simpleDateFormat.parse(request.getSentAt());
//        var sentAt = parse.getTime();

        UserEmails email = new UserEmails();
//        email.setFrom(request.getTo());
        email.setContent(request.getEmailContent());
        email.setSubject(request.getSubject());
        email.setCreatedAt(System.currentTimeMillis());
        email.setUpdatedAt(System.currentTimeMillis());
        email.setStatus(MailStatus.IN_ANTICIPATION);
//        email.setWorkflow(workflowService.findById(workflowId));
//        email.setSentAt(sentAt);
        for (MailAttachment mailAttachment : draft) {
            mailAttachment.setStatus("sent");

        }
        email.setMailAttachment(draft);

        mailRepository.save(email);

        logger.info("Email saved for workflow.");
    }

    @Override
    public UserEmails findMailById(Long workflowId, Long mailId) {

        return this.mailRepository.findById(mailId).get();
    }

    @Override
    public void update(Long workflowId, Long mailId, CreateMailRequest request) throws ParseException {
        logger.info("Saving the mail details for workflow.", request);

        String patter = "MM/dd/yyyy hh:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        Date parse = simpleDateFormat.parse(request.getSentAt());
        var sentAt = parse.getTime();

        UserEmails email = findMailById(workflowId, mailId);
        email.setContent(request.getEmailContent());
        email.setSubject(request.getSubject());
        email.setCreatedAt(System.currentTimeMillis());
        email.setUpdatedAt(System.currentTimeMillis());
        email.setStatus(MailStatus.IN_ANTICIPATION);
        email.setWorkflow(workflowService.findById(workflowId));
        email.setSentAt(sentAt);

        mailRepository.save(email);

        logger.info("Email saved for workflow.");
    }

    @Override
    public boolean delete(Long workflowId, Long mailId) {
        UserEmails email = findMailById(workflowId, mailId);
        this.mailRepository.delete(email);
        return true;
    }

    @Override
    public Optional<UserEmails> findById(Long userEmailId) {
        return mailRepository.findById(userEmailId);
    }
}
