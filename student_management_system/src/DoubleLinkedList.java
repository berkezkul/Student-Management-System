import java.io.*;
import java.util.Scanner;

public class DoubleLinkedList <T extends Comparable> {

    private DNode<T> head;

    public void addRightAfterHead(T val) {
        if (head == null) {
            addFront(val);
            //head = new DNode<>(val);
        } else {
            DNode<T> newNode = new DNode<>(val);
            newNode.next = head.next;
            head.next = newNode;
        }
    }


    public void addFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }


    public void addToEnd(T val) {

        if (head == null) {
            addFront(val);
        } else {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new DNode<>(val);
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        } else {
            int size = 0;
            DNode<T> iterator = head;
            while (iterator != null) {
                size++;
                iterator = iterator.next;
            }
            return size;
        }
    }


    public boolean search(T val) {
        if (head == null)
            return false;
        DNode<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0)
                return true;
            iterator = iterator.next;
        }
        return false;
    }


    public void delete(T val) {
        if (search(val) == false) {
            System.out.println("the value does not exist");
            return;
        }
        if (head.value.compareTo(val) == 0) {
            head = head.next;
        }
        DNode<T> iterator = head, prev = head;
        while (iterator.value.compareTo(val) != 0) {
            prev = iterator;
            iterator = iterator.next;
        }
        prev.next = iterator.next;
    }


    public void sortByAverage() {

        if (head == null)
            System.out.println("doesn't exist..");
        DNode<T> prev = head;
        DNode<T> iterator = prev.next;
        T temp;
        Student student1 = (Student) prev.value;
        Student student2 = (Student) iterator.value;


        if (iterator.value instanceof Student) {
            Student s = ((Student) iterator.value);
        }

        for (prev = head; prev != null; prev = prev.next) {
            for (iterator = prev.next; iterator != null; iterator = iterator.next) {

                if (((Student) prev.value).compareToAverage(iterator.value) == -1) {
                    temp = prev.value;
                    prev.value = iterator.value;
                    iterator.value = temp;

                }
            }
        }
        display();
    }


    public void sortByDataMarks() {

        if (head == null)
            System.out.println("doesn't exist..");
        DNode<T> prev = head;
        DNode<T> iterator = prev.next;
        T temp;
        Student student1 = (Student) prev.value;
        Student student2 = (Student) iterator.value;


        if (iterator.value instanceof Student) {
            Student s = ((Student) iterator.value);
        }
        for (prev = head; prev != null; prev = prev.next) {
            for (iterator = prev.next; iterator != null; iterator = iterator.next) {

                if (prev.value.compareTo(iterator.value) == -1) {
                    temp = prev.value;
                    prev.value = iterator.value;
                    iterator.value = temp;
                }
            }
        }
        display();

    }


    public double mathAverage(DoubleLinkedList dll) {

        DoubleLinkedList fileList = dll;
        DNode<T> iterator = fileList.head;


        double sum = 0;
        double count = 0;
        if (iterator.value instanceof Student) {
            while (iterator != null) {
                Student s = ((Student) iterator.value);
                sum += s.getMath();
                count++;
                iterator = iterator.next;
            }
        }
        double average = sum / count;
        return average;
    }


    public double dataStructureAverage(DoubleLinkedList dll) {

        DNode<T> iterator = dll.head;

        double sum = 0;
        double count = 0;
        if (iterator.value instanceof Student) {
            while (iterator != null) {
                Student s = ((Student) iterator.value);
                sum += s.getDataStructure();
                count++;
                iterator = iterator.next;
            }
        }
        double average = sum / count;
        return average;
    }


    public T findMin() {

        if (head == null)
            return null;
        DNode<T> iterator = head;
        T min = head.value;

        while (iterator != null) {
            if (iterator.value.compareTo(min) == -1)
                min = iterator.value;
            iterator = iterator.next;
        }
        return min;
    }


    public DoubleLinkedList deleteById(DoubleLinkedList dll) {
        System.out.println("Enter student id the user you want to delete: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        if (dll.head == null)
            System.out.println("doesn't exist..");
        DNode<T> iterator = dll.head;

        if (iterator.value instanceof Student) {
            while (iterator != null) {
                Student s = ((Student) iterator.value);
                if (id == s.getId()) {
                    dll.delete(s);
                }
                iterator = iterator.next;
            }
        }
        return dll;
    }


    public double overallAverage() throws IOException {
        DoubleLinkedList fileList = new DoubleLinkedList();
        double overallAverage = fileList.mathAverage(Test.fileReader()) + fileList.dataStructureAverage(Test.fileReader()) / 2;

        return overallAverage;
    }


    public void passClass(DoubleLinkedList dll) throws IOException {

        DNode<T> iterator = dll.head;


        for (int i = 0; i < dll.size(); i++) {
            if (iterator.value instanceof Student) {
                Student s = ((Student) iterator.value);
                if ((s.getMath() + s.getDataStructure()) / 2 >= overallAverage()) {
                    System.out.println(s);
                }
                iterator = iterator.next;
            }
        }
    }


    public void display() {
        DNode<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }
}