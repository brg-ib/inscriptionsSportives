package menuUser;

import java.util.*;

import inscriptions.*;
import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;



import java.time.LocalDate;

//import entity.Candidat;
//import entity.Competition;
//import entity.Equipe;
//import entity.Personne;

public class MainUser {

	
	// Menu principal
	 private static Menu getMainMenu(){
		Menu menu = new Menu("Inscriptions Sportives");
//		menu.add(getmenuInscriptions());
		menu.add(getmenuCandidats());
		menu.add(getmenuCompetitions());
		menu.add(getmenuPersonne());
//		menu.add(getmenuEquipe());
//		menu.add(getmenuExit());
		menu.addQuit("q");
		return menu;
	}


//	 
//	// Menu Inscriptions
//
//		private static Menu getmenuInscriptions() {
//
//			
//
//			Menu menu = new Menu("MenuInscriptions","Inscriptions", "i");
//
//			// TODO 
//
//			menu.add(createEquipeOption());
//
//	        menu.add(deleteCompetitionOption());
//
//	        menu.add(deleteCandidatOption());        
//
//			menu.add(addEquipeOption());
//
//	        menu.add(displayEquipeOption());
//
//	        menu.add(modifyEquipeOption());
//
//	        menu.addBack("B");
//
//			menu.setAutoBack(true);
//
//			return menu;
//
//
//
//	        
//
//		}
//
//		
//
//	static Option createEquipeOption() {
//
//			
//
//			return new Option("createPersonne", "C", createPersonne());
//
//
//
//		}
//
//		
//
//		
//
//		static Option createEquipeOption() {
//
//			
//
//			return new Option("addEquipe", "A", createEquipe());
//
//
//
//		}
//
//		
//
//		
//
//		static Option deleteCompetitionOption() {
//
//			
//
//			return new Option("deleteEquipe", "D", InscriptionsDetele(Competition));
//
//
//
//		}
//
//		
//
//		static Option deleteCandidatOption() {
//
//			
//
//			return new Option("addEquipe", "d", InscriptionsDelete(Candidat));
//
//
//
//		}
//
//		static Option createEquipeOption() {
//
//			
//
//			return new Option("addEquipe", "c", InscriptionsgetInscriptions());
//
//
//
//		}
//
//
//
//		
//
//		
//
//		
//
//		
//
//		static ArrayList<String> tab = new ArrayList<String>();
//
//
//
//		
//
//	static Action deleteCompetitionOption() {
//
//		{
//
//			return new Action()
//
//			{
//
//				public void optionSelected()
//
//				{
//
//					tab.add("Ligue1");
//
//					tab.remove("Ligue1");
//
//					System.out.println(al + " a bien ete supprimee.");
//
//		
//				}
//
//			};
//
//		}
//
//			
//
//		static Action deleteCandidatOption() {
//
//			{
//
//				return new Action()
//
//				{
//
//					public void optionSelected()
//
//					{
//
////						tab.add("Gisele");
//
//						tab.remove("Gisele");
//
//						System.out.println(al + " a bien ete supprimee.");
//
//					}
//
//				};
//
//			}
//
//
//		}
//



	

	// Menu Candidats
	private static Menu getmenuCandidats() {
		Menu menu = new Menu("Candidats", "Candidat", "c");
		// TODO
		menu.add(getCandidatsNom());
		menu.add(CandidatsDelete());
		menu.add(setCandidatsNom());
		menu.add(getCandidatsCompetitions());
		menu.addBack("b");
		menu.setAutoBack(true);
		return menu;
	}
	
//	static Option getCandidatsOption()
//	{
//		return new Option("Nom", "N", getCandidatsNom());
//
//	}
	
//	static Option getCandidatsOption1()
//	{
//
//		return new Option("Delete", "D", CandidatsDelete());
//
//	}
	
//	static Option getCandidatsOption2()
//	{
//
//		return new Option("Modifier le Nom", "MN", setCandidatsNom());
//	}
	
//	static Option getCandidatsOption3()
//	{
//
//		return new Option("Compétitions", "C", getCandidatsCompetitions());
//
//	}
	
	
	
	
	static Option getCandidatsNom()
	{
		
		return new Option("Liste des noms des candidats", "l", () -> { 
			System.out.println(Candidat.getNom());
		});
	
	}
	
	
//	static ArrayList<String> al = new ArrayList<String>();
//
//	
//	static Action getCandidatsNom()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
////				System.out.println("Marcel");
//				al.add("Ginette");
//				
//			      System.out.println("Nom du candidat : " + al);
//			    
//			}
//		};
//	}

	
	
	
	static Option CandidatsDelete()
	{
		
		return new Option("Supprime un candidat de l'application.", "s", () -> { 
			Candidat.delete();
			System.out.println("le candidat a bien été supprimer de l'application");
		});
	
	}
	
	
//	static Action CandidatsDelete()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				
//				al.add("Ginette");
//				al.remove("Ginette");
//				System.out.println(al + " has been deleted.");
//				
//			}
//		};
//	}
		
	
	static Option setCandidatsNom()
	{
		
		return new Option("Modifier le nom du candiat.", "m", () -> { 
			Scanner sc = new Scanner(System.in);
			System.out.println("Saisir le nouveau nom du candidat : ");
			String i = sc.nextLine(); 
			Candidat.setNom(i);
		});
	
	}
	
	
	
	
//	static Action setCandidatsNom()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Saisissez l'indice : ");
//				int i = sc.nextInt();
//				System.out.println("Saisissez le nouveau nom : ");
//				String n = sc.nextLine();
//				al.set(i, n);
//			}
//		};
//	}
	
	static Option getCandidatsCompetitions()
	{
		
		return new Option("Liste des compétitions du candidat", "c", () -> { 
			System.out.println(Candidat.getCompetitions());
		});
	
	}
	
	
//	static Action getCandidatsCompetitions()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				System.out.println("Basket");
//				System.out.println("Golf");
//				System.out.println("Course de cheveaux");
//				System.out.println("Handball");
//			}
//		};
//	}
	
	
	
	
	
	
	// TODO

	
//	 Menu Competitions
	private static Menu getmenuCompetitions() {
		Menu menu = new Menu("Competitions", "cp");
		// TODO
		
		menu.add(getCompetitionNom());
		menu.add(getCandidatComp());
		menu.add(getPersonnesAInscrire());
		menu.add(getDateCloture());
		menu.add(addEquipe());
		menu.add(addPersonne());
		menu.add(setDateCloture());
		menu.add(setCompetitionNom());
		menu.add(removeCandidat());
//		menu.add(delete());
		menu.addBack("B");
		menu.setAutoBack(true);
		return menu;
	}
	
//	static Option getCompetitionOption1()
//	{
//		return new Option("Nom", "NC", getCompetitionNom());
//
//	}
	
//	static Option getCompetitionOption2()
//	{
//
//		return new Option("Candidats inscrits", "CI", getCandidatComp());
//
//	}
	
//	static Option getCompetitionOption3()
//	{
//
//		return new Option("Personne à inscrire", "PI", getPersonnesAInscrire());
//	}
	
	
	
//	static Option getCompetitionOption5()
//	{
//
//		return new Option("Date de cloture", "DC", getDateCloture());
//	}
	
//	static Option getCompetitionOption6()
//	{
//
//		return new Option("Ajouter une équipe", "AE", addEquipe());
//	}
	
//	static Option getCompetitionOption7()
//	{
//
//		return new Option("Ajouter une personne", "AP", addPersonne());
//	}
	
//	static Option getCompetitionOption8()
//	{
//
//		return new Option("Modifier la date de cloture", "MDC", setDateCloture());
//	}
	
//	static Option getCompetitionOption9()
//	{
//
//		return new Option("Modifier le Nom de la competition", "MNC", setCompetitionNom());
//	}
	
//	static Option getCompetitionOption10()
//	{
//		return new Option("Désinscrit un candidat", "RC", removeCandidat());
//	}
	
//	static Option getCompetitionOption11()
//	{
//		return new Option("Supprimer la compétition de l'application", "D", delete());
//	}
	
//	static Option getCompetitionOption12()
//	{
//		return new Option("Modifier le Nom", "MN", setCandidatsNom());
//	}
	
	
	


	
	static Option getCompetitionNom()
	{
		
		return new Option("Liste des competitions", "l", () -> { 
			System.out.println(Inscriptions.getInscriptions().getCompetitions());
		});
	
	}
	
	
	static Option getCandidatComp()
	{
		
		return new Option("Liste des candidats", "c", () -> { 
			System.out.println(Inscriptions.getInscriptions().getCandidats());
		});
	}
	
//static ArrayList<String> candcomp = new ArrayList<String>();
//
//	
//	static Action getCandidatComp()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				candcomp.add("Ginette");
//				candcomp.add("Marcel");
//				candcomp.add("Gisèle");
//				candcomp.add("Raymond");
//				candcomp.add("Ginette");
//				
//			      System.out.println("Nom des candidats inscrits : " + candcomp);
//			    
//			}
//		};
//	}
	
	
	
	static Option getPersonnesAInscrire()
	{
		
		return new Option("Liste des personnes pouvant s'inscrire", "p", () -> { 
			System.out.println(Inscriptions.getInscriptions().getPersonnes());
		});
	
	}
	
//static ArrayList<String> PIC = new ArrayList<String>();
//
//	
//	static Action getPersonnesAInscrire()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				PIC.add("Ginette");
//				PIC.add("Marcel");
//				PIC.add("Gisèle");
//				PIC.add("Raymond");
//			      System.out.println("Personnes pouvant être inscrit à la compétition : " + PIC);
//			    
//			}
//		};
//	}
	

	
	static Option getDateCloture()
	{
		
		return new Option("Date de cloture des inscriptions ", "d", () -> { 
			System.out.println(Competition.getDateCloture());
		});
	
	}
	
	
//static ArrayList<String> DCC = new ArrayList<String>();
//
//	
//	static Action getDateCloture()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				DCC.add("27/08/2018");
//			      System.out.println("Date de cloture des inscriptions : " + DCC);
//			    
//			}
//		};
//	}
	
	
	static Option addEquipe()
	{
		
		return new Option("Inscrit un candidat de type équipe à la compétition.", "ae", () -> { 
			Scanner sc = new Scanner(System.in);
			String e = sc.nextLine();
			System.out.println("Saisir le nom d'un candidat : " + Inscriptions.getInscriptions().createEquipe(e));
		});
	
	}
	
	
	
	static Option addPersonne()
	{
		
		return new Option("Inscrit un candidat de type Personne à la compétition.", "ap", () -> { 
			Scanner sc = new Scanner(System.in);
			System.out.println("Saisir le nom : ");
			String n = sc.nextLine();
			System.out.println("Saisir le prénom : ");
			String p = sc.nextLine();
			System.out.println("Saisir le mail : ");
			String m = sc.nextLine();
			System.out.println(Inscriptions.getInscriptions().createPersonne(n, p, m));
		});
	
	}
	
	
	static Option setDateCloture()
	{
		
		return new Option("Modifier la date de cloture des inscriptions.", "md", () -> { 
			Scanner sc = new Scanner(System.in);
			String i = sc.nextLine();
			System.out.println("Saisir la nouvelle date cloture : ");
//			 Competition.setDateCloture(i);
		});
	
	}
	
//	static Option setDateCloture()
//	{
//		
//		return new Option("Modifier la date de cloture des inscriptions.", "md", () -> { 
//			Scanner sc = new Scanner(System.in);
//			LocalDate i = sc.locale();
////			int i = sc.nextInt();
//			System.out.println("Saisir le nouveau nom de la compétition : ");
//			Competition.setDateCloture(i);
//		});
//	
//	}
	
//static ArrayList<String> MDCC = new ArrayList<String>();	
//	static Action setDateCloture()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Saisissez l'indice : ");
//				int i = sc.nextInt();
//				System.out.println("Saisissez la nouvelle date de cloture : ");
//				String n = sc.nextLine();
//				MDCC.set(i, n);
//			}
//		};
//	}
	
	
	
	
	static Option setCompetitionNom()
	{
		
		return new Option("Modifier le nom de la compétition.", "mc", () -> { 
			Scanner sc = new Scanner(System.in);
			String i = sc.nextLine();
			System.out.println("Saisir le nouveau nom de la compétition : ");
			 Competition.setNom(i);
		});
	
	}
	
	
	
//static ArrayList<String> MNC = new ArrayList<String>();	
//	static Action setCompetitionNom()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				Scanner sc = new Scanner(System.in);
//				System.out.println("Saisissez l'indice : ");
//				int i = sc.nextInt();
//				System.out.println("Saisissez le nouveau nom de la compétition : ");
//				String n = sc.nextLine();
//				MNC.set(i, n);
//			}
//		};
//	}
	
	
	
	static Option removeCandidat()
	{
		return new Option("Désinscrit un candidat.", "r", () -> { 
//			Competition.remove();
			System.out.println("le candidat a bien été désinscrit.");
		});
	
	}
	
//static ArrayList<String> RCC = new ArrayList<String>();	
////RCC.add("Ginette");
//	static Action removeCandidat()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				
//				RCC.remove("Ginette");
//				System.out.println(RCC + " a été désincrit(e).");
//				
//			}
//		};
//	}
	
	
	static Option delete()
	{
		
		return new Option("Supprime la compétition de l'application.", "s", () -> { 
			Competition.delete();
			System.out.println("la compétition a bien été supprimer de l'application");
		});
	
	}
	
		
//static ArrayList<String> D = new ArrayList<String>();	
//	static Action delete()
//	{
//		return new Action()
//		{
//			public void optionSelected()
//			{
//				
//				D.remove("Course");
//				System.out.println(D + " a été supprimé.");
//				
//			}
//		};
//	}
	// TODO

	
	
	
	// Menu Personne
		private static Menu getmenuPersonne() {
			Menu menu = new Menu("Personnes", "p");
			// TODO
			
			menu.add(getPrenom());
			menu.add(getMail());
			menu.add(getEquipe());
			menu.add(setPrenom());
			menu.add(setMail());
			menu.add(deletePers());
			menu.addBack("B");
			menu.setAutoBack(true);
			return menu;
		}
		
		
//		static Option getPersonneOption1()
//		{
//			return new Option("Prenom", "GP", getPrenom());
//
//		}
		
//		static Option getPersonneOption2()
//		{
//
//			return new Option("Email", "GM", getMail());
//
//		}
		
//		static Option getPersonneOption3()
//		{
//
//			return new Option("Les équipes dont la personne fait partie", "GE", getEquipe());
//		}
		
//		static Option getPersonneOption4()
//		{
//
//			return new Option("Modifier le prénom", "SP", setPrenom());
//
//		}
//		
//		static Option getPersonneOption5()
//		{
//
//			return new Option("Modifier l'email", "SM", setMail());
//		}
		
//		static Option getPersonneOption6()
//		{
//
//			return new Option("Supprime le candidat de l'application", "D", deletePers());
//
//		}
//		
		
		static Option getPrenom()
		{
			
			return new Option("Prénom de la personne", "p", () -> { 
				System.out.println(Personne.getPrenom());
			});
		
		}
		
//static ArrayList<String> GP = new ArrayList<String>();
//		
//		static Action getPrenom()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					
//					GP.add("Ginette");
//				    System.out.println("Prenom  : " + GP);
//				    
//				}
//			};
//		}
		
		
		
		static Option getMail()
		{
			
			return new Option("Mail de la personne", "m", () -> { 
				System.out.println(Personne.getMail());
			});
		
		}
		
		
//static ArrayList<String> GM = new ArrayList<String>();
//		
//		static Action getMail()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					
//					GM.add("Ginette@gmail.com");
//				    System.out.println("Prenom  : " + GM);
//				    
//				}
//			};
//		}
		
	
		
		static Option getEquipe()
		{
			
			return new Option("Les équipes de la personne", "e", () -> { 
				System.out.println(Personne.getEquipes());
			});
		
		}
		
		
//static ArrayList<String> GE = new ArrayList<String>();
//		
//		static Action getEquipe()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					
//					GE.add("Equipe Moustache");
//					GE.add("Equipe TOTO");
//					GE.add("Equipe Torro");
//				    System.out.println("Equipes : " + GE);
//				    
//				}
//			};
//		}
	
		
		
		static Option setPrenom()
		{
			
			return new Option("Modifier le prenom de la personne.", "mp", () -> { 
				Scanner sc = new Scanner(System.in);
				System.out.println("Saisir le nouveau prenom de la personne : ");
				String i = sc.nextLine();
				Personne.setPrenom(i);
			});
		
		}
		
//static ArrayList<String> SP = new ArrayList<String>();	
//		static Action setPrenom()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					Scanner sc = new Scanner(System.in);
//					System.out.println("Saisissez l'indice : ");
//					int i = sc.nextInt();
//					System.out.println("Saisissez le nouveau prénom : ");
//					String n = sc.nextLine();
//					SP.set(i, n);
//				}
//			};
//		}
		
		
		static Option setMail()
		{
			
			return new Option("Modifier le mail de la personne.", "mm", () -> { 
				Scanner sc = new Scanner(System.in);
				System.out.println("Saisir le nouveau mail de la personne : ");
				String i = sc.nextLine(); 
				Personne.setMail(i);
			});
		
		}
		
//static ArrayList<String> SM = new ArrayList<String>();	
//		static Action setMail()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					Scanner sc = new Scanner(System.in);
//					System.out.println("Saisissez l'indice : ");
//					int i = sc.nextInt();
//					System.out.println("Saisissez le nouvel email : ");
//					String n = sc.nextLine();
//					SM.set(i, n);
//				}
//			};
//		}
		
	
		
		static Option deletePers()
		{
			
			return new Option("Supprime un candidat de l'application.", "s", () -> { 
				Personne.delete();
				System.out.println("Le candidat a bien été supprimé");
			});
		
		}
		
		
//static ArrayList<String> DP = new ArrayList<String>();	
//		static Action deletePers()
//		{
//			return new Action()
//			{
//				public void optionSelected()
//				{
//					
//					DP.remove("Course");
//					System.out.println(DP + " a été supprimé.");
//					
//				}
//			};
//		}
		// TODO

	
	// Main
	public static void main(String[] args)
	{
		Menu menu = getMainMenu();
		menu.start();
		
	
	}
	
	
}