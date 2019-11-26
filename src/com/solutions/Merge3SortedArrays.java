package com.solutions;

import java.util.PriorityQueue;

public class Merge3SortedArrays {
    private class QueueNode implements Comparable<QueueNode> {
        int array, index, value;

        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        public int compareTo(QueueNode n) {
            if(value > n.value) return 1;
            if(value < n.value) return -1;
            return 0;
        }
    }

    public int[] merge(int[][] arrays) {
        int size = 0;
        PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
        for(int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
            if(arrays[i].length > 0) {
                pq.add(new QueueNode(i,0,arrays[i][0]));
            }
        }
        int[] result = new int[size];
        for(int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            result[i] = n.value;
            int  newIndex = n.index + 1;
            if(newIndex < arrays[n.array].length) {
                pq.add(new QueueNode(n.array,newIndex, arrays[n.array][newIndex]));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{
                { 1,3,5},
                { 2,4},
        };
        Merge3SortedArrays obj = new Merge3SortedArrays();

        int[] res = obj.merge(input);
        for(int i = 0; i< res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
