package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici\n");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peut vous trouver un étal.\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			}
			else {
				installerVendeur(nomVendeur);
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder dialogueInstallerVendeur = new StringBuilder();
		dialogueInstallerVendeur.append("C'est parfait, il me reste un étal pour vous !\n");
		dialogueInstallerVendeur.append("Il me faudrait quelques renseignements :\n");
		dialogueInstallerVendeur.append("Quel produit souhaitez vous vendre ?\n");
		System.out.println(dialogueInstallerVendeur);
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			numeroEtal+=1;
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numeroEtal+"\n");
			
		}
	}
}
