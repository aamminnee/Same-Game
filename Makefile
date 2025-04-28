### VARIABLES ###
JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -Xlint:unchecked -deprecation
JVM = java
JVMFLAGS = -Xmx128m -cp .

### RÈGLES PRINCIPALES ###
all: Main.class

Main.class: Main.java Acceuil1.class
	${JC} ${JCFLAGS} Main.java

### INTERFACES ###
Acceuil1.class: Acceuil1.java FondJeu.class BoutonMenu.class BoutonQuitter.class BoutonRegles.class BoutonAcceuil2.class
	${JC} ${JCFLAGS} Acceuil1.java

Acceuil2.class: Acceuil2.java FondJeu.class BoutonMenu.class BoutonJouerAleatoire.class BoutonJeuFile.class BoutonRetour.class
	${JC} ${JCFLAGS} Acceuil2.java

FondJeu.class: FondJeu.java
	${JC} ${JCFLAGS} FondJeu.java

### JEU ###
JeuAleatoire.class: JeuAleatoire.java Jeu.class Grille.class ControlleurGrille.class
	${JC} ${JCFLAGS} JeuAleatoire.java

JeuFile.class: JeuFile.java Jeu.class Grille.class ControlleurGrille.class
	${JC} ${JCFLAGS} JeuFile.java

Jeu.class: Jeu.java
	${JC} ${JCFLAGS} Jeu.java

Grille.class: Grille.java Bloc.class
	${JC} ${JCFLAGS} Grille.java

Bloc.class: Bloc.java
	${JC} ${JCFLAGS} Bloc.java

ControlleurGrille.class: ControlleurGrille.java FinJeu.class
	${JC} ${JCFLAGS} ControlleurGrille.java

### BOUTONS ###
BoutonAcceuil2.class: BoutonAcceuil2.java Acceuil2.class
	${JC} ${JCFLAGS} BoutonAcceuil2.java

BoutonJeuFile.class: BoutonJeuFile.java JeuFile.class
	${JC} ${JCFLAGS} BoutonJeuFile.java

BoutonJouerAleatoire.class: BoutonJouerAleatoire.java JeuAleatoire.class
	${JC} ${JCFLAGS} BoutonJouerAleatoire.java

BoutonMenu.class: BoutonMenu.java
	${JC} ${JCFLAGS} BoutonMenu.java

BoutonQuitter.class: BoutonQuitter.java
	${JC} ${JCFLAGS} BoutonQuitter.java

BoutonRegles.class: BoutonRegles.java Regles.class
	${JC} ${JCFLAGS} BoutonRegles.java

BoutonRejouer.class: BoutonRejouer.java
	${JC} ${JCFLAGS} BoutonRejouer.java

BoutonRetour.class: BoutonRetour.java
	${JC} ${JCFLAGS} BoutonRetour.java

### AUTRES ###
FinJeu.class: FinJeu.java BoutonRejouer.class FondJeu.class
	${JC} ${JCFLAGS} FinJeu.java

Regles.class: Regles.java BoutonRetour.class
	${JC} ${JCFLAGS} Regles.java

### UTILITAIRES ###
run: all
	${JVM} ${JVMFLAGS} Main

clean:
	-rm -f *.class

mrproper: clean

.PHONY: all run clean mrproper