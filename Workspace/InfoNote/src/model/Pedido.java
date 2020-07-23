package model;

import java.util.List;
import java.util.ArrayList;

public class Pedido {

	private int numeroPedido;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	private Endereco enderecoDeEntrega;
	private List<ItemDePedido> itens = new ArrayList<ItemDePedido>();
	private String fkcpf;
	private int fkIdEnd;

	public Pedido(String dataEmissao, String formaDePagamento, double valorTotal, String situacao,
			Endereco enderecoDeEntrega, List<ItemDePedido> itens) {
		super();
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.itens = itens;
	}

	public Pedido(int numeroPedido, String dataEmissao, String formaDePagamento, double valorTotal, String situacao,
			Endereco enderecoDeEntrega, List<ItemDePedido> itens) {
		super();
		this.numeroPedido = numeroPedido;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.itens = itens;
	}

	public Pedido(int numeroPedido, String dataEmissao, String situacao, double valorTotal, String fkcpf, int fkIdEnd) {
		super();
		this.numeroPedido = numeroPedido;
		this.dataEmissao = dataEmissao;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.fkcpf = fkcpf;
		this.fkIdEnd = fkIdEnd;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getFkcpf() {
		return fkcpf;
	}

	public void setFkcpf(String fkcpf) {
		this.fkcpf = fkcpf;
	}

	public int getFkIdEnd() {
		return fkIdEnd;
	}

	public void setFkIdEnd(int fkIdEnd) {
		this.fkIdEnd = fkIdEnd;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemDePedido> itens) {
		this.itens = itens;
	}

}
