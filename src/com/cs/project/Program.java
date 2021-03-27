package com.cs.project;

import java.util.List;

import com.cs.project.domain.Creature;
import com.cs.project.domain.Hero;
import com.cs.project.service.CreatureService;
import com.cs.project.service.FileService;
import com.cs.project.service.MessageService;

public class Program {

	private FileService fileService;
	private CreatureService creatureService;
	private static final String FROM_READ = "d:/input.txt";
	private static final String TO_WRITE = "d:/output.txt";

	public Program(FileService fs, CreatureService cs) {
		this.fileService = fs;
		this.creatureService = cs;
	}

	public void run() {
		try {
			String buffer = this.fileService.readFromFile(FROM_READ);
			List<Creature> creatures = this.creatureService.getCreatures(buffer);
			Hero hero = this.creatureService.getHero(buffer, creatures);
			this.creatureService.findCreatureThenAttack(hero);
			this.fileService.writeToFile(MessageService.s, TO_WRITE);
			System.out.println("Ýþlem Bitti!");
		} catch (Exception e) {
			System.out.println("Hata!");
		}
		
		
	}

}
