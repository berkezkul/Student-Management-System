public class Student implements Comparable {

    private int id;
    private String name;
    private int math;
    private int dataStructure;



    public Student(int id, String name, int math,int dataStructure){
        this.id = id;
        this.name = name;
        this.math = math;
        this.dataStructure = dataStructure;
    }

    public Student(String id, String name, String math, String dataStructure) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.math = Integer.parseInt(math);
        this.dataStructure = Integer.parseInt(dataStructure);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getDataStructure(){
        return  dataStructure;
    }

    public void setDataStructure(){
        this.dataStructure = dataStructure;
    }


    public int compareTo(Object o) {
        Student s = ((Student) o);


        if (this.dataStructure == s.dataStructure)
            return 0;
        else if (this.dataStructure > s.dataStructure)
            return 1;
        else {
            return -1;
        }
    }



    public int compareToAverage(Object obj){
        Student s = ((Student)obj);

        if ((this.dataStructure + this.math) / 2 == (s.dataStructure + s.math) / 2){
            return 0;
        }
        else if ((this.dataStructure + this.math) / 2 > (s.dataStructure + s.math) / 2){
            return 1;
        }
        else{
            return -1;
        }

    }




    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.math + " " + this.dataStructure +"\n";
    }

    public String toStringLine() {
        return this.id + " " + this.name + " " + this.math + " " + this.dataStructure;
    }


}
