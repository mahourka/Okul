class TreeNode {
    public int value;
    public TreeNode leftchild;
    public TreeNode rightchild;

    public TreeNode(int value) {
        this.value = value;
        this.leftchild = null;
        this.rightchild = null;
    }
}


public class first {
    // Kök düğümünü kendinden önceki düğümle değiştiren metot
    public TreeNode Replace_Root_With_Its_Predecessor(TreeNode root) {
        // Kök düğüm null veya sol çocuğu yoksa, kök düğüm olduğu gibi döndürülür
        if (root == null || root.leftchild == null) {
            return root;
        }

        // Parent ve current düğümlerini takip etmek için değişkenler
        TreeNode parent = null;
        TreeNode current = root.leftchild;

        // Sol alt ağaçtaki en sağdaki düğümü bul
        while (current.rightchild != null) {
            parent = current;
            current = current.rightchild;
        }

        // Bağlantıları yeniden düzenleyerek kök düğümünü predecessor ile değiştir
        if (parent != null) {
            // Eğer predecessor'ın parent'ı varsa, parent'ın sağ çocuğunu predecessor'ın sol çocuğuna ayarla
            parent.rightchild = current.leftchild;
        } else {
            // Eğer predecessor'ın parent'ı yoksa, kök düğümün sol çocuğunu predecessor'ın sol çocuğuna ayarla
            root.leftchild = current.leftchild;
        }

        // Predecessor'ın sol ve sağ çocuklarını, orijinal kök düğümün çocuklarına ayarla
        current.leftchild = root.leftchild;
        current.rightchild = root.rightchild;

        // Predecessor'ı yeni kök düğüm olarak döndür
        return current;
    }

    // Test metodu
    public static void main(String[] args) {
        // Örnek bir ağaç oluştur
        TreeNode root = new TreeNode(39);
        root.leftchild = new TreeNode(30);
        root.rightchild = new TreeNode(72);
        root.rightchild.rightchild = new TreeNode(84);
        root.rightchild.leftchild = new TreeNode(61);
        root.rightchild.rightchild.leftchild = new TreeNode(79);

        first bst = new first();
        System.out.println("Original Root: " + root.value +" "+ root.rightchild );
        root = bst.Replace_Root_With_Its_Predecessor(root);
        System.out.println("New Root: " + root.value +" "+ root.leftchild);
    }
}
