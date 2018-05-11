/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/11/18
 *
 * Description: Item class
 *****************************************************************/


public class Item implements ItemInterface {

    private String desc;
    private int qty;
    private String store;
    private String assign;

    public Item(String d, int q, String s, String a) {
        desc = d;
        qty = q;
        store = s;
        assign = a;
    }

    // Item Description
    public void setDesc(String d) {
        desc = d;
    }

    // Item Quantity
    public void setQty(int q) {
        qty = q;
    }

    // Where to purchase
    public void setStore(String s) {
        store = s;
    }

    // Who will purchase
    public void setAssign(String a) {
        assign = a;
    }

    // Item Description
    public void getDesc() {
        return desc;
    }

    // Item Quantity
    public void getQty() {
        return qty;
    }

    // Where to purchase
    public void getStore() {
        return store;
    }

    // Who will purchase
    public void getAssign() {
        return assign;
    }

}
