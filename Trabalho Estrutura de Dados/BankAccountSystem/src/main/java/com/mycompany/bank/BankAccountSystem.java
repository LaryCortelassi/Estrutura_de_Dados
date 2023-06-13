package com.mycompany.bank;

/**
 * @author Laryssa Ferres 00239784
 * @author Beatriz Omori 00234624
 */
public class BankAccountSystem {
    private String nomeTitular;
    private int numeroConta;
    private double saldo;

    public BankAccountSystem() {
    }

    public BankAccountSystem(String nomeTitular, int numeroConta, double saldo) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
    saldo -= valor;
    if (saldo < 0) {
        System.out.println("\nVocê está com saldo negativo " +nomeTitular+ "!");
    }
}

    @Override
    public String toString() {
        return "AccountSystem{" + "Nome do titular=" + nomeTitular + ", numero da conta=" + numeroConta + ", saldo=" + saldo + '}';
    }
}

