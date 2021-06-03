public class Academic extends Employee {
    protected float courseRate;

    Academic(){ super(); courseRate = 0; }

    Academic(int _id, String _name, float _courseRate)
    {
        super(_id, _name);
        courseRate = _courseRate;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public float getCourseRate() {
        return courseRate;
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setCourseRate(float courseRate) {
        this.courseRate = courseRate;
    }
}
