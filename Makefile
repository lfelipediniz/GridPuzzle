# name of java file
MAIN = Main
BOARD = Board

# compile the program
all:
	javac $(BOARD).java $(MAIN).java

# run the program
run:
	java $(MAIN)
