package HuffManEncoding;

import java.util.BitSet;
import java.util.PriorityQueue;

public class UsingHuffMan {
    public static void main(String[] args) {
        String input = "abbccda";
        HuffManEncoding hf = new HuffManEncoding(input);
        String encoded  = hf.encodeData(input);
        System.out.println(encoded);
        String decoded  = hf.decodeData(encoded);
        System.out.println(decoded);
        BitSet bitSet  = new BitSet(encoded.length());
        int bitCounter  = 0;
        for (Character c :
                encoded.toCharArray()) {
            if(c.equals('1')){
                bitSet.set(bitCounter);
            }
            bitCounter++;
        }
        for (int i = 0; i < bitSet.length(); i++) {
            System.out.print(bitSet.get(i));
        };

    }
}
