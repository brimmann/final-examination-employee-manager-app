public class Lecturer extends Academic{

    private int noOfPublication;

    Lecturer(){ super(); noOfPublication = 0; }

    Lecturer(int _id, String _name, float _courseRate, int _noOfPublication)
    {
        super(_id, _name, _courseRate);
        noOfPublication = _noOfPublication;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public float getCourseRate() {
        return super.getCourseRate();
    }

    public int getNoOfPublication() {
        return noOfPublication;
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setCourseRate(float courseRate) {
        super.setCourseRate(courseRate);
    }

    public void setNoOfPublication(int noOfPublication) {
        this.noOfPublication = noOfPublication;
    }
}
