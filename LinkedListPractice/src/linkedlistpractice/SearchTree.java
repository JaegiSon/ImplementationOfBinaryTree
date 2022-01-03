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
public class SearchTree implements NodeList{
    private ListItem head = null;

    public SearchTree(ListItem head) {
        this.head=head;
    }
    
    @Override
    public ListItem getHead() {
        return this.head;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.head == null){
            this.head = newItem;
            return true;
        }
        ListItem currentItem = this.head;
        while(currentItem!=null){
            int comparison = (currentItem.compareTo(newItem));
            if(comparison<0){
                if(currentItem.next()!=null){//new item is greater, move to the right if possible
                    currentItem=currentItem.next();
                }else{//there is no node to the right so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            }else if(comparison>0){
                // new item is less, move left is possible
                if(currentItem.previous() !=null){
                    currentItem = currentItem.previous();
                }else{
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else{
                //equal so no need to add
                System.out.println(newItem.getValue()+" already exists");
                return false;
            }
        }
        return false;
    }
    

    @Override
    public boolean removeItem(ListItem item) {
        if(item!=null){
            System.out.println("Deleting item"+item.getValue());
        }
        ListItem currentItem = this.head;
        ListItem parentItem = currentItem;
        
        while(currentItem!=null){
            int comparison=currentItem.compareTo(item);
            if(comparison<0){
                parentItem=currentItem;
                currentItem=currentItem.next();
            }else if(comparison>0){
                parentItem=currentItem;
                currentItem=currentItem.previous();
            }else{
                //we've found item that's equal so remove 
                performRemoval(currentItem,parentItem);
                return true;
            }
        }
        return false;
    }
    private void performRemoval(ListItem item, ListItem parent){
        //remove item from the tree
        if(item.next()==null){
            //no right tree, so make parent point to left tree (note that this might be null
            if(parent.next()==item){
                //item is right child of parent
                parent.setNext(item.previous());
            }else if(parent.previous()==item){
                //item is left child of parent
                parent.setPrevious(item.previous());
            }else{
                this.head = item.previous();
            }
        }else if(item.previous()==null){
            //no left tree - so make parent point to the right tree
            if(parent.next()==item){
                //item is right child of its parent
                parent.setNext(item.next());
            }else if(parent.previous()==item){
                //item is left child of its parent
                parent.setPrevious(item.next());
            }else{
                this.head=item.next();
            }
        }else{
            //neither left nor right are null
            //from the right sub-tree, find the smallest value
            ListItem current=item.next();
            ListItem leftMostParent = item;
            while(current.previous()!=null){
                leftMostParent=current;
                current=current.previous();
            }
            //now put the smallest alue into our node to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if(leftMostParent==item){
                //there was no leftmost node, so "current" points to the smallest
                //node (the one that must now be deleted.
                item.setNext(current.next());
            }else{
                //set the smallest node's parent to point to
                //the smallest node's right child(which may be null)
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem head) {
        if(head!=null){
            traverse(head.previous());
            System.out.println(head.getValue());
            traverse(head.next());
        }
    }

    
}
