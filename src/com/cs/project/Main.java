package com.cs.project;

import com.cs.project.service.CreatureService;
import com.cs.project.service.FileService;

public class Main {

	public static void main(String[] args) {
		FileService fileService = new FileService();
		CreatureService creatureService = new CreatureService();
		Program program = new Program(fileService, creatureService);
		program.run();
	}

}
