package br.com.generate.java.command.rest;
import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;


public class RestGenerator  extends ReadTemplateFile{
	
	
	@Override
	public String getLayer() {
		return Layers.REST;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".rest")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());
				//.replace("${url_path}", nameClass.toLowerCase() + "s");
	}
	
	public static void main(String[] args) throws IOException {
		new RestGenerator().generate("User", null, "template-rest-controller.txt");
	}
}
