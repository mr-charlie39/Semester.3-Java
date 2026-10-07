import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.HashMap;

class Household {

    ArrayList<RecyclingEvent> rechousehold = new ArrayList<>();
    private UUID householdId;
    private String name;
    private String address;
    private LocalDate joiningDate;
    private double totalRecycledWeight;
    private int totalpoints;

    public Household(UUID householdId, String name, String address, LocalDate joiningDate) {
        this.householdId = householdId;
        this.name = name;
        this.address = address;
        this.joiningDate = joiningDate;
        this.rechousehold = new ArrayList<>();
        this.totalRecycledWeight = 0.0;
        this.totalpoints = 0;
    }

    public double getTotalRecycledWeight() {
        return totalRecycledWeight;
    }



    public void setTotalRecycledWeight(double totalRecycledWeight) {
        this.totalRecycledWeight = totalRecycledWeight;
    }



    public int getTotalpoints() {
        return totalpoints;
    }



    public void setTotalpoints(int totalpoints) {
        this.totalpoints = totalpoints;
    }



    public UUID getHouseholdId() {
        return householdId;
    }



    public void setHouseholdId(UUID householdId) {
        this.householdId = householdId;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public LocalDate getJoiningDate() {
        return joiningDate;
    }



    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }



    public ArrayList<RecyclingEvent> getRechousehold() {
        return rechousehold;
    }


    @Override
    public String toString() {
        return "Household{" +
                "householdId=" + householdId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", joiningDate=" + joiningDate +
                ", totalRecycledWeight=" + totalRecycledWeight +
                ", totalpoints=" + totalpoints +
                '}';
    }
}
class RecyclingEvent {

    private String materialType;
    private double weight;
    private LocalDate recyclingDate;
    private double pointsEarned;


    public RecyclingEvent(String materialType, double weight, LocalDate recyclingDate, double pointsEarned) {
        this.materialType = materialType;
        this.weight = weight;
        this.recyclingDate = recyclingDate;
        this.pointsEarned = pointsEarned;
    }


    public String getMaterialType() {
        return materialType;
    }


    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


    public LocalDate getRecyclingDate() {
        return recyclingDate;
    }


    public void setRecyclingDate(LocalDate recyclingDate) {
        this.recyclingDate = recyclingDate;
    }


    public double getPointsEarned() {
        return pointsEarned;
    }


    public void setPointsEarned(double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    @Override
    public String toString() {
        return "RecyclingEvent{" +
                "materialType='" + materialType + '\'' +
                ", weight=" + weight +
                ", recyclingDate=" + recyclingDate +
                ", pointsEarned=" + pointsEarned +
                '}';
    }

}

class Data_Manager {
    public static void household_data(Collection<Household> households) {
        try(PrintWriter writer = new PrintWriter(new FileWriter("households.txt"))) {

            for(Household household : households) {
                writer.println(household.toString());

                for(RecyclingEvent event : household.getRechousehold()){
                    writer.println(event.toString());
                }
            }
        }catch (Exception e) {
            System.out.println("Exception is : " + e.getMessage());
        }
    }
}

public class EcoPointsSystem {

    private HashMap<String, Household> households;

    public EcoPointsSystem() {
        households = new HashMap<>();
    }

    public void registerHousehold(String id,
                                  String name,
                                  String address) {

        if (households.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate Household ID.");
        }

        Household household =
                new Household(id, name, address, LocalDate.now());

        households.put(id, household);
    }

    public void logRecycling(String id,
                             String material,
                             double weight) {

        if (weight < 0)
            throw new IllegalArgumentException("Weight cannot be negative.");

        Household household = households.get(id);

        if (household == null) {
            System.out.println("Household not found.");
            return;
        }

        RecyclingEvent event =
                new RecyclingEvent(material, weight, LocalDate.now());

        household.addRecyclingEvent(event);
    }

    public void displayHouseholds() {

        for (Household h : households.values()) {

            System.out.println("-------------------------");
            System.out.println(h);
        }
    }

    public void displayEvents(String id) {

        Household h = households.get(id);

        if (h == null) {
            System.out.println("Household not found.");
            return;
        }

        for (RecyclingEvent e : h.getRecyclingEvents()) {
            System.out.println(e);
        }
    }

    public void displayTotals(String id) {

        Household h = households.get(id);

        if (h == null) {
            System.out.println("Household not found.");
            return;
        }

        System.out.println("Weight = " +
                h.getTotalWeight() +
                " kg");

        System.out.println("Points = " +
                h.getTotalPoints());
    }

    public void highestPoints() {

        Household best = null;

        for (Household h : households.values()) {

            if (best == null ||
                    h.getTotalPoints() > best.getTotalPoints()) {

                best = h;
            }
        }

        if (best != null) {

            System.out.println("Highest Points Household");
            System.out.println(best);
        }
    }

    public void totalCommunityWeight() {

        double total = 0;

        for (Household h : households.values()) {
            total += h.getTotalWeight();
        }

        System.out.println("Community Weight = " + total + " kg");
    }

    public HashMap<String, Household> getHouseholds() {
        return households;
    }
}

public class EcoPointsSystem {

    private HashMap<String, Household> households;

    public EcoPointsSystem() {
        households = new HashMap<>();
    }

    public void registerHousehold(String id,
                                  String name,
                                  String address) {

        if (households.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate Household ID.");
        }

        Household household =
                new Household(id, name, address, LocalDate.now());

        households.put(id, household);
    }

    public void logRecycling(String id,
                             String material,
                             double weight) {

        if (weight < 0)
            throw new IllegalArgumentException("Weight cannot be negative.");

        Household household = households.get(id);

        if (household == null) {
            System.out.println("Household not found.");
            return;
        }

        RecyclingEvent event =
                new RecyclingEvent(material, weight, LocalDate.now());

        household.addRecyclingEvent(event);
    }

    public void displayHouseholds() {

        for (Household h : households.values()) {

            System.out.println("-------------------------");
            System.out.println(h);
        }
    }

    public void displayEvents(String id) {

        Household h = households.get(id);

        if (h == null) {
            System.out.println("Household not found.");
            return;
        }

        for (RecyclingEvent e : h.getRecyclingEvents()) {
            System.out.println(e);
        }
    }

    public void displayTotals(String id) {

        Household h = households.get(id);

        if (h == null) {
            System.out.println("Household not found.");
            return;
        }

        System.out.println("Weight = " +
                h.getTotalWeight() +
                " kg");

        System.out.println("Points = " +
                h.getTotalPoints());
    }

    public void highestPoints() {

        Household best = null;

        for (Household h : households.values()) {

            if (best == null ||
                    h.getTotalPoints() > best.getTotalPoints()) {

                best = h;
            }
        }

        if (best != null) {

            System.out.println("Highest Points Household");
            System.out.println(best);
        }
    }

    public void totalCommunityWeight() {

        double total = 0;

        for (Household h : households.values()) {
            total += h.getTotalWeight();
        }

        System.out.println("Community Weight = " + total + " kg");
    }

    public HashMap<String, Household> getHouseholds() {
        return households;
    }
}

public class RecyclingProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EcoPointsSystem system = new EcoPointsSystem();

        while (true) {

            System.out.println("\n====== EcoPoints Recycling Program ======");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. Display Households");
            System.out.println("4. Display Household Events");
            System.out.println("5. Display Household Totals");
            System.out.println("6. Highest Points Report");
            System.out.println("7. Community Weight Report");
            System.out.println("8. Save Data");
            System.out.println("9. Exit");

            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Address: ");
                        String address = sc.nextLine();

                        system.registerHousehold(id, name, address);

                        System.out.println("Household Registered.");

                        break;

                    case 2:

                        System.out.print("Household ID: ");
                        id = sc.nextLine();

                        System.out.print("Material: ");
                        String material = sc.nextLine();

                        System.out.print("Weight: ");
                        double weight = sc.nextDouble();

                        system.logRecycling(id, material, weight);

                        System.out.println("Recycling Event Added.");

                        break;

                    case 3:

                        system.displayHouseholds();

                        break;

                    case 4:

                        System.out.print("Household ID: ");
                        id = sc.nextLine();

                        system.displayEvents(id);

                        break;

                    case 5:

                        System.out.print("Household ID: ");
                        id = sc.nextLine();

                        system.displayTotals(id);

                        break;

                    case 6:

                        system.highestPoints();

                        break;

                    case 7:

                        system.totalCommunityWeight();

                        break;

                    case 8:

                        DataManager.saveHouseholds(system.getHouseholds().values());

                        System.out.println("Data Saved.");

                        break;

                    case 9:

                        System.out.println("Goodbye!");
                        return;

                    default:

                        System.out.println("Invalid Choice.");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}