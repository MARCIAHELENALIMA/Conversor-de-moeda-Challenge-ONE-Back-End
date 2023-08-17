package br.com.conversor_moedas.conversorMoedas;

import br.com.conversor_moedas.servico.ServicoDeCambio;
import org.json.JSONObject;

/**
 * Classe responsável por converter diversas moedas para reais utilizando taxas de câmbio.
 */
public class ConverteMoedasParaReais {

    private final JSONObject taxasDeCambio;

    /**
     * Construtor da classe. Inicializa as taxas de câmbio utilizando o serviço de câmbio.
     */
    public ConverteMoedasParaReais() {
        // Inicializa o serviço de câmbio para obter as taxas de câmbio
        ServicoDeCambio servico = new ServicoDeCambio();
        // Busca as taxas de câmbio para as moedas especificadas
        this.taxasDeCambio = servico.buscarTaxasDeCambio("USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL");
    }

    /**
     * Converte um valor em dólares para reais utilizando a taxa de câmbio correspondente.
     *
     * @param valorRecebido Valor em dólares a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    public double converterDolaresParaReais(double valorRecebido) {
        return convert("USDBRL", valorRecebido);
    }

    /**
     * Converte um valor em euros para reais utilizando a taxa de câmbio correspondente.
     *
     * @param valorRecebido Valor em euros a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    public double converterEurosParaReais(double valorRecebido) {
        return convert("EURBRL", valorRecebido);
    }

    /**
     * Converte um valor em libras para reais utilizando a taxa de câmbio correspondente.
     *
     * @param valorRecebido Valor em libras a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    public double converterLibrasParaReais(double valorRecebido) {
        return convert("GBPBRL", valorRecebido);
    }

    /**
     * Converte um valor em pesos argentinos para reais utilizando a taxa de câmbio correspondente.
     *
     * @param valorRecebido Valor em pesos argentinos a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    public double converterPesosArgentinosParaReais(double valorRecebido) {
        return convert("ARSBRL", valorRecebido);
    }

    /**
     * Converte um valor em pesos chilenos para reais utilizando a taxa de câmbio correspondente.
     *
     * @param valorRecebido Valor em pesos chilenos a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    public double converterPesosChilenosParaReais(double valorRecebido) {
        return convert("CLPBRL", valorRecebido);
    }

    /**
     * Método privado para realizar a conversão de uma moeda para reais.
     *
     * @param currencyPair Par de moedas no formato "MOEDA-BRL".
     * @param valorRecebido Valor a ser convertido para reais.
     * @return Valor equivalente em reais.
     */
    private double convert(String currencyPair, double valorRecebido) {
        double taxa = taxasDeCambio.getJSONObject(currencyPair).getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round(valorRecebido * taxa * 100d) / 100;
    }
}
