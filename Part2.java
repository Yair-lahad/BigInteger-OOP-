/*
I, Yair lahad (205493018), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/
class Part2 {
    public static boolean change(int[] coins, int n, int i) {
        boolean ans = false;
        if (n == 0)
            ans = true;
        else if (n < 0 | i >= coins.length)
            ans = false; // not a solution
        else {
            ans = change(coins, n, i + 1) || change(coins, n - coins[i], i);
        }
        return ans;
    }

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse, int i) {
        boolean ans = false;
        if (n == 0 & numOfCoinsToUse == 0)
            ans = true;
        else if (n < 0 | i >= coins.length | numOfCoinsToUse < 0)
            ans = false; // not a solution
        else {
            ans = changeLimited(coins, n - coins[i], numOfCoinsToUse - 1, i + 1)
                    || changeLimited(coins, n, numOfCoinsToUse, i + 1);
        }
        return ans;
    }

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse, String acc, int i) {
        if (n == 0 & numOfCoinsToUse == 0) {
            System.out.println(acc.substring(1));

        } else if (n < 0 | i >= coins.length | numOfCoinsToUse < 0) {
            //stop
        } else {
            printChangeLimited(coins, n - coins[i], numOfCoinsToUse - 1, acc +","+ coins[i]  , i + 1);
            printChangeLimited(coins, n, numOfCoinsToUse, acc, i + 1);
        }
    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse, int i) {
        int count=0;
        if(n==0 & numOfCoinsToUse==0){
            count=1;
        }
        else if(n<0 | i>=coins.length){
            count=0; // not a solution
        }
        else{
            // count the option that use the coin in place i and stay on this spot, and count the option that skip the coin in place i
            count=countChangeLimited(coins,n-coins[i],numOfCoinsToUse-1,i)+countChangeLimited(coins,n,numOfCoinsToUse,i+1);
        }
        return count;
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse,String acc, int i){
        if (n == 0 & numOfCoinsToUse == 0) {
            System.out.println(acc.substring(1));

        } else if (n < 0 | i >= coins.length | numOfCoinsToUse < 0) {
            //stop
        } else {
            // print the option that use the coin in place i and stay on this spot, and print the option that skip the coin in place i
            printAllChangeLimited(coins, n - coins[i], numOfCoinsToUse - 1, acc +","+ coins[i]  , i );
            printAllChangeLimited(coins, n, numOfCoinsToUse, acc, i + 1);
        }
    }
    public static int changeInCuba(int cuc,int [] coins, int i){
        int ans = 0;
        if(cuc==0) ans=1;
        else if(cuc<0 | i>=coins.length) ans=0;
        else
            ans=changeInCuba(cuc-coins[i],coins,i)+changeInCuba(cuc,coins,i+1);
        return ans;
    }



    //////////////////////// added functions for solutions

    public static boolean change(int [] coins, int n){
        boolean ans = false;
        ans=change(coins,n,0);
        return ans;
    }

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        boolean ans = false;
        ans=changeLimited(coins,n,numOfCoinsToUse,0);
        return ans;
    }

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        if(changeLimited(coins,n,numOfCoinsToUse)){
            printChangeLimited(coins,n,numOfCoinsToUse,"",0);
        }

    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        int ans = 0;
        ans=countChangeLimited(coins,n,numOfCoinsToUse,0);
        return ans;
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        printAllChangeLimited(coins,n,numOfCoinsToUse,"",0);
    }

    public static int changeInCuba(int cuc){
        int ans = 0;
        int[] coins={1,3,3,5,9,10,15,20,30,50,60,100,150,300}; // combine the cuc and cup into one cuc value Array
        ans=changeInCuba(3*cuc,coins,0); //call the recursive function as  the smallest value (cup value)
        return ans;
    }

    public static void main(String[] args){
        //tests for part 2.1
         int []changee1 = {1,5,10};
         int n = 7;
         System.out.println("change test 1:expected true, got " + change(changee1,n));
         int []cchange2 = {2,10,20,100};
         n = 15;
         System.out.println("change test 2: expected false, got " + change(cchange2,n)+"\n");

        // tests for part 2.2
         int []changeLimited1 = {1,12,17,19};
         n = 20;
         int numOfCoinsToUse = 2;
         System.out.println("ChangeLimited test 1: expected true, got " + changeLimited(changeLimited1,n ,numOfCoinsToUse));
         int []changeLimited2 = {5,7,12};
         n = 8;
         numOfCoinsToUse = 2;
         System.out.println("ChangeLimited test 2: expected false, got " + changeLimited(changeLimited2,n ,numOfCoinsToUse));
         int []changeLimited3 = {1,7,12,10};
         n = 10;
         numOfCoinsToUse = 5;
         System.out.println("ChangeLimited test 3: expected false, got " + changeLimited(changeLimited3,n ,numOfCoinsToUse)+"\n");

        // tests for part 2.3
         int []printChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("PrintChangeLimited test 1: expected 2,2 or 1,3 , got ");
         printChangeLimited(printChangeLimited1,n ,numOfCoinsToUse);
         int []printChangeLimited2 = {1,7,12};
         n = 10;
         numOfCoinsToUse = 5;
         System.out.println("PrintChangeLimited test 2: expected printing nothing, got ");
         printChangeLimited(printChangeLimited2,n ,numOfCoinsToUse);
         System.out.println("");

        //tests for part 2.4
         int []countChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("CountChangeLimited test 1: expected 2, got " + countChangeLimited(countChangeLimited1,n ,numOfCoinsToUse));
         int []countChangeLimited2 = {5,10,20,50,100};
         n = 100;
         numOfCoinsToUse = 5;
         System.out.println("CountChangeLimited test 2: expected 3, got " + countChangeLimited(countChangeLimited2,n ,numOfCoinsToUse));
         int []countChangeLimited3 ={5,10,50};
         n = 65;
         numOfCoinsToUse = 2;
         System.out.println("CountChangeLimited test 3: expected 0, got " + countChangeLimited(countChangeLimited3,n ,numOfCoinsToUse)+"\n");

        //tests for part 2.5
         int []printAllChangeLimited1 = {1,2,3};
         n = 4;
         numOfCoinsToUse = 2;
         System.out.println("PrintAllChangeLimited test 1: expected : \n 2,2 \n 1,3 \n or \n 1,3 \n 2,2 , got " );
         printAllChangeLimited(printAllChangeLimited1,n ,numOfCoinsToUse);
         int []printAllChangeLimited2 = {1,5,10,20};
         n = 13;
         numOfCoinsToUse = 2;
         System.out.println("PrintAllChangeLimited  test 2: expected printing nothing, got ");
         printAllChangeLimited(printAllChangeLimited2,n ,numOfCoinsToUse);
         System.out.println("");

        //tests for part 2.6
         System.out.println("ChangeInCuba 1");
         System.out.println(changeInCuba(1));
         System.out.println("ChangeInCuba 2");
         System.out.println(changeInCuba(2));
         System.out.println("ChangeInCuba 20");
         System.out.println(changeInCuba(20));
         System.out.println("ChangeInCuba 50");
         System.out.println(changeInCuba(50));
    }
}
