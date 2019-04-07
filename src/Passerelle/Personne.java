package Passerelle;

import java.sql.Date;

@Entity
@Table(name = "Personne")


public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "Prenom")
	private String Prenom;

	@Column(name = "mail")
	private String mail;

	
	public Personne(int id, String Prenom, String mail)
	{
		this.id = id;
		this.Prenom = Prenom;
		this.mail = mail;

	}

}
