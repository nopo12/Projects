#include "linkedList.h"

struct node *head = NULL;
struct node *current = NULL;
//display the list
void printList() {
    struct node *ptr = head;
    reverse(&ptr);
    //start from the beginning
    while(ptr != NULL) {
        printf("%s %d\n",ptr->key,ptr->value);
        ptr = ptr->next;
    }
}

//insert link at the first location
void insertFirst(char *key, int data) {
    //create a link
    struct node *link = (struct node*) malloc(sizeof(struct node));

    link->key = key;
    link->value = data;
    //point it to old first node
    link->next = head;
    //point first to new first node
    head = link;
}

//delete first item
struct node* deleteFirst() {

    //save reference to first link
    struct node *tempLink = head;

    //mark next to first link as first
    head = head->next;

    //return the deleted link
    return tempLink;
}

//is list empty
bool isEmpty() {
    return head == NULL;
}

int length() {
    int length = 0;
    struct node *current;

    for(current = head; current != NULL; current = current->next) {
        length++;
    }

    return length;
}

//find a link with given key
struct node* find(char *key) {

    //start from the first link
    struct node* current = head;

    //if list is empty
    if(head == NULL) {
        return NULL;
    }

    //navigate through list
    while(strcmp(current->key,key) != 0) {
        //if it is last node
        if(current->next == NULL) {
            return NULL;
        } else {
            //go to next link
            current = current->next;
        }
    }

    //if data found, return the current Link
    return current;
}

//delete a link with given key
struct node* delete(char *key){

    //start from the first link
    struct node* current = head;
    struct node* previous = NULL;

    //if list is empty
    if(head == NULL) {
        return NULL;
    }

    //navigate through list
    while(strcmp(current->key,key) == 1) {

        //if it is last node
        if(current->next == NULL) {
            return NULL;
        } else {
            //store reference to current link
            previous = current;
            //move to next link
            current = current->next;
        }
    }
    //found a match, update the link
    if(current == head) {
        //change first to point to next link
        head = head->next;
    } else {
        //bypass the current link
        previous->next = current->next;
    }

    return current;
}

void reverse(struct node** head_ref) {
    struct node* prev   = NULL;
    struct node* current = *head_ref;
    struct node* next;

    while (current != NULL) {
        next  = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    *head_ref = prev;
}