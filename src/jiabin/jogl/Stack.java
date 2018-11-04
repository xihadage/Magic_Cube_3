package jiabin.jogl;

/**
 * @author Administrator
 * @version 1.0
 * @className Stack
 * @description TODO
 * @date 2018/11/2 10:53
 **/
public class Stack {
    private int maxSize;// 栈的大小
    private int top;
    private String[] arr;

    public Stack(int size) {
        maxSize = size;
        top = -1;
        arr = new String[maxSize];
    }

    public void push(String value) { // 压入数据

        arr[++top] = value;
    }

    public String pop() { // 弹出数据

        return arr[top--];
    }

    public String peek() { // 访问栈顶元素

        return arr[top];
    }

    public boolean isFull() { // 栈是否满了

        return maxSize - 1 == top;
    }

    public boolean isEmpty() { // 栈是否为空

        return top == -1;
    }
}
