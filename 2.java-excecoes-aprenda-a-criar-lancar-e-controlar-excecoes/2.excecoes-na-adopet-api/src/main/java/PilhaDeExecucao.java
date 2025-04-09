public class PilhaDeExecucao {
    public static void metodo1() {
        System.out.println("[Inicio] - metodo1");

        metodo2();

        System.out.println("[Fim] - metodo1");
    }

    public static void metodo2() {
        System.out.println("[Inicio] - metodo2");

        Usuario usuario = null;

        // O bloco try-catch é utilizado para capturar exceções que podem ocorrer durante a execução do código.
        try {
            System.out.println(usuario.nome); // Imprime o nome do usuário que nesse caso está nulo.
        } // O bloco catch é executado quando uma exceção do tipo NullPointerException é lançada.
        catch (NullPointerException e) {
            System.out.println("Usuário não encontrado.");
        }

        System.out.println("[Fim] - metodo2");
    }

    public static void main(String[] args) {
        System.out.println("[Inicio] - main");

        // O bloco try-catch é utilizado para capturar exceções que podem ocorrer durante a execução do código.
        try {
            metodo1();
        } // O bloco catch é executado quando uma exceção do tipo NullPointerException é lançada.
        catch (NullPointerException e) {
            System.out.println("Usuário não encontrado.");
        }

        System.out.println("[Fim] - main");
    }
}

class Usuario {
    public String nome;
    public Usuario(String nome) {
        this.nome = nome;
    }
}