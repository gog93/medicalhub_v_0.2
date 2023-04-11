package org.medical.hub.mailAttachment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.medical.hub.mail.UserEmails;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MailAttachment {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    @Column(nullable = false)
    private byte[] file;
    private String status;

    public MailAttachment(  String fileName, byte[] uploadedFile, String status) {
        this.fileName = fileName;
        this.file = uploadedFile;
        this.status=status;
    }

}
