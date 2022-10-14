package HuffManEncoding;

import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;

public class HuffManEncoding {
    HashMap<Character , String> encoder ;
    HashMap<String ,Character> decoder ;

    HuffManEncoding(String feeder){
        HashMap<Character , Integer> fmap = new HashMap<>();
        //1.Making the frequency map
        for(int i = 0 ; i<feeder.length();i++){
            char cc = feeder.charAt(i);
            if(fmap.containsKey(cc)){
                int count = fmap.get(cc);
                count=count+1;
                fmap.put(cc,count);

            }else {
                fmap.put(cc,1);
            }
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Map.Entry<Character,Integer>> entrySet = fmap.entrySet();
        for (Map.Entry<Character, Integer> entry :
                entrySet) {
            Node newNode = new Node(entry.getKey(),entry.getValue());
            minHeap.add(newNode);
        }
        while (minHeap.size()!=1){
            Node leftNode = minHeap.remove();
            Node rightNode = minHeap.remove();

            Node combineNode  = new Node(leftNode,rightNode);
            minHeap.add(combineNode);
        }
        Node fullTree = minHeap.remove();
        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();
        this.intiEncoderDecoder(fullTree,"");
    }
    private void intiEncoderDecoder(Node fullTree , String osf ){
        if(fullTree==null){
            return;
        }
        if(fullTree.left==null&&fullTree.right==null){
            this.encoder.put(fullTree.data,osf);
            this.decoder.put(osf,fullTree.data);
        }
        this.intiEncoderDecoder(fullTree.left,osf+"0");
        this.intiEncoderDecoder(fullTree.right,osf+"1");

    }
    public String encodeData(String data){
        String res ="";
        for(int i =0 ; i < data.length() ; i++){
            char cc  = data.charAt(i);
            String code = this.encoder.get(cc);
            res=res+code;
        }
        return res;
    }
    public String decodeData(String codedString){
        String decoded ="";
        String key = "";
        for(int i =0 ; i < codedString.length() ; i++){
            key = key+codedString.charAt(i);
            if(this.decoder.containsKey(key)){
                decoded=decoded+this.decoder.get(key);
                key="";
            }
        }
        return decoded;
    }
    private class Node implements Comparable<Node>{
        char data ;
        int cost;
        Node left;
        Node right;
        Node(char data , int cost){
            this.data = data;
            this.cost=cost;
            this.left = null;
            this.right=null;

        }
        Node(Node left , Node right){
            this.data='\0';
            this.cost = left.cost+right.cost;
            this.left=left;
            this.right=right;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}
