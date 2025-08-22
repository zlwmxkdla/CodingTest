import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static Node root;
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 노드 만들기
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            char parent = arr[0].charAt(0);
            char left = arr[1].charAt(0);
            char right = arr[2].charAt(0);

            Node parentNode = map.getOrDefault(parent, new Node(parent));
            map.put(parent, parentNode);

            if (i == 0) root = parentNode; // 첫 번째 입력이 루트

            if (left != '.') {
                Node leftNode = new Node(left);
                parentNode.left = leftNode;
                map.put(left, leftNode);
            }

            if (right != '.') {
                Node rightNode = new Node(right);
                parentNode.right = rightNode;
                map.put(right, rightNode);
            }
        }

        preorder(root);
        sb.append('\n');
        inorder(root);
        sb.append('\n');
        postorder(root);
        System.out.println(sb);
    }

    static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }
}
