/**
 * @author Jerry Ngo
 */

package hashTable;

import java.util.Arrays;
import java.util.Random;

import hashTable.ClosedHashTable.ProbeSequence;

public class Driver {
	public static void main(String[] args) {
		float[] thresholds = {0.33f, 0.50f, 0.75f};
		int collisionCnt = 0;
		int probeCnt = 0;
		long[][][][] firstQuestion = new long[2][3][2][2]; 
		Random rand = new Random();
		String question2 = "QUESTION 2\n\n";
		String question3 = "QUESTION 3\n\n";
		String question4 = "QUESTION 4\n\n";
		String question5 = "QUESTION 5\n\n";
		
		//Initialize the first question answer array
		for(int i = 0; i < 2; ++i) {
			for(int j = 0;j < 3; ++j) {
				for(int z = 0; z < 2; ++z) {
					for(int v = 0; v < 2; ++ v) {
						firstQuestion[i][j][z][v] = (long) 0.0;
					}
				}
			}
		}
		
		int temp = 0;
		for(int size = 8190; size < 8210; size++) {
			System.out.format("Size %d\n", size);
			//Construct question answer strings
			switch (size) {
				case 8192: question2 += String.format("Size %d\n", size); break;
				case 8191: case 8209: question3 += String.format("Size %d\n", size); break;
				case 8190: case 8200: case 8208: question4 += String.format("Size %d\n", size); break;
				case 8201: case 8203: case 8207: question5 += String.format("Size %d\n", size); break;
			}
			
			for(int thresholdIndex = 0; thresholdIndex < 3; thresholdIndex++) {
				//Construct question answer strings
				switch (size) {
					case 8192: question2 += String.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]); break;
					case 8191: case 8209: question3 += String.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]); break;
					case 8190: case 8200: case 8208: question4 += String.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]); break;
					case 8201: case 8203: case 8207: question5 += String.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]); break;
				}
				System.out.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]);
				for(int probe = 0; probe < 2; ++probe) {
					collisionCnt = 0;
					probeCnt = 0;
					boolean flag = true;
					for(int trial = 0; trial < 10; trial++) {
						ProbeSequence a = (probe == 0) ? ProbeSequence.LINEAR : ProbeSequence.QUADRATIC;
						ClosedHashTable hashTableLinear = new ClosedHashTable(size, thresholds[thresholdIndex], a);
						while(hashTableLinear.getFilledCnt() < size * thresholds[thresholdIndex]) {
							int returnCode = hashTableLinear.insert(rand.nextInt(10000) + 1);
							if(returnCode == -1) {
								flag = !flag;
								break;
							}
						}
						collisionCnt += hashTableLinear.getCollisionCnt();
						for(int i = 0; i < 1000; ++i) {
							hashTableLinear.find(rand.nextInt(10000) + 1);
						}
						probeCnt += hashTableLinear.getProbeCnt();
					}
					if(!flag) System.out.println("Failed configuration");
					else System.out.format("          %s: The average number of collisions is %.1f. \n                           The average number of probes is %.1f.\n", (probe == 0) ? "Linear probe   " : "Quadratic probe", collisionCnt / 10.0,  probeCnt / 10.0); 				
					firstQuestion[size % 2][thresholdIndex][probe][0] += collisionCnt / 10.0;
					firstQuestion[size % 2][thresholdIndex][probe][1] += probeCnt / 10.0;
					if(thresholdIndex + probe == 0) ++temp;
					
					//Construct question answer strings
					switch (size) {
						case 8192: question2 += String.format("          %s: Collisions: %.1f | Probes is %.1f.\n", (probe == 0) ? "Linear probe   " : "Quadratic probe", collisionCnt / 10.0,  probeCnt / 10.0); 				
						break;
						case 8191: case 8209: question3 += String.format("          %s: Collisions: %.1f | Probes is %.1f.\n", (probe == 0) ? "Linear probe   " : "Quadratic probe", collisionCnt / 10.0,  probeCnt / 10.0); 				
						break;
						case 8190: case 8200: case 8208: question4 += String.format("          %s: Collisions: %.1f | Probes is %.1f.\n", (probe == 0) ? "Linear probe   " : "Quadratic probe", collisionCnt / 10.0,  probeCnt / 10.0); 				
						break;
						case 8201: case 8203: case 8207: question5 += String.format("          %s: Collisions: %.1f | Probes is %.1f.\n", (probe == 0) ? "Linear probe   " : "Quadratic probe", collisionCnt / 10.0,  probeCnt / 10.0); 				
						break;
					}
				}
			}
			System.out.println();
		}
		
		//First Question 
		//Compute the average collisions and probes of every case in this question
		System.out.println("QUESTION 1 \n");
		for(int oe = 0; oe < 2; oe++) {
			System.out.format("%s\n", (oe == 0) ? "Even" : "Odd");
			for(int thresholdIndex = 0; thresholdIndex < 3; thresholdIndex++) {
				System.out.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]);
				for(int probe = 0; probe < 2; ++probe) {
					System.out.format("          %s: Collisions: %.1f | Probes is %.1f.\n"
							, (probe == 0) ? "Linear probe   " : "Quadratic probe", firstQuestion[oe][thresholdIndex][probe][0] / 10.0,  firstQuestion[oe][thresholdIndex][probe][1] / 10.0); 				
				}
			}
		}
		
		//Second Question
		//Compute the average collisions and probes of every case in this experiment
		System.out.println(question2);
		System.out.format("Average\n");
		for(int thresholdIndex = 0; thresholdIndex < 3; thresholdIndex++) {
			System.out.format("     Threshold %.2f%%\n", thresholds[thresholdIndex]);
			for(int probe = 0; probe < 2; ++probe) {
				System.out.format("          %s: Collisions: %.1f | Probes is %.1f.\n"
						, (probe == 0) ? "Linear probe   " : "Quadratic probe", 
								(firstQuestion[0][thresholdIndex][probe][0] + firstQuestion[1][thresholdIndex][probe][0]) / 20.0,  
								(firstQuestion[0][thresholdIndex][probe][1] + firstQuestion[1][thresholdIndex][probe][1]) / 20.0); 				
			}
		}
		
		//Third Question
		System.out.println(question3);
		
		//Fourth Question
		System.out.println(question4);
		
		//Fifth Question
		System.out.println(question5);
		
		//Sixth Question could be gotten from second question
	}
}



