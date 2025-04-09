package br.com.alura.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class Produto {
    @CsvBindByName(column = "productId", required = true) // Anotação do OpenCSV que indica que o campo productId deve ser vinculado à coluna "id" do arquivo CSV.
    private int id; // Criado uma variável do tipo int chamado id para armazenar o id do produto.
    @CsvBindByName(column = "productName", required = true) // Anotação do OpenCSV que indica que o campo productName deve ser vinculado à coluna "name" do arquivo CSV.
    private String name; // Criado uma variável do tipo String chamada name para armazenar o nome do produto.
    @CsvBindByName(column = "Description", required = true) // Anotação do OpenCSV que indica que o campo Description deve ser vinculado à coluna "description" do arquivo CSV.
    private String description; // Criado uma variável do tipo String chamada description para armazenar a descrição do produto.
    @CsvBindByName(column = "price", required = true) // Anotação do OpenCSV que indica que o campo price deve ser vinculado à coluna "price" do arquivo CSV.
    private BigDecimal price; // Criado uma variável do tipo BigDecimal chamada price para armazenar o preço do produto.
    @CsvBindByName(column = "category", required = true) // Anotação do OpenCSV que indica que o campo category deve ser vinculado à coluna "category" do arquivo CSV.
    private String category; // Criado uma variável do tipo String chamada category para armazenar a categoria do produto.

    // Construtor da classe Produto que recebe os parâmetros id, name, description, price e category.
    public Produto(int id, String name, String description, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Criado um getter chamado getId para retornar o id do produto.
    public int getId() {
        return id; // Retorna o id do produto.
    }

    // Criado um setter chamado setId para definir o id do produto.
    public void setId(int id) {
        this.id = id; // Define o id do produto.
    }

    // Criado um getter chamado getName para retornar o nome do produto.
    public String getName() {
        return name; // Retorna o nome do produto.
    }

    // Criado um setter chamado setName para definir o nome do produto.
    public void setName(String name) {
        this.name = name; // Define o nome do produto.
    }

    // Criado um getter chamado getDescription para retornar a descrição do produto.
    public String getDescription() {
        return description; // Retorna a descrição do produto.
    }

    // Criado um setter chamado setDescription para definir a descrição do produto.
    public void setDescription(String description) {
        this.description = description; // Define a descrição do produto.
    }

    // Criado um getter chamado getPrice para retornar o preço do produto.
    public BigDecimal getPrice() {
        return price; // Retorna o preço do produto.
    }

    // Criado um setter chamado setPrice para definir o preço do produto.
    public void setPrice(BigDecimal price) {
        this.price = price; // Define o preço do produto.
    }

    // Criado um getter chamado getCategory para retornar a categoria do produto.
    public String getCategory() {
        return category; // Retorna a categoria do produto.
    }

    // Criado um setter chamado setCategory para definir a categoria do produto.
    public void setCategory(String category) {
        this.category = category; // Define a categoria do produto.
    }

    // Criado um método toString que retorna uma representação em String do objeto Produto.
    @Override
    public String toString() {
        // Retorna uma representação em String do objeto Produto.
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
