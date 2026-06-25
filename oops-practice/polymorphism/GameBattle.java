package polymorphism;

class GameCharacter {
    String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " prepares to attack!");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " attacks with a Sword! (Slash!)");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " attacks with Magic! (Fireball!)");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " attacks with a Bow! (Arrow shot!)");
    }
}

public class GameBattle {
    // Requirement 3: Method startBattle which invokes attacks polymorphically
    public static void startBattle(GameCharacter[] characters) {
        System.out.println("--- The Battle Starts! ---");
        for (GameCharacter c : characters) {
            c.performAttack();
        }
    }

    public static void main(String[] args) {
        // Requirement 1: Store all characters inside a GameCharacter[] array
        // Requirement 2: Character names are stored as strings
        GameCharacter[] heroes = new GameCharacter[4];
        heroes[0] = new Warrior("Arthur");
        heroes[1] = new Mage("Merlin");
        heroes[2] = new Archer("Legolas");
        heroes[3] = new Warrior("Thorin");

        startBattle(heroes);

        // Requirement 4: Count how many Warriors, Mages, and Archers participated
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter c : heroes) {
            if (c instanceof Warrior) {
                warriorCount++;
            } else if (c instanceof Mage) {
                mageCount++;
            } else if (c instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("\n--- Battle Participation Summary ---");
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}
