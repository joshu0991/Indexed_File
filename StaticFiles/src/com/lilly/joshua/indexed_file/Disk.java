package com.lilly.joshua.indexed_file;

public class Disk
{
	static int counter = 0;
   private int sectorCount;   // sectors on the disk
   private int sectorSize;    // characters in a sector
   private char[][] store;    // all disk data is stored here
   public Disk()    // for default sectorCount and sectorSize
   {
	   this.sectorCount = 10000;
	   this.sectorSize = 512;
	   store = new char[10000][512];
   }
   public Disk(int sectorCount, int sectorSize)
   {
	   this.sectorCount = sectorCount;
	   this.sectorSize = sectorSize;
	   store = new char[sectorCount][sectorSize];
   }

   //buffer should be created with new therefore isn't popped with stack
   //frame
	public void readSector(int sectorNumber, char[] buffer)   // sector to buffer
   {
		//have to read one sector at a time. 
	 for(int i = 0; i < sectorSize; i++){

		 buffer[i] = store[sectorNumber][i];
	 }
   }
	
   public void writeSector(int sectorNumber, char[] buffer)  // buffer to sector 
   {
	   //length of the data to write.
	   int length = buffer.length;
	   
	   for(int i = 0; i <= (length - 1); i++){
			   store[sectorNumber][i] = buffer[i];
		}
	   
	   char[] tester = new char[300];
	   for(int test = 0; test < 300; test++){
		   tester[test] = store[sectorNumber][test];
	   }
   }
   
   public int getSectorCount()
   {
      return sectorCount;
   }
   
   public int getSectorSize()
   {
      return sectorSize;
   }

}