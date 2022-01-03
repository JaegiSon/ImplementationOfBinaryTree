/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistpractice;

/**
 *
 * @author Windows 10
 */
public class MyLinkedList implements NodeList{

    private ListItem head = null;

    public MyLinkedList(ListItem head) {
        this.head=head;
    }
    
    @Override
    public ListItem getHead() {
         return this.head;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.head==null){
            this.head=newItem;
            return true;
        }
        ListItem currentItem = this.head;
        while(currentItem!=null){
            int comparison = currentItem.compareTo(newItem);
            if(comparison<0){
                //new item is greater --> move to right
                if(currentItem.next()!=null){
                    currentItem=currentItem.next();
                }else{
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }else if(comparison>0){
                //new item is lesser --> move to left
                if(currentItem.previous()!=null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                }else{
                    //the node with a previous is the root
                    newItem.setNext(this.head);
                    this.head.setPrevious(newItem);
                    this.head = newItem;
                    
                }
                return true;
            }else{
                System.out.println(newItem.getValue()+" already exists in the list. ");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(this.head!=null){    //if the list is not empty
            System.out.println("deleting item "+item.getValue());
        }
        ListItem currentItem = this.head;
        while(currentItem!=null){
            int comparison = currentItem.compareTo(item);
            if(comparison==0){
                //found the item to delete
                if(currentItem==this.head){
                    this.head=currentItem.next();
                }else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if(comparison<0){
                currentItem=currentItem.next();
            }else{
                //We are at an item greater than the one to be deleted
                //So the item is not in the list
                return false;
            }
        }
        //We have reached the end of the list without findiing the item to be deleted
        return false;
    }

    @Override
    public void traverse(ListItem head) {
        if(head==null){
            System.out.println("The list is empty");
        }else{
            while(head!=null){
                System.out.println(head.getValue().toString());
                head=head.next();
            }
        }
    }

    
}
