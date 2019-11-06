package com.vertx.restapi;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "name")
    private  String name;

    @Column(name = "position")
    private String position;

    @Column(name = "company")
    private String company;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String id,String name, String position, String company) {
        this.id=id;
        this.name = name;
        this.position = position;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }


    public String getCompany() {
        return company;
    }

    public static EmployeeEntityBuilder builder() {
        return new EmployeeEntityBuilder();
    }

    public static class EmployeeEntityBuilder {

        private  String id;
        private String name;
        private String position;
        private String company;

        public EmployeeEntityBuilder setId(final String id) {
            this.id = id;
            return this;
        }

        public EmployeeEntityBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public EmployeeEntityBuilder setPosition(final String position) {
            this.position = position;
            return this;
        }

        public EmployeeEntityBuilder setCompany(final String company) {
            this.company = company;
            return this;
        }

        public EmployeeEntity build() {
            return new EmployeeEntity(id,name, position, company);
        }

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

}

