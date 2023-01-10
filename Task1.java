package ArrayVersion;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task1 {





        static int FuelStock = 6600;

        public static void main(String[] args) throws IOException {
            int x1 = 0;
            Scanner scn = new Scanner(System.in);

            String[] ThePump = new String[21];


            int Pump1free = 0;
            int Pump2free = 0;
            int Pump3free = 0;


            int menuCount = 1;

            System.out.println("****Fuel Queue Management System.****\n");

            System.out.println("100 or VFQ: View all Fuel Queues.");
            System.out.println("101 or VEQ: View all Empty Queues");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue.");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order.");
            System.out.println("106 or SPD: Store Program Data into file");
            System.out.println("107 or LPD: Load Program Data from file.");
            System.out.println("108 or STK: View Remaining Fuel Stock.");
            System.out.println("109 or AFS: Add Fuel Stock.");
            System.out.println("999 or EXT: Exit the Program.");


            while (menuCount > -1) {

                System.out.println("Enter your option  :");
                String MenuOpt = scn.next();
                MenuOpt=MenuOpt.toUpperCase();

                if (MenuOpt.equals("100") || MenuOpt.equals("VFQ")) {
                    ViewFuelQueues(ThePump, Pump1free, Pump2free, Pump3free);
                } else if (MenuOpt.equals("101") || MenuOpt.equals("VEQ")) {
                    ViewEmptyQueue(ThePump, Pump1free, Pump2free, Pump3free);
                } else if (MenuOpt.equals("102") || MenuOpt.equals("ACQ")) {
                    AddCustomers(ThePump);
                } else if (MenuOpt.equals("103") || MenuOpt.equals("RCQ")) {
                    RemoveCustomers(ThePump);

                } else if (MenuOpt.equals("104") || MenuOpt.equals("PCQ")) {
                    RemoveServedCustomer(ThePump);

                } else if (MenuOpt.equals("105") || MenuOpt.equals("VCS")) {
                    SortedNames(ThePump);

                } else if (MenuOpt.equals("106") || MenuOpt.equals("SPD")) {
                    StoreDataIntoFile(ThePump);

                } else if (MenuOpt.equals("107") || MenuOpt.equals("LPD")) {
                    LoadData(ThePump);

                } else if (MenuOpt.equals("108") || MenuOpt.equals("STK")) {
                    RemainingFuel();

                } else if (MenuOpt.equals("109") || MenuOpt.equals("AFS")) {
                    ADDFuel();

                } else if (MenuOpt.equals("999") || MenuOpt.equals("EXT")) {
                    System.exit(0);

                } else {
                    System.out.println("Invalid input!!!");
                }

                menuCount++;
            }
        }



    //view the fuel Queue
        public static void ViewFuelQueues(String[] ThePump, int Pump1free, int Pump2free, int Pump3free) {

            for (int x = 0; x < 6; x++) {
                System.out.println(ThePump[x]);
            }
            for (int x = 0; x < 6; x++) {
                if (ThePump[x] == null) {
                    Pump1free++;
                    if (Pump1free == 6) {
                        System.out.println("Queue 1 is empty");
                    }
                }
            }
            System.out.println("Pump 1: available slots amount is " + Pump1free);
            System.out.println("-------------------------------------------------------------\n");

            for (int x = 7; x < 13; x++) {
                System.out.println(ThePump[x]);
            }
            for (int x = 7; x < 13; x++) {
                if (ThePump[x] == null) {
                    Pump2free++;
                    if (Pump2free == 6) {
                        System.out.println("Queue 2 is empty");
                    }
                }
            }
            System.out.println("Pump 2: available slots amount is " + Pump2free);
            System.out.println("-------------------------------------------------------------\n");

            for (int x = 14; x < 20; x++) {
                System.out.println(ThePump[x]);
            }
            for (int x = 14; x < 20; x++) {
                if (ThePump[x] == null) {
                    Pump3free++;
                    if (Pump3free == 6) {
                        System.out.println("Queue 3 is empty");
                    }
                }
            }
            System.out.println("Pump 3: available slots amount is " + Pump3free);
            System.out.println("-------------------------------------------------------------\n");
        }

        //View Empty fuel Queue
        public static void ViewEmptyQueue(String[] ThePump, int Pump1free, int Pump2free, int Pump3free) {
            for (int x = 0; x < 6; x++) {
                if (ThePump[x] == null) {
                    Pump1free++;
                    if (Pump1free == 6) {
                        System.out.println("Queue 1 is empty");
                    }
                }
            }
            for (int x = 7; x < 13; x++) {
                if (ThePump[x] == null) {
                    Pump2free++;
                    if (Pump2free == 6) {
                        System.out.println("Queue 2 is empty");
                    }
                }
            }

            for (int x = 14; x < 20; x++) {
                if (ThePump[x] == null) {
                    Pump3free++;
                    if (Pump3free == 6) {
                        System.out.println("Queue 3 is empty");
                    }
                }
            }
        }

        //add customers to Queue
        public static void AddCustomers(String[] ThePump) {
            Scanner scn = new Scanner(System.in);

            for (int i = 1; i > -1; i++) {

                System.out.println("Enter the Pump number (1-3) or Press 0 to come back to menu  :");
                int PumpNo = scn.nextInt();

                if (PumpNo == 1) {
                    for(int c=0;c<6;c++) {
                        if (ThePump[5] == null) {
                            for (int w = 0; w < 6; w++) {
                                if (ThePump[w] == null) {
                                    System.out.println("Enter customer name  :");
                                    ThePump[w] = scn.next();
                                    System.out.println(ThePump[w] + " added to the Queue 1 successfully");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Queue 1 is full");
                            break;
                        }break;
                    }

                } else if (PumpNo == 2) {
                    for(int c=7;c<13;c++) {
                        if (ThePump[12] == null) {
                            for (int w = 7; w < 13; w++) {
                                if (ThePump[w] == null) {
                                    System.out.println("Enter customer name  :");
                                    ThePump[w] = scn.next();
                                    System.out.println(ThePump[w] + " added to the Queue 2 successfully");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Queue 2 is full");
                            break;
                        }break;
                    }

                } else if (PumpNo == 3) {
                    for(int c=14;c<20;c++) {
                        if (ThePump[19] == null) {
                            for (int w = 14; w < 21; w++) {
                                if (ThePump[w] == null) {
                                    System.out.println("Enter customer name  :");
                                    ThePump[w] = scn.next();
                                    System.out.println(ThePump[w] + " added to the Queue 3 successfully");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Queue 3 is full");
                            break;
                        }break;
                    }

                } else if (PumpNo == 0) {
                    break;

                } else {
                    System.out.println("Invalid input");
                    break;
                }
            }
        }

        /*Remove customer from Queue*/
        public static void RemoveCustomers(String[] ThePump) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter the Queue number :");
            int Qnumber = scn.nextInt();

            if (Qnumber == 1) {
                System.out.println("Enter the position of the queue you wish to remove  :");
                int RemoName = scn.nextInt();
                    if (RemoName >= 7) {
                        System.out.println("invalid input.There are maximum 6 people in the queue");
                    } else {
                        if (ThePump[RemoName - 1] == null) {
                            System.out.println("There is no person in that location");
                        } else {
                            for (int x = RemoName - 1; x < 6; x++) {
                                ThePump[x] = ThePump[x + 1];
                            }
                            System.out.println("No " + RemoName + " removed from Queue 1");
                        }
                    }

            } else if (Qnumber == 2) {
                System.out.println("Enter the position of the queue you wish to remove  :");
                int RemoName = scn.nextInt();
                if (RemoName >= 7) {
                    System.out.println("invalid input.There are maximum 6 people in the queue");
                }else {
                    if (ThePump[RemoName +6] == null) {
                        System.out.println("There is no person in that location");
                    }else {
                        for (int x = RemoName + 6; x < 13; x++) {
                            ThePump[x] = ThePump[x + 1];
                        }
                        System.out.println("No " + RemoName + " removed from Queue 2");
                    }
                }
            } else if (Qnumber == 3) {
                System.out.println("Enter the position of the queue you wish to remove  :");
                int RemoName = scn.nextInt();
                if (RemoName >= 7) {
                    System.out.println("invalid input.There are maximum 6 people in the queue");
                }else {
                    if (ThePump[RemoName +13] == null) {
                        System.out.println("There is no person in that location");
                    } else {
                        for (int x = RemoName + 13; x < 20; x++) {
                            ThePump[x] = ThePump[x + 1];
                        }
                        System.out.println("No " + RemoName + " removed from Queue 3");
                    }
                }
            } else {
                System.out.println("Invalid input");
            }
        }

        /*Remove served customer*/
        public static void RemoveServedCustomer(String[] ThePump) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter the Queue number :");
            int QueueNO = scn.nextInt();

            if (QueueNO == 1) {
                if(ThePump[0]==null){
                    System.out.println("There is no person in queue 1");
                }else {
                    for (int x = 0; x < 6; x++) {
                        ThePump[x] = ThePump[x + 1];
                    }
                    FuelStock = FuelStock - 10;
                    System.out.println("Served and removed from Queue 1");
                }
            } else if (QueueNO == 2) {
                if(ThePump[7]==null){
                    System.out.println("There is no person in queue 2");
                }else {
                    for (int x = 7; x < 13; x++) {
                        ThePump[x] = ThePump[x + 1];
                    }
                    FuelStock = FuelStock - 10;
                    System.out.println("Served and removed from Queue 2");
                }
            } else if (QueueNO == 3) {
                if(ThePump[14]==null){
                    System.out.println("There is no person in queue 3");
                }else {
                    for (int x = 14; x < 20; x++) {
                        ThePump[x] = ThePump[x + 1];
                    }
                    FuelStock = FuelStock - 10;
                    System.out.println("Served and removed from Queue 3");
                }
            } else {
                System.out.println("Invalid input");
            }
            if (FuelStock <= 500) {
                System.out.println("****Remaining fuel amount is "+FuelStock+"L ****");
            }

        }

        /*View Customers Sorted in alphabetical order*/
        public static void SortedNames(String[] ThePump) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Which Queue do you want to sort :");
            int Qnum = scn.nextInt();
            if (Qnum == 1){
                String[] Q1temparray = new String[]{"empty", "empty", "empty", "empty", "empty", "empty"};
                int cnt = 0;
                for (int y = 0; y < 6; y++) {
                    if (ThePump[y] != null) {
                        Q1temparray[y] = ThePump[y];
                        cnt++;
                    }
                }

                String temp;
                for (int i = 0; i < cnt; i++) {
                    for (int j = i + 1; j < cnt; j++) {
                        if (Q1temparray[i].compareTo(Q1temparray[j]) > 0) {
                            temp = Q1temparray[i];
                            Q1temparray[i] = Q1temparray[j];
                            Q1temparray[j] = temp;
                        }
                    }
                }
                for (String name : Q1temparray) {
                    System.out.println(name);
                }
            } else if (Qnum==2){
                String[] Q2temparray = new String[]{"empty", "empty", "empty", "empty", "empty", "empty"};
                int cnt = 0;
                for (int y = 7; y < 13; y++) {

                    if (ThePump[y] != null) {
                        Q2temparray[y-7] = ThePump[y];
                        cnt++;
                    }
                }

                String temp;
                for (int i = 0; i < cnt; i++) {
                    for (int j = i + 1; j < cnt; j++) {
                        if (Q2temparray[i].compareTo(Q2temparray[j]) > 0) {
                            temp = Q2temparray[i];
                            Q2temparray[i] = Q2temparray[j];
                            Q2temparray[j] = temp;
                        }
                    }
                }
                for (String name : Q2temparray) {
                    System.out.println(name);
                }
            } else if (Qnum==3){
                String[] Q3temparray = new String[]{"empty", "empty", "empty", "empty", "empty", "empty"};
                int cnt = 0;
                for (int y = 14; y < 20; y++) {

                    if (ThePump[y] != null) {
                        Q3temparray[y-14] = ThePump[y];
                        cnt++;
                    }
                }

                String temp;
                for (int i = 0; i < cnt; i++) {
                    for (int j = i + 1; j < cnt; j++) {
                        if (Q3temparray[i].compareTo(Q3temparray[j]) > 0) {
                            temp = Q3temparray[i];
                            Q3temparray[i] = Q3temparray[j];
                            Q3temparray[j] = temp;
                        }
                    }
                }
                for (String name : Q3temparray) {
                    System.out.println(name);
                }
            }else{
                System.out.println("invalid input");
            }
        }
        /*Remaining fuel stock*/
        public static void RemainingFuel() {
            System.out.println("Remaining Fuel stock is " + FuelStock + " liters");
        }

        /*add fuel stock*/
        public static void ADDFuel() {
            Scanner scn = new Scanner(System.in);

            System.out.println("How many liters do you want to add :");
            double FuelAmount = scn.nextDouble();

            FuelStock += FuelAmount;
            System.out.println("Successfully added");
            System.out.println("Current stock is "+FuelStock+" L");

        }

        /*Store Program Data into file.*/
        public static void StoreDataIntoFile(String[] ThePump){

            File Store_data = new File("Fuel_details.txt");
            try {
                PrintStream write = new PrintStream(Store_data);
                write.println("Pump 1");

                for (int i=0;i<6;i++){
                    write.println(ThePump[i]);
                }

                write.println("Pump 2");

                for (int i=7;i<13;i++){
                    write.println(ThePump[i]);
                }

                write.println("Pump 3");

                for (int i=14;i<20;i++){
                    write.println(ThePump[i]);
                }
                System.out.println("Saved successfully...!");
                write.close();
            } catch (FileNotFoundException e) {
                /*throw new RuntimeException(e);*/
            }


        }

        /*Load Program Data from file.*/
        public static void LoadData(String[] ThePump)throws IOException{

            /*File Store_data = new File("Fuel_details.txt");
            Scanner scn = new Scanner(Store_data);*/

           FileReader f = new FileReader("Fuel_details.txt");
            BufferedReader b = new BufferedReader(f);

            String i ;
            while((i = b.readLine()) != null) {
                System.out.println((String) i);
            }
            b.close();
            f.close();

        }


    }


