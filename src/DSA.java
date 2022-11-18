import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DSA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        prefabOrNot prefabOrNot1 = new prefabOrNot();
        prefabOrNot1.prefabOrNot();
        String name = "";
        int MU = prefabOrNot1.MU;
        int KL = prefabOrNot1.KL;
        int IN = prefabOrNot1.IN;
        int CH = prefabOrNot1.CH;
        int FF = prefabOrNot1.FF;
        int GE = prefabOrNot1.GE;
        int KO = prefabOrNot1.KO;
        int KK = prefabOrNot1.KK;
        characterPrefab character = new characterPrefab(name, MU, KL, IN, CH, FF, GE, KO, KK);
        introduction();
        chooseVersion(MU, KL, IN, CH, FF, GE, KO, KK);
    }

    static void introduction() {
        System.out.println("Hey and welcome! Do you want to choose the light (l) or the full (f) version?");
        System.out.println("In the light version you keep all the fun of throwing the dices yourself while not having to do tedious math!");
        System.out.println("In the full version everything is done for you, you don't even need a dice in the first place!");
        System.out.print("Enter l or f: ");
    }


    static void fullVersion(int MU, int KL, int IN, int CH, int FF, int GE, int KO, int KK) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat2 = true;
        int skill1 = -1;
        int skill2 = -1;
        int skill3 = -1;
        while (repeat2) {

            int number_Of_Times = 3;
            int skillNumber = 0;
            System.out.println("Enter the tested main skills: ");
            while (number_Of_Times >= 1) {
                number_Of_Times--;
                skillNumber++;
                System.out.print("skill" + skillNumber + ": ");
                String mainSkill = scanner.next().toUpperCase();
                switch (mainSkill) {
                    case "MU":
                        if ((skill1 == -1))
                            skill1 = MU;
                        else if ((skill2 == -1))
                            skill2 = MU;
                        else
                            skill3 = MU;
                        break;
                    case "KL":
                        if ((skill1 == -1))
                            skill1 = KL;
                        else if ((skill2 == -1))
                            skill2 = KL;
                        else
                            skill3 = KL;
                        break;
                    case "IN":
                        if ((skill1 == -1))
                            skill1 = IN;
                        else if ((skill2 == -1))
                            skill2 = IN;
                        else
                            skill3 = IN;
                        break;
                    case "CH":
                        if ((skill1 == -1))
                            skill1 = CH;
                        else if ((skill2 == -1))
                            skill2 = CH;
                        else
                            skill3 = CH;
                        break;
                    case "FF":
                        if ((skill1 == -1))
                            skill1 = FF;
                        else if ((skill2 == -1))
                            skill2 = FF;
                        else
                            skill3 = FF;
                        break;
                    case "GE":
                        if ((skill1 == -1))
                            skill1 = GE;
                        else if ((skill2 == -1))
                            skill2 = GE;
                        else
                            skill3 = GE;
                        break;
                    case "KO":
                        if ((skill1 == -1))
                            skill1 = KO;
                        else if ((skill2 == -1))
                            skill2 = KO;
                        else
                            skill3 = KO;
                        break;
                    case "KK":
                        if ((skill1 == -1))
                            skill1 = KK;
                        else if ((skill2 == -1))
                            skill2 = KK;
                        else
                            skill3 = KK;
                        break;
                    default:
                        System.out.println("Please enter a valid Skill");
                        number_Of_Times++;
                        skillNumber--;
                        break;
                }

            }
            System.out.print("Points in the tested skill: ");
            int testedSkill = scanner.nextInt();
            System.out.println("Is the skill harder (h) or easier (e)? to skip this enter (n)");
            String harderOrEasier = scanner.next();
            if (!harderOrEasier.equals("h") && !harderOrEasier.equals("e"))
                System.out.println("This will be a normal Test!");
            else if (harderOrEasier.equals("h")) {
                System.out.print("Enter how much harder is it: ");
                int h = scanner.nextInt();
                skill1 = skill1 - h;
                skill2 = skill2 - h;
                skill3 = skill3 - h;
            } else {
                System.out.print("Enter how much easier it is: ");
                int e = scanner.nextInt();
                skill1 = skill1 + e;
                skill2 = skill2 + e;
                skill3 = skill3 + e;
            }
            int originalTestedSkill = testedSkill;
            System.out.println("Throwing the Dices!");
            Random r = new Random();
            int dice1 = r.nextInt(20) + 1;
            int dice2 = r.nextInt(20) + 1;
            int dice3 = r.nextInt(20) + 1;
            int dice4 = r.nextInt(20) + 1;
            boolean useless = false;
            System.out.println(dice1);
            System.out.println(dice2);
            System.out.println(dice3);

            if ((dice1 == 20 || dice2 == 20 || dice3 == 20) && (dice4 == 20)) {
                System.out.println("Your control dice has a value of: " + dice4);
                System.out.println("Your test failed horribly!");
                useless = true;

            }
            if ((dice1 == 20 || dice2 == 20 || dice3 == 20) && (dice4 != 20)) {
                System.out.println("Your control dice has a value of: " + dice4);
                System.out.println("Your test failed :(");
                useless = true;
            }

            if ((dice1 == 1 || dice2 == 1 || dice3 == 1) && (dice4 == 1)) {
                System.out.println("Your control dice has a value of: " + dice4);
                System.out.println("A legendary throw!");
                useless = true;
            }
            if ((dice1 == 1 || dice2 == 1 || dice3 == 1) && (dice4 != 1)) {
                System.out.println("Your control dice has a value of: " + dice4);
                System.out.println("Your test succeeded with a quality of" + (testedSkill / 3));
                useless = true;
            }


            if (dice1 > skill1)
                testedSkill = testedSkill - (dice1 - skill1);
            if (dice2 > skill2)
                testedSkill = testedSkill - (dice2 - skill2);
            if (dice3 > skill3)
                testedSkill = testedSkill - (dice3 - skill3);

            int quality = 0;
            if (testedSkill >= 0 && testedSkill <= 3)
                quality = 1;
            if (testedSkill >= 4 && testedSkill <= 6)
                quality = 2;
            if (testedSkill >= 7 && testedSkill <= 9)
                quality = 3;
            if (testedSkill >= 10 && testedSkill <= 12)
                quality = 4;
            if (testedSkill >= 13 && testedSkill <= 15)
                quality = 5;
            if (testedSkill >= 16)
                quality = 6;

            if (testedSkill < 0 && !useless)
                System.out.println("Your test failed :(");
            else if (testedSkill >= 0 && !useless)
                System.out.println("Your Test succeeded with a quality of " + quality + "!");
            System.out.println("To repeat with current stats enter y, otherwise enter n");
            if (!scanner.next().equals("y"))
                break;
        }
    }

    static void lightVersion(int MU, int KL, int IN, int CH, int FF, int GE, int KO, int KK) {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        boolean repeat2 = true;
        while (repeat2) {
            int skill1 = -1;
            int skill2 = -1;
            int skill3 = -1;
            int number_Of_Times = 3;
            int skillNumber = 0;
            System.out.println("Enter the tested main skills: ");
            while (number_Of_Times >= 1) {
                number_Of_Times--;
                skillNumber++;
                System.out.print("skill" + skillNumber + ": ");
                String mainSkill = scanner.next().toUpperCase();
                switch (mainSkill) {
                    case "MU":
                        if ((skill1 == -1))
                            skill1 = MU;
                        else if ((skill2 == -1))
                            skill2 = MU;
                        else
                            skill3 = MU;
                        break;
                    case "KL":
                        if ((skill1 == -1))
                            skill1 = KL;
                        else if ((skill2 == -1))
                            skill2 = KL;
                        else
                            skill3 = KL;
                        break;
                    case "IN":
                        if ((skill1 == -1))
                            skill1 = IN;
                        else if ((skill2 == -1))
                            skill2 = IN;
                        else
                            skill3 = IN;
                        break;
                    case "CH":
                        if ((skill1 == -1))
                            skill1 = CH;
                        else if ((skill2 == -1))
                            skill2 = CH;
                        else
                            skill3 = CH;
                        break;
                    case "FF":
                        if ((skill1 == -1))
                            skill1 = FF;
                        else if ((skill2 == -1))
                            skill2 = FF;
                        else
                            skill3 = FF;
                        break;
                    case "GE":
                        if ((skill1 == -1))
                            skill1 = GE;
                        else if ((skill2 == -1))
                            skill2 = GE;
                        else
                            skill3 = GE;
                        break;
                    case "KO":
                        if ((skill1 == -1))
                            skill1 = KO;
                        else if ((skill2 == -1))
                            skill2 = KO;
                        else
                            skill3 = KO;
                        break;
                    case "KK":
                        if ((skill1 == -1))
                            skill1 = KK;
                        else if ((skill2 == -1))
                            skill2 = KK;
                        else
                            skill3 = KK;
                        break;
                    default:
                        System.out.println("Please enter a valid Skill");
                        number_Of_Times++;
                        skillNumber--;
                        break;
                }
            }

            System.out.print("Points in the tested skill: ");
            int testedSkill = scanner.nextInt();
            System.out.println("Is the skill harder (h) or easier (e)? to skip this enter (n)");
            String harderOrEasier = scanner.next();
            if (!harderOrEasier.equals("h") && !harderOrEasier.equals("e"))
                System.out.println("This will be a normal Test!");
            else if (harderOrEasier.equals("h")) {
                System.out.print("Enter how much harder is it: ");
                int h = scanner.nextInt();
                skill1 = skill1 - h;
                skill2 = skill2 - h;
                skill3 = skill3 - h;
            } else {
                System.out.print("Enter how much easier it is: ");
                int e = scanner.nextInt();
                skill1 = skill1 + e;
                skill2 = skill2 + e;
                skill3 = skill3 + e;
            }


            int originalTestedSkill = testedSkill;
            System.out.println("Throwing the Dices!");
            Random r = new Random();
            System.out.print("First Dice: ");
            int dice1 = scanner.nextInt();
            System.out.print("Second Dice: ");
            int dice2 = scanner.nextInt();
            System.out.print("Third Dice: ");
            int dice3 = scanner.nextInt();
            int dice4 = -1;
            boolean useless = false;


            if (dice1 == 20 || dice2 == 20 || dice3 == 20) {
                System.out.println("Oh no, you threw a 20! Please throw a control dice!");
                System.out.print("Control dice: ");
                dice4 = scanner.nextInt();
                useless = true;
                if (dice4 == 20)
                    System.out.println("Your test failed horribly and something terrible will happen!");
                else if (dice4 != 20)
                    System.out.println("Your test failed but nothing terrible happened");
            }

            if (dice1 == 1 || dice2 == 1 || dice3 == 1) {
                System.out.println("Oh wow, you rolled a 1! Please throw a control dice!");
                System.out.print("Control dice: ");
                dice4 = scanner.nextInt();
                useless = true;
                if (dice4 == 1)
                    System.out.println("Your test went perfectly, what a legendary throw!");
                else if (dice4 != 20)
                    System.out.println("Your test succeeded but nothing special happened!");
            }


            if (dice1 > skill1)
                testedSkill = testedSkill - (dice1 - skill1);
            if (dice2 > skill2)
                testedSkill = testedSkill - (dice2 - skill2);
            if (dice3 > skill3)
                testedSkill = testedSkill - (dice3 - skill3);

            int quality = 0;
            if (testedSkill >= 0 && testedSkill <= 3)
                quality = 1;
            if (testedSkill >= 4 && testedSkill <= 6)
                quality = 2;
            if (testedSkill >= 7 && testedSkill <= 9)
                quality = 3;
            if (testedSkill >= 10 && testedSkill <= 12)
                quality = 4;
            if (testedSkill >= 13 && testedSkill <= 15)
                quality = 5;
            if (testedSkill >= 16)
                quality = 6;

            if (testedSkill < 0 && !useless)
                System.out.println("Your test failed :(");
            else if (testedSkill >= 0 && !useless)
                System.out.println("Your Test succeeded with a quality of " + quality + "!");
            System.out.println("To repeat with current stats enter y, otherwise enter n");
            if (!scanner.next().equals("y"))
                break;
        }
    }

    static void chooseVersion(int MU, int KL, int IN, int CH, int FF, int GE, int KO, int KK) {
        Scanner scanner = new Scanner(System.in);
        String version = scanner.next();
        boolean repeat = true;
        while (repeat) {
            if (version.equals("f")) {
                fullVersion(MU, KL, IN, CH, FF, GE, KO, KK);
                break;
            } else if (version.equals("l")) {
                lightVersion(MU, KL, IN, CH, FF, GE, KO, KK);
                break;
            } else {
                System.out.println("Please input a valid Version");
                break;
            }
        }

    }
}
