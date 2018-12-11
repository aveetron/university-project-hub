#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void operation(); //for operatinting the system with graphical view
int loading();

int main(){
    system("mode 1000");
    system("color 0a");
    int X=1;
    char ch;
    operation();

    while(X){
        ch=getche();


        switch(ch){


        case 's' :
        case 'S' : search_blood();
        break;

        case 'A' :
        case 'a' : add_donor();
        break;

        case 'D':
            case 'd':
            printf("\n");
            operation();
        break;


        case 'Q':
        case 'q': exit(0);
        break;


        case 'c':
        case 'C': system("cls");
        operation();
        break;


        default : system("cls");
          printf("\n\t\t***You have entered unavailable option");
        printf("***\t\t\n");
        printf("\n\t\t    ** My knowledge is limited ** \n");
        printf("\n\t    *Please Enter any one of below available ");
        printf("options*\t\n");
                          operation();
        }
    }

    return 0;
}


void operation()
{
//system of replay,close,run
//DIU CLASS SCHEDULE BUILDER

    printf("\n\t\t\t  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    printf("\n\t\t\t  \t\t                                          ");
    printf("\n\t\t\t  \t\t\tWELCOME TO  BBM v1.0  ");
    printf("\n\t\t\t  \t\t                                          ");
    printf("\n\t\t\t  \t\t                                         ");
    printf("\n\t\t\t  \t\t                                          ");
    printf("\n\t\t\t  \t\t* Press 'Q' or 'q' to quit the program.   ");
    printf("\n\t\t\t  \t\t* Press 'D' or 'd' to display below options.");
    printf("\n\t\t\t  \t\t* Press 'C' or 'c' to clear the screen and");
    printf("\n\t\t\t  \t\t  display available option.");
    printf("\n\t\t\t  \t\t                                         ");
    printf("\n\t\t\t  \t\t                                          ");

    printf("\n\t\t\t  \t\t\t->  'A' = ADD Donor        ");
    printf("\n\t\t\t  \t\t\t->  'S' = Search Blood   ");
    //printf("\n\t\t\t  \t\t\t->  'S' = Search Blood   \t\t");
    printf("\n\t\t\t  \t\t\t->  'V' = View Blood Bank   ");
    printf("\n\t\t\t  \t\t                                         ");
    printf("\n\t\t\t  \t\t                                          ");
    printf("\n\t\t\t  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

printf("\n\n\n");
printf("\nPlease Enter a symbol for choosing option:\t");

}


struct donor
    {
        char name[50];
        char address[70];
        char phn[20];

        char blood_grp[10];

        char rh_factor[10];
        double sbp; //systolic blood pressure
        double dbp; //diastolic blood pressure
        double heartrate;

   };

   struct donor donor_id[300];
   int temp=0;



int add_donor()
{
    printf("\n\n\t\t\t\t\t\t  Loading . . .");
    loading();

    int d1,n1;
    int i,j;
    printf("\n\nHow Many Blood Donor You Want To Add :\t");
    scanf("%d",&d1);
    FILE *fp;
    fp = fopen("akhi.txt","ab+");
    for(i=0;i<d1;i++)
    {
        //struct cr c[j];

/*take input and store in array on struct*/

        printf("\n\n  *** ^^ BLOOD DONOR No. %d ^^ ***",temp);
        printf("\n\n   Name Of Donor\t\t:\t");
        scanf("%s",&donor_id[temp].name);
        printf("   Address \t\t\t:\t");
        scanf("%s",&donor_id[temp].address);
        printf("   Phone Number\t\t\t:\t");
        scanf("%s",&donor_id[temp].phn);


        printf("\n   Blood Group \t\t?\t");
        scanf("%s",&donor_id[temp].blood_grp);
        printf("   RH Factor    \t:\t");
        scanf("%s",&donor_id[temp].rh_factor);

        printf("   Systolic BP  \t:\t");
        scanf("%lf",&donor_id[temp].sbp);
        printf("   Diastolic BP \t:\t");
        scanf("%lf",&donor_id[temp].dbp);
        printf("   Heart Rate   \t:\t");
        scanf("%lf",&donor_id[temp].heartrate);


        printf("\n   __________   __________");
        printf("\n");

        temp = temp + 1;
        }


    fwrite(&donor_id, sizeof(donor_id), 1, fp);
/*now print the data on screen*/
printf("\n\n\t\t\t\t\t\t  Creating . . .");
loading();

    fclose(fp);
   printf("\nProject Done!!!");
   printf("\nPlease give me another command:\t");
}

search_blood(){

    int i;
    char temp_blood[10];

    printf("\n\nPlease, type a blood group what you need :\t");
    scanf("%s",temp_blood);
    //printf("\n%s",temp_blood);


    for(i=0; i<=temp; i++){
        FILE *fp;
        fp = fopen("record.txt","rb");
        if(strcmp(temp_blood, donor_id[i].blood_grp) ==0){

                       printf("\n\n  *** ^^ BLOOD DONOR No. %d ^^ ***",i);
        printf("\n\n   Name Of Donor\t\t:\t");
        printf("%s",donor_id[i].name);
        printf("\n");
        printf("   Address \t\t\t:\t");
        printf("%s",donor_id[i].address);
        printf("\n");
        printf("   Phone Number\t\t\t:\t");
        printf("%s",donor_id[i].phn);
        printf("\n");


        printf("\n   Blood Group \t\t?\t");
        printf("%s",donor_id[i].blood_grp);
        printf("\n");
        printf("   RH Factor    \t:\t");
        printf("%s",donor_id[i].rh_factor);
        printf("\n");

        printf("   Systolic BP  \t:\t");
        printf("%lf",donor_id[i].sbp);
        printf("\n");
        printf("   Diastolic BP \t:\t");
        printf("%lf",donor_id[i].dbp);
        printf("\n");
        printf("   Heart Rate   \t:\t");
        printf("%lf",donor_id[i].heartrate);
        //printf("\n");


        printf("\n   __________   __________");
        printf("\n");
        fclose(fp);

        }
    }

}

loading()
{
    printf("\n");
int k;
int c = 1, d = 1;
printf("\n\t\t\t  [ ");
for(k=1;k<=60;k++)
    {
//c <= 22000
        printf("-");

        for ( c = 1 ; c <= 22000/8 ; c++ )
           for ( d = 1 ; d <= 22000/8 ; d++ )
           {}



    }
    printf(" ]");
    printf("\n\t\t\t\t\t\t    DONE >> \n");
    return 0;
}



