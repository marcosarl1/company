package com.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min = 2, message = "Informe ao menos dois caracteres para o campo nome")
    private String name;
    @CPF
    private String cpf;
    @NotBlank(message = "Telefone obrigatório")
    private String phone;
    @NotBlank(message = "E-mail obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotNull(message = "Salário obrigatório")
    private double salary;

    public Employee(){}

    public Employee(Integer id, String name, String cpf, String phone, String email, double salary) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
