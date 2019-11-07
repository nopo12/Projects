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
void printList(struct node *head);

//insert link at the first location
struct node *insertFirst(struct node *head,char *key, int data);

//delete first item
struct node* deleteFirst(struct node *head);

//is list empty
bool isEmpty(struct node *head);

//find a link with given key
struct node* find(struct node *head,char *key);

//delete a link with given key
struct node* delete(struct node *head,char *key);
void reverse(struct node** head_ref);

#endif //IMPERATIVE_LINKEDLIST_H
