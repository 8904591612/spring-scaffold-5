package br.com.generate.java.command.rest;

import java.io.IOException;

import br.com.generate.Layers;
import br.com.generate.ReadTemplateFile;

public class ServerPagination extends ReadTemplateFile{

	@Override
	public String getLayer() {
		// TODO Auto-generated method stub
		return Layers.SERVERPAGINATION;
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass,
			String parameters) {
		// TODO Auto-generated method stub
		return javaStrings.replace("${package}", getPackage() + ".rest")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());
	}
	
	
	public static void main(String[] args) throws IOException {
		new ServerPagination().generate("User", null, "template-server-pagination-rest-controller.txt");
	}

}
	 