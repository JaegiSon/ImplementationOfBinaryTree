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
public interface NodeList {
    ListItem getHead();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem head);
    
}
