JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        Accueil.java \
        AjoutCarton.java \
        AjoutMeuble.java \
        Data.java  \
        MesCartons.java \
        MesMeubles.java \
        MonMenu.java \
        Application.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class