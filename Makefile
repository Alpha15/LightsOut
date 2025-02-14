JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin

SOURCES := $(wildcard $(SRC_DIR)/*.java)
CLASSES := $(patsubst $(SRC_DIR)/%.java, $(BIN_DIR)/%.class, $(SOURCES))

all: $(CLASSES)
run: all
	$(JAVA) -cp $(BIN_DIR) Main

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) -cp $(BIN_DIR) $(SOURCES)

clean:
	rm -rf $(BIN_DIR)/*.class

.PHONY: all clean
