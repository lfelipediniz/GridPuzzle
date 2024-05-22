# name of java file
MAIN = Main
BOARD = Board
BOARDGUI = BoardGUI

# compile the program
all:
	javac $(BOARD).java $(MAIN).java $(BOARDGUI).java

# run the program
run:
	java $(MAIN)
