package br.com.generate.thymeleaf;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ClientPaginationThemeGenerator extends AbstractThymeleafGenerate {
	
	
	public ClientPaginationThemeGenerator(String className, String parameters) throws IOException {
		if (validateLayoutHtml()) {
			generateTemplateLayout();
		}
	//	generateIndexHtml(className, parameters);
	//	generateFormHtml(className, parameters);
	//	generateShowHtml(className, parameters);
	//	generatePanelIndexHtml(className, parameters);
	}
	
public void generatePanelIndexHtml(String className, String parameters) throws IOException{
		
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-client-index.html"), null);
		String classNameParam = className;
		String paramClassName = className.toLowerCase();
		String pathUrl = "/" + className.toLowerCase() + "s";
		String thAttributes = generateThParameters(parameters);
		String template = "layout";
		htmlString = htmlString.replace("${template}", template);
	//	htmlString = htmlString.replace("${className}", classNameParam);
		htmlString = htmlString.replace("paramClassName", paramClassName);
		htmlString = htmlString.replace("${th_attributes}", thAttributes);

		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/" + className.toLowerCase() + "/index.html");
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/" + className.toLowerCase() + "/index.html");


	}
	public void generateTemplateLayout() throws IOException {
		String htmlString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-layout.html"), null);
		File newHtmlFile = new File(getUserDir() + "/src/main/resources/templates/layout.html");
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("create /src/main/resources/templates/layout.html");
	}
	


	public boolean validateLayoutHtml() throws IOException {
		String pathFile = "/src/main/resources/templates/layout.html";
		File f = new File(getUserDir() + pathFile);
		if(f.exists()) { 
			return false;
		} 
		return true;
	}
	
}
