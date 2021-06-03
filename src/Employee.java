public class Employee {
    protected int id;
    protected String name;

    Employee(){ id = 0; name = ""; }

    Employee(int _id, String _name)
    {
        id = _id;
        name = _name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
