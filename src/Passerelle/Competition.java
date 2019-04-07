package Passerelle;


import java.sql.Date;



@Entity
@Table(name = "Competition")

public class Competition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "date_cloture")
	private Date date_cloture;


	@Column(name = "EnEquipe")
	private Boolean EnEquipe;
	
	
	public Competition(int id, String nom, Date date_cloture, Boolean EnEquipe)
	{
		this.id = id;
		this.nom = nom;
		this.date_cloture = date_cloture;
		this.EnEquipe = EnEquipe;

	}
	
}
