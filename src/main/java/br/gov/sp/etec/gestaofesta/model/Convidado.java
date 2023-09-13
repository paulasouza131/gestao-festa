package br.gov.sp.etec.gestaofesta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity // Cria a tabela no banco
@Table(name="TBL_Convidado") //Serve para dar um nome dela com o atributo name
public class Convidado {
	@Id // Para referenciar o id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Esse @ gera um valor unico, tipo o Identity do SQL Server
	private Long id; //privado, Long(estipula um tipo de dado maior, nome do campo Ex:"idConvidado")
	private String nome;
	private int acompanhante;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAcompanhante() {
		return acompanhante;
	}
	public void setAcompanhante(int acompanhante) {
		this.acompanhante = acompanhante;
	}
	
	
}
