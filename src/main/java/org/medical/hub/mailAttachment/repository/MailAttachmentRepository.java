package org.medical.hub.mailAttachment.repository;

import org.medical.hub.mailAttachment.model.MailAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailAttachmentRepository extends JpaRepository<MailAttachment, Long> {
    List<MailAttachment> findByStatus(String draft);
//    List<MailAttachment> findByEmailId(long id);

}
