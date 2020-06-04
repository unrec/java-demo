package core.inheritance;

// Поля в Java не являются полиморфными, поэтому будет обращение к полю на основе типа ссылочной переменной

public class InheritanceDemo {
    public static void main(String[] args) {
        Person person = new Student();
        System.out.println(person.version);
    }
}