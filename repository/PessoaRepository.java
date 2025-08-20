package repository;

import model.Pessoa;

import java.io.File;
import java.io.FileWriter;

public class PessoaRepository {
    private static final String pasta = "cadastros";

    public void salvar(Pessoa pessoa) {
        try {
            File file = new File(pasta, pessoa.getNome() + ".json");
            try (FileWriter writer = new FileWriter(file)) {
                String json = "{\n" +
                        "  \"nome\": \"" + pessoa.getNome() + "\",\n" +
                        "  \"idade\": " + pessoa.getIdade() + "\n" +
                        "}";
                writer.write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}