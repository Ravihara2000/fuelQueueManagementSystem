package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

    public static void main( String[] args ) {
        FuelSystem fuelSystem;
        int queueId;
        int adding;
        ArrayList<String> customers = new ArrayList<>();

        int FuelStock = 6600;
        Passenger passenger;
        FuelQueue[] pumps = new FuelQueue[5];
        for (int i=0; i<pumps.length; i++) {
            pumps[i] = new FuelQueue(i);
        }

        Scanner scn = new Scanner(System.in);

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
        System.out.println("110 or IFQ: Income of Fuel");
        System.out.println("999 or EXT: Exit the Program.");

        outer: while (true) {
            if (FuelStock < 500) {
                System.out.println("Warning: Stock are less than 500l");
            }

            System.out.println("\nEnter your option  :");
            String MenuOpt = scn.next();
            MenuOpt=MenuOpt.toUpperCase();

            int requiredLiters = 0;
            if (MenuOpt.equals("100") || MenuOpt.equals("VFQ")) {
                System.out.println("** All Fuel Queues **\n");

                for (FuelQueue fuelQueue : pumps) {
                    fuelQueue.viewPassengers();
                }

            } else if (MenuOpt.equals("101") || MenuOpt.equals("VEQ")) {
                System.out.println("** Empty Fuel Queues **");

                for (FuelQueue fuelQueue : pumps) {
                    if (fuelQueue.isEmpty()) {
                        System.out.println(String.format("Fuel queue %d is empty", fuelQueue.getId()));
                    }
                }

            } else if (MenuOpt.equals("102") || MenuOpt.equals("ACQ")) {


                System.out.println("Enter first name  :");
                String firstName = scn.next();

                System.out.println("Enter second name  :");
                String secondName = scn.next();

                System.out.println("Enter vehicle no  :");
                String vehicleNo = scn.next();

                System.out.println("Enter No. of liters required  :");
                requiredLiters = scn.nextInt();

                passenger = new Passenger(firstName, secondName, vehicleNo, requiredLiters);

                customers.add(passenger.getFullName());

                int minQueueId = 0;
                int minQueueCount = 0;

                //find the shortest Queue
                for (FuelQueue fuelQueue : pumps) {
                    if (fuelQueue.getQueueLength() <= minQueueCount) {
                        minQueueCount = fuelQueue.getQueueLength();
                        minQueueId = fuelQueue.getId();
                    }
                }

                pumps[minQueueId].addPassenger(passenger);

                System.out.println(String.format("customer is added to fuel queue %d", minQueueId));


            } else if (MenuOpt.equals("103") || MenuOpt.equals("RCQ")) {
                System.out.println("** Remove a customer from a Queue **");

                System.out.println("Enter the queue No  :");
                queueId = scn.nextInt();
                pumps[queueId].removePassenger();

                System.out.println(String.format("One customer is removed from fuel queue %d", queueId));


            } else if (MenuOpt.equals("104") || MenuOpt.equals("PCQ")) {
                System.out.println("** Remove a served customer **");

                System.out.println("Enter queue id to serve:");

                queueId= scn.nextInt();
                passenger = pumps[queueId].servePassenger();

                if(passenger==null){
                    System.out.println("Queue is empty");
                }else {
                    FuelStock -= passenger.getRequiredLiters();
                    System.out.println(String.format("First customer of the fuel queue %d is served", queueId));
                }


            } else if (MenuOpt.equals("105") || MenuOpt.equals("VCS")) {
                System.out.println("** View Customers Sorted in alphabetical order **");

                Collections.sort(customers);
                customers.forEach(s -> System.out.println(s));


            } else if (MenuOpt.equals("106") || MenuOpt.equals("SPD")) {
                System.out.println("** Store Program Data into file **");

                try {
                    File Store_data = new File("Fuel_details.txt");
                    FileOutputStream fos = new FileOutputStream("FuelSystem.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    fuelSystem = new FuelSystem();
                    fuelSystem.setStock(FuelStock);
                    fuelSystem.setCustomers(customers);
                    fuelSystem.setPumps(pumps);

                    oos.writeObject(fuelSystem);

                    oos.close();
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            } else if (MenuOpt.equals("107") || MenuOpt.equals("LPD")) {
                System.out.println("** Load Program Data from file **");

                try {
                    FileInputStream fi = new FileInputStream("FuelSystem.txt");
                    ObjectInputStream oi = new ObjectInputStream(fi);

                    fuelSystem = (FuelSystem) oi.readObject();
                    FuelStock = fuelSystem.getStock();
                    customers = fuelSystem.getCustomers();
                    pumps = fuelSystem.getPumps();

                    oi.close();
                    fi.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


            } else if (MenuOpt.equals("108") || MenuOpt.equals("STK")) {
                System.out.println("** View Remaining Fuel Stock **");
                System.out.println(String.format("Remaining Fuel Stock: %dl", FuelStock));

            } else if (MenuOpt.equals("109") || MenuOpt.equals("AFS")) {
                System.out.println("How many liters do you want to add :");
                double FuelAmount = scn.nextDouble();

                FuelStock += FuelAmount;
                System.out.println("Successfully added");
                System.out.println("Current stock is " + FuelStock + " L");


            } else if (MenuOpt.equals("110") || MenuOpt.equals("IFQ")) {
                System.out.println("** Income of queue **");

                System.out.println("Enter queue id:");
                queueId = scn.nextInt();

                System.out.println(String.format(
                        "Income of fuel queue %d is %d",
                        queueId,
                        pumps[queueId].getQueueIncome()
                ));


            } else if (MenuOpt.equals("999") || MenuOpt.equals("EXT")) {
                System.exit(0);

            } else {
                System.out.println("Error - Invalid number");
            }

        }
    }

}
