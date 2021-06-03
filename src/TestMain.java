public class TestMain {
    public static void main(String args[])
    {
        Employee db[] = new Employee[3];
        Lecturer l1 = new Lecturer(3, "he", 20, 5);
        SecurityGuard g1 = new SecurityGuard(2, "me", 2, "Dona");
        db[0] = l1;
        db[1] = g1;

        //Lecturer k = (Lecturer) db[0];
        if(db[0] instanceof Lecturer)
        {
            Lecturer d = (Lecturer) db[0];
            System.out.println(d.getNoOfPublication());
        }
    }
}
