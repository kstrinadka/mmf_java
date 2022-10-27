/**
 * класс стек с поддержкой операций
 * push (добавить элемент),
 * pushStack(добавить элементы контейнера стек) pop(взять элемент),
 * popStack(взять заданное количество элементов в виде объекта стек), и count(узнать количество элементов)
 */
public class MyOwnStack<E> {

    // кол-во элементов в стеке
    private int count = 0;

    // сами элементы стека
    private Object[] values;

    // размер стека
    private int size = 1000;


    public MyOwnStack() {
        this.values = new Object[size];
    }


    /**
     * @return - пустой стек или нет
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else
            return false;
    }


    /**
     * Проверяет есть ли место в стеке и добавляет новый элемент
     */
    public void push(E element) {
        if (count < size) {
            values[count] = element;
            count++;
        }
        else {
            this.increaseStackSize();
            throw new ArrayIndexOutOfBoundsException("stack overflow");
        }
    }


    /**
     * Увеличивает емкость стека, если заканчивается место
     */
    private void increaseStackSize() {
        int newSize = this.size*2;
        Object[] newValues = (E[]) new Object[newSize];

        for (int i=0; i<this.size; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
        this.size = newSize;
    }


    /**
     * Метод добавляет в конец текущего стека все элементы из поступившего стека.
     * @param anotherStack - стек, который нужно добавить к текущему стеку.
     */
    public void pushStack(MyOwnStack anotherStack) {

        int anotherStackCount = anotherStack.count;
        E[] arr = (E[]) new Object[anotherStackCount];

        for (int i = (anotherStackCount - 1); i >= 0; i--) {
            arr[i] = (E) anotherStack.pop();
        }

        for (var element: arr) {
            this.push(element);
        }
    }


    /**
     * Проверяет есть ли элементы в стеке и извлекает
     */
    public E pop() {
        if (count > 0) {
            E value = (E) values[count-1];
            count--;
            return value;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        }
    }


    /**
     * @param sizeOfNewStack - кол-во элементов, которое нужно извлечь.
     * @return - новый стек из извлеченных со старого стека элементов.
     */
    public MyOwnStack popStack (int sizeOfNewStack) {
        MyOwnStack newStack = new MyOwnStack();
        E[] arr = (E[]) new Object[sizeOfNewStack];

        for (int i = (sizeOfNewStack - 1); i >= 0; i--) {
            arr[i] = (E) this.pop();
        }

        for (var element: arr) {
            newStack.push(element);
        }

        return newStack;
    }


    /**
     * @return - кол-во элементов в стеке на данный момент.
     */
    public int count() {
        return this.count;
    }
}
