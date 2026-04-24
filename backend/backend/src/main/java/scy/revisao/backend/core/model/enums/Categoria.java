package scy.revisao.backend.core.model.enums;

public enum Categoria {
    ROUPA( "Roupa"),
    ELETRONICO("Eletrônico"),
    ESCRITORIO("Escritório"),
    MOVEIS("Móveis");

    private final String valor;

    Categoria(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }
}

