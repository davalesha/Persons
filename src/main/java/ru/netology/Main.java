package ru.netology;

public class Main {
    public static void main(String[] args) {

        Person mom = new Person.PersonBuilder()
                .setName("Анна")
                .setSurName("Иванова")
                .setAge(31)
                .setCity("Сидней")
                .build();
        System.out.println(mom);
        mom.happyBirthday();
        System.out.println(mom.getAge());

        Person son = mom.newChildBuilder()
                .setName("Pety")
                .build();
        System.out.println(son);

        Person dad = new Person.PersonBuilder()
                .setName("Иван")
                .setSurName("Иванов")
                .build();

        dad.happyBirthday();
        System.out.println(dad.getAge());
        System.out.println(dad);
        dad.setAddress("street");
        System.out.println(dad);
        try {
            // Не хватает обязательных полей
            new Person.PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new Person.PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}

