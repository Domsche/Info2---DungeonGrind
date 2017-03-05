import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import sun.audio.*;

public class Main {

	public static void main(String[] args)   throws Exception {
		
	
		//System Variablen&Objekte
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		boolean run = true;
		boolean debugMode = true;
		boolean menu = true;
		String audioPath;
		Player player = new Player();
		Enemy enemy = new Enemy();
		String input;
		int amount;
		
		//Game Statistiken
		String[] enemies = {"Skelett", "Zombie", "Minotaur", "Geist"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		int missingXp = 0;

		//Spieler Statistiken
		int attackDamage = 50;
		int numPotions = 3;
		int potionHeal = 30;
		int potionChance = 50;
		int playerExperience = 0;	
		int itemChance = 90;
		
		

		
		
	while(menu){			
		System.out.println("Willkommen zu DungeonGrind!");
		System.out.println("\n\t1. Neues Spiel");
		System.out.println("\n\t2. Spiel Laden");
		System.out.println("\n\td. DebugMode");
		input = in.nextLine();
		//Neues Spiel starten
		if(input.equals("1")){
			System.out.println("--------------------------------------------------");
			System.out.println("\n\tHallo Abenteurer! Wie ist dein Name?");
			input = in.nextLine();
			player.setName(input);
			System.out.println("--------------------------------------------------");
			System.out.println("\n\tW�hle deine Klasse!\n");
			System.out.println("\n\t1. Krieger");
			System.out.println("\t Krieger sind besonders z�h und stark im Kampf!");
			System.out.println("\t Dein Schaden und deine R�stung erh�hen sich um 10!");
			System.out.println("\n\t2. Alchimist");
			System.out.println("\t Alchimisten sind experten im Umgang mit Tr�nken jeder Art!");
			System.out.println("\t Du startest mit 2 extra Tr�nken und deine Tr�nke heilen mehr!");
			System.out.println("\n\t3. Dieb");
			System.out.println("\t Diebe sind heimt�ckisch und bewandert im Taschendiebstahl!");
			System.out.println("\t Du kannst kritische Treffer landen und Gegner beklauen!");
			System.out.println("--------------------------------------------------");
			input = in.nextLine();
			
			//Klassenauswahl
			if(input.equals("1")){
				player.setKlasse("Krieger");
				player.increaseArmorUp(10);
				player.increaseAttackDamage(10);
			}
			else if(input.equals("2")){
				player.setKlasse("Alchimist");
				player.setPotionHeal(50);
				player.increaseNumPotions(player.getNumPotions()+2);
			}
			else if(input.equals("3")){
				player.setKlasse("Dieb");
			}
			break;
			
		}
		//Spielstand Laden
		else if (input.equals("2")){
			
		}
		//Debug Mode
		else if (input.equals("d")){
			while(debugMode){
				System.out.println("# Willkommen im DebugMode! # ");	
				System.out.println("# Welche Variablen wollen sie �ndern? #\n");
				System.out.println("\t# Spieler-Variablen#");
				System.out.println("\t1. Spieler-HP: "+ player.getPlayerHealth() );
				System.out.println("\t2. Spieler-AttackDamage: "+ player.getAttackDamage() );
				System.out.println("\t3. Spieler-LevelupPoints: "+ player.getPlayerHealth()  );
				System.out.println("\t4. Spieler-HeilRate: "+ player.getPotionHeal()  );
				System.out.println("\t5. Spieler-AnzahlHeiltr�nke: "+ player.getNumPotions()  );
				System.out.println("\n\t# Monster-Variablen#");
				System.out.println("\t6. Monster-MaximaleHP: "+ enemy.getEnemyMaxHealth()  );	
				System.out.println("\t7. Monster-AttackDamage: "+ enemy.getEnemyAttackDamage()  );	
				System.out.println("\t8. Monster-Heiltrank DropChance: "+ potionChance + " % ");
				System.out.println("\t9. Monster-Waffe/R�stung DropChance: "+ itemChance + " % ");	
				System.out.println("\n\tq. DebugMode verlassen! ");	
				input = in.nextLine();
				if (input.equals("1")){
					System.out.println("\n\t Auf welchen Wert sollen die Spieler-HP gesetzt werden?");
					amount = in.nextInt();
					player.setPlayerHealth(amount);
					System.out.println("\t Spieler-HP wurden auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("2")){
					System.out.println("\n\t Auf welchen Wert sollen der Spieler-AttackDamage gesetzt werden?");
					amount = in.nextInt();
					player.setAttackDamage(amount);
					System.out.println("\t Spieler-AttackDamage wurden auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("3")){
					System.out.println("\n\t Auf welchen Wert soll man das erste LevelUp bekommen?");
					amount = in.nextInt();
					player.setLevelUpPoints(amount);
					System.out.println("\t LevelUp Grenze auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("4")){
					System.out.println("\n\t Wieviele HP sollen durch Heiltr�nke wiederhergestellt werden?");
					amount = in.nextInt();
					player.setPotionHeal(amount);
					System.out.println("\t Heiltrank-Rate auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("5")){
					System.out.println("\n\t Mit wievielen Heiltr�nken soll gestartet werden?");
					amount = in.nextInt();
					player.setNumPotions(amount);
					System.out.println("\t Anzahl Start-Heiltr�nke auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("6")){
					System.out.println("\n\t Bis zu wieviel HP sollen Monster bekommen?");
					amount = in.nextInt();
					enemy.setMaxEnemyHealth(amount);
					System.out.println("\t Maximale gegnerische HP auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("7")){
					System.out.println("\n\t Wie hoch soll der maximale Schaden von Gegnern sein?");
					amount = in.nextInt();
					enemy.setEnemyAttackDamage(amount);
					System.out.println("\t Maximalen gegnerischen Schaden auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("8")){
					System.out.println("\n\t Wie hoch soll die Chance in % auf einen Heiltrank sein?");
					amount = in.nextInt();
					potionChance = amount;
					System.out.println("\t DropChance von Heiltr�nken auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("9")){
					System.out.println("\n\t Wie hoch soll die Chance in % auf ein Item sein?");
					amount = in.nextInt();
					itemChance = amount;
					System.out.println("\t DropChance von Items auf " + amount +" gesetzt. \n");
				}
				else if (input.equals("q")){
					break;
				}
				else {
					System.out.println("\t Ung�ltiger Befehl\n");
				}
			}
		}
	}
		GAME:	
		while(run){
			
			enemy.spawnEnemy(1);
			System.out.println("\t# Ein " + enemy.getEnemyName() + " taucht auf! #\n");
			
			//KampfStart
			while(enemy.getEnemyHealth() > 0){
				System.out.println("\tDeine HP: " + player.getPlayerHealth());
				System.out.println("\t" + enemy.getEnemyName() + " HP: "+ enemy.getEnemyHealth());
				System.out.println("\n\tWas willst du tun?");
				System.out.println("\n\t1. Angreifen");
				System.out.println("\n\t2. Heiltrank");
				System.out.println("\n\t3. Fl�chten");
				input = in.nextLine();
				
				if(input.equals("1")){
			   			 		 		
					//Audio Ausgabe	Schlag
					
					String punshFile = "E:/Uni/info 2/DungeonGrind/src/Punsh.wav";
			    	InputStream stream = new FileInputStream(punshFile);
				    AudioStream audioStream = new AudioStream(stream);    
				    AudioPlayer.player.start(audioStream);
				    
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemy.takeDamage(damageDealt);
					player.takeDamage(damageTaken);
					
					System.out.println("\t> " + player.getKlasse() + " " + player.getName()+ " trifft den "+ enemy.getEnemyName() + " f�r " + damageDealt + " Schaden.");
					System.out.println("\t> Du wurdest f�r "+ damageTaken + " getroffen.");
					
					if(player.getPlayerHealth() < 1){
						System.out.println("\t>"+ enemy.getEnemyName() +" hat dich t�dlich verwundet!");
						break;
					}
				}
				
				else if(input.equals("2")){
					if(player.getNumPotions() > 0) {
						
						//Audio Ausgabe	Heilung				
						String magicFile = "E:/Uni/info 2/DungeonGrind/src/Magic.wav";
				    	InputStream stream = new FileInputStream(magicFile);
					    AudioStream audioStream = new AudioStream(stream);

					    // play the audio clip with the audioplayer class
					    AudioPlayer.player.start(audioStream);
						  
					//Abrechnung Heiltrank
						player.potionHeal(player.getPotionHeal());
						System.out.println("\t> Du trinkst einen deiner Heiltr�nke, er heilt dich um " + player.getPotionHeal() + "."
								+ "\n\t> Du hast nun: "+player.getPlayerHealth()+" HP."
								+ "\n\t> Du hast nun " +player.getNumPotions() +" Tr�nke �brig.\n");
					}
					else {
						System.out.println("\t> Du hast keine Tr�nke mehr!");
					}
					
				}
				else if(input.equals("3")){
					System.out.println("\tDu l�ufst davon.");
					continue GAME;
				}
				else{
					System.out.println("Kein g�ltiger Befehl");		
				}

			}
			if(player.getPlayerHealth() < 1){
				System.out.println("GAME OVER");
				break;
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println(" # " + enemy.getEnemyName() + " wurde besiegt! # ");
			
			//Abrechnung Erfahrungspunkte und LevelUps
			player.increaseExperience(enemy.getEnemyXp());
			System.out.println(" # Du hast " + enemy.getEnemyXp() + " Erfahrungspunkte gesammelt! # ");
			if(player.getExperience() > player.getLevelUpPoints()){
				player.setExperience(0);
				player.levelUp(3);
				player.increaseLevel(1);
			}
			else {
				missingXp = player.getLevelUpPoints() - player.getExperience();
				System.out.println(" # Du brauchst noch " + missingXp + " Erfahrungspunkte zum n�chsten Aufstieg! # \n");
			}
		
			//Berechnung ob ein Gegenstand fallengelassen wurde
			if(rand.nextInt(100) < potionChance) {
				player.increaseNumPotions(1);
				System.out.println(" # " + enemy.getEnemyName() + " lies einen Heiltrank fallen # ") ;
				System.out.println(" # Du hast jetzt " + player.getNumPotions() + " Tr�nke �brig.\n");
			}
			if(rand.nextInt(100) < itemChance) {
				player.increaseArmorUp(1);
				System.out.println(" # " + enemy.getEnemyName() + " lies einen magischen Talisman fallen. Du bist besser gesch�tzt! # ") ;
				System.out.println(" # Du hast jetzt " + player.getArmorUp() + " Schutzpunkte.\n");
			}
			if(rand.nextInt(100) < itemChance) {
				player.increaseAttackDamage(5);
				System.out.println(" # " + enemy.getEnemyName() + " lies eine bessere Waffe fallen. Du machst nun mehr Schaden! # ") ;
				System.out.println(" # Du teilst nun bis zu "+ player.getAttackDamage()+" aus! \n");
				
			}
			if(rand.nextInt(100) < itemChance) {
				player.increaseArmorUp(5);
				System.out.println(" # " + enemy.getEnemyName() + " lies eine bessere R�stung fallen. Du h�lst nun mehr aus! # ") ;
				System.out.println(" # Du reduzierst den Schaden des Gegners nun um "+ player.getArmorUp()+" Punkte! \n");
			}
			
			
			//N�chste Kampfphase
			System.out.println(" # Du hast noch " + player.getPlayerHealth() + " HP.");
			System.out.println("--------------------------------------------------");
			System.out.println("Was willst du tun?");
			System.out.println("1. Weiter k�mpfen!");
			System.out.println("2. Den Dungeon verlassen");
			System.out.println("3. Speichern");
			input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")){
				System.out.println("Ung�ltiger Befehl");
				input = in.nextLine();
			}
			if(input.equals("1")) {
				System.out.println("Du begibst dich tiefer in das Dungeon");
			}
			else if(input.equals("2")) {
				System.out.println("Du gehst in den wohlverdienten Ruhestand!");
				break;
			}
			else if(input.equals("3")) {
				System.out.println("Spielstand gespeichert!");
				
			}
		}
		
	}
	
}
		
	

