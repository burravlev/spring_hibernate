package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;



    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "car")
    private User person;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return this.model + " " + this.series;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && series == car.series && Objects.equals(model, car.model) && Objects.equals(person, car.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series, person);
    }
}
