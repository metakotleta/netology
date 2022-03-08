package com.rvukolov.javacore.stream_api.hw22;

public class Person implements Comparable<Person>{
        private String name;
        private String family;
        private Integer age;
        private Sex sex;
        private Education education;

        public Person(String name, String family, int age, Sex sex, Education education) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.sex = sex;
            this.education = education;
        }

        public String getName() {
            return name;
        }

        public String getFamily() {
            return family;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        public Education getEducation() {
            return education;
        }

        @Override
        public String toString() {
            return "Person: " + name + " " + family + ", " + age + ", " + sex + ", " + education;
        }

    @Override
    public int compareTo(Person o) {
        return this.getFamily().compareTo(o.getFamily());
    }
}
