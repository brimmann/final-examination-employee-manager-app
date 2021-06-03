public class SecurityGuard extends NonAcademic{

    private String areaAssigned;

    SecurityGuard(){ super(); areaAssigned = ""; }

    SecurityGuard(int _id, String _name, float _hourlyRate, String _areaAssigned)
    {
        super(_id, _name, _hourlyRate);
        areaAssigned = _areaAssigned;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public float getHourlyRate() {
        return super.getHourlyRate();
    }

    public String getAreaAssigned() {
        return areaAssigned;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setHourlyRate(float hourlyRate) {
        super.setHourlyRate(hourlyRate);
    }

    public void setAreaAssigned(String areaAssigned) {
        this.areaAssigned = areaAssigned;
    }
}
