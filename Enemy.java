import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Enemy extends MainApp {

	Random rand = new Random();
	String[] enemies = {"Skelett", "Minotaur", "Geist"};
	String enemyName;
	int maxEnemyHealth = 75;
	int enemyAttackDamage = 25;
	int enemyHealth;
	int enemyXp;
	boolean enemyAlive = true;
	String enemyLiving;
	
	int[] enemyInformation = {maxEnemyHealth , enemyAttackDamage, enemyHealth, enemyXp};
	String[] enemyStatusInformation = {enemyLiving, enemyName};
	int eMLoc = 0;
	int eALoc = 1;
	int eHLoc = 2;
	int eXLoc = 3;
	
	int eLLoc = 0;
	int eNLoc = 1;
	
	public void readEnemyStatus (String filePath) {
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader (new FileReader(inputFile));
			for (int i = 0; i< enemyStatusInformation.length;i++){
				enemyStatusInformation[i] = inputReader.readLine();
			}
			enemyLiving = enemyStatusInformation[eLLoc];
			enemyName = enemyStatusInformation[eNLoc] ;
			inputReader.close();
			if (enemyLiving.equalsIgnoreCase("true") || enemyLiving.equalsIgnoreCase("false")) {
			    enemyAlive = Boolean.valueOf(enemyLiving);
			} 
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readEnemy (String filePath) {
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader (new FileReader(inputFile));
			for (int i = 0; i< enemyInformation.length;i++){
				enemyInformation[i] = Integer.parseInt(inputReader.readLine());
			}
			maxEnemyHealth = enemyInformation[eMLoc];
			enemyAttackDamage = enemyInformation[eALoc] ;
			enemyHealth = enemyInformation[eHLoc];
			enemyXp = enemyInformation[eXLoc];
			
			inputReader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	

	public void saveEnemy (String filePath) {
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter (new FileWriter(outputFile));
			
			enemyInformation[eMLoc] = maxEnemyHealth;
			enemyInformation[eALoc] = enemyAttackDamage;
			enemyInformation[eHLoc] = enemyHealth;
			enemyInformation[eXLoc] = enemyXp;
			
			for (int i = 0; i < enemyInformation.length; i++){
				outputWriter.write(Integer.toString(enemyInformation[i]) + "\n");
			}
			outputWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveEnemyStatus (String filePath) {
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter (new FileWriter(outputFile));
			
			enemyStatusInformation[eLLoc] = enemyLiving;
			enemyStatusInformation[eNLoc] = enemyName;
			
			for (int i = 0; i < enemyStatusInformation.length; i++){
				outputWriter.write(enemyStatusInformation[i] + "\n");
			}
			outputWriter.close();
		}	 catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public String getEnemyName (){
	return enemyName; 
 	} 
	
	public int getEnemyMaxHealth (){
	return maxEnemyHealth; 
 	} 
	
	public int getEnemyAttackDamage (){
	return enemyAttackDamage; 
 	} 
	
	public int getEnemyHealth (){
	return enemyHealth; 
 	} 
	public String getEnemyLiving (){
		return enemyLiving; 
	 	} 
	public boolean getEnemyAliveStatus (){
		return enemyAlive;
	 	} 
	
	public int getEnemyXp (){
	return enemyXp;
 	} 
	
	public void takeDamage (int damage){
		this.enemyHealth = enemyHealth - damage;
		if (this.enemyHealth < 1){
			this.enemyAlive = false;
			this.enemyLiving = "false";
		}
	}
	
	public void setMaxEnemyHealth (int enemyHealth){
		this.maxEnemyHealth = enemyHealth;
	}
	
	public void setEnemyAttackDamage (int attackDamage){
		this.enemyAttackDamage = attackDamage;
	}
		
	 public void spawnEnemy (int enemeyEvent){
		 this.enemyAlive = true;
		 this.enemyLiving = "true";
		 this.enemyHealth = rand.nextInt(maxEnemyHealth);
		 this.enemyName = enemies[rand.nextInt(enemies.length)];
		 this.enemyXp = enemyHealth / 2;
	 }
	 
	 
}
