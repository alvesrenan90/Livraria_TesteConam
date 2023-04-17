package com.alvesrenan.erp.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_autor;
	
	@Column(name = "nome_autor", nullable = false )
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;		

	@Enumerated(EnumType.STRING)
	@Column(name = "pais_origem")
	private PaisOrigem paisOrigem;	
	
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_obra", nullable = true)
	private Obra obra;

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public PaisOrigem getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(PaisOrigem paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String string) {
		this.cpf = string;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_autor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id_autor, other.id_autor);
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + "]";
	}
	

}