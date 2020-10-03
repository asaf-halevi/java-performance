package basics.exercise;

public class Emp {

    private Long id;
    private boolean isPregnant;
    private Long salary;

    public Emp(Long id, boolean isPregnant, Long salary) {
        super();
        this.id = id;
        this.isPregnant = isPregnant;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", isPregnant=" + isPregnant + ", salary=" + salary + "]";
    }
}
