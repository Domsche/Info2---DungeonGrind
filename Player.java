import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Player extends MainApp{
	
	String name;
	String klasse;
	String inCombat = "false";
 	int playerHealth = 100;
	int attackDamage = 50;
	int numPotions = 3;
	int potionHeal = 30;
	int playerExperience = 0;
	int levelUpPoints = 50;
	int armorUp = 0;
	int weaponUp = 0;
	int playerLevel = 1;
	int maxPlayerHealth = 100;
	int score;
	
	//SpielerInfos aus SaveFile
	int[] saveInformation = { playerHealth, attackDamage, numPotions, potionHeal, playerExperience, playerLevel, levelUpPoints, armorUp, weaponUp, score, maxPlayerHealth};
	int pHLoc = 0;
	int pALoc = 1;
	int pPLoc = 2;
	int pHeLoc = 3;
	int pXPLoc = 4;
	int pLLoc = 5;
	int pLpLoc = 6;
	int pArLoc = 7;
	int pWLoc = 8;
	int pSLoc = 9;
	int pMHLoc = 10;
	
	String[] userInformation = {name , klasse};
	int pNLoc = 0;
	int pKLoc = 1;
	
	//Laden
	public void readUser (String filePath) {
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader (new FileReader(inputFile));
			for (int i = 0; i< userInformation.length;i++){
				userInformation[i] = inputReader.readLine();
			}
			this.name = userInformation[pNLoc];
			this.klasse = userInformation[pKLoc];

			inputReader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void readPlayer (String filePath) {
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader (new FileReader(inputFile));
			for (int i = 0; i< saveInformation.length;i++){
				saveInformation[i] = Integer.parseInt(inputReader.readLine());
			}
			this.playerHealth = saveInformation[pHLoc];
			this.attackDamage = saveInformation[pALoc];
			this.numPotions = saveInformation[pPLoc];
			this.potionHeal = saveInformation[pHeLoc];
			this.playerExperience = saveInformation[pXPLoc];
			this.playerLevel = saveInformation[pLLoc];
			this.levelUpPoints = saveInformation[pLpLoc];
			this.armorUp = saveInformation[pArLoc];
			this.weaponUp= saveInformation[pWLoc];
			this.score = saveInformation[pSLoc];
			this.maxPlayerHealth = saveInformation[pMHLoc];
			
			inputReader.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//Speichern
	public void saveUser (String filePath) {
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter (new FileWriter(outputFile));
			
			userInformation[pNLoc] = name;
			userInformation[pKLoc] = klasse;
			
			for (int i = 0; i < userInformation.length; i++){
				outputWriter.write(userInformation[i] + "\n");
			}
			
			outputWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void savePlayer (String filePath) {
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter (new FileWriter(outputFile));
			
			saveInformation[pHLoc] = playerHealth;
			saveInformation[pALoc] = attackDamage;
			saveInformation[pPLoc] = numPotions;
			saveInformation[pHeLoc] = potionHeal;
			saveInformation[pXPLoc] = playerExperience;
			saveInformation[pLLoc] = playerLevel;
			saveInformation[pLpLoc] = levelUpPoints;
			saveInformation[pArLoc] = armorUp;
			saveInformation[pWLoc] = weaponUp;
			saveInformation[pSLoc] = score;
			saveInformation[pMHLoc] = maxPlayerHealth;
			
			for (int i = 0; i < saveInformation.length; i++){
				outputWriter.write(Integer.toString(saveInformation[i]) + "\n");
			}
			
			outputWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
 
//Getter Methoden
 public String getInCombat(){
		 return inCombat;
	}	

 public String getName (){
	return name; 
 	} 
 
 public String getKlasse (){
		return klasse; 
	 	} 
	 
 public int getLevelUpPoints (){
		return levelUpPoints; 
	 	} 
 
 public int getPlayerHealth (){
	return playerHealth; 
 	} 
 
 public int getScore(){
	 return score;
 }
 
 public int getAttackDamage(){
	 return attackDamage;
 }
 
 public int getNumPotions(){
	 return numPotions;
 }
 
 public int getPotionHeal(){
	 return potionHeal;
 }
 
 public int getExperience(){
	 return playerExperience;
 }
 
 public int getArmorUp(){
	 return armorUp;
 }
 

 
 
 //Setter Methoden
 public void increaseArmorUp (int armorUps){
	 this.armorUp += armorUps;
 }
 
 public void takeDamage (int damage){
		 this.playerHealth = playerHealth - damage; 
 }
 
 public void potionHeal (int heal){
	 this.numPotions--;
	 this.playerHealth = playerHealth + potionHeal;
	 if (this.playerHealth > this.maxPlayerHealth){
		 this.playerHealth = this.maxPlayerHealth;
	 }
 }
 
	
public void increaseLevel(int levelUps){
this.playerLevel += levelUps;
this.levelUpPoints = levelUpPoints + 50;
this.playerHealth = maxPlayerHealth;
System.out.println(" # Du bist ein Level Aufgestiegen! # ");
System.out.println(" # Du bist jetzt Level " + this.playerLevel +" !  # \n");
}

 
 public void levelUp (int increase){
	 this.attackDamage += increase; 
	 
 }
 
 public void setInCombat (String combat){
	 this.inCombat = combat;
 }
 public void setAttackDamage (int attackDamage){
	 this.attackDamage = attackDamage;
 }
 
 public void setPlayerHealth (int playerHealth){
	 this.playerHealth = playerHealth;
	 this.maxPlayerHealth = playerHealth;
 }
 
 public void setLevelUpPoints (int levelUpPoints){
	 this.levelUpPoints = levelUpPoints;
 }
 
 public void increaseAttackDamage (int addition){
	 this.attackDamage += addition;
 }
 
 public void increaseNumPotions (int potions){
	 this.numPotions += potions;
 }
 
 public void setPotionHeal (int potionHeal){
	 this.potionHeal = potionHeal;
 }
 
 public void setNumPotions (int numPotion){
	 this.numPotions = numPotion;
 }
 
 public void increaseScore (int points) {
	 this.score += points;
 }
 
 public void increaseExperience (int experience){
	 this.playerExperience += experience;
	 increaseScore(experience);
 }
 
 public void setExperience (int experience){
	 this.playerExperience = experience;
 }
 
 public void improveDamage (int damage){
	 
 }
 
 public void setKlasse (String klasse){
	 this.klasse = klasse;
 }
 
 public void setName (String name){
	 this.name = name;
 }
 
}