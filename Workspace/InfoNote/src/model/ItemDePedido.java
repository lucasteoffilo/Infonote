package model;

import model.DAO.NotebookDAO;

public class ItemDePedido implements Cloneable {

	private int qtde;
	private double valorUnitario;
	private Notebook notebook;

	public ItemDePedido() {
		super();
	}

	public ItemDePedido(int qtde, double valorUnitario, Notebook notebook) {
		super();
		this.qtde = qtde;
		this.valorUnitario = valorUnitario;
		this.notebook = notebook;
	}

	public ItemDePedido(int qtde, double valorUnitario, String fkSerial) {
		super();
		this.qtde = qtde;
		this.valorUnitario = valorUnitario;
		this.notebook = NotebookDAO.buscarPorSerial(fkSerial);
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

}
