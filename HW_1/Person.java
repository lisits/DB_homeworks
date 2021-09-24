import java.util.StringJoiner;

public class Person {
    private String name;
    private String totem;
    private int count_of_siblings;

    public Person(String name, String totem, int count_of_siblings) {
        this.name = name;
        this.totem = totem;
        this.count_of_siblings = count_of_siblings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotem() {
        return totem;
    }

    public void setTotem(String totem) {
        this.totem = totem;
    }

    public int getCount_of_siblings() {
        return count_of_siblings;
    }

    public void setCount_of_siblings(int count_of_siblings) {
        this.count_of_siblings = count_of_siblings;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("totem='" + totem + "'")
                .add("count_of_siblings=" + count_of_siblings)
                .toString();
    }
}
