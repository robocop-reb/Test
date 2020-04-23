import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

import static javax.persistence.GenerationType.TABLE;

@Entity(name = "vehicles_table")
public class Warmachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Id=" + id
                + ", Name=" + name  + ", type=" +type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
