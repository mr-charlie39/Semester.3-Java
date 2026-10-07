import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList_1 {
    private ArrayList<Object>[] list;

    ArrayList_1(int n) {
        list = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            list[i] = new ArrayList<Object>();
        }

    }
    Scanner s = new Scanner(System.in);
    
    private void add(int n){
         
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter Name of Student " + (i+1) + " : ");
            String student = s.next();
            System.out.print("Enter Age of Student " + (i+1) + " : ");
            String age = s.next();

            System.out.print("Enter Grade of Student " + (i+1) + " : ");
            String grade = s.next();

            list[i].add(student);
            list[i].add(age);
            list[i].add(grade);

        }

    }

    private void display() {
        for(ArrayList<Object> studentlist : list) {
            for(Object list : studentlist){
                System.out.println(list);
            }
        }
    }

    private void update (){
        System.out.println("Enter the name of student you want to update : ");
        String name = s.next();
        for(ArrayList<Object> studentlist : list) {
            if(studentlist.get(0).equals(name)){
                System.out.print("Enter new name of Student : ");
                String student = s.next();
                studentlist.set(0, student);
    }
        }
    }

    private void remove(){
        System.out.println("Enter the name of student you want to remove : ");
        String name = s.next();
        for(ArrayList<Object> studentlist : list) {
            if(studentlist.get(0).equals(name)){
                studentlist.clear();
            }
        }
    }

    private void search(){
        System.out.println("Enter the name of student you want to search : ");
        String name = s.next();
        for(ArrayList<Object> studentlist : list) {
            if(studentlist.get(0).equals(name)){
                System.out.println("Student found!");
                for(Object list : studentlist){
                    System.out.println(list);
                }
            }
        }
    }

    private void sort(){
        for(int i = 0 ; i < list.length ; i++){
            for(int j = 0 ; j < list.length - 1 ; j++){
                if(list[j].get(0).toString().compareTo(list[j+1].get(0).toString()) > 0){
                    ArrayList<Object> temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }
        

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("How many Students you want to enter : ");
        int n = s.nextInt();

        ArrayList_1 obj = new ArrayList_1(n);

        System.out.println("Enter functions you want to perform : ");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Update Student");
        System.out.println("4. Remove Student");
        System.out.println("5. Search Student");
        System.out.println("6. Sort Students");
        System.out.println("7. Exit");
        System.out.println();

        int choice = s.nextInt();
        Boolean condition = true;

        while (condition) {
            if(choice == 1)
            obj.add(n);
        else if(choice == 2)
            obj.display();
        else if(choice == 3)
            obj.update();
        else if(choice == 4)
            obj.remove();
        else if(choice == 5)
            obj.search();
        else if(choice == 6)
            obj.sort();
        else if(choice == 7)
            condition = false;
        }
        
    }
}
