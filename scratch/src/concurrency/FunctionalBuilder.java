package concurrency;

import java.util.function.Function;

public class FunctionalBuilder {
    public static void main(String[] args) {
        Person mahmoud = Person.builder()
                .withFirstName("Mahmoud")
                .withPhoneNumber("0123456789")
                .build();

        Person mary = Person.builder()
                .withFirstName("Mary")
                .withPhoneNumber("0132123456")
                .withLastName("The Best")
                .build();

        System.out.println(mahmoud);
        System.out.println(mary);
    }
}

class Person {
    private String firstName; // required
    private String lastName;
    private String phoneNumber; // required

    private Person(String firstName, String phoneNumber){
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static FirstNameAdder builder() {
        return firstName -> phoneNumber -> new PersonBuilder(firstName, phoneNumber);
    }

    @FunctionalInterface
    static interface FirstNameAdder {
        PhoneNumberAdder withFirstName(String firstName);
    }

    @FunctionalInterface
    static interface PhoneNumberAdder {
        PersonBuilder withPhoneNumber(String phoneNumber);
    }

    static class PersonBuilder {

        private final Person person;

        public PersonBuilder(String firstName, String phoneNumber) {
            person = new Person(firstName, phoneNumber);
        }

        public PersonBuilder withLastName(String lastName) {
            person.setLastName(lastName);
            return this;
        }

        public Person build(){
            return this.person;
        }
    }
}