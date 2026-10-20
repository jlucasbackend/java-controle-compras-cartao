public class Compras{
    private String nomeProduto;
    private double valorProduto;

    public Compras(String nomeProduto, double valorProduto){
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto + " Valor: " + valorProduto + "";
    }

}