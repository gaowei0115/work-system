package com.mmc.work.algorithm.heap;

/**
 * @packageName：com.mmc.work.algorithm.heap
 * @desrciption: 数组实现堆结构数据类型
 * @author: GW
 * @date： 2019-02-21 11:30
 * @history: (version) author date desc
 */
public class HeapData<T extends Comparable<? super T>> {

    /**
     * 数组保存堆数据
     */
    private T[] heapArrays;

    /**
     * 保存数据长度
     */
    private int size;

    /**
     * 默认堆结构数组长度
     */
    private static final int DEFAULT_LEN = 10;

    /**
     * Construct
     */
    public HeapData() {
        this(DEFAULT_LEN);
    }

    /**
     * Construct
     *
     * @param len
     */
    public HeapData(int len) {
        heapArrays = (T[]) new Comparable[len];
        size = 0;
    }

    /**
     * 确保heap数组是否溢出
     *
     * @param length
     */
    public void ensureCapacity(int length) {
        if (length > heapArrays.length) {

        }
    }

    /**
     * 重置heap数组
     *
     * @param capacity
     */
    public void grow(int capacity) {

    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(T element) {
        ensureCapacity(size);
        heapArrays[size] = element;
        size++;
        upHeap(size - 1);
    }


    /**
     * 上浮
     *
     * @param length
     */
    private void upHeap(int length) {
        int index = length;
        T temp = heapArrays[index];
        int parent = (index - 1) / 2;
        while (index > 0 && temp.compareTo(heapArrays[parent]) > 0) {
            heapArrays[index] = heapArrays[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArrays[index] = temp;
    }

    /**
     * 删除元素
     *
     * @return
     */
    public T delete() {
        if (heapArrays.length == 0) {
            return null;
        }
        T temp = heapArrays[0];
        heapArrays[0] = heapArrays[--size];
        downHeap(0);
        return temp;
    }

    /**
     * 下沉
     *
     * @param index
     */
    private void downHeap(int index) {
        T temp = heapArrays[index];
        int largerIndex = 0;
        while (index <= ((size-1) / 2)) {
            int leftIndex = index * 2 + 1;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && heapArrays[leftIndex].compareTo(heapArrays[rightIndex]) < 0) {
                largerIndex = rightIndex;
            } else {
                largerIndex = leftIndex;
            }
            if (temp.compareTo(heapArrays[largerIndex]) >= 0) {
                break;
            }
            heapArrays[index] = heapArrays[largerIndex];
            index = largerIndex;
        }
        heapArrays[index] = temp;
    }

    private void printHeap() {
        System.out.println("print heap data : [");
        for (int i = 0; i < size; i++) {
            T data = heapArrays[i];
            if (i < size - 1) {
                System.out.print(data.toString() + ", ");
            } else {
                System.out.print(data.toString());
            }
        }
        System.out.println("");
        System.out.println("]");
    }

    public static void main(String[] args) {
        HeapData<Integer> heapData = new HeapData<>(19);
        heapData.add(30);
        heapData.add(23);
        heapData.add(35);
        heapData.add(18);
        heapData.add(19);
        heapData.add(7);
        heapData.add(89);
        heapData.add(59);
        heapData.add(67);
        heapData.add(100);
        heapData.add(99);

        heapData.printHeap();

        /**
         * 删除元素
         */
        heapData.delete();
        heapData.printHeap();
    }

}
