public class MutableArrayList<E> {
    private int size = 0;
    private E[] elementDate;

    private static final int initialLength = 1;//初始长度

    public MutableArrayList() {                //构造方法，若没有长度指示，默认开辟10个内存
        elementDate = (E[]) new Object[initialLength];
    }

    public MutableArrayList(int incomingLength) {//根据输入的数组长度取值
        incomingLength = (incomingLength < initialLength) ? initialLength : incomingLength;
        elementDate = (E[]) new Object[incomingLength];
    }

    //添加一个元素给动态容器中。提示：如果容器满了就扩容
    void add(E element) {
        if (checkType(element)) {
            size += 1;
            capacity();
            for (int i = 0; i < elementDate.length; i++) {
                if (elementDate[i] == null) {
                    elementDate[i] = element;
                    break;
                }
            }
        }
    }

    //给对应位置添加元素
    void add(int index, E element) {
        if(checkType(element)) {
            capacity();
            if (checkIndex(index)) {
                elementDate[index] = element;
            }
        }
    }

    public Boolean checkType(E element) {
        if(size==0){
            return true;
        }
        String type = element.getClass().getSimpleName();
        if (elementDate[0].getClass().getSimpleName().equals(type)) {
            return true;
        }
        throw new IndexOutOfBoundsException("数据类型错误");
    }

    private void capacity() {
        while (true) {
            int oldLength = elementDate.length;         //获取原数组的长度
            if (oldLength >= size) {                    //若原数组长度大于元素个数，直接返回
                return;
            }
            int newLength = oldLength * 2;
            E[] newElementDate = (E[]) new Object[newLength];
            for (int i = 0; i != size - 1; i++) {
                newElementDate[i] = elementDate[i];
            }
            elementDate = newElementDate;
            break;
        }
    }

    //得到某个索引下的元素，提示：首先判断一下该index是否符合要求
    Object get(int index) {
        if (index >= 0 && index < size) {
            return elementDate[index];
        }
        throw new IndexOutOfBoundsException("索引超出范围！");
    }

    //得到某个索引下的元素，提示：首先判断下index是否符合要求。删除就是数组最后一个向前挪。
    void remove(int index) {
        if (index >= 0 && index < size) {                   //判断索引是否在数组范围内
            for (int i = index + 1; i < size; i++) {        //删除元素，把后边儿的往前边儿移一个
                elementDate[i - 1] = elementDate[i];
            }
            elementDate[size - 1] = null;
            size -= 1;
        } else {
            throw new IndexOutOfBoundsException("索引超出范围！");
        }
    }

    //remove方法的重载，删除某个指定的元素。
    private void remove(E obj) {
        for (int i = 0; i < size; i++) {                    //遍历数组，寻找需要删除的元素
            if (elementDate[i] == obj) {
                for (int j = i + 1; j < size; j++) {        //删除元素
                    elementDate[j - 1] = elementDate[j];
                }
            } else {
                throw new IndexOutOfBoundsException("未查找到此元素！");
            }
        }
    }

    //返回数组中元素个数
    public int size() {
        return size;
    }

    //检查索引是否超出数组范围
    private boolean checkIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        }
        return false;
    }

    //输出数组
    void print() {
        int i = 0;
        do {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print("elementDate[" + i + "]" + "=" + elementDate[i] + "\t");
            i += 1;
        } while (i < size);
        System.out.println();
    }
}
