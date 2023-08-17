package br.com.conversor_moedas.conversorMoedas;

/**
 * Classe responsável por realizar conversões de moedas e aplicar taxas sobre valores convertidos.
 */
public class Funcao {

    // Instâncias das classes de conversão
    ConverteMoedas moedas = new ConverteMoedas();
    ConverteMoedasParaReais reais = new ConverteMoedasParaReais();

    /**
     * Realiza a conversão entre moedas ou de moeda para reais.
     *
     * @param moedaOrigem    Moeda de origem.
     * @param moedaDestino   Moeda de destino.
     * @param valorRecebido  Valor a ser convertido.
     * @return Valor convertido na moeda de destino ou em reais.
     * @throws IllegalArgumentException Se a combinação de moedas não for suportada.
     */
    public double converterMoeda(String moedaOrigem, String moedaDestino, double valorRecebido) {
        String combinacaoMoedas = moedaOrigem + " para " + moedaDestino;

        switch (combinacaoMoedas) {
            case "Reais para Dólares" -> {
                return moedas.converterReaisParaDolares(valorRecebido);
            }
            case "Reais para Euros" -> {
                return moedas.converterReaisParaEuros(valorRecebido);
            }
            case "Reais para Libras" -> {
                return moedas.converterReaisParaLibras(valorRecebido);
            }
            case "Reais para Peso Argentino" -> {
                return moedas.converterReaisParaPesosArgentinos(valorRecebido);
            }
            case "Reais para Peso Chileno" -> {
                return moedas.converterReaisParaPesosChilenos(valorRecebido);
            }
            case "Dólares para Reais" -> {
                return reais.converterDolaresParaReais(valorRecebido);
            }
            case "Euros para Reais" -> {
                return reais.converterEurosParaReais(valorRecebido);
            }
            case "Libras para Reais" -> {
                return reais.converterLibrasParaReais(valorRecebido);
            }
            case "Peso Argentino para Reais" -> {
                return reais.converterPesosArgentinosParaReais(valorRecebido);
            }
            case "Peso Chileno para Reais" -> {
                return reais.converterPesosChilenosParaReais(valorRecebido);
            }
            default -> {
                throw new IllegalArgumentException("Combinação de moedas não suportada: " + combinacaoMoedas);
            }
        }
    }

    /**
     * Aplica uma taxa sobre um valor convertido.
     *
     * @param valorConvertido Valor já convertido.
     * @param taxaSelecionada Taxa a ser aplicada (em formato de string).
     * @return Valor após a aplicação da taxa.
     */
    public double aplicarTaxa(double valorConvertido, String taxaSelecionada) {
        double taxa;

        switch (taxaSelecionada) {
            case "+/- 0%":
                taxa = 0.0;
                break;
            case "+/- 1%":
                taxa = 0.01;
                break;
            case "+/- 2% (Taxa típica ATM)":
                taxa = 0.02;
                break;
            case "+/- 3% (Taxa típica de cartão de crédito)":
                taxa = 0.03;
                break;
            case "+/- 4%":
                taxa = 0.04;
                break;
            case "+/- 5% (Taxa típica de quiosque)":
                taxa = 0.05;
                break;
            default:
                taxa = 0.0;
        }

        return valorConvertido * (1 + taxa);
    }
}
