public class BinaryTree {
    Node root;
    boolean n1Present;
    boolean n2Present;

    public Node findLca(int number1, int number2) {
        n1Present = false;
        n2Present = false;
        Node result = findLca(number1, number2, root);
        if(!n1Present || !n2Present) return null;
        else return result;
    }

    private Node findLca(int number1, int number2, Node node) {
        if(node == null) {
            return null;
        }

        Node tmp = null;

        if(node.data == number1 || node.data == number2) {
            if(node.data == number1) n1Present = true;
            if(node.data == number2) n2Present = true;
            tmp = node;
        }

        Node leftNode = findLca(number1, number2, node.left);
        Node rightNode = findLca(number1, number2, node.right);

        if(tmp != null) return tmp;

        if(leftNode != null && rightNode != null){
            return node;
        }
        return (leftNode != null)? leftNode : rightNode;

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.left = new Node(7);
        System.out.println(tree.findLca(4, 5).data);
        if(tree.findLca(4,10) == null) System.out.println("not present");
    }
}
