package com.DataStructurePrograms;


public class PrimeAndAnagrams0to1000<arr> {
    public boolean isPrime(int num){
        for (int i=2; i<num; i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PrimeAndAnagrams0to1000 Prm = new PrimeAndAnagrams0to1000();
        int num = 1;
        int arr[][] = new int[10][100];
        for (int i=0; i<10; i++){
            for (int j=0; j<100; j++){
                if (Prm.isPrime(num)){
                    arr[i][j] = num;
                }else {
                    arr[i][j] = -1;
                }
                num++;
            }
        }

        int p=0;
        for (int[] k1 : arr){
            if(p<10){
                if (p==0)
                    System.out.print("0 to 100 \t: \t");
                else if (p == 1)
                    System.out.print("100 to 200 \t: \t");
                else if (p == 2)
                    System.out.print("200 to 300 \t: \t");
                else if (p == 3)
                    System.out.print("300 to 400 \t: \t");
                else if (p == 4)
                    System.out.print("400 to 500 \t: \t");
                else if (p == 5)
                    System.out.print("500 to 600 \t: \t");
                else if (p == 6)
                    System.out.print("600 to 700 \t: \t");
                else if (p == 7)
                    System.out.print("700 to 800 \t: \t");
                else if (p == 8)
                    System.out.print("800 to 900 \t: \t");
                else if (p == 9)
                    System.out.print("900 to 1000 \t: \t");
                else
                    System.out.print("Can't Print More Rows");
            }
            p++;
            for (int k2 : k1){
                if (k2 != -1 && k2 != 1){
                    String str = ""+num;
                    char[] arr1 = str.toCharArray();
                    int flag=0;
                    for (int i=0; i<=arr1.length-1; i++ ){
                        if (arr1[i] != arr1[arr1.length-i-1]){
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1);
                        //System.out.println(k2+"Not Palindrome and Anagram");
                    else
                        System.out.println(k2+"Palindrome and Anagram"); ;
                }


            }
            System.out.println("\n");

        }


    }
}


