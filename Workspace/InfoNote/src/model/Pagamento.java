package model;

public class Pagamento {

	private String tipoDePagamento;
	private String dataAprovado;
	private double valorTotal;
	private String fkNumPedido;

	public Pagamento(String tipoDePagamento, String dataAprovado, double valorTotal) {
		super();
		this.tipoDePagamento = tipoDePagamento;
		this.dataAprovado = dataAprovado;
		this.valorTotal = valorTotal;
	}

	public Pagamento(String tipoDePagamento, String dataAprovado, double valorTotal, String fkNumPedido) {
		super();
		this.tipoDePagamento = tipoDePagamento;
		this.dataAprovado = dataAprovado;
		this.valorTotal = valorTotal;
		this.fkNumPedido = fkNumPedido;
	}

	public Pagamento() {
		super();
	}

	public String getTipoDePagamento() {
		return tipoDePagamento;
	}

	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}

	public String getDataAprovado() {
		return dataAprovado;
	}

	public void setDataAprovado(String dataAprovado) {
		this.dataAprovado = dataAprovado;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFkNumPedido() {
		return fkNumPedido;
	}

	public void setFkNumPedido(String fkNumPedido) {
		this.fkNumPedido = fkNumPedido;
	}

}
