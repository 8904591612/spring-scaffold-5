package br.com.generate.java.command.rest;
import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;


public class ClientPagination extends ReadTemplateFile{

	@Override
	public String getLayer() {
		// TODO Auto-generated method stub
		return Layers.CLIENTPAGINATION;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass,
			String parameters) {
		
		return javaStrings.replace("${package}", getPackage() + ".rest")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());
		// TODO Auto-generated method stub
	
	}
	public static void main(String[] args) throws IOException {
		new ClientPagination().generate("User", null, "template-client-pagnation-rest-controller.txt");
	}
}
