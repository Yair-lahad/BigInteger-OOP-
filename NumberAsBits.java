import java.math.BigInteger;

/*
I, Yair lahad (205493018), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
public class NumberAsBits {

    private Bit[] bits;

    public NumberAsBits(Bit[] bits) {
        if(bits == null)
            throw new IllegalArgumentException("Array entered is null");
        this.bits= new Bit[bits.length]; //we need to put values somewhere, if not we would call null pointer.
        for(int i=0;i<bits.length;i++){
            if(bits[i]==null)
                throw new IllegalArgumentException("value in array is null");
            this.bits[i]=bits[i];
        }
    }

    public String toString() { 
        String ans ="";
        BigInteger two= new BigInteger("2"); // value to multiply i times
        BigInteger pow=new BigInteger("1"); // represent each value of 2^i (changing each iteration)
        BigInteger value=new BigInteger("0"); //in order to represent the decimal value- we sum 2^i * binary value and we sum it "array length" times
        for(int i=0; i<this.bits.length;i++){
          for(int j=i+1;j<this.bits.length;j++)
              pow=pow.multiply(two);
          BigInteger binary=new BigInteger(this.bits[i].toString()); // gives you the value inside bits[i] either 0 or 1
          value=value.add(pow.multiply(binary));
          pow=BigInteger.ONE; // nuetral number for multification
        }
        ans=ans+value.toString(); //changing the value to string type
        return ans;
    }

    public String base2() {
        String ans ="";
        for(int i=0; i<bits.length;i++){
            ans=ans+bits[i].toString();
        }
        return ans;
    }
}


