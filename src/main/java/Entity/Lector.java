package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lector")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(name = "salary")
    private int salary;

    @ManyToMany
    @JoinTable(name = "lector_department",
        joinColumns = @JoinColumn(name = "id_lector"),
        inverseJoinColumns = @JoinColumn(name = "id_department"))
    private List<Department> departments;

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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Lector() {
    }
}
