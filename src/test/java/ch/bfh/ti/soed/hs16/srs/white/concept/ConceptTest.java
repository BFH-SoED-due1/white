package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import com.vaadin.ui.Component;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
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
    public void testAbstractControllerView() {
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
}
