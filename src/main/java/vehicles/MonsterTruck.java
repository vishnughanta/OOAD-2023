package main.java.vehicles;

import main.java.abstracts.Vehicle;
import main.java.activities.Activity;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.enums.VehicleType;
import main.java.functions.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterTruck extends Vehicle {
    private List<String> monsterTruckNames;
    private Map<String, Integer> monsterTruckNamesHashMap;
    private int monsterTruckIndex;

    public MonsterTruck(Activity activity) {
        monsterTruckIndex = -1;
        monsterTruckNamesHashMap = new HashMap<>();
        monsterTruckNames = new ArrayList<>();
        /*
         *Monster Truck Names - source: https://www.rookieroad.com/monster-trucks/list-a-z-2027269/
         */
        monsterTruckNames.add("Air Force Afterburner");
        monsterTruckNames.add("Avenger");
        monsterTruckNames.add("Bad News Travel Fast");
        monsterTruckNames.add("Batman");
        monsterTruckNames.add("Backwards Bob");
        monsterTruckNames.add("Bear Foot (1979)");
        monsterTruckNames.add("Bear Foot (F-150)");
        monsterTruckNames.add("Bear Foot (2xtreme)");
        monsterTruckNames.add("Bear Foot (Silverado)");
        ;
        monsterTruckNames.add("Bear Foot USA");
        monsterTruckNames.add("BigFoot");
        monsterTruckNames.add("Black Stallion");
        monsterTruckNames.add("BlackSmith");
        monsterTruckNames.add("Blue Thunder");
        monsterTruckNames.add("Bounty Hunter");
        monsterTruckNames.add("Brutus");
        monsterTruckNames.add("Bulldozer");
        monsterTruckNames.add("Captain's Curse");
        monsterTruckNames.add("Cyborg");
        monsterTruckNames.add("El Toro Loco");
        monsterTruckNames.add("Grave Digger");
        monsterTruckNames.add("Grinder");
        monsterTruckNames.add("Gunslinger");
        monsterTruckNames.add("Jurassic Attack");
        monsterTruckNames.add("King Krunch");
        monsterTruckNames.add("Lucas Oil Crusader");
        monsterTruckNames.add("Madusa");
        monsterTruckNames.add("Maximum Destruction (Max-D)");
        monsterTruckNames.add("Mohawk Warrior");
        monsterTruckNames.add("Monster Mutt");
        monsterTruckNames.add("Monster Mutt Dalmation");
        monsterTruckNames.add("Predator");
        monsterTruckNames.add("Shell Camino");
        monsterTruckNames.add("Raminator");
        monsterTruckNames.add("Snake Bite");
        monsterTruckNames.add("Stone Crusher");
        monsterTruckNames.add("Sudden Impact");
        monsterTruckNames.add("Swamp Thing");
        monsterTruckNames.add("The Destroyer");
        monsterTruckNames.add("The Felon");
        monsterTruckNames.add("USA-1");
        monsterTruckNames.add("War Wizard");
        monsterTruckNames.add("WCW Nitro Machine");
        monsterTruckNames.add("Zombie");

        randomNumberGenerator = new RandomNumberGenerator();
        int randomNameIndex = randomNumberGenerator.generateRandomNumber(0, monsterTruckNames.size() - 1);
        String monsterTruckName = monsterTruckNames.get(randomNameIndex);
        if (monsterTruckNamesHashMap.containsKey(monsterTruckName)) {
            monsterTruckIndex = monsterTruckNamesHashMap.get(monsterTruckName);
            monsterTruckIndex++;
        } else {
            monsterTruckIndex = 1;
        }
        monsterTruckNamesHashMap.put(monsterTruckName, monsterTruckIndex);
        setName("Monster Truck " + monsterTruckName + "-" + monsterTruckIndex);
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000, 20000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0, 2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(0, 2);
        washBonus = 100;
        repairBonus = 200;
        salesBonus = 300;
        vehicleType = VehicleType.MONSTER_TRUCK;

        if (randomConditionNumber == 0) {
            setCondition(Condition.NEW);
        } else if (randomConditionNumber == 1) {
            setCondition(Condition.USED);
            setCostPrice(getCostPrice() * 0.8);
        } else {
            setCondition(Condition.BROKEN);
            setCostPrice(getCostPrice() * 0.5);
        }

        this.salePrice = 2 * costPrice;

        if (randomCleanlinessNumber == 0) {
            setCleanliness(Cleanliness.SPARKLING);
        } else if (randomCleanlinessNumber == 1) {
            setCleanliness(Cleanliness.CLEAN);
        } else {
            setCleanliness(Cleanliness.DIRTY);
        }
        setRacesWon(0);
        setFinalSalePrice(getSalePrice());

    }
}
