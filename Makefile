clean:
	rm -rf *.class *.java~ Makefile~
test: t1 t2
t1: TestJauge.java
	javac $< && java TestJauge
t2: TestPosition.java
	javac $< && java TestPosition
