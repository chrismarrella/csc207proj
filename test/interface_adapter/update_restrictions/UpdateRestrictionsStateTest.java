package interface_adapter.update_restrictions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateRestrictionsStateTest {

    @Test
    public void testDefaultConstructor() {
        UpdateRestrictionsState state = new UpdateRestrictionsState();
        assertNull(state.getMaxcals());
        assertNull(state.getMincals());
        assertNull(state.getMaxprotein());
        assertNull(state.getMinprotein());
        assertNull(state.getMaxfat());
        assertNull(state.getMinfat());
        assertNull(state.getMaxcarbs());
        assertNull(state.getMincarbs());
        assertNull(state.getRestriction());
        assertNull(state.getError());
    }

    @Test
    public void testCopyConstructor() {
        UpdateRestrictionsState originalState = new UpdateRestrictionsState();
        originalState.setMaxcals(100.0f);
        originalState.setMincals(50.0f);
        originalState.setMaxprotein(100.0f);
        originalState.setMinprotein(50.0f);
        originalState.setMaxfat(100.0f);
        originalState.setMinfat(50.0f);
        originalState.setMaxcarbs(100.0f);
        originalState.setMincarbs(50.0f);
        originalState.setRestriction("Egg");
        originalState.setError("Error Message");


        UpdateRestrictionsState copyState = new UpdateRestrictionsState(originalState);

        assertEquals(originalState.getMaxcals(), copyState.getMaxcals());
        assertEquals(originalState.getMincals(), copyState.getMincals());
        assertEquals(originalState.getMaxprotein(), copyState.getMaxprotein());
        assertEquals(originalState.getMinprotein(), copyState.getMinprotein());
        assertEquals(originalState.getMaxfat(), copyState.getMaxfat());
        assertEquals(originalState.getMinfat(), copyState.getMinfat());
        assertEquals(originalState.getMaxcarbs(), copyState.getMaxcarbs());
        assertEquals(originalState.getMincarbs(), copyState.getMincarbs());
        assertEquals(originalState.getRestriction(), copyState.getRestriction());
        assertEquals(originalState.getError(), copyState.getError());

    }

    @Test
    public void testGettersAndSetters() {
        UpdateRestrictionsState state = new UpdateRestrictionsState();

        state.setMaxcals(200.0f);
        assertEquals(200.0f, state.getMaxcals());

        state.setMincals(100.0f);
        assertEquals(100.0f, state.getMincals());

        state.setMinprotein(100.0f);
        assertEquals(100.0f, state.getMinprotein());

        state.setMaxprotein(200.0f);
        assertEquals(200.0f, state.getMaxprotein());

        state.setMinfat(100.0f);
        assertEquals(100.0f, state.getMinfat());

        state.setMaxfat(200.0f);
        assertEquals(200.0f, state.getMaxfat());

        state.setMincarbs(100.0f);
        assertEquals(100.0f, state.getMincarbs());

        state.setMaxcarbs(200.0f);
        assertEquals(200.0f, state.getMaxcarbs());

        state.setError("Error Message");
        assertEquals("Error Message", state.getError());

        state.setRestriction("Egg");
        assertEquals("Egg", state.getRestriction());

        state.setValue(100.0f);
        assertEquals(100.0f, state.getValue());

    }

    @Test
    public void testGettersAndSettersWithNull() {
        UpdateRestrictionsState state = new UpdateRestrictionsState();

        state.setMaxcals(null);
        assertNull(state.getMaxcals());

        state.setMincals(null);
        assertNull(state.getMincals());
    }



}
