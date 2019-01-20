package main.java.chapter1.builder;

import java.util.Date;

public class Person {

    private String name;
    private boolean gender;
    private int age;
    private String address;
    private Date birthday;

    private Person(Builder builder){
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.address = builder.address;
        this.birthday= builder.birthday;
    }


    public static class Builder {
        // required parameters
        private String name;
        private boolean gender;

        // optional parameters: initialized to default values
        private int age = 0;
        private String address = "China";
        private Date birthday = new Date();

        public Builder(String name, boolean gender) {
            this.name = name;
            this.gender = gender;
        }

        public Builder age(int age) {
            this.age= age;
            return this;
        }

        public Builder address(String address) {
            this.address= address;
            return this;
        }

        public Builder birthday(Date birthday) {
            this.birthday= birthday;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
