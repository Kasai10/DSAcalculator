import java.io.*;
import java.util.Scanner;

public class prefabOrNot {
    int MU = 0;
    int KL = 0;
    int IN = 0;
    int CH = 0;
    int FF = 0;
    int GE = 0;
    int KO = 0;
    int KK = 0;

    void prefabOrNot() {
        boolean repeat = true;
        while (repeat) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("To create a new character enter (c) to select a character enter (s) to delete a character enter (d): ");
            String name = "";
            int MU = 0;
            int KL = 0;
            int IN = 0;
            int CH = 0;
            int FF = 0;
            int GE = 0;
            int KO = 0;
            int KK = 0;
            String hasCharacterAlready = scanner.next().toLowerCase();
            if (hasCharacterAlready.equals("c")) {

                System.out.print("Enter a name: ");
                name = scanner.next().toLowerCase();
                System.out.print("MU: ");
                this.MU = scanner.nextInt();
                System.out.print("KL: ");
                this.KL = scanner.nextInt();
                System.out.print("IN: ");
                this.IN = scanner.nextInt();
                System.out.print("CH: ");
                this.CH = scanner.nextInt();
                System.out.print("FF: ");
                this.FF = scanner.nextInt();
                System.out.print("GE: ");
                this.GE = scanner.nextInt();
                System.out.print("KO: ");
                this.KO = scanner.nextInt();
                System.out.print("KK: ");
                this.KK = scanner.nextInt();
                characterPrefab character = new characterPrefab(name, MU, KL, IN, CH, FF, GE, KO, KK);
                repeat = false;

                try {

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\simob\\OneDrive\\Desktop\\Test\\" + name + ".txt"));
                    bufferedWriter.write("Name: " + name);
                    bufferedWriter.newLine();
                    bufferedWriter.write("MU: " + String.valueOf(MU));
                    bufferedWriter.newLine();
                    bufferedWriter.write("KL: " + String.valueOf(KL));
                    bufferedWriter.newLine();
                    bufferedWriter.write("IN: " + String.valueOf(IN));
                    bufferedWriter.newLine();
                    bufferedWriter.write("CH: " + String.valueOf(CH));
                    bufferedWriter.newLine();
                    bufferedWriter.write("FF: " + String.valueOf(FF));
                    bufferedWriter.newLine();
                    bufferedWriter.write("KK: " + String.valueOf(KK));
                    bufferedWriter.newLine();
                    bufferedWriter.write("GE: " + String.valueOf(GE));
                    bufferedWriter.newLine();
                    bufferedWriter.write("KO: " + String.valueOf(KO));
                    bufferedWriter.newLine();
                    bufferedWriter.write("KK: " + String.valueOf(KK));
                    bufferedWriter.close();

                } catch (Exception ex) {
                    System.out.println("Didnt work");
                    return;
                }

            } else if (hasCharacterAlready.equals("s")) {
                System.out.print("Please enter your name: ");
                name = scanner.next();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\simob\\OneDrive\\Desktop\\Test\\" + name + ".txt"));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.startsWith("Name: ")) {
                            name = line;
                        } else if (line.startsWith("MU: ")) {
                            if (line.length() == 6)
                                this.MU = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.MU = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("KL: ")) {
                            if (line.length() == 6)
                                this.KL = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.KL = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("IN: ")) {
                            if (line.length() == 6)
                                this.IN = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.IN = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("CH: ")) {
                            if (line.length() == 6)
                                this.CH = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.CH = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("KK: ")) {
                            if (line.length() == 6)
                                this.FF = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.FF = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("KK: ")) {
                            if (line.length() == 6)
                                this.GE = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.KO = Integer.valueOf(line.substring(line.length() - 1));
                        } else if (line.startsWith("KK: ")) {
                            if (line.length() == 6)
                                this.KK = Integer.valueOf(line.substring(line.length() - 2));
                            else
                                this.KK = Integer.valueOf(line.substring(line.length() - 1));
                        }
                    }
                    characterPrefab character = new characterPrefab(name, MU, KL, IN, CH, FF, GE, KO, KK);
                    repeat = false;
                    bufferedReader.close();
                } catch (IOException ioException) {
                    System.out.println("Didnt work");
                    return;
                }
            } else if (hasCharacterAlready.equals("d")) {
                System.out.print("Enter the Name of the character you want to delete: ");
                name = scanner.next().toLowerCase();
                File file = new File("C:\\Users\\simob\\OneDrive\\Desktop\\Test\\" + name + ".txt");
                file.delete();
            } else
                System.out.println("Please enter something valid next time!");
        }
    }
}

