import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {

    @Column(name = "Name")
    String name;

    @Column(name = "Age")
    int age;

    @Column(name = "City")
    String city;

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }
}

public class ColumnMapper {

    public static void main(String[] args) throws Exception {

        String[] header = {"Name", "Age", "City"};
        String[] data = {"Kavya", "19", "Anand"};

        Student student = new Student();

        Field[] fields = Student.class.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();

                boolean found = false;

                for (int i = 0; i < header.length; i++) {

                    if (header[i].equals(columnName)) {

                        field.setAccessible(true);

                        if (field.getType() == int.class) {
                            field.set(student, Integer.parseInt(data[i]));
                        } else {
                            field.set(student, data[i]);
                        }

                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Missing column: " + columnName);
                }
            }
        }

        student.display();
    }
}