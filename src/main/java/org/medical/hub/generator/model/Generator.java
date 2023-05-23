package org.medical.hub.generator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "generator")
public class Generator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String htmlHeader;
    private String thymeleafTemplateFolder;
    private String pathForExel;
    private String methodName2;
    private String controllerName;
    private String controllerUrl;
    private String methodName;
    private String methodUrl;
    private String entityName;
    private String entityTableName;
    private String exel;
    private String databaseUsername;
    private String databasePassword;
    private String databaseName;
    private int serverPort;


}
