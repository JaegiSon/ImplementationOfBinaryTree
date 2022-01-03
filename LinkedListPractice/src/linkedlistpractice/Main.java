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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                     //***below commented code is to test out linked list in work***
//        MyLinkedList list = new MyLinkedList(null);
//        //try traverse through to check it's working
//        list.traverse(list.getHead());
//        //mock data
//        String stringData = "5 7 3 9 8 2 1 0 4 6";     
//        //add the words from mock data into an array
//        String [] data = stringData.split(" "); 
//        for (String s : data){
//            list.addItem(new Node(s));
//        }
//        //try traverse through to check it's working
//        list.traverse(list.getHead());
//        //try remove item and traverse again to check item was removed
//        list.removeItem(new Node("5"));
//        list.traverse(list.getHead());
////        list.traverse(list.getHead());
                    //***below commented code is to test out binary tree in work***
        SearchTree tree = new SearchTree(null);
        //try traverse through to check it's working
        tree.traverse(tree.getHead());
        //mock data
        String stringData = "5 7 3 9 8 2 1 0 4 6";     
        //add the words from mock data into an array
        String [] data = stringData.split(" "); 
        for (String s : data){
            tree.addItem(new Node(s));
        }
        //try traverse through to check it's working
        tree.traverse(tree.getHead());
        //try remove item and traverse again to check item was removed
        tree.removeItem(new Node("5"));
        tree.traverse(tree.getHead());
//        list.traverse(list.getHead());
    }
}
