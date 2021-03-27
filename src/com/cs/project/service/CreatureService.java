package com.cs.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cs.project.domain.Creature;
import com.cs.project.domain.Hero;

public class CreatureService {

	/**
	 * Get Hero Information with creatures list(Enemies of Hero)
	 * 
	 * @param buffer
	 * @param creatures
	 * @return
	 */
	public Hero getHero(String buffer, List<Creature> creatures) {
		int power = ParseService.getEnemyAttackPower("Hero", buffer);
		int hp = ParseService.getEnemyHealthPower("Hero", buffer);
		int endPosition = ParseService.getResource(buffer);
		Hero hero = new Hero("Hero", hp, power, creatures, 0, endPosition);

		return hero;

	}

	/**
	 * Get All Enemies with Informations Against To 'Hero' in creatures list From
	 * Buffer
	 * 
	 * @param buffer
	 * @return
	 */
	public List<Creature> getCreatures(String buffer) {
		List<Creature> creatures = new ArrayList<>();
		ArrayList<String> enemies = ParseService.getEnemy(buffer);
		for (String enemy : enemies) {
			int power = ParseService.getEnemyAttackPower(enemy, buffer);
			int hp = ParseService.getEnemyHealthPower(enemy, buffer);
			ArrayList<Integer> positions = ParseService.getEnemyPosition(enemy, buffer);
			for (int i = 0; i < positions.size(); i++) {
				Creature creature = new Creature(enemy, hp, power, positions.get(i));
				creatures.add(creature);
			}
		}
		return creatures;

	}

	/**
	 * Sort positions of the enemies, then attack them sequential
	 * 
	 * @param hero
	 */
	public void findCreatureThenAttack(Hero hero) {
		List<Creature> creatures = hero.getEnemies().stream().sorted(Comparator.comparingInt(Creature::getPosition))
				.collect(Collectors.toList());
		MessageService.s.append(hero.getName() + " started journey with " + hero.getHp() + " HP!" + "\n");
		for (Creature creature : creatures) {
			if (hero.getHp() > 0 && hero.getPosition() <= hero.getEndPosition()
					&& hero.getPosition() <= creature.getPosition()) {
				hero.setPosition(creature.getPosition()); // go to position of creature!
				this.attack(hero, creature); // then attack!
			}
		}
		if (hero.getHp() > 0)
			MessageService.s.append(hero.getName() + " Survived!");
	}

	/**
	 * Hero attack to creature then creature attack to hero by considering the
	 * number of moves
	 * 
	 * @param hero
	 * @param creature
	 */
	public void attack(Hero hero, Creature creature) {
		int count = CreatureService.calculateAttackCount(hero, creature);
		for (int i = 0; i < count; i++) {
			hero.attack(hero, creature);
			creature.attack(creature, hero);
		}
		if (hero.getHp() <= 0 && creature.getHp() > hero.getHp()) {
			MessageService.s.append(creature.getName() + " defeated " + hero.getName() + " with " + creature.getHp()
					+ " HP remaining" + "\n");
			MessageService.s.append(hero.getName() + " is Dead!! Last seen at position " + hero.getPosition() + " !!");
		} else if (hero.getHp() <= 0 && creature.getHp() <= 0) {
			MessageService.s.append("Extrem Situation: Both of them died very recently.");
		} else
			MessageService.s.append(hero.getName() + " defeated " + creature.getName() + " with " + hero.getHp()
					+ " HP remaining" + "\n");
	}

	/**
	 * Find the number of moves required for at least one creature to die
	 * 
	 * @param hero
	 * @param creature
	 * @return
	 */
	private static int calculateAttackCount(Hero hero, Creature creature) {
		List<Integer> values = new ArrayList<>();
		values.add((int) Math.ceil((double) hero.getHp() / (double) creature.getPower()));
		values.add((int) Math.ceil((double) creature.getHp() / (double) hero.getPower()));
		return Collections.min(values);
	}

}