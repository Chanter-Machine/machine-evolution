package algorithms.interview;


public class Test3 {
    public static void main(String[] args) {
        Double d = 1.0;
        if (d instanceof Number)
            d = d++;
        boolean condition1 = (d == 2) ? true : false;
        if(condition1)
            System.out.println("Perform action1");
        double e = 1.0;
        if ((Double) e instanceof Double | d++ == e++)
            d += d;
        boolean condition2 = (d > 2) ? true : false;
        if(condition2)
            System.out.println("Perform action2");
        boolean condition3 = condition1 ^ condition2;
        if(condition3)
            System.out.println("Perform action3");
    }

}

class Namer {
    final private String firstName,lastName;
    public Namer(String fn,String ln) { firstName=fn; lastName=ln;}
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
}

