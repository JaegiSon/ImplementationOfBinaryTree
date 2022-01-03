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
public abstract class ListItem {
    protected ListItem next, previous;
    protected Object value;

    abstract ListItem next();
    abstract ListItem previous();
    abstract ListItem setNext(ListItem item);
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);
    
    public ListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    
}
