package org.medical.hub.generator;

import org.medical.hub.generator.model.Generator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

@Service
public class UtilGenerator {

    public void write(Generator generator) {
        String folder = "generatedProject/src/main/java/com/example/generatedproject";
        String propertiesPath = "generatedProject/src/main/resources/application.properties";
        String pac = "com.example.generatedproject";
        String repositoryName = generator.getEntityName() + "Repository";
        String controllerName = generator.getControllerName() + "Controller";
        deleteFilesInDirectory(folder);
        String properties = "spring.datasource.url= jdbc:postgresql://localhost:5432/" + generator.getDatabaseName() + "\n" +
                "spring.datasource.username=" + generator.getDatabaseUsername() + "\n" +
                "spring.datasource.password=" + generator.getDatabasePassword() + "\n" +
                "spring.jpa.hibernate.ddl-auto=create\n" +
                "server.port = " + generator.getServerPort() + "\n";
        String controller = "package " + pac + ";\r\n" +
                "import io.micrometer.common.util.StringUtils;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.ui.ModelMap;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "@Controller\r\n" +
                "@RequestMapping(\"/" + generator.getControllerUrl() + "\")\r\n" +
                "public class " + controllerName + " {\r\n" +
                "    @Autowired\r\n" +
                repositoryName + " " + repositoryName.toLowerCase() + ";\r\n" +
                "    @GetMapping(\"/" + generator.getMethodUrl() + "/{surveyTwoId}\")\r\n" +
                "    public String " + generator.getMethodName() + "(@PathVariable(\"surveyTwoId\") String surveyTwoId, ModelMap map) {\r\n" +
                "        if (!StringUtils.isEmpty(surveyTwoId)) {\r\n" +
                "            " + generator.getEntityName() + " данные_для_заполнения = " + repositoryName.toLowerCase() + ".findBySurveyTwoId(surveyTwoId);\r\n" +
                "            map.addAttribute(\"formObj\", данные_для_заполнения);\r\n" +
                "        }\r\n" +
                "        return \"ecrf1\";\r\n" +
                "    }\r\n" +
                "    @PostMapping(\"/" + generator.getMethodUrl() + "/{surveyTwoId}\")\r\n" +
                "    public String " + generator.getMethodName2() + "(@PathVariable(\"surveyTwoId\") String surveyTwoId, @ModelAttribute(\"formObj\")" + generator.getEntityName() + " formObj, ModelMap map) {\r\n" +
                "        if (!StringUtils.isEmpty(surveyTwoId)) {\r\n" +
                "            " + generator.getEntityName() + " данные_для_заполнения =" + repositoryName.toLowerCase() + ".findBySurveyTwoId(surveyTwoId);\r\n" +
                "            formObj.setId(данные_для_заполнения.getId());\r\n" +
                "            " + repositoryName.toLowerCase() + ".save(formObj);\r\n" +
                "        }\r\n" +
                "        map.addAttribute(\"collected\", \"Your data has been saved.\");\r\n" +
                "        return \"ecrf1 \";\r\n" +
                "    }\r\n" +
                "}\r\n";
        String entity =
                "package " + pac + ";\r\n" +
                        "import jakarta.persistence.*;\r\n" +
                        "@Entity\r\n" +
                        "@Table(name = \"" + generator.getEntityTableName() + "\")\r\n" +
                        "public class " + generator.getEntityName() + " {\r\n" +
                        "@Id\r\n" +
                        "@GeneratedValue(strategy = GenerationType.SEQUENCE)\r\n" +
                        "private Long id;\r\n" +
                        "private String surveyTwoId;\r\n" +
                        "\r\n" +
                        "	public " + generator.getEntityName() + "() {\r\n" +
                        "	}\r\n" +
                        "	public Long getId() {\r\n" +
                        "		return this.id;\r\n" +
                        "	}\r\n" +
                        "	public void setId(Long id) {\r\n" +
                        "		this.id = id;\r\n" +
                        "	}\r\n" +

                        "}\r\n";
        String repository = "package " + pac + ";\r\n" +
                "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                "import org.springframework.data.jpa.repository.JpaSpecificationExecutor;\n" +
                "import org.springframework.stereotype.Repository;" +
                "@Repository\n" +
                "public interface " + " " + repositoryName + " extends JpaRepository<" + generator.getEntityName() + ", Long> {\n" +
                generator.getEntityName() + " findBySurveyTwoId(String surveyTwoId);\n" +
                "\n" +
                "}";
        System.out.println(controller);

        String controllerPath = folder + "/" + controllerName + ".java";
        String entityPath = folder + "/" + generator.getEntityName() + ".java";
        String repositoryPath = folder + "/" + repositoryName + ".java";
        writeFile(controller, controllerPath);
        writeFile(entity, entityPath);
        writeFile(repository, repositoryPath);
        writeFile(properties, propertiesPath);
    }

    private static void writeFile(String content, String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("File created and written successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + filePath);
            e.printStackTrace();
        }

    }

    public static void deleteFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            // Iterate through the files and delete each one
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && !file.getName().endsWith("Application.java")) {
                        boolean isDeleted = file.delete();
                        if (!isDeleted) {
                            System.out.println("Failed to delete file: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }

    public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        byte[] fileBytes = multipartFile.getBytes();
        File file = new File("exel/" + multipartFile.getName() + ".xlsx");
        Files.write(file.toPath(), fileBytes);
        return file;
    }
public void changeHtmlHeader(String header){
    String filePath = "generatedProject/src/main/resources/templates/ecrf1.html";
    String markerWord = "<head>";

    try {
        // Read the contents of the file
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        reader.close();
        String fileContent = stringBuilder.toString();

        // Locate the marker word
        int markerIndex = fileContent.indexOf(markerWord);

        if (markerIndex != -1) {
            // Insert the custom sentence after the marker word
            StringBuilder modifiedContent = new StringBuilder(fileContent);
            modifiedContent.insert(markerIndex + markerWord.length(), " " + header);

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(modifiedContent.toString());
            writer.close();

            System.out.println("Custom sentence added successfully.");
        } else {
            System.out.println("Marker word not found in the file.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}



