public class VetorClientes {
    private Cliente[] clientes;
    private int tamanho;

    public VetorClientes(int capacidade) {
        this.clientes = new Cliente[capacidade];
        this.tamanho = 0;
    }


    public void inserir(Cliente cliente){
        if(this.tamanho < clientes.length){
            this.clientes[this.tamanho] = cliente;
            this.tamanho++;
        }else{
            System.out.println("O vetor já está cheio.");
        }
    }

    public void inserir(int posicao, Cliente cliente){
        if (!(posicao >= 0 && posicao < tamanho))
        {
            System.out.println("A posição é inválida.");
        }
        for (int i = this.tamanho-1; i>=posicao; i--){
            this.clientes[i+1] =this.clientes[i];
        }
        this.clientes[posicao] = cliente;
        this.tamanho++;
    }

    public void alterar(int indice, Cliente cliente){
        if(indice < 0 || indice > clientes.length){
            System.out.println("Índice inválido.");
        }else {
            this.clientes[indice] = cliente;
        }
    }

    public void remover(int indice){
        if(indice >=0 && indice < clientes.length){
            this.clientes[indice] = null;
            for (int i = indice; i < clientes.length -1; i++){
                this.clientes[i] = this.clientes[i+1];
                this.tamanho--;
            }
        }else{
            System.out.println("índice inválido.");
        }
    }


    public Cliente buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getNome().equalsIgnoreCase(nome)) {
                return clientes[i];
            }
        }
        return null;
    }

    public Cliente[] listar() {
        Cliente[] lista = new Cliente[tamanho];
        System.arraycopy(clientes, 0, lista, 0, tamanho);
        return lista;
    }

    public Cliente[] filtrar(String dominio) {
        int contador = 0;
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getEmail().endsWith(dominio)) {
                contador++;
            }
        }
        Cliente[] resultado = new Cliente[contador];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (clientes[i].getEmail().endsWith(dominio)) {
                resultado[index++] = clientes[i];
            }
        }
        return resultado;
    }
}
