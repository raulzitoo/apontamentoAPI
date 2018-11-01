package br.com.oportuna.apontamento.API.model;
//package br.com.oportuna.apontamento.entity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.mysql.jdbc.StringUtils;

//import br.com.oportuna.apontamento.util.Criptografia;

@Entity
@Table(name = "Usuari")
public class Usuario {

	public Usuario() {

	}
	
	public Usuario(String codigo) {
		this.codigo = codigo;
	}

	@Id
	@Column(name = "usrCodigo", length = 10)
	private String codigo;
	@Column(name = "usrNome", length = 30, nullable = false)
	private String nome;
	@Column(name = "usrNivel", length = 1)
	private int nivel;
	@Column(name = "usrSenha", length = 128, nullable = true)
	private String senha;
	@Column(name = "usrDatCri")
	private Date dataCriacao;
	@Column(name = "usrSit", nullable = false)
	private String situacao;
	@Column(name = "usrMail", length = 100, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Apontamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Apontamento> apontamentos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void resetSenha() throws Exception {
		try {
			this.setSenha(Criptografia.encrypt("oportuna2014"));
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Erro ao resetar senha do usuário - NoSuchAlgorithmException");
		} catch (UnsupportedEncodingException e) {
			throw new Exception("Erro ao resetar senha do usuário - UnsupportedEncodingException");

		}
	}
	
	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}

}
