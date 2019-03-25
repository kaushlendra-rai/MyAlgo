package com.kausha.algo.ds;

class KthLargestElementInBST_old{
    static class Tree{
           int data;
           Tree left = null;
           Tree right = null;

           public Tree(int data){
                 this.data = data;
           }

           //Utility function to create minimal bst
           public static Tree createBST(int []a, int left, int right){
                  if(right < left)
                        return null;
  
                  int mid = (left + right)/2;
                  Tree root = new Tree(a[mid]);
                  root.left = createBST(a, left, mid - 1);
                  root.right = createBST(a, mid + 1, right);
 
                  return root;
           }

           //method to get the kth largest value in BST
           static int index = 0; //Counter variable
           public static void getElement(Tree root, int k){
                    //Base condition
                    if(root == null)
                          return;

                    getElement(root.right, k);   //first traverse the right sub tree
                    if(++index == k){
                            System.out.println(root.data);
                            return;
                    }  
                    getElement(root.left, k);    //then traverse the left sub tree
            }
     }

     public static void main(String... args){
           int []a = {1,2,3,4,5,6,7};
           Tree root = Tree.createBST(a, 0, a.length - 1);
           Tree.getElement(root, 2);
      }
}
