#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <stdlib.h>
#include <windows.h>

struct student{
    char idNumber[15];
    char name[20];
    char date[15];
    char deptName[20];
    char payingAmmount[20];
};
struct student stu;

void SetColor(int ForgC)
{
     WORD wColor;
     HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
     CONSOLE_SCREEN_BUFFER_INFO csbi;

     if(GetConsoleScreenBufferInfo(hStdOut, &csbi))
     {
          wColor = (csbi.wAttributes & 0xF0) + (ForgC & 0x0F);
          SetConsoleTextAttribute(hStdOut, wColor);
     }
     return;
}
void ClearConsoleToColors(int ForgC, int BackC)
{
     WORD wColor = ((BackC & 0x0F) << 4) + (ForgC & 0x0F);

     HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);

     COORD coord = {0, 0};
     DWORD count;
     CONSOLE_SCREEN_BUFFER_INFO csbi;
     SetConsoleTextAttribute(hStdOut, wColor);
     if(GetConsoleScreenBufferInfo(hStdOut, &csbi))
     {
          FillConsoleOutputCharacter(hStdOut, (TCHAR) 32, csbi.dwSize.X * csbi.dwSize.Y, coord, &count);
          FillConsoleOutputAttribute(hStdOut, csbi.wAttributes, csbi.dwSize.X * csbi.dwSize.Y, coord, &count );
          SetConsoleCursorPosition(hStdOut, coord);
     }
     return;
}
void SetColorAndBackground(int ForgC, int BackC)
{
     WORD wColor = ((BackC & 0x0F) << 4) + (ForgC & 0x0F);;
     SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), wColor);
     return;
}
COORD coord = {0,0};
void gotoxy(int x, int y){
    coord.X = x; coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

void drawRectangle(){
    int i, j;
    gotoxy(0,0);
    printf("%c",201);
    for(i = 1; i < 78; i++){
        gotoxy(i, 0);
        printf("%c",205);
    }
    gotoxy(78,0);
    printf("%c",187);
    for(i = 1; i < 25; i++){
        gotoxy(78, i);
        if(i == 6){
            printf("%c",185);
        }else{
            printf("%c",186);
        }
    }
    gotoxy(78, 25);
    printf("%c",188);
    for(i = 77; i > 0; i--){
        gotoxy(i,25);
        if(i == 35){
            printf("%c",202);
        }else{
            printf("%c",205);
        }
    }
    gotoxy(0,25);
    printf("%c",200);
    for(i = 24; i > 0; i--){
        gotoxy(0,i);
        if(i == 6){
            printf("%c",204);
        }else{
            printf("%c",186);
        }
    }
    for(i = 1; i < 78; i++){
        gotoxy(i,6);
        if(i == 35){
            printf("%c",203);
        }else{
            printf("%c",205);
        }
    }
    for(i = 7; i < 25; i++){
        gotoxy(35,i);
        printf("%c",186);
    }
}
void clearWindow(){
    int i,j;
    for(i = 37; i < 78; i++){
        for(j = 7; j < 25; j++){
            gotoxy(i,j);printf(" ");
        }
    }
    return;
}
void window(){
    drawRectangle();
    gotoxy(28,2);
    SetColor(35);
    printf("Student Billing System\n");
    gotoxy(20,3);
    printf("Programming Language With Lab 'C' Project");
    gotoxy(25,24);
    SetColor(17);
}
void print_heading(const char st[]){
    SetColorAndBackground(31,28);
    gotoxy(45,8);printf("%s",st);
    SetColorAndBackground(17,15);
}

int conf_record(char id[]){

}

void add_student(){
    clearWindow();
    print_heading("Add a new data");
    int print = 37;
    FILE *fp;
    fp = fopen("record.txt","ab+");
    SetColor(45);
    if(fp == NULL){
        MessageBox(0,"Error!!!","Warning",0);

    }else{
        fflush(stdin);
        gotoxy(print,10);printf("Name: ");
        gets(stu.name);
        gotoxy(print,12);printf("ID Number: ");
        gets(stu.idNumber);
        gotoxy(print,14);printf("date (DD/MM/YY): ");
        gets(stu.date);
        gotoxy(print,16);printf("dept name: ");
        gets(stu.deptName);
        gotoxy(print,18);printf("paying ammount: ");
        gets(stu.payingAmmount);


        fwrite(&stu, sizeof(stu), 1, fp);
         int i,j,k;
    printf("\t\t\t\n\n\n");
    for(i=0;i<33;i++){
        printf("=");
        for(j=0;j<22000/8;j++){
            for(k=0;k<220000/8;k++){

            }
        }
    }
        MessageBoxA(NULL,"data added successfully","",MB_OKCANCEL);
        gotoxy(40,24); printf("New ID Number is successfully added :D");
    }
    SetColor(28);
    fclose(fp);
    return;
}

void search_student(){
    clearWindow();
    print_heading("Search a ID Number");
    SetColor(45);
    char s_id[150];
    int isFound = 0;
    gotoxy(37,10);printf("Enter a ID Number to Search: ");fflush(stdin);
    gets(s_id);
    FILE *fp;
    fp = fopen("record.txt","rb");
    while(fread(&stu,sizeof(stu),1,fp) == 1){
        if(strcmp(s_id,stu.idNumber) == 0){
            isFound = 1;
            break;
        }
    }
    if(isFound == 1){
        gotoxy(37,12);printf("      Entered ID Number is Found");
        gotoxy(37,14);printf("ID Number: %s",stu.idNumber);
        gotoxy(37,15);printf("Name: %s",stu.name);
        gotoxy(37,16);printf("det name: %s",stu.deptName);
        //gotoxy(37,17);printf("Fathers Name: %s",stu.fathersname);
        //gotoxy(37,18);printf("Blood Group: %s",stu.bloodgroup);
        gotoxy(37,17);printf(" date: %s",stu.date);
        gotoxy(37,19);printf("ammount: %s",stu.payingAmmount);
    }else{
        gotoxy(37,12);printf("Sorry!!! This ID Number does not exist.");
        gotoxy(37,15);printf("     Please enter correct ID Number.");
    }
    SetColor(28);
    fclose(fp);
    return;
}



void main_window(){
    int choice;
    SetColor(28);
    int x = 2;
    while(1){
        gotoxy(x,8);printf("1. Add new ID Number");
        gotoxy(x,10);printf("2. Search");
        gotoxy(x,12);printf("5. Exit");
        gotoxy(x,16);printf("Enter your choice: ");
        scanf("%d",&choice);
        switch(choice){
            case 1:
                add_student();
                break;
            case 2:
                search_student();
                break;
            case 3:
                exit(0);
                break;
            default:
                break;
        }

    }

}

int main()
{
    ClearConsoleToColors(17,15);
    SetConsoleTitle("Student Billing System Created by ~Avee~");
    window();
    main_window();
    return 0;
}
