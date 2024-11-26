import java.util.List;

class Box<T extends Number> {
    private T content;

    public Box() {
        this.content = null;
    }

    public Box(T content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public T getContent() {
        return content;
    }

    public void put(T item) {
        if (!isEmpty()) {
            throw new IllegalStateException("В коробке уже есть объект.");
        }
        this.content = item;
    }

    public T get() {
        if (isEmpty()) {
            return null;
        }
        T temp = this.content;
        this.content = null; //обнуляем ссылку
        return temp;
    }
    public String toString() {
        return ("Содержимое коробки: " + content);
    }
}