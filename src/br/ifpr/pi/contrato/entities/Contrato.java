package br.ifpr.pi.contrato.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.ifpr.pi.pessoa.entities.Contratante;
import br.ifpr.pi.pessoa.entities.Fiador;
import br.ifpr.pi.pessoa.entities.Proprietario;

@Entity
@Table(name = "contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 1)
	private char tipo;
	
	@Column(name = "data_inicio_vigencia")
	private LocalDate dataInicioVigencia;
	
	@Column(name = "data_final_vigencia")
	private LocalDate dataFinalVigencia;
	
	private Double valor;
	
	@Column(name = "tipo_contratante", length = 1)
	private char tipoContratante;
	
	private Imovel imovel;
	
	private Fiador fiador;
	
	private Contratante contratante;
	
	private Proprietario proprietario;
	
	@Column(name = "status_ativo", length = 1)
	private char statusAtivo;
	
	@Column(name = "data_hora_cadastro", columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;
	
	@Column(name = "data_hora_alteracao", columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime dataHoraAlteracao;
	
	@Deprecated
	public Contrato() {}

	public Long getId() {
		return id;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFinalVigencia() {
		return dataFinalVigencia;
	}

	public void setDataFinalVigencia(LocalDate dataFinalVigencia) {
		this.dataFinalVigencia = dataFinalVigencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public char getTipoContratante() {
		return tipoContratante;
	}

	public void setTipoContratante(char tipoContratante) {
		this.tipoContratante = tipoContratante;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Fiador getFiador() {
		return fiador;
	}

	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public char getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(char statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
			
		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} 
		
		else if (!id.equals(other.id)) {
			return false;
		}
		
		return true;
	}
}
