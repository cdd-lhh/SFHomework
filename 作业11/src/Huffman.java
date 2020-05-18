import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Huffman{
    static class BTreeNode implements Comparable<BTreeNode>{
        int data;
        BTreeNode lChild = null;
        BTreeNode rChild = null;

        public BTreeNode(int data,BTreeNode lChild,BTreeNode rChild){
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }
        public int getData(){
            return data;
        }

        public BTreeNode getlChild(){
            return lChild;
        }

        public BTreeNode getrChild(){
            return rChild;
        }

        @Override
        public int compareTo(BTreeNode o) {
            if(this.getData() < o.getData()) return -1;
            if(this.getData() > o.getData()) return 1;
            return 0;
        }

        public static void main(String[] args) {
            int[] C = new int[]{5,5,10,10,10,15,20,25};
            BTreeNode huffman = createHuffman(C,C.length);
            String huffmanCode = "";
            printHuffmanCode(huffman,huffmanCode);
        }

        public static BTreeNode createHuffman(int C[],int n){
            Queue<BTreeNode> queue = new PriorityQueue<>();
            for(int i = 0;i < n;i++){
                BTreeNode node = new BTreeNode(C[i],null,null);
                queue.add(node);
            }
            BTreeNode node1 = null;//最小权值结点
            BTreeNode node2 = null;//次最小权值结点
            BTreeNode node3 = null;//最小权值结点和次最小权值结点合并后的结点

            for(int j = 0;j < n-1;j++){
                node1 = queue.poll();
                node2 = queue.poll();
                node3 = new BTreeNode(node1.getData()+node2.getData(),node1,node2);
                queue.add(node3);
            }
            return queue.poll();
        }

        public static void printHuffmanCode(BTreeNode huffman,String huffmanCode){
            if(huffman.getlChild() == null && huffman.getrChild() == null){
                System.out.println("权值为" + huffman.getData() + "结点的编码为："+ huffmanCode);
            }if (huffman.getlChild() != null) {
                printHuffmanCode(huffman.getlChild(), huffmanCode+"0");
            }
            if (huffman.getrChild() != null) {
                printHuffmanCode(huffman.getrChild(), huffmanCode+"1");
            }
        }
    }
}
