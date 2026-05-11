package AtCoder.F_RangeXorQuery;

import java.util.Scanner;

import javax.print.DocFlavor.SERVICE_FORMATTED;
import javax.swing.text.Segment;

public class RangeXorQuery {

    class Node {
        int start;
        int end;
        int val;
        Node left;
        Node right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        RangeXorQuery rq=new RangeXorQuery();
        Node root =rq.SegmentTree(arr, 1, n);

        for(int i=0;i<q;i++)
        {
            if(in.nextInt()==1)
            {
                int xi=in.nextInt();
                int y1=in.nextInt();
                rq.update(root,xi,y1);
            }
            else
            {
                int xi=in.nextInt();
                int yi=in.nextInt();
                System.out.println(rq.rangeAnswer(root,xi,yi));
            }
        }
    }

    Node SegmentTree(int arr[], int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.val = arr[start - 1];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = SegmentTree(arr, start, mid);
        node.right = SegmentTree(arr, mid + 1, end);

        node.val = (node.left.val ^ node.right.val);

        return node;

    }
    void update(Node node,int xi,int y1)
    {
        if(node.start==node.end)
        {
            node.val=node.val^y1;
            return;
        }
        int mid=(node.start +node.end)/2;
        if(xi<=mid)
        {
            update(node.left, xi, y1);
        }
        else
        {
            update(node.right, xi, y1);
        }
        node.val=node.left.val ^node.right.val;
    }
    int rangeAnswer(Node node, int xi,int yi)
    {
        if(node.end<xi || node.start>yi)
        {
            return 0;
        }
        if(node.start>=xi && node.end<=yi)
        {
            return node.val;
        }

        int left=rangeAnswer(node.left, xi, yi);
        int right=rangeAnswer(node.right, xi, yi);
        return left^ right;
    }

}
