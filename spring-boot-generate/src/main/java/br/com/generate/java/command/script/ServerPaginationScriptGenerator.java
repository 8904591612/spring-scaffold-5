package br.com.generate.java.command.script;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import br.com.generate.thymeleaf.AbstractThymeleafGenerate;

public class ServerPaginationScriptGenerator extends AbstractThymeleafGenerate {
public ServerPaginationScriptGenerator (String nameClass, String parametersClass) throws IOException{
		
		generatescript(nameClass, parametersClass);

		
	}
	
	public void generatescript(String nameClass , String parameterClass) throws IOException{
		String scriptString = IOUtils.toString(getClass().getResourceAsStream("/templates/template-client-script.txt"), null);

		String classNameParam = nameClass;
		String paramClassName = nameClass.toLowerCase();
		String pathUrl = "/" + nameClass.toLowerCase() + "s";
		String tdAttributes = generateScriptparameters(nameClass, parameterClass);
		scriptString = scriptString.replace("paramClassName", paramClassName);
		scriptString= scriptString.replace("${td_attributes}", tdAttributes);
		File newScriptFile = new File(getUserDir() + "/src/main/webapp/page_js/" + paramClassName+".js");
		FileUtils.writeStringToFile(newScriptFile, scriptString);
		System.out.println("created /src/main/webapp/page_js/" + nameClass.toLowerCase() + ".js");



}


}
