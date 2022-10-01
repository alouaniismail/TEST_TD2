all: test testsFaussaires 
clean: clean2
	rm -rf build/* *.class *.java~ Makefile~
clean2:
	rm -rf autobus/*.java~ autobus/*.class passager/*.java~ passager/*.class
testsFaussaires: tf1 tf2
test: t1 t2
t1: TestJauge.java
	javac $< && java TestJauge
t2: TestPosition.java
	javac $< && java TestPosition
tf1: tf1_annexe
	java -ea -cp build TestAutobus
tf1_annexe:
	javac -d build autobus/*.java
tf2: tf2_annexe
	java -ea -cp build TestPassagerStandard
tf2_annexe:
	javac -d build passager/*.java
#-d lance les .class dans le folder choisi en parametre.
#-cp dis au jvm d'aller chercher la classe dans ce folder en question
#(qui est en parametre bien sur).
