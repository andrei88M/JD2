public class PersonBulder implements PersonBuldInterf {
    Person person = new Person();

    @Override
    public PersonBuldInterf setSurname(String surname) {
        person.setSurname(surname);
        return this;
    }

    @Override
    public PersonBuldInterf setName(String name) {
        person.setName(name);
        return this;
    }

    @Override
    public PersonBuldInterf setAge(int age) {
        person.setAge(age);
        return this;
    }

    @Override
    public Person buld() {
        return person;
    }
}
