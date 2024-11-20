JAVAC = javac
JAVA = java
SOURCES = $(wildcard *.java)
CLASSES = $(SOURCES:.java=.class)
MAIN = Main

all: $(MAIN)

%.class: %.java
	$(JAVAC) $<
	@echo "*********************COMPILACION FINALIZADA*********************"

$(MAIN): $(CLASSES)
	@$(JAVA) $(MAIN)
	@echo "*********************EJECUCION FINALIZADA***********************"

clean:
	rm -f $(CLASSES)
