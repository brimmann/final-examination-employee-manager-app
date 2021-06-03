public class NonAcademic extends Employee{

    protected float hourlyRate;

    NonAcademic(){ super(); hourlyRate = 0; }

    NonAcademic(int _id, String _name, float _hourlyRate)
    {
        super(_id, _name);
        hourlyRate = _hourlyRate;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
