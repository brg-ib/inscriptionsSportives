package Passerelle;

import java.sql.Date;

@Entity
@Table(name = "Candidat")


public class Candidat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;
	
	public Candidat(int id, String nom)
	{
		this.id = id;
		this.nom = nom;

	}
	
	
}
