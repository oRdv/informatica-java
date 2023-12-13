package br.senai.jandira.sp.model;

import java.util.Scanner;

public class Cliente {

    Scanner scanner = new Scanner(System.in);

    private int id, idade, cpf;
    private String nome, email;

    public  void cadastroCliente() {

        System.out.println("Informe o Nome do cliente: ");
        setNome(scanner.nextLine());
        System.out.println("Informe o CPF do cliente: ");
        setCpf(scanner.nextInt());
        System.out.println("Informe a Idade do cliente: ");
        setIdade(scanner.nextInt());
        System.out.println("Informe o email do cliente: ");
        setEmail(scanner.nextLine());

        System.out.println("O Cliente foi cadastrado com sucesso!");
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
