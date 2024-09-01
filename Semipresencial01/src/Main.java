//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VetorClientes vetorClientes = new VetorClientes(20);
        String[] nomes = {
                "Isabelle Cardoso", "Leonardo Almeida", "Rafael Cavalcanti", "João Pereira", "Laura Almeida",
                "Samuel Chambers", "Mei Teng", "Daniel Choi", "Victoria Jang", "Ricardo Martins",
                "Sofia Andrade", "Tiago Ferreira", "Vanessa Ramos", "Wellington Campos", "Anna Han",
                "Yasmin Barbosa", "Nina Nakamura", "Juliana Mendes", "Claudia Rocha", "Marcelo Pires"
        };

        String[] telefones = {
                "(11) 9611-7439", "(11) 8963-8284", "(38) 5653-5808", "(71) 3933-5041", "(49) 4494-9933",
                "(31) 8173-5430", "(16) 5637-6106", "(16) 6482-4486", "(51) 3399-7238", "(11) 8243-5598",
                "(31) 2641-5788", "(75) 3249-2328", "(99) 3963-3122", "(69) 3288-7028", "(68) 3592-3115",
                "(86) 2030-8542", "(47) 3526-3951", "(49) 2535-1180", "(54) 2888-5765", "(53) 2624-0642"
        };

        String[] emails = {
                "isabellecardoso21@gmail.com", "leonardo_almeida@outlook.com", "rafaelemanuelcanti@rede.ulbra.br",
                "joao.pereira@gmail.com", "chambers.samuel@gmail.com", "meitenghong@gmail.com",
                "danielchoi@outlook.com.br", "danielchoi@yahoo.com", "victoriajang@gmail.com",
                "ricardo.martins@rede.ulbra.br", "sofia.andrade@rede.ulbra.br", "tiago.ferreira@gmail.com",
                "vanessa.ramos@ymail.com", "wellington.campos@outlook.com", "annahan@rede.ulbra.br",
                "yasminbarbosa2000@gmail.com", "nina.nakamura@rede.ulbra.br", "julianamendes21@rede.ulbra.br",
                "claudia.rocha@rede.ulbra.br", "marcelo.pires@gmail.com"
        };

        for (int i = 0; i < 20; i++) {
            Cliente cliente = new Cliente(nomes[i], telefones[i], emails[i]);
            vetorClientes.inserir(cliente);
        }

        for (int i = 20; i < 30; i++) {
            String nome = "Novo Cliente " + (i + 1);
            String telefone = "(00) 0000-000" + (i % 10);
            String email = "novo" + (i + 1) + "@exemplo.com";
            Cliente cliente = new Cliente(nome, telefone, email);
            vetorClientes.alterar((i - 1) % 20, cliente); //
        }

        System.out.println("Lista de todos os clientes:");
        Cliente[] clientesListados = vetorClientes.listar();
        for (Cliente cliente : clientesListados) {
            System.out.println(cliente);
            System.out.println();
        }

        Cliente clienteModificado = new Cliente("Fernando Gonçalves", "(55) 3716-9268", "fernandinhogonçalves@hotmail.com");
        vetorClientes.alterar(5, clienteModificado);

        vetorClientes.remover(10);

        Cliente clienteInserido = new Cliente("Ayla Lee", "(53) 3233-5056", "leeaylalee@outlook.com");
        vetorClientes.inserir(3, clienteInserido);

        System.out.println("Lista de todos os clientes após modificações:");
        clientesListados = vetorClientes.listar();
        for (Cliente cliente : clientesListados) {
            System.out.println(cliente);
            System.out.println();
        }

        String nomeBusca = "Alice Nakamura";
        Cliente clienteBuscado = vetorClientes.buscar(nomeBusca);
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado com o nome \"" + nomeBusca + "\":");
            System.out.println(clienteBuscado);
        } else {
            System.out.println("Cliente com o nome \"" + nomeBusca + "\" não encontrado.");
        }

        String dominioFiltro = "@gmail.com";
        Cliente[] clientesFiltrados = vetorClientes.filtrar(dominioFiltro);
        System.out.println("Clientes com domínio de email \"" + dominioFiltro + "\":");
        for (Cliente cliente : clientesFiltrados) {
            System.out.println(cliente);
            System.out.println();
        }
    }
}


