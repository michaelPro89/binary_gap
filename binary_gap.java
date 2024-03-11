/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codilitytest.binarygap;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Michal Switala
 */
public class CodilityTestBinaryGap {

    
// source : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
/*
    
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary 
representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001
and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary 
gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of 
length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
    
*/
 
    
    CodilityTestBinaryGap(){
        
        int longestGap;
        int N = 5435345;
        longestGap = solution(N);
        
        System.out.println("Longest gap for " + N +" is "+ longestGap);
        
        
        
    }
    
  
    int solution(int N) {

        ArrayList<Integer> lenghtOfGaps = new ArrayList();
        String binaryValue = "";
        int longestGap = 0;// must return the longest length of the gap
        // or return 0 if N doesnt contain binary gap.

        String binString = Integer.toBinaryString(N); // Returns binary representation of the given String ex. 1001
        System.out.println(binaryValue);
        
        // if there is no 0 means no gaps at all so break
        for (int x = 0; x < binString.length(); x++) {

            if (!binString.contains("0")) {

                System.out.println(" THIS NUMBER DOESNT CONTAIN GAPS YUPI");
                break;
            }
        }


        for (int x = 0; x < binString.length(); x++) {
            
            System.out.println(" checking "+N+" binary representation equal to =   "+binString);

            char one = binString.toLowerCase().charAt(x);
           

            if (one == '1') { //start cointing 0
                
                System.out.println(" 1 occured at index " + x);
                
                int amountOfZeros = 0;
                
               

                for (int b = x + 1; b < binString.length(); b++) { // 1000001011
                    
                    System.out.println(" int b: " + b);

                    System.out.println("checking ZEROS");
                    
                    if ( binString.charAt(b) == '0') {
                        
                        System.out.println(" 0 occured at index " + b + " counting zeros now");
                        amountOfZeros++;

                        System.out.println("current amount of zeros counted : "+amountOfZeros);

                    }else if(binString.charAt(b) == '1')
                    {
                        lenghtOfGaps.add(amountOfZeros);
                        System.out.println(" Encountered end of gap. Breaking, adding zeros.");
                        break;

                    }                            
                    else{ 
                                                       

                        lenghtOfGaps.add(amountOfZeros);
                        System.out.println(" breaking out of for loop because there is no more ZEROS");
                        break;
                    }

                }

            }

        }

        
        //test check array list 
        for(int x=0;x < lenghtOfGaps.size(); x++){
            
            
            System.out.println("Array index at  "+x+" has gaps lenfth :"+lenghtOfGaps.get(x));
            
            
        }
        
        
        
        // calculate longest gap of all gaps here ... and thats it! reutrn INT here
        if (lenghtOfGaps.size() >= 1) {

            // get maximum gap length from our array list here
            Object obj = Collections.max(lenghtOfGaps);

            int i = (Integer) obj;

            return i;

        } else {
            // return 0 if there are no gaps at all.
            return 0;
        }


    }

    
    
    public static void main(String[] args) {
       
        
        CodilityTestBinaryGap test = new CodilityTestBinaryGap();
    }
    
}

        
