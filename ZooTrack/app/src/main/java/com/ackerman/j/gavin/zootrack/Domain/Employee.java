package com.ackerman.j.gavin.zootrack.Domain;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class Employee {
    private String name;
    private long id;
    private String surname;
    private int age;
    private String Country;


    private Employee() {
    }



    public int getAge(){return age;}
    public long getId() {
        return id;
    }
    public String getName(){return name;}
    public String getsurname(){return surname;}


    public String getCountry(){return Country;}

    public Employee(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.surname=builder.surname;
        this.age=builder.age;

        this.Country=builder.Country;

    }

    public static class Builder{
        private long id;
        private String name;
        private String surname;
        private int age;

        private String Country;


        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder(long id)
        {
            this.id= id;

        }

        public Builder surname(String value)
        {
            this.surname=value;
            return this;
        }



        public Builder Country(String value)
        {
            this.Country=value;
            return this;
        }

        public Builder age(int value){
            this.age=value;
            return this;

        }



        public Builder copy(Employee value){
            this.id=value.id;
            this.name=value.name;

            this.age=value.age;
            this.Country=value.Country;

            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
