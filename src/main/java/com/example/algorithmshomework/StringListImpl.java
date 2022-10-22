package com.example.algorithmshomework;

public class StringListImpl implements StringList {
    private static final int DEFAULT_SIZE = 15;

    private final String[] data;
    private int capacity;

    public StringListImpl() {
        this(DEFAULT_SIZE);
    }

    public StringListImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер списка не должен быть меньше 0!");
        }
        data = new String[DEFAULT_SIZE];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        // 4 5 6 2 null null null capacity = 4
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {
        // 4 5 6 2 null null null capacity= 4, index = 2
        // 4 5 6 6 2 null null
        // 4 5 item 62 null null
        checkItem(item);
        checkIndex(index, true);
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Нет места!");
        }
        System.arraycopy(data, index, data, index + 1, capacity - index); // 1 шаг копируем значение на ячейку дальше

        capacity++; // увеличить
        return data[index] = item; //добавить элемент
    }

    @Override
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index, false);

        return data[index] = item;
    }

    @Override
    public String remove(String item) {
        // 4 5 6 2 null null null capacity= 4, index = 2
        // 4 5 6 6 2 null null
        // 4 5 item 62 null null

        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        // 4 5 6 2  null null null capacity= 4, index = 2
        // 4 6 2 2 null null null
        // 4 6 2  null null null null

        // 4 5 6 2 7 null null index = 4, capacity = 5

        checkIndex(index, false);
        String item = data[index];
        if (index + 1 < capacity) { // проверить если элемент последний то удалить без здвига
            System.arraycopy(data, index + 1, data, index, capacity - index - 1); // 1 шаг копируем значение на ячейку  в перед
        }
        data[--capacity] = null;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) !=-1;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < capacity; i++) {
            if (item.equals(data[i])) {

            return i;
        }
    }
    return-1;
}

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = capacity - 1; i >= 0; i--) {
            if (item.equals(data[i])) {

                return i;
            }
        }
        return-1;
    }

    @Override
    public String get(int index) {
        checkIndex(index, false);
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(size() != otherList.size()){
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!get(i).equals(otherList.get(i))) {

                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i]=null;
        }
           capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] copy = new String[capacity];
        System.arraycopy(data, 0, copy, 0, capacity);
        return copy;
    }

    private void checkItem(String item) {
        if (item==null){
            throw new IllegalArgumentException("Список не может содержать null");
        }
    }

    private void checkIndex(int index, boolean include){
        // if (index < 0 || (include ? index >= capacity : index > capacity))
        boolean condition;
        if(include){
            condition = index > capacity;
        }else {
            condition = index >= capacity;
        }
        if (index <0 || condition){
            throw new IllegalArgumentException("Index должен быть в диапозоне от 0 до размера списка");
        }


    }
}