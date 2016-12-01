package ch.bfh.ti.soed.hs16.srs.white.view;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by joni on 30/11/16.
 */
public class TableView {

    VerticalLayout layout = new VerticalLayout();

    public VerticalLayout createTable(){

        Table table1 = new Table("Shoes price list");

        table1.addContainerProperty("Name", String.class, null);
        table1.addContainerProperty("#Seats", Integer.class, null);
        table1.addContainerProperty("Reservations", Integer.class, null);
        table1.addContainerProperty("Equipment", String.class, null);

        table1.addItem(new Object[] {"A001",50, 2, "Cheese"}, new Integer(1));
        table1.addItem(new Object[] {"A002",40, 0, "Oranges"}, new Integer(2));
        table1.addItem(new Object[] {"A003",60, 3, "Apples"}, new Integer(3));
        table1.addItem(new Object[] {"A004",20, 1, "Bananas"}, new Integer(4));

        layout.addComponent(table1);

        return layout;
    }
}

