package br.com.senac.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class OrdemDeServico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(mappedBy="usuario")
	private Usuario responsavel;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
	private Date dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy") // formatar a data
	private Date dataTermino;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy="recurso")
	private List<Recurso> recurso;
	
	@Column(length = 255)
	private String urlRegistroInstalacao;
	
	@Column(length = 255)
	private String latitudeInstalacao;
	
	@Column(length = 255)
	private String longitudeInstalacao;
	
	private boolean fechada;
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Recurso> getRecurso() {
		return recurso;
	}

	public void setRecurso(List<Recurso> recurso) {
		this.recurso = recurso;
	}

	public String getUrlRegistroInstalacao() {
		return urlRegistroInstalacao;
	}

	public void setUrlRegistroInstalacao(String urlRegistroInstalacao) {
		this.urlRegistroInstalacao = urlRegistroInstalacao;
	}

	public String getLatitudeInstalacao() {
		return latitudeInstalacao;
	}

	public void setLatitudeInstalacao(String latitudeInstalacao) {
		this.latitudeInstalacao = latitudeInstalacao;
	}

	public String getLongitudeInstalacao() {
		return longitudeInstalacao;
	}

	public void setLongitudeInstalacao(String longitudeInstalacao) {
		this.longitudeInstalacao = longitudeInstalacao;
	}

	public boolean isFechada() {
		return fechada;
	}

	public void setFechada(boolean fechada) {
		this.fechada = fechada;
	}
	

}
