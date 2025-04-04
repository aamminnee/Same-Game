# Variables
JAVAC = javac
JAVA_FILES = Main.java Fenetre.java Bloc.java Grille.java ControlleurGrille.java ControlleurBoutonMenu.java FondJeu.java BoutonMenu.java
CLASS_FILES = $(JAVA_FILES:.java=.class)
MAIN_CLASS = Main

# Règles
all: $(CLASS_FILES)

%.class: %.java
	$(JAVAC) $<

run: all
	java $(MAIN_CLASS)

# pour supprimmer tout les fichier .clss
clean:
	rm -f $(CLASS_FILES)

.PHONY: all run clean