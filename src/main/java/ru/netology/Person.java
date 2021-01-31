package ru.netology;

import static java.util.Objects.hash;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    //указан возраст или нет
    public boolean hasAge() {
        return getAge() != 0 ? true : false;
    }

    public boolean hasAddress() {
        return getCity() != null ? true : false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void happyBirthday() {
        if (hasAge()) this.age = getAge() + 1;
    }

    public void setAddress(String address){
        this.city = address;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return hash(name, surname, age, city);
    }

    public interface IPersonBuilder {
        Person build();
    }

    public static class PersonBuilder implements IPersonBuilder {
        public String name;
        public String surname;
        public int age;
        public String city;

        public PersonBuilder setName(String name){
            if (this.name == null) {
                this.name = name;
                return this;
            }
            throw new IllegalArgumentException("Изменить имя нельзя");
        }

        public PersonBuilder setSurName(String surname){
            if (this.surname == null) {
                this.surname = surname;
                return this;
            }
            throw new IllegalArgumentException("Изменить фамилию нельзя");
        }

        public PersonBuilder setAge(int age) {
            if ( age > 0) {
                this.age = age;
                return this;
            }
            throw new IllegalArgumentException("Некорректное поле Возраст");
        }

        public PersonBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public Person build() throws NullPointerException {
            if (this.name == null && this.surname == null)
                throw new NullPointerException("Не заполнены обязательные поля");
            return new Person(this);
        }
    }

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.surname = getSurname();
        personBuilder.age = 1;
        personBuilder.city = getCity();

        return personBuilder;

    }

}