import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {


        System.out.println("      Welcome to Students Menu!!!      ");

        System.out.println("Press 1 to view the linked list.");
        System.out.println("Press 2 to view the ranking of students according to their grade point averages.");
        System.out.println("Press 3 to view students sorted by data structure grades.");
        System.out.println("Press 4 to view students' math averages.");
        System.out.println("Press 5 for the student with the lowest data structure grade.");
        System.out.println("Press 6 to delete the student with the id you entered.");
        System.out.println("Press 7 to add a new student.");
        System.out.println("Press 8 to find out the number of students.");
        System.out.println("Press 9 to view successful students.");
        System.out.println("For exit, press -1.");


        System.out.println("Choose (1 to 9):");
        Scanner input =new Scanner(System.in);
        int selection = input.nextInt();

        DoubleLinkedList studentLink = fileReader();
        DoubleLinkedList link = new DoubleLinkedList();




        while(selection != -1){

            if(selection == 1){
                studentLink.display();
            }

            else if(selection == 2){
                studentLink.sortByAverage();
            }

            else if(selection == 3){
                studentLink.sortByDataMarks();
            }

            else if(selection == 4){
                System.out.println(link.mathAverage(fileReader()));
            }

            else if(selection == 5){;
                System.out.println(studentLink.findMin());
            }

            else if(selection == 6){
                (studentLink.deleteById(fileReader())).display();
            }

            else if(selection == 7){
                System.out.println("Enter the student's information in order (id,name,math,data structure):");

                input =new Scanner(System.in);
                int id = input.nextInt();

                input = new Scanner(System.in);
                String name = input.next();

                input = new Scanner(System.in);
                int math = input.nextInt();

                input = new Scanner(System.in);
                int dataStructure = input.nextInt();

                Student s = new Student(id,name,math,dataStructure);
                fileWriter(s).display();
            }

            else if(selection == 8){
                System.out.println(studentLink.size());
            }

            else if(selection == 9){
                link.passClass(fileReader());
            }


            System.out.println("Choose (1 to 9): ");
            input =new Scanner(System.in);
            selection = input.nextInt();
        }

        System.out.println("You have successfully exited the menu.");

    }




    public static DoubleLinkedList fileReader() throws IOException {

        File file = new File("C:\\DataStructures\\Homework3\\src\\Students.txt");
        if (!file.exists()) {
            file.createNewFile();
        }


        FileReader fReader = new FileReader(file);
        BufferedReader bfReader = new BufferedReader(fReader);
        String line = " ";
        DoubleLinkedList<Student> students = new DoubleLinkedList<>();


        while ((line = bfReader.readLine()) != null) {
            String[] aLine = line.split(" ");

            for (int i = 0; i < aLine.length; i= i+4) {
                Student s = new Student(aLine[i], aLine[i + 1], aLine[i + 2], aLine[i + 3]);
                students.addToEnd(s);
            }
        }
        return students;
    }





    public static DoubleLinkedList fileWriter(Student s) throws IOException {

        File file = new File("C:\\DataStructures\\Homework3\\src\\Students.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        DoubleLinkedList newLinkedList = fileReader();

        FileWriter fWritter = new FileWriter(file,true);
        BufferedWriter bWritter = new BufferedWriter(fWritter);
        bWritter.write("\n" + s.toStringLine());
        newLinkedList.addToEnd(s.toStringLine());
        bWritter.close();

        return newLinkedList;
    }


}
