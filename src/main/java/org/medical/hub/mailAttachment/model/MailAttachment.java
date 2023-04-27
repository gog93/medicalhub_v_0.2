package org.medical.hub.mailAttachment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

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
    private UUID uuid;

    public MailAttachment(String fileName, byte[] uploadedFile, String status) {
        this.fileName = fileName;
        this.file = uploadedFile;
        this.status = status;
    }

}
