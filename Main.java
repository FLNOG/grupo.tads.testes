import model.Pessoa;
import repository.PessoaRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome que você deseja cadastrar: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();

        Pessoa newPessoa = new Pessoa(nome, idade);
        PessoaRepository pessoaRepository = new PessoaRepository();

        pessoaRepository.salvar(newPessoa);

    }
}