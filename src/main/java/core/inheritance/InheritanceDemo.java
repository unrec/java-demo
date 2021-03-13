package core.inheritance;

// Поля в Java не являются полиморфными, поэтому будет обращение к полю на основе типа ссылочной переменной

public class InheritanceDemo {
    public static void main(String[] args) {
        Person person = new Person();
        Person student = new Student();

        // call to fields 'version'
        System.out.println(person.version);
        System.out.println(student.version);

        // call to method 'toString()'
        System.out.println(person);
        System.out.println(student);
    }
}