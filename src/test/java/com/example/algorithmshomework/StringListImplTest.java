package com.example.algorithmshomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.awt.AWTEventMulticaster.add;
import static org.assertj.core.api.Assertions.assertThat;

public class StringListImplTest {

    private final  StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach(){stringList.clear();}

    @Test
    void addTest() {
        String[] elements = {"test1", "test2", "test3", "test5"};
        add(elements);

        for (int i = 0; i < elements.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
        }

    }

    @Test
    void  addByIndexTest() {
        String[] elements = {"test1", "test2", "test3", "test5"};
        add(elements);

        stringList.add(0, "test");
        assertThat(stringList.size()).isEqualTo(elements.length + 1);
        assertThat(stringList.get(0)).isEqualTo("test");

        stringList.add(3, "test");
        assertThat(stringList.size()).isEqualTo(elements.length + 2);
        assertThat(stringList.get(3)).isEqualTo("test");
        assertThat(stringList.lastIndexOf("test")).isEqualTo(3);
        assertThat(stringList.indexOf("test")).isEqualTo(0);
    }

    private void add(String[] elements) {
        assertThat(stringList.isEmpty()).isTrue();
        Stream.of(elements).forEach(stringList::add);
        assertThat(stringList.size()).isEqualTo(elements.length);
    }


}
