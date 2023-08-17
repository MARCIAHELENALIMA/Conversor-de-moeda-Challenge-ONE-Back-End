package br.com.conversor_moedas.conversorMoedas;

import br.com.conversor_moedas.servico.ServicoDeCambio;
import org.json.JSONObject;

/**
 * Classe responsável por realizar a conversão de moedas utilizando as taxas de câmbio.
 */
public class ConverteMoedas {

    private final JSONObject taxasDeCambio;

    /**
     * Construtor da classe. Inicializa as taxas de câmbio utilizando o serviço de câmbio.
     */
    public ConverteMoedas() {
        // Inicializa o serviço de câmbio para obter as taxas de câmbio
        ServicoDeCambio servico = new ServicoDeCambio();
        // Busca as taxas de câmbio para as moedas especificadas
        this.taxasDeCambio = servico.buscarTaxasDeCambio("USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL");
    }

    /**
     * Converte o valor de reais para dólares utilizando a taxa de câmbio.
     *
     * @param valorRecebido Valor em reais a ser convertido para dólares.
     * @return Valor equivalente em dólares.
     */
    public double converterReaisParaDolares(double valorRecebido) {
        double taxa = taxasDeCambio.getJSONObject("USDBRL").getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    /**
     * Converte o valor de reais para euros utilizando a taxa de câmbio.
     *
     * @param valorRecebido Valor em reais a ser convertido para euros.
     * @return Valor equivalente em euros.
     */
    public double converterReaisParaEuros(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("EURBRL").getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    /**
     * Converte o valor de reais para libras utilizando a taxa de câmbio.
     *
     * @param valorRecebido Valor em reais a ser convertido para libras.
     * @return Valor equivalente em libras.
     */
    public double converterReaisParaLibras(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("GBPBRL").getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    /**
     * Converte o valor de reais para pesos argentinos utilizando a taxa de câmbio.
     *
     * @param valorRecebido Valor em reais a ser convertido para pesos argentinos.
     * @return Valor equivalente em pesos argentinos.
     */
    public double converterReaisParaPesosArgentinos(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("ARSBRL").getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    /**
     * Converte o valor de reais para pesos chilenos utilizando a taxa de câmbio.
     *
     * @param valorRecebido Valor em reais a ser convertido para pesos chilenos.
     * @return Valor equivalente em pesos chilenos.
     */
    public double converterReaisParaPesosChilenos(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("CLPBRL").getDouble("ask");
        // Realiza a conversão e arredonda para duas casas decimais
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }
}
