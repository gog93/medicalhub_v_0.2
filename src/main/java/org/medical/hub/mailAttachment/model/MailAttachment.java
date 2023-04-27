package org.medical.hub.mailAttachment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MailAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    @Column(nullable = false)
    private byte[] file;
    private String status;
    private UUID uuid;

    public MailAttachment(String fileName, byte[] uploadedFile, String status,UUID uuid) {
        this.fileName = fileName;
        this.file = uploadedFile;
        this.status = status;
        this.uuid = uuid;
    }

}
