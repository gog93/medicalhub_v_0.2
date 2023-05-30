package com.example.generatedproject;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/controllerUrl")
public class controllerNameController {
    @Autowired
entitynameRepository entitynamerepository;
    @GetMapping("/MethodUrl/{surveyTwoId}")
    public String Methodname1(@PathVariable("surveyTwoId") String surveyTwoId, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId)) {
            entityname данные_для_заполнения = entitynamerepository.findBySurveyTwoId(surveyTwoId);
            map.addAttribute("formObj", данные_для_заполнения);
        }
        return "ecrf1";
    }
    @PostMapping("/MethodUrl/{surveyTwoId}")
    public String Methodname1(@PathVariable("surveyTwoId") String surveyTwoId, @ModelAttribute("formObj")entityname formObj, ModelMap map) {
        if (!StringUtils.isEmpty(surveyTwoId)) {
            entityname данные_для_заполнения =entitynamerepository.findBySurveyTwoId(surveyTwoId);
            formObj.setId(данные_для_заполнения.getId());
            entitynamerepository.save(formObj);
        }
        map.addAttribute("collected", "Your data has been saved.");
        return "ecrf1 ";
    }
}
