package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by arauzca on 08.01.17.
 */
public class ConceptTest {

    @Test
    public void testAbstractModel() throws SQLException {
        AbstractModel abstractModel = new AbstractModel() {
            @Override
            public boolean loadModel() throws SQLException {
                data = new ArrayList();
                return true;
            }
        };

        assertTrue(abstractModel.loadModel());

        List l1 = abstractModel.getData();
        assertEquals(0, l1.size());

        Object o = new Object();
        abstractModel.addData(o);

        List l2 = abstractModel.getData();
        assertTrue(l2.size() > 0);
        assertEquals(o, l2.get(0));

    }

    @Test
    public void testAbstractViewController() {
        AbstractController abstractController = new AbstractController() {
            @Override
            public void init() {

            }
        };

        AbstractView abstractView0 = new AbstractView() {
            @Override
            public Component load() {
                return null;
            }

            @Override
            public Controller loadController() {
                return abstractController;
            }

            @Override
            public void restart() throws OperationNotSupportedException {
                throw new OperationNotSupportedException();
            }

            @Override
            public void changeContent(View newContent) {}
        };

        abstractController.setMyView(abstractView0);


        assertNull(abstractView0.load());
        assertEquals(abstractController, abstractView0.loadController());
        assertEquals(abstractView0, abstractController.myView);

        AbstractView abstractView1 = new AbstractView(abstractView0) {
            @Override
            public Component load() {
                return null;
            }

            @Override
            public Controller loadController() {
                return null;
            }

            @Override
            public void restart() throws OperationNotSupportedException {}

            @Override
            public void changeContent(View newContent) {}
        };

        assertEquals(abstractView0, abstractView1.getLastView());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAbstractTableViewController() {
        List<Object> list = new ArrayList<>();
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        list.add(new Object());

        AbstractTableController abstractTableController0 = new AbstractTableController() {

            @Override
            public List getData() {
                return Collections.unmodifiableList(list);
            }

            @Override
            public boolean deleteData(int ID) {
                return false;
            }

            @Override
            public void init() {
            }
        };

        AbstractTableView abstractTableView = new AbstractTableView() {
            @Override
            public Component createItemView(Object o) {
                return horizontalLayout;
            }

            @Override
            public Component createHeader() {
                return verticalLayout;
            }

            @Override
            public Controller loadController() {
                abstractTableController = abstractTableController0;
                return abstractTableController;
            }

            @Override
            public void changeContent(View newContent) {

            }
        };

        assertEquals(abstractTableController0, abstractTableView.loadController());
        abstractTableView.load();
        abstractTableView.restart();
        assertTrue(abstractTableController0.getData().size() > 0);
        assertFalse(abstractTableController0.deleteData(0));
        assertEquals(horizontalLayout, abstractTableView.createItemView(null));
        assertEquals(verticalLayout, abstractTableView.createHeader());
    }
}
