/*
//avee chakraborty  151-35-924
//diganta protic biswas   151-35-960
dept. of software engineering
Daffodil international university,
bangladesh.
mentors:
//sadik H khan
dept of computer science and engineering
daffodil international university,
bangladesh.
// jannatun nahar trisna
lecturer dept of software engineering
daffodil international university,
bangladesh.
*/
#include <iostream>
#include <windows.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fstream>

//here we add some header file to make our program efficient and successful 

using namespace std;

//we used some standard i/o systems

void lockfolder();
void unlockfolder();

//those are two functions

int main()

{
    unsigned int choice=0;
    SetConsoleTitle("Folder Lock");
    system("CLS");
    //make the consol name with <windows.h>
     printf("\t\t\t\t"  "shinduk\n");
     printf("\t\t\t" "-------------------\n");


     printf("\n\nOptions:\t\t\t\n");
     printf("\t======================\n");
     printf("\t1. - Lock Folder.\n");
     printf("\t2. - Unlock Folder.\n");
     printf("\t3. - Exit.\n");
     printf("\t======================  \n");


     printf("\nEnter your choice: ");
     scanf("%d",&choice);
    //here the user'll chose which one he wants
     switch (choice)
     {
     case 1:
         lockfolder();
      break;
     case 2:
          unlockfolder();
           break;
     case 3:
         exit(0);
         //here we tried to gte out from the system
         break;
     default:
         printf("\nError. Unknown Option Entered. \n\n\n");
         break;
     }

 return 0;
}

        void lockfolder()
        {

         ofstream lfolder;
         char folder[200]={0};
         char tempfolder[200]={'0'};
         char attributes[50]={'0'};

        //here we have initialed some strings.

         printf("\nEnter the complete path to the Folder: ");
         cin >> folder;
         
        //enter the path of the selected folder
        
         strcpy(tempfolder, folder);

        //we have copied the name of the folder into 'tempfolder'

         strcat(folder, "\\Desktop.ini");
        //added the name of the path with the extention
         lfolder.open(folder, ios::out);
        //opened a file 
         lfolder << "[.shellClassInfo]" << endl;
         lfolder << "CLSID = {63E23168-BFF7-4E87-A246-EF024425E4EC}" << endl;
        //on the file added those windows self program
         lfolder.close();

         strcpy(attributes, "attrib +h +s ");
         strcat(attributes, tempfolder);
        //added the command to lock or hide the selected file
         WinExec(attributes, NULL);

         lfolder.open("C:\\windows\\db.dat", ios::app);
         lfolder << "Folder Locked: " << tempfolder << endl;
         lfolder.close();
        //saved a document on the computer,what we have done 
         printf("\n\n %s has been locked successfully!\n",tempfolder);
         // thus the folder locked succesfully
        }
        // without the -h -s the pogram is same as lockfolder 
        // here using -h -s we tried to say that we wanna unhind or unlock
        void unlockfolder()
        {
         char folder[255];
         char tempfolder[255];
         char attributes[50];
         char del[50];
         ofstream lfolder;


         printf("\nEnter the complete path to the Folder: ");
         scanf("%s",folder);

         strcpy(tempfolder, folder);

         strcat(folder, "\\Desktop.ini");

         strcpy(del, "del ");
         strcat(del, folder);
         system(del);

         strcpy(attributes, "attrib -h -s ");
         strcat(attributes, tempfolder);

         WinExec(attributes, NULL);

         lfolder.open("C:\\windows\\db.dat", ios::app);
         lfolder << "! Folder Unlocked: " << tempfolder << endl;
         lfolder.close();

         printf("\n\n %s  has been unlocked successfully!\n",tempfolder);
        }
