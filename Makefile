JAVASRC    =\
AdventureGame.java \
GameHashMap.java \
Entry.java \
RoomOption.java \
GameStack.java \
map.java \
auxlib.java \
Room.java \
Player.java

SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = AdventureGame
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java AdventureGame test.adventure


.PHONY: clean all test
