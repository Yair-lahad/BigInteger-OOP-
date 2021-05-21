/*
I, <yair lahad> (205493018), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
public class Bit {

    private boolean value;

    public Bit(boolean value){
        this.value=value; // false= 0 and true =1
    }

    public int toInt(){ 
        int ans = 0;
        if(value) ans=1;
        return ans;

    }

    public String toString(){
        String ans = "";
        if(!value) ans="0";
        else ans="1";
        return ans;
    }
}

