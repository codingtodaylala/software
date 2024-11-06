package programs;
// Write a program to simulate Memory placement strategies –first fit and worstfit.
import java.util.Arrays;
import java.util.Scanner;
class GFG  
{ 
 // Method to allocate memory to  
 // blocks as per First fit algorithm 
 static void firstFit(int blockSize[], int m,  
                      int processSize[], int n) 
 { 
     // Stores block id of the  
     // block allocated to a process 
     int allocation[] = new int[n]; 
   
     // Initially no block is assigned to any process 
     for (int i = 0; i < allocation.length; i++) 
         allocation[i] = -1; 
   
     // pick each process and find suitable blocks 
     // according to its size ad assign to it 
     for (int i = 0; i < n; i++) 
     { 
         for (int j = 0; j < m; j++) 
         { 
             if (blockSize[j] >= processSize[i]) 
             { 
                 // allocate block j to p[i] process 
                 allocation[i] = j; 
   
                 // Reduce available memory in this block. 
                 blockSize[j] -= processSize[i]; 
   
                 break; 
             } 
         } 
     } 
   
     System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
     for (int i = 0; i < n; i++) 
     { 
         System.out.print(" " + (i+1) + "\t\t" +  
                          processSize[i] + "\t\t"); 
         if (allocation[i] != -1) 
             System.out.print(allocation[i] + 1); 
         else
             System.out.print("Not Allocated"); 
         System.out.println(); 
     } 
 } 

//Method to allocate memory to blocks as per worst fit 
  // algorithm 
  static void worstFit(int blockSize[], int m, int processSize[],  
                                                   int n) 
  { 
      // Stores block id of the block allocated to a 
      // process 
      int allocation[] = new int[n]; 
     
      // Initially no block is assigned to any process 
      for (int i = 0; i < allocation.length; i++) 
          allocation[i] = -1; 
     
      // pick each process and find suitable blocks 
      // according to its size ad assign to it 
      for (int i=0; i<n; i++) 
      { 
          // Find the best fit block for current process 
          int wstIdx = -1; 
          for (int j=0; j<m; j++) 
          { 
              if (blockSize[j] >= processSize[i]) 
              { 
                  if (wstIdx == -1) 
                      wstIdx = j; 
                  else if (blockSize[wstIdx] < blockSize[j]) 
                      wstIdx = j; 
              } 
          } 
     
          // If we could find a block for current process 
          if (wstIdx != -1) 
          { 
              // allocate block j to p[i] process 
              allocation[i] = wstIdx; 
     
              // Reduce available memory in this block. 
              blockSize[wstIdx] -= processSize[i]; 
          } 
      } 
     
      System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
      for (int i = 0; i < n; i++) 
      { 
          System.out.print("   " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
          if (allocation[i] != -1) 
              System.out.print(allocation[i] + 1); 
          else
              System.out.print("Not Allocated"); 
          System.out.println(); 
      } 
  } 
 // Driver Code 
 public static void main(String[] args) 
 {  
     int blockSize[] = {100, 500, 200, 300, 600}; 
     int processSize[] = {212, 417, 112, 426}; 
     int m = blockSize.length; 
     int n = processSize.length; 
     Scanner s= new Scanner(System.in);
     while(true) {
    	 System.out.println("Select the type of scheduler to be used:");
 		System.out.println("1. First Fit");
 		System.out.println("2. Worst Fit");
 		System.out.println("3. Exit");
 		System.out.println("Enter your choice:");
 		int choice = s.nextInt();
 		
 		switch(choice){
 		case 1:
 			firstFit(blockSize, m, processSize, n);
 			break;
 		case 2:
 			worstFit(blockSize, m, processSize, n);
 			break;
 		case 3:
 			s.close();
 			System.exit(1);
 			break;
 		default:
 			System.out.println("Incorrect Choice");
 			break;
 		}
     }
 } 
} 