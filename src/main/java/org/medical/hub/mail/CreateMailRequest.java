package org.medical.hub.mail;

import lombok.Getter;
import lombok.Setter;
import org.medical.hub.mailAttachment.model.MailAttachment;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class CreateMailRequest {

    @NotEmpty(message = "Name is required.")
    private String subject;

    private String to;

    @NotEmpty(message = "Email content is required")
    private String emailContent;

    private String sentAt ;
    private List<MailAttachment> attachmentList;
}
