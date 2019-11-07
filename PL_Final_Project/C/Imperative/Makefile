# Makefile for Grep

CC = gcc
CFLAGS = -g -Wall
LDFLAGS = -lpthread

all: grep

linkedList.o: linkedList.c linkedList.h
	$(CC) $(CFLAGS) -c linkedList.c

grep.o: grep.c
	$(CC) $(CFLAGS) -c grep.c

grep: grep.o linkedList.o
	$(CC) $(CFLAGS) grep.o linkedList.o -o grep $(LDFLAGS)

clean:
	rm -f *~ *.o grep core *.tar *.zip *.gzip *.bzip *.gz

