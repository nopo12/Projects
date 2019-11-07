//
// Created by noah on 12/24/18.
//

#ifndef IMPERATIVE_LINKEDLIST_H
#define IMPERATIVE_LINKEDLIST_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

struct node {
    char *key;
    int value;
    struct node *next;
};


//display the list
void printList();

//insert link at the first location
void insertFirst(char *key, int data);

//delete first item
struct node* deleteFirst();

//is list empty
bool isEmpty();

//find a link with given key
struct node* find(char *key);

//delete a link with given key
struct node* delete(char *key);
void reverse(struct node** head_ref);

#endif //IMPERATIVE_LINKEDLIST_H
