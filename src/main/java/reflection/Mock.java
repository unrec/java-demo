package reflection;

import lombok.Getter;
import lombok.Setter;


@MyAnnotation(name = "just a name", value = "9000")
public class Mock {
    @Getter @Setter private String name;
    @Getter @Setter private int value;
    @Getter @Setter private boolean status;
    public String author;
    public boolean isEmpty;


    public void doStuff() {
        System.out.println("DO STUFF");
    }

    private String privateMethod() {
        return "THIS IS PRIVATE METHOD";
    }

    Mock() {
    }

    public Mock(String name, int value, boolean status) {
        this.name = name;
        this.value = value;
        this.status = status;
    }

} // end of class
