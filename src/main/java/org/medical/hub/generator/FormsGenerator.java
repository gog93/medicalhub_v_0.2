package org.medical.hub.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FormsGenerator {
	private static final String N_G = "-99";
	private static final int PART_2 = 2;
	public static final int PART_5 = 5;

	private Set<String> part_names = new HashSet<>();
	private StringBuilder документ = new StringBuilder();
	private StringBuilder java_script = new StringBuilder("<script  type=\"text/javascript\">\r\n" + "function __main__() {\r\n");
	private Set<String> active_keys = new HashSet<>();
	private Set<String> all_identifier_for_db = new TreeSet<>();
	private Map<String, StringBuilder> map_for_java_script = new HashMap<>();
	private String table_name_to_generate = "public.forms_ecrf";
	private String name_get_method_for_generation = "ecrf";
	private String table_name_to_generate_java_class = "forms_ecrf";
	private String class_name = "FormsEcrf";

	BiFunction<String, String, Object> processor = (ключ, значение) -> {
// int field_size = 6;
// String identifier = "Site/Principal Investigator";
// String text = "Site/Principal Investigator";
// plusText(size_field, identifier, text);
//
// if (key != null && !names_sympt.contains(key) && (StringUtils.endsWith(key, "_sympt") || StringUtils.contains(key, "_hp:")) {
// names_symptoms.add(key);
// }
		return null;
	};


	private FormsGenerator плюс_документ(Integer index) {
		документ.append(
				"<!DOCTYPE html>\r\n" +
						"<html>\r\n" +
						"<head>\r\n" +
						"<meta charset=\"utf-8\"/>\r\n" +
						"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n" +
						"<title>eCRF</title>\r\n" +
						"<!-- css files -->\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\"/>\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap-theme.min.css\"/>\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../fonts/font-awesome.min.css\"/>\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/registration-style.css\"/>\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/elements.css\"/>\r\n" +
						"<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/check-ecrf-minimal.css\"/>\r\n");
//				"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css\"/>\r\n" +
		if (index == PART_2 && false) {
//    документ.append(
//			"  <link rel=\"stylesheet\" media=\"all\" href=\"../css/application-93d92604534c7016642adf195f7d5464bc441c73b942a30e9febbe75e693c0fb.css\" data-turbolinks-track=\"true\" />\r\n"
//			);
			документ.append(
//			"  <link rel=\"stylesheet\" href=\"../js/docsupport/style.css\">\r\n" +
//			"  <link rel=\"stylesheet\" href=\"../js/docsupport/prism.css\">\r\n" +
					"  <link rel=\"stylesheet\" href=\"../css/chosen.min.css\"/>\r\n");
		}
		документ.append(
				"<!-- jquery library --> \r\n" +
						"<script type=\"text/javascript\" src=\"../js/jquery-1.11.3.min.js\"></script> \r\n" +
						"<script type=\"text/javascript\" src=\"../js/bootstrap.min.js\"></script>\r\n" +
						"<script type=\"text/javascript\" src=\"../js/survey.js\"></script>\r\n" +
						"<script type=\"text/javascript\" src=\"../js/check-ecrf-minimal.js\"></script>\r\n");
		if (index == PART_2 && false) {
			документ.append(
					"<script src=\"../assets/application-d5997003b29970562b85e7a6e6c304597fcc2b562f53e4e6e0760e2a7b4abd77.js\" data-turbolinks-track=\"true\"></script>\r\n"
			);
		}

		if (index == PART_2) {
			документ.append(
					"<!-- Latest compiled and minified CSS -->\r\n" +
							"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css\">\r\n" +
							"\r\n" +
							"<!-- Latest compiled and minified JavaScript -->\r\n" +
							"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js\"></script>\r\n" +
							"\r\n" +
							"<!-- (Optional) Latest compiled and minified JavaScript translation files -->\r\n" +
							"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/i18n/defaults-en_US.min.js\"></script>\r\n" +
							""			);
		}


		if (index == PART_2 && false) {
			документ.append(
					"<script type=\"text/javascript\" src=\"../js/i9multiselect.js\"></script>\r\n");
		}
		документ.append(
//				"<script src=\"https://code.jquery.com/ui/1.11.3/jquery-ui.js\" integrity=\"sha256-0vBSIAi/8FxkNOSKyPEfdGQzFDak1dlqFKBYqBp1yC4=\" crossorigin=\"anonymous\"></script>" +
				"<script  type=\"text/javascript\">\r\n" +
//				"    // <![CDATA[\r\n" +
						"$(document).ready(function(){ ");
		if (index == PART_2 && false) {
			документ.append(
					"      $(() => {\r\n" +
							"        $('#genotyp_detail_mutation').i9multiselect();\r\n" +
							"        $('#2ap').i9multiselect();\r\n" +
							"      });\r\n");
		}
		документ.append("});\r\n" +
//				"    // ]]>\r\n" +
				"</script>\r\n" +
				"</head>\r\n" +
				"\r\n" +
				"<body>\r\n");
		if (index != null)
			документ.append(
					"<nav class=\"navbar main-navbar\">\r\n" +
							"        <div class=\"container\">\r\n" +
							"          <!-- Brand and toggle get grouped for better mobile display -->\r\n" +
							"          <div class=\"navbar-header\">\r\n" +
							"            <button class=\"navbar-toggle\" type=\"button\" data-target=\"#responsive-menu\" data-toggle=\"collapse\">\r\n" +
							"             <span class=\"sr-only\">${open-navigation}</span>\r\n" +
							"             <span class=\"glyphicon-barcode\"></span>\r\n" +
							"             <span class=\"glyphicon-barcode\"></span>\r\n" +
							"             <span class=\"glyphicon-barcode\"></span>\r\n" +
							"           </button>\r\n" +
							"           <a class=\"navbar-brand-placeholder\" href=\"#\"><img style=\"margin-top: 20px; margin-bottom: 20px; left: 72px; top: 60px; width: 190px;\" class=\"main-logo\" alt=\"\" src=\"https://medical.org/images/tild3933-3033-4364-b136-386138373934__fullcolor_w_tag-_1_.png\"></a>\r\n" +
							"         </div>\r\n" +
							"         <!-- Collect the nav links, forms, and other content for toggling -->\r\n" +
							"         <div class=\"collapse navbar-collapse\" id=\"responsive-menu\">\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a href=\"https://medical.org/yourProfile.html\">Back to patient list</a></li>\r\n" +
							"          </ul>\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a th:href=\"${'../ecrf5/' + formObj.surveyTwoId }\">Part 5</a></li>\r\n" +
							"          </ul>\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a th:href=\"${'../ecrf4/' + formObj.surveyTwoId }\">Part 4</a></li>\r\n" +
							"          </ul>\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a th:href=\"${'../ecrf3/' + formObj.surveyTwoId }\">Part 3</a></li>\r\n" +
							"          </ul>\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a th:href=\"${'../ecrf2/' + formObj.surveyTwoId }\">Part 2</a></li>\r\n" +
							"          </ul>\r\n" +
							"          <ul class=\"nav navbar-nav navbar-right remove-right-padding\">\r\n" +
							"            <li class=\"signIn\"><a th:href=\"${'../ecrf1/' + formObj.surveyTwoId }\">Part 1</a></li>\r\n" +
							"          </ul>\r\n" +
							"        </div>\r\n" +
							"        <!-- /.navbar-collapse -->\r\n" +
							"    </nav>\r\n" +
							"\r\n");
		документ.append("<div class=\"registration-page\">\r\n" +
				"  <div class=\"container\">\r\n" +
				"    <div class=\"row\">\r\n" +
				"      <div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\">");
		return this;
	}

	private FormsGenerator плюс_форма(String action) {
		документ.append(
//				"        <form class=\"registration-form\" action=\"" + action + "\" method=\"POST\" enctype=\"\">\r\n" +
				"        <form accept-charset=\"UTF-8\" class=\"registration-form onlyForm\" method=\"post\" th:object=\"${formObj}\" th:id=\"${formObj.surveyTwoId}\" >\r\n" +
						"<input type='hidden' id=\"filling_status\" th:field=\"${formObj.fillingStatus}\"/>" +
//						"<p style=\"margin-bottom: 1.14em;\" th:if=\"${collected != null}\"></p>\r\n" +
//				        "<div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\" th:if=\"${collected != null}\">\r\n" +
//				        "	<div class=\"top-box text-center\">\r\n" +
//				        "		<h2 class=\"title\" th:text=\"${collected}\"></h2>\r\n" +
//				        "	</div>\r\n" +
//				        "</div>\r\n" +
//						"<p style=\"margin-bottom: 1.14em;\" th:if=\"${collected == null}\"></p>\r\n" +
//				        "<div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\" th:if=\"${collected == null}\">\r\n" +
//				        "	<div class=\"top-box text-center\">\r\n" +
//				        "		<h2 class=\"title\"> Please press ‘done’ to save your data. </h2>\r\n" +
//				        "	</div>\r\n" +
//				        "</div>\r\n" +

						"<div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\">\r\n" +
						"	<div class=\"top-box text-right\">\r\n" +
						"<button name=\"action\" class=\"button secondary radius expand survey-button\" style=\"margin-bottom: 40px;\" onclick='this.blur();next_part();' type=\"submit\" value=\"plot\" th:if=\"${collected == null}\">\r\n" +
						"    Next\r\n" +
						"</button>" +

//				        "<button name=\"action\" class=\"button secondary radius expand sruvey-button\" style=\"margin-bottom: 40px;\" onclick=\"this.blur();\" type=\"submit\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//				        "    Update\r\n" +
//				        "</button>" +
//						" <button name=\"action\" class=\"button secondary radius expand\" style=\"margin-bottom: 40px;\"  th:onclick=\"${'this.blur();location.href=''' + '/ecrf1/' + formObj.surveyTwoId + ''';'}\" type=\"button\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//						"    Go To Part - 1 \r\n" +
//						"</button>" +
//						" <button name=\"action\" class=\"button secondary radius expand\" style=\"margin-bottom: 40px;\"  th:onclick=\"${'this.blur();location.href=''' + '/ecrf2/' + formObj.surveyTwoId + ''';'}\" type=\"button\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//						"    Go To Part - 2 \r\n" +
//						"</button>" +
//						" <button name=\"action\" class=\"button secondary radius expand\" style=\"margin-bottom: 40px;\"  th:onclick=\"${'this.blur();location.href=''' + '/ecrf3/' + formObj.surveyTwoId + ''';'}\" type=\"button\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//						"    Go To Part - 3 \r\n" +
//						"</button>" +
//						" <button name=\"action\" class=\"button secondary radius expand\" style=\"margin-bottom: 40px;\"  th:onclick=\"${'this.blur();location.href=''' + '/ecrf4/' + formObj.surveyTwoId + ''';'}\" type=\"button\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//						"    Go To Part - 4 \r\n" +
//						"</button>" +
//						" <button name=\"action\" class=\"button secondary radius expand\" style=\"margin-bottom: 40px;\"  onclick=\"this.blur();location.href='../../page14046043.html';\" type=\"button\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//						"    Return To Hub \r\n" +
//						"</button>" +
						"	</div>\r\n" +
						"</div>\r\n"
		);
		return this;
	}

	private FormsGenerator плюс_название(String название) {
		документ.append(
				"<div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\">" +
						"        <div class=\"top-box text-left\">\r\n" +
						"          <h2 class=\"title\">" + название + "</h2>\r\n" +
						"        </div>" +
						"  <div class=\"progress\">\r\n" +
						"    <div class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"70\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:0%;background-image: linear-gradient(to bottom,#33A371 0,#33A371 100%)\">\r\n" +
						"      <span class=\"sr-only\">0% Complete</span>\r\n" +
						"    </div>\r\n" +
						"  </div>\r\n" +
						"	<div class=\"alert alert-warning\" role=\"alert\">\r\n" +
						"  	   <strong>Warning:</strong> The minimal dataset is not complete yet. Please be reminded that to complete the minimal dataset is mandatory in order to have samples processed for analysis. Please continue or come back when you can complete at least the minimal dataset.\r\n" +
						"	</div>\r\n" +
						"</div>"
		);
		return this;
	}

	private FormsGenerator плюс_строка() {
		документ.append(
				"          <div class=\"row\">\r\n"
		);
		return this;
	}

	//	private SurveyGeneratorTest плюс(String тип_поля, int размер_поля, String идентификатор, String текст, String dataset) {
//		документ.append(
//		"            <div class=\"col-sm-" + размер_поля + "\">\r\n" +
//		"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
//		"                <label for=\"" + идентификатор + "\">" + StringUtils.trimToEmpty(текст) + ":</label>\r\n" +
//		"                <input type=\"" + тип_поля + "\" class=\"form-control\" id=\"" + идентификатор + "\" placeholder=\"\"/>\r\n" +
//		"              </div>\r\n" +
//		"            </div>");
//		return this;
//	}
//
	private FormsGenerator плюс(String тип_поля, int размер_поля, boolean активний, String идентификатор, String текст, String ограничения, String dataset) {
		документ.append(
				"            <div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label for=\"" + идентификатор + "\">" + StringUtils.trimToEmpty(текст) + "</label>\r\n" +
						"                <input type=\"" + тип_поля + "\" class=\"form-control\" id=\"" + идентификатор + "\"  th:field=\"${formObj." + humanize_add_to_db(идентификатор) + "}\" " + ограничения + " placeholder=\"\" " + (активний ? " onchange=\"__main__()\" " : "" + on_change_dataset_js(dataset, true) + "") + "/>\r\n" +
						"              </div>\r\n" +
						"            </div>");
		return this;
	}

	private FormsGenerator плюс_загаловок(String идентификатор, int размер_поля, String текст, String dataset) {
		документ.append(
				"            <div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label id=\"" + идентификатор + "\">"  + StringUtils.trimToEmpty(текст) + "</label>\r\n" +
						"              </div>\r\n" +
						"            </div>");
		return this;
	}

	private FormsGenerator плюс(String тип_поля, int размер_поля, boolean активний, String идентификатор, String текст, List<String[]> список, String dataset) {
		if (StringUtils.isBlank(dataset)) dataset = "";
		документ.append(
				"            <div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label namelabel=\"" + идентификатор + "\" for=\"\">" + StringUtils.trimToEmpty(текст) + "</label>\r\n" +
						"                \r\n");
		if (список != null) {
			документ.append(
					"		<ul class=\"listing " + dataset.toLowerCase() + "-" + тип_поля + "\">\r\n");
			for (int i=0; i < список.size(); i++) {
				документ.append(
						"            <li>\r\n" +
								"                <label style=\"margin-left:10px;\">\r\n" +
								"                  <span class=\"lbl padding-8\" style=\"margin-left:5px;\">" + список.get(i)[0] + "</span>   \r\n" +
								"                  <input style=\"margin-left:5px;opacity:100!important;\" th:field=\"${formObj." + ("checkbox".equals(тип_поля) ? humanize_add_to_db(идентификатор + "_" + i) : humanize_add_to_db(идентификатор)) + "}\" type=\"" + тип_поля + "\" name1=\"" + идентификатор + "\" value=\"" + список.get(i)[1] + "\" " + (активний ? " onchange=\"__main__()\" " : " onchange=\"__main__();" + on_change_dataset_js(dataset, false) + "\" ") + "/>\r\n" +
								"				 </label>\r\n" +
								"            </li>\r\n"
				);
			}
			документ.append(
					"		</ul>\r\n");
		}

		документ.append(
				"              </div>\r\n" +
						"            </div>\r\n" +
						"");
		return this;
	}

	private String on_change_dataset_js(String dataset, boolean add_event) {
		if (add_event) return " onchange=\"minimum_part_filled_out()\"; ";
		return " minimum_part_filled_out(); ";
	}

	private FormsGenerator плюс_список(int размер_поля, boolean активний, String идентификатор, String текст, List<String[]> список, boolean multi_slect, String dataset) {
		документ.append(
				"			<div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label for=\"sel1\">" + StringUtils.trimToEmpty(текст) + "</label>\r\n" +
						"                <select class=\"form-control\" id=\"" + идентификатор + "\"" + (multi_slect ? " multiple=\"multiple\" " : "") + " th:field=\"${formObj." + humanize_add_to_db(идентификатор) + "}\" " + (активний ? " onchange=\"__main__()\" " : "" + on_change_dataset_js(dataset, true) + "") + ">\r\n");
		if (список != null)
			for (int i=0; i < список.size(); i++) {
				документ.append(
						"                  <option th:selected=\"${(formObj." + humanize_add_to_db(идентификатор) + " == '" + список.get(i)[1] + "')}\" value='" + список.get(i)[1] + "'>" + список.get(i)[0] + "</option>\r\n"
				);
			}
		документ.append(
				"                </select>\r\n" +
						"              </div>\r\n" +
						"            </div>" +
						"");
		return this;
	}

	private FormsGenerator плюс_список(int размер_поля, boolean активний, String идентификатор, String текст, int start, int end, String dataset) {
		документ.append(
				"			<div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label for=\"sel1\">" + текст + "</label>\r\n" +
						"                <select class=\"form-control\" id=\"" + идентификатор + "\" th:field=\"${formObj." + humanize_add_to_db(идентификатор) + "}\"" + (активний ? " onchange=\"__main__()\" " : "" + on_change_dataset_js(dataset, true) + "") + ">\r\n");
		for (int i=start; i <= end; i++) {
			документ.append(
					" 				   <option th:selected=\"${(formObj." + humanize_add_to_db(идентификатор) + " == '" + i + "')}\" value='" + i + "'>" + i + "</option>\r\n"
			);
		}
		документ.append(
				"                </select>\r\n" +
						"              </div>\r\n" +
						"            </div>" +
						"");
		return this;
	}

	private FormsGenerator плюс_список2(int размер_поля, boolean активний, String идентификатор, String текст, List<String> список, String dataset) {
		документ.append(
				"			<div class=\"col-sm-" + размер_поля + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label for=\"sel1\">" + текст + "</label>\r\n" +
						"                <select class=\"form-control\" id=\"" + идентификатор + "\" th:field=\"${formObj." + humanize_add_to_db(идентификатор) + "}\"" + (активний ? " onchange=\"__main__()\" " : "" + on_change_dataset_js(dataset, true) + "") + ">\r\n");
		if (список != null)
			for (int i=0; i < список.size(); i++) {
				документ.append(
						"                  <option th:selected=\"${(formObj." + humanize_add_to_db(идентификатор) + " == '" + список.get(i) + "')}\" value='" + список.get(i) + "'>" + список.get(i) + "</option>\r\n"
				);
			}
		документ.append(
				"                </select>\r\n" +
						"              </div>\r\n" +
						"            </div>" +
						"");
		return this;
	}

	private FormsGenerator минус_строка() {
		документ.append(
				"          </div>\r\n"
		);
		return this;
	}

	private FormsGenerator минус_форма(Integer index) {
		документ.append(
//		        "<div class=\"col-sm-10 col-md-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-0 col-lg-12\">\r\n" +
//		        "	<div class=\"top-box text-center\">\r\n" +
//		        "<button name=\"action\" class=\"button secondary radius expand survey-button\" style=\"margin-bottom: 40px;\" onclick=\"this.blur();\" type=\"submit\" value=\"plot\" th:if=\"${collected == null}\">\r\n" +
//		        "    Done\r\n" +
//		        "</button>" +
//		        "<button name=\"action\" class=\"button secondary radius expand survey-button\" style=\"margin-bottom: 40px;\" onclick=\"this.blur();\" type=\"submit\" value=\"plot\" th:if=\"${collected != null}\">\r\n" +
//		        "    Update\r\n" +
//		        "</button>" +
//		        "	</div>\r\n" +
//		        "</div>\r\n" +
				"        </form>\r\n" +
						"<div id=\"upload-progress\" style='display:none'><div class=\"progress-bar-1\" style=\"display:none\"></div></div> <!-- Progress bar added -->" +
						"    <div class=\"selectedDrogsChildren\">\r\n" +
						"                    <span th:each=\"formChild: ${formD}\"\r\n" +
						"                          th:text=\"${formChild.name}\"\r\n" +
						"                          th:class=\"${formChild.name}\"\r\n" +
						"                          style=\"display:none;\"\r\n" +
						"                    ></span>\r\n" +
						"    </div>\r\n" +
						"<div class=\"row\">\r\n" +
						"	<div class=\"col-md-3\">\r\n" +
						"	</div>\r\n" +
						"	<div class=\"col-md-2\">\r\n" +
						"		<ul class=\"listing minimal-radio\">\r\n" +
						"			<li class=\"has-core\">Data required</li>\r\n" +
						"		</ul>\r\n" +
						"	</div>\r\n" +
						"	<div class=\"col-md-2\">\r\n" +
						"		<ul class=\"listing core-radio\">\r\n" +
						"			<li class=\"has-core\">Preferable data</li>\r\n" +
						"		</ul>\r\n" +
						"	</div>\r\n" +
						"	<div class=\"col-md-2\">\r\n" +
						"		<ul class=\"listing extended-radio\">\r\n" +
						"			<li class=\"has-core\">Extended data</li>\r\n" +
						"		</ul>\r\n" +
						"	</div>\r\n" +
						"	<div class=\"col-md-3\">\r\n" +
						"	</div>\r\n" +
						"</div>\r\n"

		);
		return this;
	}

	private FormsGenerator минус_документ(Integer index) {
		if (index == PART_5) {
			int start = документ.indexOf("Next");
			int end = start + "Next".length();
			документ = документ.replace(start, end, "Finish");
		}
		java_script.append("minimum_part_filled_out();\r\n");
		документ.append(
				"      </div>\r\n" +
						"    </div>\r\n" +
						"  </div>\r\n" +
						"</div>\r\n" +
						"\r\n" +
						java_script.toString() +
						"    } __main__(); \r\n");
		for (String imja_elementa : active_keys) {
			документ.append("$('#" + imja_elementa + ",input[name=\"" + imja_elementa + "\"]').on('change', function() {"
					+ map_for_java_script.get(imja_elementa)
					+ "});\r\n");

//			документ.append("$('#" + imja_elementa + ",input[name=\"" + imja_elementa + "\"]').on('change', function() {"
//			+ "__main__();"
//			+ "});\r\n");
		}
		документ.append(
				"\r\n</script>\r\n");
		if (index == PART_2 && false)
			документ.append("<script>\r\n" +
					"    let changeThis = () => {\r\n" +
					"        f = document.getElementById('2ap');\r\n" +
					"        for(let i=0; i< f.length; i++){\r\n" +
					"            console.log(\"Selected?\");\r\n" +
					"            console.log(f[i]);\r\n" +
					"            if (!f[i].selected){\r\n" +
					"                console.log(\"thees\" + i + \"=>\" + f[i].selected);\r\n" +
					"                console.log(\"thees\" + i + \"=>\" + f[i].text);\r\n" +
					"                let className = document.getElementsByClassName(`${f[i].text}`);\r\n" +
					"                console.log(\"Toggled the class isSelected: \" + className);\r\n" +
					"                console.log(\"Toggled the class isSelected: \" + className.selected);\r\n" +
					"                console.log(\"Toggled the class isSelected: \" + $(className).selected);\r\n" +
					"                $(className).toggle(false);\r\n" +
					"                console.log(\"Toggled the class isSelected: \" + $(className).toggle(false));\r\n" +
					"                console.log(\"Toggled the class: \" + className);\r\n" +
					"                childNodes = document.getElementsByClassName(`${f[i].text}`);\r\n" +
					"                console.log(\"gotNode: \" + childNodes);\r\n" +
					"                for(let j=0; j<childNodes.length; j++){\r\n" +
					"                    console.log(childNodes[j])\r\n" +
					"                    childNodes[j].selected = false;\r\n" +
					"                }\r\n" +
					"            }\r\n" +
					"            if (f[i].selected){\r\n" +
					"                console.log(\"thees\" + i + \"=>\" + f[i].selected);\r\n" +
					"                let className = `.${f[i].text}`;\r\n" +
					"                let elementName = document.getElementsByClassName(`${f[i].text}`);\r\n" +
					"                console.log(\"Toggling true:\" + className);\r\n" +
					"                console.log($(className).toggle(true));\r\n" +
					"            }\r\n" +
					"        }\r\n" +
					"    };\r\n" +
					"    $(document).ready(function(){\r\n" +
					"        document.forms[0].originalSubmit = document.forms[0].submit;\r\n" +
					"        $('.onlyForm').submit((e) => {\r\n" +
					"            var elementalList = getElementList();\r\n" +
					"            e.preventDefault();\r\n" +
					"            var formId = `${document.forms[0].id}`;\r\n" +
					"            console.log(\"Hitting: \" + JSON.stringify(elementalList));\r\n" +
					"            $.ajax({\r\n" +
					"                url: '/api/drogs/children/addToForm/' + formId,\r\n" +
					"                type: \"POST\",\r\n" +
					"                dataType: 'json',\r\n" +
					"                contentType: 'application/json',\r\n" +
					"                data: JSON.stringify(elementalList),\r\n" +
					"                success: function(response){\r\n" +
					"                    console.log(response);\r\n" +
					"					 document.forms[0].originalSubmit();\r\n" +
					"                }\r\n" +
					"            });\r\n" +
					"        })\r\n" +
					"        var selectedChildren = $('.selectedDrogsChildren').children();\r\n" +
					"        console.log(selectedChildren.length);\r\n" +
					"        var kindList = [];\r\n" +
					"        if(selectedChildren.length > 0){\r\n" +
					"            selectedChildren.each(function(childIndex){\r\n" +
					"                var childText = $(selectedChildren[childIndex]).text();\r\n" +
//			"                var ap = $(`#${childText}`);\r\n" +
//			"                var apMap = ap.attr('class');\r\n" +
					"                var apMap = childText;\r\n" +
					"                console.log($.inArray(apMap, kindList));\r\n" +
					"                if($.inArray(apMap, kindList) === -1){\r\n" +
					"                    kindList.push(apMap);\r\n" +
					"                }\r\n" +
					"            })\r\n" +
					"            $.map(kindList, function(element){\r\n" +
					"                classNameFromElement = `.${element}`;\r\n" +
					"                $(classNameFromElement).toggle(true);\r\n" +
					"                idNameFromElement = `#${element}`;\r\n" +
					"                $(idNameFromElement).attr('selected', true);\r\n" +
					"            });\r\n" +
					"            selectedChildren.each(function(index){\r\n" +
					"                var indexElementText = $(selectedChildren[index]).text();\r\n" +
					"                $(`#${indexElementText}`).attr('selected', true);\r\n" +
					"            });\r\n" +
					"            console.log(\"Made:\" + kindList);\r\n" +
					"        }\r\n" +
					"    })\r\n" +
					"    let getElementList = () => {\r\n" +
					"        targetElement = document.getElementById('genotyp_detail_mutation');\r\n" +
					"        elementListForUpdate = [];\r\n" +
					"        for (let i=0; i < targetElement.length; i++) {\r\n" +
					"            if(targetElement[i].selected){\r\n" +
					"                elementListForUpdate.push(targetElement[i].text);\r\n" +
					"            }\r\n" +
					"        }\r\n" +
					"        console.log(\"Hitting: \" + JSON.stringify(elementListForUpdate));\r\n" +
					"        return elementListForUpdate;\r\n" +
					"    }\r\n" +
					"</script>\r\n");
		документ.append(
				"</body>\r\n" +
						"</html>");
		return this;
	}

	int[] line_no = new int[1];
	Map<Integer, Map<String, String>> буффер = new TreeMap<Integer, Map<String, String>>();
	Map<String, TreeMap<Integer, Map<String, String>>> __буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
	Map<String, TreeMap<Integer, Map<String, String>>> буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
	Map<String, Integer> буффер_для_колличества_повторений = new TreeMap<String, Integer>();

	//здесь жикла массив только потому, что он иначе не работает в лямде ато 'то могла быть и переменная
	List<Map<Integer, Map<String, String>>> цикл = new ArrayList<Map<Integer, Map<String, String>>>();

	final String имя_цикла[] = new String[1];
	Function<Map<String, String>, Map<String, String>> переводчик = (строка) -> {
		System.out.println(++line_no[0]);

		do
			if (строка != null) {
				//смотрим есть ли активный цыкл
				TreeMap<Integer,Map<String,String>> карта_цикла;
				Integer колличество_повторений;

				if (буффер_для_повторения == __буффер_для_повторения) {
					карта_цикла = буффер_для_повторения.get(имя_цикла[0]);
					колличество_повторений = буффер_для_колличества_повторений.get(имя_цикла[0]);

					//то нет активных цыклов
					System.out.println("имя_цикла[0] " +  имя_цикла[0]);
					while (колличество_повторений != null && колличество_повторений != 0) {
						колличество_повторений -= 1;
						буффер_для_колличества_повторений.put(имя_цикла[0], колличество_повторений);
						Iterator<Integer> iterator = карта_цикла.keySet().iterator();
						while(iterator.hasNext()) {
							цикл.add(карта_цикла);
							Integer next = iterator.next();
							строка = карта_цикла.get(next);
							рисовать_строку(строка);
						}
					}
					//сброс цикла
					буффер_для_колличества_повторений.put(имя_цикла[0], 0);
					__буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
				} else {
					рисовать_строку(строка);
				}
			}
		while (буффер_для_повторения == __буффер_для_повторения);
		return строка;
	};

	int[] _сумма_размеров = new int[1];
	private void рисовать_строку(Map<String, String> строка) {
		List<Map<String, String>> _с = new ArrayList<Map<String, String>>();
		_с.add(строка);

		строка.entrySet().stream().forEach((es) -> {
			String ключ = es.getKey();
			String значение = es.getValue();

			значение = StringUtils.trim(значение);
			Map<String, String> _строка = _с.get(0);

			if (_строка.get("part no") != null && !part_names.contains(_строка.get("part no"))) {
				if (part_names.size() == 0) плюс_форма("/medicalquestionary");
				part_names.add(_строка.get("part no"));
				плюс_название(_строка.get("part no"));
			}

			String текст = _строка.get("question/headline");
			int размер_поля = NumberUtils.isParsable(_строка.get("size")) ? Double.valueOf(_строка.get("size")).intValue() : 12;
			String идентификатор = _строка.get("variable name (short and concise, no spaces)");
			String values = _строка.get("values (e. g. yes=1, no=0)");
			String ограничения = _строка.get("restrictions");
			String условие = _строка.get("condition");
			String dataset = _строка.get("dataset (minimal, core, extended)");
			boolean активний = false; //активние_клучи.contains(идентификатор);

			Integer номер_повторения = null;

			if (буффер_для_повторения == __буффер_для_повторения) {
				номер_повторения = буффер_для_колличества_повторений.get(имя_цикла[0]);
				идентификатор += номер_повторения;
			}

			if (ключ.startsWith("field type")) {
				if(ограничения != null) {
					String[] split = ограничения.split("\\s+");
					if (split.length > 1 && split[1].startsWith("characters")) {
						ограничения = " maxlength='" + split[0] + "'";
					} else ограничения = "";
				} else {
					ограничения = "";
				}

				if (_сумма_размеров[0] == 12 || _сумма_размеров[0] == 0) {
					if (_сумма_размеров[0] != 0) минус_строка();
					плюс_строка();
					_сумма_размеров[0] = 0;
				}
				_сумма_размеров[0] =+ размер_поля;

				имя_цикла[0] = null;
				ImmutableTriple<String, String, String> __параметры = null;

				if (условие != null)
					for (String под_условие : условие.split(";")) {

						if (StringUtils.countMatches(под_условие, "display only if") == 1) {
							java_script.append("//begin " + идентификатор + "\r\n");
							java_script.append("//condition " + под_условие + "\r\n");
							if (StringUtils.countMatches(под_условие, "\"") == 4 || StringUtils.countMatches(под_условие, "\"") == 6) {
								ImmutableTriple<String, String, String> параметры =
										StringUtils.countMatches(под_условие, "\"") == 4 ?
												ImmutableTriple.of(под_условие.split("\"")[1], 	null, под_условие.split("\"")[3]) :
												ImmutableTriple.of(под_условие.split("\"")[1], под_условие.split("\"")[3], под_условие.split("\"")[5]);

								active_keys.add(параметры.getRight());

								//если есть цикл поклучить его имя
								for (String под_условие1 : условие.split(";")) {
									if (StringUtils.countMatches(под_условие1, "display as many") == 1) {
										try {
											имя_цикла[0] = под_условие1.split("display as many")[1].trim().split("\"")[1];
										} catch (Exception ex) {
											System.out.println("ошибка при чтение значений. display as many fields as selected " + под_условие);
										}
										break;
									}
								}

								StringBuilder под_ява_скрипт = new StringBuilder();
								//для под функций
								StringBuilder a1 = map_for_java_script.getOrDefault(параметры.getRight(), new StringBuilder());
								map_for_java_script.put(параметры.getRight(), a1);
								создать_скрипт_ява(a1, идентификатор, номер_повторения, под_условие, параметры);
								if (имя_цикла[0] != null) {
									StringBuilder a2 = map_for_java_script.getOrDefault(имя_цикла[0], new StringBuilder());
									map_for_java_script.put(имя_цикла[0], a2);
									создать_скрипт_ява(a2,
											идентификатор, номер_повторения, под_условие, параметры);
								}
								//для основной функции
								создать_скрипт_ява(java_script, идентификатор, номер_повторения, под_условие, параметры);




							}
//							if (StringUtils.countMatches(под_условие, "\"") == 6) {
//								ImmutableTriple<String, String, String> параметры = ImmutableTriple.of(под_условие.split("\"")[1], под_условие.split("\"")[3], под_условие.split("\"")[5]);
//								if (StringUtils.countMatches(под_условие, "or") > 0)
//									if (NumberUtils.isDigits(параметры.getLeft())) {
//										ява_скрипт.append(
//											"if ($('#" + параметры.getRight() + "').is(\':visible\')) { if ($('#" + параметры.getRight() + "').val() == " + параметры.getLeft() + " || " + "$('#" + параметры.getRight() + "').val() == " + параметры.getMiddle() + ")  " + кусок + "} else " + кусок2 + " \r\n"
//										);
//										ява_скрипт.append(
//											"if ($('#" + параметры.getRight() + "').is(\':visible\')) { if ($('#" + параметры.getRight() + "').val() == " + параметры.getLeft() + " || " + "$('#" + параметры.getRight() + "').val() == " + параметры.getMiddle() + ")  " + кусок + "} else " + кусок2 + " \r\n"
//										);
//									} else {
//										ява_скрипт.append(
//											"if ($('#" + параметры.getRight() + "').is(\':visible\')) { if ($('#" + параметры.getRight() + "').val() == '" + параметры.getLeft() + "' || " + "$('#" + параметры.getRight() + "').val() == '" + параметры.getMiddle() + "')  " + кусок + "} else " + кусок2 + " \r\n"
//										);
//										ява_скрипт.append(
//												"if ($('#" + параметры.getRight() + "').is(\':visible\')) { if ($('#" + параметры.getRight() + "').val() == '" + параметры.getLeft() + "' || " + "$('#" + параметры.getRight() + "').val() == '" + параметры.getMiddle() + "')  " + кусок + "} else " + кусок2 + " \r\n"
//										);
//									}
//							}
							java_script.append("//end " + идентификатор + "\r\n");
						} else if (StringUtils.countMatches(под_условие, "display as many") == 1) {
							try {
								имя_цикла[0] = под_условие.split("display as many")[1].trim().split("\"")[1];

								active_keys.add(имя_цикла[0]);

								TreeMap<Integer,Map<String,String>> блок_повторений = __буффер_для_повторения.getOrDefault(имя_цикла[0], new TreeMap<Integer, Map<String, String>>());
								if (буффер_для_повторения != __буффер_для_повторения) {
									блок_повторений.put(line_no[0], _строка);
									__буффер_для_повторения.put(имя_цикла[0], блок_повторений);
								}
							} catch (Exception ex) {
								System.out.println("ошибка при чтение значений. display as many fields as selected " + под_условие);
							}
						} else if (StringUtils.countMatches(под_условие, "for(") == 1 && (буффер_для_повторения != __буффер_для_повторения)) {
							try {
								буффер_для_колличества_повторений.put(имя_цикла[0], Integer.valueOf(под_условие.split("for\\(")[1].split("\\)")[0].trim()));
								буффер_для_повторения = __буффер_для_повторения;
							} catch (Exception ex1) {
								System.out.println("ошибка при for цикла " + под_условие);
								System.out.println("ошибка при чтение значений. for(: " + под_условие);
							}
						}
					}


				if (значение.startsWith("text")) {
					плюс("text", размер_поля, активний, идентификатор, текст, ограничения, dataset);
				} else if (значение.startsWith("dropdown for month/date/year")) {
					плюс("date", размер_поля, активний, идентификатор, текст, ограничения, dataset);
				} else if (значение.startsWith("dropdown for: American Indian/ Alaska Native; Arab; Asian; Black or African American; Hispanic/ Latino; Jewish (Ashkenazi); Jewish (non-Ashkenazi); Native Hawaiian/ Other Pacific Islander; White/ European/ Caucasian; Other; Unknown")) {
					плюс_список2(размер_поля, активний, идентификатор, текст, Arrays.asList("-","American Indian/ Alaska Native","Arab","Asian","Black or African American","Hispanic/ Latino","Jewish (Ashkenazi)","Jewish (non-Ashkenazi)","Native Hawaiian/ Other Pacific Islander","White/ European/ Caucasian","Other","Unknown"), dataset);
				} else if (значение.startsWith("dropdown for: Chinese; Indian; Filipino; Japanese; Korean; Malay; Central Asian; Other")) {
					плюс_список2(размер_поля, активний, идентификатор, текст, Arrays.asList("-","Chinese", "Indian", "Filipino", "Japanese", "Korean", "Malay", "Central Asian", "Other"), dataset);
				} else if (значение.startsWith("dropdown for: ")) {
					плюс_список2(размер_поля, активний, идентификатор, текст, Arrays.asList(значение.substring("dropdown for: ".length()).split(";")), dataset);
				} else if (значение.startsWith("(dropdown list - use Survey/World Bank listing of countries, categorized by income)")) {
					TreeSet<String> treeSet = new TreeSet<String>(all_countries_by_name().keySet());
					List<String> страны = new ArrayList<>();
					страны.add("-");
					for (String s : treeSet) {
						страны.add(s);
					}
					плюс_список2(размер_поля, активний, идентификатор, текст, страны, dataset);
				} else if (значение.startsWith("multi select")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс_список(размер_поля, активний, идентификатор, текст, значения, true, dataset);
				} else if (значение.startsWith("single select")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс("radio", размер_поля, активний, идентификатор, текст, значения, dataset);
				} else if (значение.startsWith("numbers")) {
					плюс("number", размер_поля, активний, идентификатор, текст, ограничения, dataset);
				} else if (значение.startsWith("checkbox (multi select)")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс("checkbox", размер_поля, активний, идентификатор, текст, значения, dataset);
				} else if (значение.startsWith("dropdown for month/year")) {
					плюс("month", размер_поля, активний, идентификатор, текст, ограничения, dataset);
				} else if (значение.startsWith("[Provide dropdown list as per Survey platform]")) { //Or allow upload of report, without patient-identifying details"
					плюс_список_mjff(текст, идентификатор + "_drog", идентификатор + "_mutation", dataset);
				} else if (значение.startsWith("headline")) {
					плюс_загаловок(идентификатор, размер_поля, текст, dataset);
				} else if (значение.startsWith("dropdown (1-30)")) {
					плюс_список(размер_поля, активний, идентификатор, текст, 1, 30, dataset);
				} else if (значение.startsWith("dropdown (1-5)")) {
					плюс_список(размер_поля, активний, идентификатор, текст, 1, 5, dataset);
				} else if (значение.startsWith("dropdownr")) {
					List<String> список = new ArrayList<String>();
					Arrays.asList(значение.substring("dropdownr:".length()).split(";")).forEach(_s -> {
						if (_s.trim().startsWith("(")) {
							String[] range = _s.split("\\(")[1].split("\\)")[0].split("\\-");
							if (Integer.valueOf(range[0].trim()) < Integer.valueOf(range[1].trim()))
								for (int i=Integer.valueOf(range[0].trim()); i <= Integer.valueOf(range[1].trim()); i++) {
									список.add(String.valueOf(i));
								}
							else
								for (int i=Integer.valueOf(range[0].trim()); i >= Integer.valueOf(range[1].trim()); i--) {
									список.add(String.valueOf(i));
								}
						} else {
							список.add(_s.trim());
						}
					});
					плюс_список2(размер_поля, активний, идентификатор, текст, список, dataset);
				} else if (значение.startsWith("dropdown (list of countries)")) {
					TreeSet<String> treeSet1 = new TreeSet<String>(all_countries_by_name().keySet());
					List<String> страны = new ArrayList<>();
					страны.add("-");
					for (String s : treeSet1) {
						страны.add(s);
					}
					плюс_список2(размер_поля, активний, идентификатор, текст, страны, dataset);
				} else if (значение.startsWith("dropdown")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс_список(размер_поля, активний, идентификатор, текст, значения, false, dataset);
				} else if (значение.startsWith("checkboxes(multi select)")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс("checkbox", размер_поля, активний, идентификатор, текст, значения, dataset);
				} else if (значение.startsWith("number")) {
					плюс("number", размер_поля, активний, идентификатор, текст, ограничения, dataset);
				} else if (значение.startsWith("dropdown (single select)")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс_список(размер_поля, активний, идентификатор, текст, значения, false, dataset);
				} else if (значение.startsWith("multi select")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс_список(размер_поля, активний, идентификатор, текст, значения, true, dataset);
				} else if (значение.startsWith("checkbox")) {
					List<String[]> значения = прочитать_значения_в_список(values);
					плюс("checkbox", размер_поля, активний, идентификатор, текст, значения, dataset);
				} else if (значение.startsWith("headlnie")) {
					плюс_загаловок(идентификатор, размер_поля, текст, dataset);
				} else {
					System.out.println("Значение не известно:" + значение);
				}

			}
		});



	}

	private void плюс_метод_пост() {
	}

	private void минус_метод_пост(String имя_метода, String имя_класса) {
		String post_method =
				"		@PostMapping(\"/"  + имя_метода + "/{surveyTwoId}\")\r\n" +
						"		public String "  + имя_метода + "(@PathVariable(\"surveyTwoId\") String surveyTwoId, @ModelAttribute(\"formObj\") FormObj formObj, ModelMap map) {\r\n" +
						"			if (!StringUtils.isEmpty(surveyTwoId)) {\r\n" +
						"				" + имя_класса + " данные_для_заполнения = formObjSurvey22222DAO.findBySurveyTwoId(surveyTwoId);\r\n" +
						"				formObj.setId(данные_для_заполнения.getId());\r\n" +
						"				formObjSurvey22222DAO.save(formObj);\r\n" +
						"			}\r\n" +
						"			map.addAttribute(\"collected\", \"Your data has been saved.\");\r\n" +
						"			return \"" + имя_метода + "\";\r\n" +
						"		}\r\n" +
						"		";
		System.out.println(post_method);
	}

	private void плюс_метод_гет() {
	}

	private void минус_метод_гет(String имя_метода, String имя_класса) {
		String get_method =
				"		@GetMapping(\"/"  + имя_метода + "/{surveyTwoId}\")\r\n" +
						"		public String "  + имя_метода + "(@PathVariable(\"surveyTwoId\") String surveyTwoId, ModelMap map) {\r\n" +
						"			if (!StringUtils.isEmpty(surveyTwoId)) {\r\n" +
						"				" + имя_класса + " данные_для_заполнения = formObjSurvey22222DAO.findBySurveyTwoId(surveyTwoId);\r\n" +
						"				map.addAttribute(\"formObj\", данные_для_заполнения);\r\n" +
						"			}\r\n" +
						"			return \""  + имя_метода + "\";\r\n" +
						"		}\r\n";
		System.out.println(get_method);
	}

	StringBuilder база_данних = new StringBuilder();

	private void плюс_таблица(String идентификатор, String имя_таблиц) {
		String create_table_seq = "-- Sequence: " + имя_таблиц + "_id_seq\r\n" +
				"-- DROP SEQUENCE " + имя_таблиц + "_id_seq;\r\n" +
				"		CREATE SEQUENCE " + имя_таблиц + "_id_seq\r\n" +
				"		  INCREMENT 1\r\n" +
				"		  MINVALUE 1\r\n" +
				"		  MAXVALUE 9223372036854775807\r\n" +
				"		  START 1\r\n" +
				"		  CACHE 1;\r\n" +
				"		ALTER TABLE " + имя_таблиц + "_id_seq\r\n" +
				"		  OWNER TO postgres;";
		String create_table_start = "-- Table: " + имя_таблиц + "\r\n" +
				"-- DROP TABLE " + имя_таблиц + ";" + "\r\n" +
				"CREATE TABLE " + имя_таблиц + "\r\n" +
				"(" + "\r\n" +
				"  survey_two_id character varying(50),\r\n";
		if (база_данних.indexOf(create_table_start) == -1) {
			база_данних.append(create_table_seq);
			база_данних.append(create_table_start);
		}
		идентификатор = идентификатор +  " character varying(128),\r\n";
		база_данних.append(идентификатор);
	}

	StringBuilder класс_для_таблицъ = new StringBuilder();
	private void плюс_класс_для_таблицъ(String идентификатор, String имя_таблиц, String имя_класса, Integer index) {
		String класс_для_связи_с_базой = "@Caption(\"{%title}\")\r\n" +
				"@Entity\r\n" +
				"@Table(name = \"" + имя_таблиц + "\", schema = \"public\", uniqueConstraints = @UniqueConstraint(columnNames = \"survey_two_id\"))\r\n" +
				"@Cacheable(false)\r\n" +
				"public class " + имя_класса + " implements java.io.Serializable {\r\n" +
				"	private int id;\r\n" +
				"\r\n" +
				"	public " + имя_класса +"() {\r\n" +
				"	}\r\n" +
				"	\r\n" +
				"	@Id\r\n" +
				"\r\n" +
				"    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator=\"" + имя_таблиц + "_id_seq\")\r\n" +
				"    @SequenceGenerator(name=\"" + имя_таблиц + "_id_seq\", sequenceName=\"" + имя_таблиц + "_id_seq\", allocationSize=1)\r\n" +
				"	@Column(name = \"id\", unique = true, nullable = false, columnDefinition = \"serial\")\r\n" +
				"	public int getId() {\r\n" +
				"		return this.id;\r\n" +
				"	}\r\n" +
				"\r\n" +
				"	public void setId(int id) {\r\n" +
				"		this.id = id;\r\n" +
				"	}\r\n" +
				"	\r\n" +
				"	    private UserEntityModel userEntityModel;\r\n" +
				"\r\n" +
				"	    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserEntityModel.class)\r\n" +
				"	    @JoinColumn(name = \"user_id\")\r\n" +
				"		public UserEntityModel getUserEntityModel() {\r\n" +
				"			return userEntityModel;\r\n" +
				"		}\r\n" +
				"\r\n" +
				"		public void setUserEntityModel(UserEntityModel userEntityModel) {\r\n" +
				"			this.userEntityModel = userEntityModel;\r\n" +
				"		}\r\n" +
				"\r\n";
		if (index == 1) {
			класс_для_связи_с_базой +=
					"	private String ecrfStatus;\r\n" +
							"\r\n" +
							"	@Column(name = \"ecrf_status\", nullable = true, columnDefinition = \"varchar\", length = 128)\r\n" +
							"	public String getEcrfStatus() {\r\n" +
							"		return ecrfStatus;\r\n" +
							"	}\r\n" +
							"\r\n" +
							"	public void setEcrfStatus(String ecrfStatus) {\r\n" +
							"		this.ecrfStatus = ecrfStatus;\r\n" +
							"	}\r\n" +
							"\r\n" +
							"	private Date createdAt;\r\n" +
							"\r\n" +
							"	@Temporal(TemporalType.TIMESTAMP)\r\n" +
							"	@Column(name = \"created_at\", nullable = false, columnDefinition = \"timestamp\", length = 29)\r\n" +
							"	public Date getCreatedAt() {\r\n" +
							"		return this.createdAt;\r\n" +
							"	}\r\n" +
							"\r\n" +
							"	public void setCreatedAt(Date createdAt) {\r\n" +
							"		this.createdAt = createdAt;\r\n" +
							"	}\r\n" +
							"\r\n" +
							"";
		}

		if (класс_для_таблицъ.indexOf(класс_для_связи_с_базой) == -1) {
			класс_для_таблицъ.append(класс_для_связи_с_базой);
			класс_для_таблицъ.append(колонка_для_значения("survey_two_id"));
		}
		идентификатор = колонка_для_значения(идентификатор);
		класс_для_таблицъ.append(идентификатор);
	}

	private String колонка_для_значения(String идентификатор) {
		идентификатор =
				"	private String " + идентификатор + ";\r\n" +
						"\r\n" +
						"	@Column(name = \"" + идентификатор + "\", nullable = true, columnDefinition = \"varchar\", length = 128)\r\n" +
						"	public String get" + humanize(идентификатор) + "() {\r\n" +
						"		return this."  + идентификатор + ";\r\n" +
						"	}\r\n" +
						"\r\n" +
						"	public void set" + humanize(идентификатор) + "(String " +  идентификатор + ") {\r\n" +
						"		this." + идентификатор + " = " + идентификатор + ";\r\n" +
						"	}\r\n";
		return идентификатор;
	}

	private String humanize(String идентификатор) {
		return Arrays.asList(идентификатор.split("_")).stream().map(a -> (a.charAt(0) + "").toUpperCase() + a.substring(1)).collect(Collectors.joining());
	}

	private String humanize_add_to_db(String идентификатор) {
		all_identifier_for_db.add(идентификатор);
		return Arrays.asList(идентификатор.split("_")).stream().map(a -> (a.charAt(0) + "").toUpperCase() + a.substring(1)).collect(Collectors.joining());
	}

	private void минус_класс_для_таблицъ() {
		класс_для_таблицъ.append("}\r\n");
		System.out.println(класс_для_таблицъ);
	}

	private void минус_таблица(String имя_таблиц) {
		String create_table_end =
				"id integer NOT NULL DEFAULT nextval('" + имя_таблиц + "_id_seq'::regclass)"  + "\r\n" +
						") \r\n" +
						"WITH ( \r\n" +
						"  OIDS=FALSE \r\n" +
						"); \r\n" +
						"ALTER TABLE " + имя_таблиц + " \r\n" +
						"  OWNER TO postgres;";

		база_данних.append(create_table_end);
		System.out.println(база_данних);
	}

	private void создать_скрипт_ява(StringBuilder ява_скрипт, String идентификатор, Integer номер_повторения, String под_условие,
									ImmutableTriple<String, String, String> параметры) {
		//ява_скрипт.append("if ($('#" + имя_цикла[0] + "').val() == ) {");
		ява_скрипт.append(
				//проверяем является ли данный параметер последовательность чек боксов или радио баттонов //здесь так написано потому что & не поддерживается
				"if (length(\"" + параметры.getRight() + "\") > 0 ? isvisible(\"" + параметры.getRight() + "\", true) : false )  \r\n" //
						//								  "if ($('input[name=\"" + параметры.getRight() + "\"]').length > 0 ? isvisible($('input[name=\"" + параметры.getRight() + "\"]')) : false ) " //
						+ "{ "
						+ (StringUtils.countMatches(под_условие, "\"") == 4 ?
						"if (check(\"" + параметры.getRight() + "\",\"" + параметры.getLeft() + "\"))  \r\n" :
						"if (check(\"" + параметры.getRight() + "\",\"" + параметры.getLeft() + "\") || check(\"" + параметры.getRight() + "\",\"" + параметры.getMiddle() + "\"))  \r\n")
						+ " show(\"" + идентификатор + "\",true,\"" + имя_цикла[0] + "\"," + номер_повторения + ");  \r\n"
						+ "else hide(\"" + идентификатор + "\",true);  \r\n" +
						//										+ " show($('#" + идентификатор + ",input[name=\"" + идентификатор + "\"]'));"
						//									 + " else hide($('#" + идентификатор + ",input[name=\"" + идентификатор + "\"]')); " +
						"} else { \r\n"
		);
		ява_скрипт.append(
				"if (isvisible2(\"" + параметры.getRight() + "\", false)) { \r\n "
						//											"if (isvisible($('#" + параметры.getRight() + "'))) { "
						+ (StringUtils.countMatches(под_условие, "\"") == 4 ?
						"if (check2(\"" + параметры.getRight() + "\",\"" + параметры.getLeft() + "\")) \r\n " :
						"if (check2(\"" + параметры.getRight() + "\",\"" + параметры.getLeft() + "\") || check2(\"" + параметры.getRight() + "\",\"" + параметры.getMiddle() + "\")) \r\n ")
						+ " show(\"" + идентификатор + "\",false,\"" + имя_цикла[0] + "\"," + номер_повторения + "); \r\n "
						+ "else  hide(\"" + идентификатор + "\",false); \r\n "
						//													+ " show($('#" + идентификатор + ",input[name=\"" + идентификатор + "\"]')); "
						//												+ "else hide($('#" + идентификатор + ",input[name=\"" + идентификатор + "\"]')); "
						+ " } else hide(\"" + идентификатор + "\",false); \r\n"
						//											+ " } else hide($('#" + идентификатор + ",input[name=\"" + идентификатор + "\"]')); \r\n"
						+ " } \r\n"/* +
											 "  if ($('label[namelabel=\"" + идентификатор + "\"]').length > 0)  \r\n" +
											 "  if ($('label[namelabel=\"" + идентификатор + "\"]').siblings().next().is(\':visible\')) "
										 	  + "$('label[namelabel=\"" + идентификатор + "\"]').show(); "
										 	  + "else $('label[namelabel=\"" + идентификатор + "\"]').hide(); "*/
		);
		//ява_скрипт.append("}");
	}


	/**
	 * @param values
	 * @param
	 * @return
	 */
	private List<String[]> прочитать_значения_в_список(String values) {
		List<String[]> значения = new ArrayList<>();
		if (values == null) {
			System.out.println("ошибка при чтение значений.");
		} else
			for (String s : values.split(";")) {
				String[] split = s.split("=");
				if (split.length > 1) {
					значения.add(new String[] {split[0], split[1]});
				} else {
					System.out.println("ошибка при чтение значений.");
				}
			}
		return значения;
	}
	/**
	 * read the excel file from the specific sheet index, started from titleLine
	 * @param pathname TODO
	 * @param nullAllowed
	 * @param nullAllowed TODO
	 * @param строка_названий TODO
	 * @param переводчик TODO
	 * @return two dimensional array with the data from the excel file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Map<String, String>> прочитать_ексел_файл(File pathname, boolean nullAllowed, int строка_названий, Function<Map<String, String>, Map<String, String>> переводчик, BiFunction<String, String, Object> процессор) throws Exception {
		//читаем первую вкладку в файле
		FileInputStream fis;
		fis = new FileInputStream(pathname);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);

		List<Map<String, String>> result = new ArrayList<>();

		for (int i = строка_названий+1; i <= ws.getLastRowNum(); i++) {
			//for (int i = строка_названий+1+2020; i <= 2050; i++) {
			Map<String, String> строка = new HashMap<>();
			for (int j = 0; j <= ws.getRow(строка_названий).getLastCellNum() - 1; j++) {
				if (ws.getRow(i) == null) continue;
				String ключ   = readParam(ws, строка_названий, j);
				String значение = readParam(ws, i, j);
				if (nullAllowed && N_G.equals(значение)) значение = null;
				if ("disease_abbrev".equals(ключ) && (N_G.equals(значение) || значение == null)) {
					строка.put(StringUtils.lowerCase(StringUtils.trim(ключ)), "UNKNOWN");
				} else if (StringUtils.startsWith(ключ, "initial_sympt")) {
					строка.put(StringUtils.lowerCase(StringUtils.trim(ключ)), StringUtils.lowerCase(StringUtils.trim(значение)));
				} else {
					if (!(StringUtils.isBlank(значение) || StringUtils.isBlank(ключ) || Pattern.compile("(?i)^\\s*(n\\.a\\.|-99(\\.0+)?)\\s*$").matcher(значение).matches())) {
						//if (NumberUtils.isNumber(значение)) значение = значение.replace('.', ',');
						строка.put(StringUtils.lowerCase(StringUtils.trim(ключ)), значение);
					}
				}
				if (процессор != null) процессор.apply(StringUtils.lowerCase(StringUtils.trim(ключ)), значение);
			}
			if (переводчик != null) строка = переводчик.apply(строка);
			result.add(строка);
		}
		wb.close();

		return result;
	}

	/**
	 * return value of the specific cell of the working sheet
	 * @param ws -  working sheet
	 * @param i - row index
	 * @param j - column index
	 * @return string representation of the cell value
	 */
	private String readParam(XSSFSheet ws, int i, int j) {
		if (ws.getRow(i).getCell(j) == null) return N_G;
		String param = null;
		switch (ws.getRow(i).getCell(j).getCellType()) {
			case FORMULA:
				try {
					param = String.valueOf(ws.getRow(i).getCell(j).getNumericCellValue());
				} catch (Exception ex) {
					try {
						param = ws.getRow(i).getCell(j).getStringCellValue();
					} catch (Exception ex1) {

					}
				}
				break;
			case STRING:
				param = ws.getRow(i).getCell(j).getStringCellValue();
				break;
			case NUMERIC:
				param = String.valueOf(ws.getRow(i).getCell(j).getNumericCellValue());
				if (j == 0) {// this logic is added for "id" column
					param = String.valueOf(new BigDecimal(param).intValue());
				}
				break;
			default:
				break;
		}
		//param = param == null || param.startsWith("-99") ? N_G : param.split("\\.")[0];
		param = param == null || param.startsWith("-99") ? N_G : param;
		return param;
	}

	private FormsGenerator плюс_список_mjff(String текст, String идентификатор1, String идентификатор2, String dataset) {
		документ.append(
				"			<div class=\"col-sm-" + 12 + "\">\r\n" +
						"              <div class=\"" + dataset_css("form-group",dataset) + "\" >\r\n" +
						"                <label for=\"sel1\">"  + текст + "</label>\r\n" +
						"              </div>\r\n" +
						"            </div>" +
						"");
		документ.append(
				"			<div class=\"col-sm-" + 1 + "\"><label for=\"2ap\">Gene:</label></div>\r\n");
		документ.append(
				"			<div class=\"col-sm-" + 5 + "\">\r\n");
		документ.append(
				"                <select title=\"Choose one drog...\" class=\"selectpicker form-control chzn_select\" id=\"2ap\" multiple>\r\n" +
						"                    <option th:each=\"map : ${maps}\"  th:id=\"${map.name}\" th:name=\"${map.name}\" th:value=\"${map.name}\" th:text=\"${map.name}\"></option>\r\n" +
						"                </select>\r\n");
		документ.append(
				"            </div>" +
						"");
		документ.append(
				"			<div class=\"col-sm-" + 1 + "\"><label for=\"2ap\">Carrying:</label></div>\r\n");
		документ.append(
				"			<div class=\"col-sm-" + 5 + "\">\r\n");
		документ.append(
				"                <select data-size=\"5\" not-data-actions-box=\"true\" title=\"Choose one carrying...\" name=\"drogsChildren\" data-live-search=\"true\" class=\"selectpicker form-control chzn_select\" id=\"genotyp_detail_mutation\" multiple>\r\n" +
						"                    <div th:each=\"map : ${maps}\">\r\n" +
						"                        <option th:if=\"${child.isActive == false && child.form == null}\"\r\n" +
						"                                th:each=\"child: ${map.children}\"\r\n" +
						"                                th:classappend=\"${(map.name)}\"\r\n" +
						"                                th:name=\"${child.id}\"\r\n" +
						"                                th:value=\"${child.name}\"\r\n" +
						"                                th:text=\"${child.name}\"\r\n" +
						"                                th:id=\"${child.name}\"\r\n" +
						"                                style=\"display:none;\"\r\n" +
						"                        ></option>\r\n" +
						"                    </div>\r\n" +
						"                </select>\r\n");
		документ.append(
				"            </div>" +
						"");
		документ.append(
				"<script>" +
						"$('#genotyp_detail_mutation').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {\r\n" +
						on_change_dataset_js(dataset, false) +
						"saveData()" +
						"});\r\n" +
						"$('#2ap').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {\r\n" +
						"changeThis();" + on_change_dataset_js(dataset, false) +
						"$('#genotyp_detail_mutation').selectpicker('refresh');\r\n" +
						"saveData()" +
						"});\r\n" +
						"</script>");
		return this;
	}

	private String dataset_css(String firstCSSclass, String dataset) {
		if (StringUtils.isBlank(dataset)) return firstCSSclass;
		if (dataset.trim().equalsIgnoreCase("minimal")) return firstCSSclass + " has-minimal";
		if (dataset.trim().equalsIgnoreCase("core")) return firstCSSclass + " has-core";
		return firstCSSclass + " has-extended";
	}

	/**
	 * @Test
	public void test_survey_generation() throws Exception {
	//String pathname = "c:\\published\\Forms_DataDictionary_2020_30_05_LM_JV.xlsx";
	//String pathname = "c:\\published\\Forms_fam_DataDictionary_2020_13_07_LM_JV.xlsx";
	String pathname = "c:\\published\\Forms_DataDictionary_112020_LM.xlsx";
	FileTime lastModifiedTime = Files.getLastModifiedTime(Paths.get(pathname));
	while (true) {
	//		String pathname = "C:\\Users\\agklein\\Desktop\\to-delete\\Kopie von Forms_DataDictionary_2020_30_05_LM_JV_2020_06_23-1.xlsx";
	плюс_документ(null);
	прочитать_ексел_файл(pathname, false, 0, переводчик, процессор);
	for (String идентификатор : все_идентификатор_для_бази) {
	плюс_таблица(идентификатор, имя_таблиц_для_генерации);
	плюс_метод_гет();
	плюс_класс_для_таблицъ(идентификатор, имя_таблиц_для_генерации_класса, имя_класса);
	плюс_метод_пост();
	}
	минус_строка();
	минус_форма();
	минус_документ();
	минус_таблица(имя_таблиц_для_генерации);
	минус_класс_для_таблицъ();
	минус_метод_гет(имя_гет_метода_для_генерации,имя_класса);
	минус_метод_пост(имя_гет_метода_для_генерации,имя_класса);

	try (PrintWriter out = new PrintWriter("C:\\Java\\eclipse-workspace\\survey-admintool\\google-java\\src\\main\\resources\\templates\\ecrf.html")) {
	out.println(документ.toString().replace("<label for=\"sel1\">null</label>", "").replace("<label for=\"sel1\"></label>", "").replace("&", "&amp;"));
	}
	try (PrintWriter out = new PrintWriter("C:\\Java\\eclipse-workspace\\survey-admintool\\google-java\\target\\classes\\templates\\ecrf.html")) {
	out.println(документ.toString().replace("<label for=\"sel1\">null</label>", "").replace("<label for=\"sel1\"></label>", "").replace("&", "&amp;"));
	}
	//			try (PrintWriter out = new PrintWriter("C:\\Java\\servers\\google-java\\target\\classes\\templates\\survey.html")) {
	//			    out.println(документ.toString().replace("<label for=\"sel1\">null</label>", "").replace("<label for=\"sel1\"></label>", "").replace("&", "&amp;").replace("--and--", "&amp;&amp;"));
	//			}
	while (Files.getLastModifiedTime(Paths.get(pathname)).equals(lastModifiedTime)) {
	Thread.sleep(10000);
	}
	lastModifiedTime = Files.getLastModifiedTime(Paths.get(pathname));
	имена_частей = new HashSet<>();
	документ = new StringBuilder();
	ява_скрипт = new StringBuilder("<script  type=\"text/javascript\">\r\n" + "function __main__() {\r\n");
	line_no = new int[1];
	буффер = new TreeMap<Integer, Map<String, String>>();
	__буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
	буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
	буффер_для_колличества_повторений = new TreeMap<String, Integer>();
	_сумма_размеров[0] = 0;
	активние_клучи = new HashSet<>();
	под_ява_скрипт_мап = new HashMap<>();
	база_данних = new StringBuilder();
	класс_для_таблицъ = new StringBuilder();
	все_идентификатор_для_бази = new TreeSet<String>();
	}
	}
	 **/

//	/**
//	 * @param index
//	 */
//	public void ecrf_thread(int index) {
//		System.out.println("Sarted  eCRF " + index + " therad");
//		Runnable task = () -> {
//			try {
//				ecrf_generation(index);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		};
//
//		Thread thread = new Thread(task);
//		thread.start();
//
//		System.out.println("Done!");
//	}
//
	public void ecrf_generation(Integer index, boolean keep_run, File pathname, String outputFolder) throws Exception {
//		FileTime lastModifiedTime = Files.getLastModifiedTime(Paths.get(pathname));

			//		String pathname = "C:\\Users\\agklein\\Desktop\\to-delete\\Kopie von Forms_DataDictionary_2020_30_05_LM_JV_2020_06_23-1.xlsx";
//			плюс_документ(index);
			прочитать_ексел_файл(pathname, false, 0, переводчик, processor);
//			for (String идентификатор : all_identifier_for_db) {
//				плюс_таблица(идентификатор, table_name_to_generate + index);
//				плюс_метод_гет();
//				плюс_класс_для_таблицъ(идентификатор, table_name_to_generate_java_class + index, class_name + index, index);
//				плюс_метод_пост();
//			}
//			минус_строка();
//			минус_форма(index);
//			минус_документ(index);
//			минус_таблица(table_name_to_generate + index);
//			минус_класс_для_таблицъ();
//			минус_метод_гет(name_get_method_for_generation + index, class_name + index);
//			минус_метод_пост(name_get_method_for_generation + index, class_name + index);
//
//			try (PrintWriter out = new PrintWriter(outputFolder + "ecrf" + index + ".html")) {
//				out.println(документ.toString().replace("<label for=\"sel1\">null</label>", "").replace("<label for=\"sel1\"></label>", "").replace("&", "&amp;"));
//			}
//			добавить_функцию_прогресса(outputFolder + "ecrf" + index + ".html");
//
////			if (keep_run)
////				while (Files.getLastModifiedTime(Paths.get(pathname)).equals(lastModifiedTime)) {
////					Thread.sleep(10000);
////				}
////			lastModifiedTime = Files.getLastModifiedTime(Paths.get(pathname));
//			part_names = new HashSet<>();
//			документ = new StringBuilder();
//			java_script = new StringBuilder("<script  type=\"text/javascript\">\r\n" + "function __main__() {\r\n");
//			line_no = new int[1];
//			буффер = new TreeMap<Integer, Map<String, String>>();
//			__буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
//			буффер_для_повторения = new HashMap<String, TreeMap<Integer, Map<String, String>>>();
//			буффер_для_колличества_повторений = new TreeMap<String, Integer>();
//			_сумма_размеров[0] = 0;
//			active_keys = new HashSet<>();
//			map_for_java_script = new HashMap<>();
//			база_данних = new StringBuilder();
//			класс_для_таблицъ = new StringBuilder();
//			if (!keep_run) break;
//		}
	}

	private void добавить_функцию_прогресса(String путь_к_файлу) {
		// TODO Auto-generated method stub
//    	File input = new File(путь_к_файлу);
//    	try {
//			Document doc = Jsoup.parse(input, "UTF-8", "");
//			doc.select(".has-minimal").select("input, select").forEach(action -> {
//				Elements elementsByAttribute = action.getElementsByAttribute("onchange");
//				String _prefix = "";
//				if (elementsByAttribute.size() > 0) {
//					_prefix = elementsByAttribute.get(0).text();
//				}
//				action.attr("onchange", _prefix + ";minimum_part_filled_out();");
//			});
//			try (PrintWriter out = new PrintWriter(путь_к_файлу)) {
//			    out.println(doc.html());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public static Map<String, String> all_countries_by_name() {
		Map<String, String> country = new TreeMap<>();
		country.put("Afghanistan","AFG");
		country.put("Albania","ALB");
		country.put("Algeria","DZA");
		country.put("American Samoa","ASM");
		country.put("Andorra","AND");
		country.put("Angola","AGO");
		country.put("Anguilla","AIA");
		country.put("Antarctica","ATA");
		country.put("Antigua and Barbuda","ATG");
		country.put("Argentina","ARG");
		country.put("Armenia","ARM");
		country.put("Aruba","ABW");
		country.put("Australia","AUS");
		country.put("Austria","AUT");
		country.put("Azerbaijan","AZE");
		country.put("Bahamas","BHS");
		country.put("Bahrain","BHR");
		country.put("Bangladesh","BGD");
		country.put("Barbados","BRB");
		country.put("Belarus","BLR");
		country.put("Belgium","BEL");
		country.put("Belize","BLZ");
		country.put("Benin","BEN");
		country.put("Bermuda","BMU");
		country.put("Bhutan","BTN");
		country.put("Bolivia","BOL");
		country.put("Bosnia and Herzegovina","BIH");
		country.put("Botswana","BWA");
		country.put("Brazil","BRA");
		country.put("British Indian Ocean Territory","IOT");
		country.put("British Virgin Islands","VGB");
		country.put("Brunei","BRN");
		country.put("Bulgaria","BGR");
		country.put("Burkina Faso","BFA");
		country.put("Myanmar","MMR");
		country.put("Burundi","BDI");
		country.put("Cambodia","KHM");
		country.put("Cameroon","CMR");
		country.put("Canada","CAN");
		country.put("Cape Verde","CPV");
		country.put("Cayman Islands","CYM");
		country.put("Central African Republic","CAF");
		country.put("Chad","TCD");
		country.put("Chile","CHL");
		country.put("China","CHN");
		country.put("Christmas Island","CXR");
		country.put("Cocos Islands","CCK");
		country.put("Colombia","COL");
		country.put("Comoros","COM");
		country.put("Republic of the Congo","COG");
		country.put("Democratic Republic of the Congo","COD");
		country.put("Cook Islands","COK");
		country.put("Costa Rica","CRI");
		country.put("Croatia","HRV");
		country.put("Cuba","CUB");
		country.put("Curacao","CUW");
		country.put("Cyprus","CYP");
		country.put("Czech Republic","CZE");
		country.put("Denmark","DNK");
		country.put("Djibouti","DJI");
		country.put("Dominica","DMA");
		country.put("Dominican Republic","DOM");
		country.put("East Timor","TLS");
		country.put("Ecuador","ECU");
		country.put("Egypt","EGY");
		country.put("El Salvador","SLV");
		country.put("Equatorial Guinea","GNQ");
		country.put("Eritrea","ERI");
		country.put("Estonia","EST");
		country.put("Ethiopia","ETH");
		country.put("Falkland Islands","FLK");
		country.put("Faroe Islands","FRO");
		country.put("Fiji","FJI");
		country.put("Finland","FIN");
		country.put("France","FRA");
		country.put("French Polynesia","PYF");
		country.put("Gabon","GAB");
		country.put("Gambia","GMB");
		country.put("Georgia","GEO");
		country.put("Germany","DEU");
		country.put("Ghana","GHA");
		country.put("Gibraltar","GIB");
		country.put("Greece","GRC");
		country.put("Greenland","GRL");
		country.put("Grenada","GRD");
		country.put("Guam","GUM");
		country.put("Guatemala","GTM");
		country.put("Guernsey","GGY");
		country.put("Guinea","GIN");
		country.put("Guinea-Bissau","GNB");
		country.put("Guyana","GUY");
		country.put("Haiti","HTI");
		country.put("Honduras","HND");
		country.put("Hong Kong","HKG");
		country.put("Hungary","HUN");
		country.put("Iceland","ISL");
		country.put("India","IND");
		country.put("Indonesia","IDN");
		country.put("Iran","IRN");
		country.put("Iraq","IRQ");
		country.put("Ireland","IRL");
		country.put("Isle of Man","IMN");
		country.put("Israel","ISR");
		country.put("Italy","ITA");
		country.put("Ivory Coast","CIV");
		country.put("Jamaica","JAM");
		country.put("Japan","JPN");
		country.put("Jersey","JEY");
		country.put("Jordan","JOR");
		country.put("Kazakhstan","KAZ");
		country.put("Kenya","KEN");
		country.put("Kiribati","KIR");
		country.put("Kosovo","XKX");
		country.put("Kuwait","KWT");
		country.put("Kyrgyzstan","KGZ");
		country.put("Laos","LAO");
		country.put("Latvia","LVA");
		country.put("Lebanon","LBN");
		country.put("Lesotho","LSO");
		country.put("Liberia","LBR");
		country.put("Libya","LBY");
		country.put("Liechtenstein","LIE");
		country.put("Lithuania","LTU");
		country.put("Luxembourg","LUX");
		country.put("Macau","MAC");
		country.put("Macedonia","MKD");
		country.put("Madagascar","MDG");
		country.put("Malawi","MWI");
		country.put("Malaysia","MYS");
		country.put("Maldives","MDV");
		country.put("Mali","MLI");
		country.put("Malta","MLT");
		country.put("Marshall Islands","MHL");
		country.put("Mauritania","MRT");
		country.put("Mauritius","MUS");
		country.put("Mayotte","MYT");
		country.put("Mexico","MEX");
		country.put("Micronesia","FSM");
		country.put("Moldova","MDA");
		country.put("Monaco","MCO");
		country.put("Mongolia","MNG");
		country.put("Montenegro","MNE");
		country.put("Montserrat","MSR");
		country.put("Morocco","MAR");
		country.put("Mozambique","MOZ");
		country.put("Namibia","NAM");
		country.put("Nauru","NRU");
		country.put("Nepal","NPL");
		country.put("Netherlands","NLD");
		country.put("Netherlands Antilles","ANT");
		country.put("New Caledonia","NCL");
		country.put("New Zealand","NZL");
		country.put("Nicaragua","NIC");
		country.put("Niger","NER");
		country.put("Nigeria","NGA");
		country.put("Niue","NIU");
		country.put("Northern Mariana Islands","MNP");
		country.put("North Korea","PRK");
		country.put("Norway","NOR");
		country.put("Oman","OMN");
		country.put("Pakistan","PAK");
		country.put("Palau","PLW");
		country.put("Palestine","PSE");
		country.put("Panama","PAN");
		country.put("Papua New Guinea","PNG");
		country.put("Paraguay","PRY");
		country.put("Peru","PER");
		country.put("Philippines","PHL");
		country.put("Pitcairn","PCN");
		country.put("Poland","POL");
		country.put("Portugal","PRT");
		country.put("Puerto Rico","PRI");
		country.put("Qatar","QAT");
		country.put("Reunion","REU");
		country.put("Romania","ROU");
		country.put("Russia","RUS");
		country.put("Rwanda","RWA");
		country.put("Saint Barthelemy","BLM");
		country.put("Samoa","WSM");
		country.put("San Marino","SMR");
		country.put("Sao Tome and Principe","STP");
		country.put("Saudi Arabia","SAU");
		country.put("Senegal","SEN");
		country.put("Serbia","SRB");
		country.put("Seychelles","SYC");
		country.put("Sierra Leone","SLE");
		country.put("Singapore","SGP");
		country.put("Sint Maarten","SXM");
		country.put("Slovakia","SVK");
		country.put("Slovenia","SVN");
		country.put("Solomon Islands","SLB");
		country.put("Somalia","SOM");
		country.put("South Africa","ZAF");
		country.put("South Korea","KOR");
		country.put("South Sudan","SSD");
		country.put("Spain","ESP");
		country.put("Sri Lanka","LKA");
		country.put("Saint Helena","SHN");
		country.put("Saint Kitts and Nevis","KNA");
		country.put("Saint Lucia","LCA");
		country.put("Saint Martin","MAF");
		country.put("Saint Pierre and Miquelon","SPM");
		country.put("Saint Vincent and the Grenadines","VCT");
		country.put("Sudan","SDN");
		country.put("Suriname","SUR");
		country.put("Svalbard and Jan Mayen","SJM");
		country.put("Swaziland","SWZ");
		country.put("Sweden","SWE");
		country.put("Switzerland","CHE");
		country.put("Syria","SYR");
		country.put("Taiwan","TWN");
		country.put("Tajikistan","TJK");
		country.put("Tanzania","TZA");
		country.put("Thailand","THA");
		country.put("Togo","TGO");
		country.put("Tokelau","TKL");
		country.put("Tonga","TON");
		country.put("Trinidad and Tobago","TTO");
		country.put("Tunisia","TUN");
		country.put("Turkey","TUR");
		country.put("Turkmenistan","TKM");
		country.put("Turks and Caicos Islands","TCA");
		country.put("Tuvalu","TUV");
		country.put("United Arab Emirates","ARE");
		country.put("Uganda","UGA");
		country.put("United Kingdom","GBR");
		country.put("Ukraine","UKR");
		country.put("Uruguay","URY");
		country.put("United States","USA");
		country.put("Uzbekistan","UZB");
		country.put("Vanuatu","VUT");
		country.put("Vatican","VAT");
		country.put("Venezuela","VEN");
		country.put("Vietnam","VNM");
		country.put("U.S. Virgin Islands","VIR");
		country.put("Wallis and Futuna","WLF");
		country.put("Western Sahara","ESH");
		country.put("Yemen","YEM");
		country.put("Zambia","ZMB");
		country.put("Zimbabwe","ZWE");
		return country;
	}

}


