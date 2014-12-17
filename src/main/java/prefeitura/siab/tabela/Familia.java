package prefeitura.siab.tabela;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_FAMILIA")
public class Familia {

	//ATRIBUTOS
	private Integer codigo;
	private Acs agente;
	private Endereco rua;
	private List<Pessoa> pessoas;
	private Integer numero;
	private Integer numeroFamilia;
	
	//PROPRIEDADES
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="FAM_CODIGO")
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
		
	@Column(name="FAM_NUMFAMILIA")
	public Integer getNumeroFamilia() {
		return numeroFamilia;
	}
	public void setNumeroFamilia(Integer numeroFamilia) {
		this.numeroFamilia = numeroFamilia;
	}
	
	@ManyToOne
	@JoinColumn(name="FAM_ACS")
	public Acs getAgente() {
		return agente;
	}
	public void setAgente(Acs agente) {
		this.agente = agente;
	}
	
	@ManyToOne
	@JoinColumn(name="FAM_RUA")
	public Endereco getRua() {
		return rua;
	}
	public void setRua(Endereco rua) {
		this.rua = rua;
	}
	
	@OneToMany(mappedBy="familia", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@Column(name="FAM_NUMERO")
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
