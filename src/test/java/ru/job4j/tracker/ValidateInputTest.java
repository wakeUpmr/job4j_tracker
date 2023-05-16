package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(2);

        selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(1);

        selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    public void whenNegativeInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Select: ");
        assertThat(selected).isEqualTo(-1);
    }
}