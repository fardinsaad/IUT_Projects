#include<bits/stdc++.h>
#include<conio.h>
#include<windows.h>
#include<time.h>
#include"checkers.h"
using namespace std;

char giveMePiece(int n)
{
    switch(n)
    {
        case 0:
            return ' ';
        case 1:
            return ' ';
        case 2:
            return 'r';
        case 3:
            return 'b';
        case 4:
            return 'R';
        case 5:
            return 'B';
    }
}
void leaderboard(int player,char pla1[100],char pla2[100],int red,int black)
{
    FILE *fp;
    fp = fopen("leaderboard.txt","a");
    if(player == 2)
        fprintf(fp,"%s(%d)\t\t%s(%d) \n",pla1,red,pla2,black);
    else if(player == 3)
        fprintf(fp,"%s(%d)\t\t%s(%d) \n",pla2,black,pla1,red);
}
void scan_board(int a[8][8])
{
   FILE *fp;
    fp=fopen("leaderboard.txt","r");
    system("cls");
    printf("[[ Press escape button to go back ]]\n\n");
    printf("Winner\t\t\tLoser\n");
    while(1)
    {
        char ch;
        if(ch==EOF) break;
        ch=fgetc(fp);
        printf("%c",ch);
    }
    while(1)
    {
        if(kbhit())
        {
            char key=getche();
            if(key==27)
            {
                return;
            }
        }
    }
}

void rule()
{
    system("mode 350,300");
    FILE *fp2;
    fp2=fopen("rule.txt","r");
    system("cls");
    while(1)
    {
        char ch;
        if(ch==EOF) break;
        ch=fgetc(fp2);
        printf("%c",ch);
    }
    while(1)
    {
        if(kbhit())
        {
            char key=getche();
            if(key==27)
            {
                system("mode 100,40");
                return;
            }
        }
    }
}
int double_jump(int a[8][8],int player,int k,int l)
{
    if(player==2)
    {
        if((k==6 || l==6) && a[k][l]!=4) return -1;
        if(a[k+1][l+1]==3 && a[k+2][l+2]==1) return 1;
        else if(a[k+1][l-1]==3 && a[k+2][l-2]==1) return 1;
        else if(a[k-1][l+1]==3 && a[k-2][l+2]==1 &&a[k][l]==4) return 1;
        else if(a[k-1][l-1]==3 && a[k-2][l-2]==1 && a[k][l]==4) return 1;
        else return -1;
    }
    else
    {
        if((k==1 || l==1)&& a[k][l]!=5) return -1;
        if(a[k+1][l+1]==2 && a[k+2][l+2]==1 && a[k][l]==5) return 1;
        else if(a[k+1][l-1]==2 && a[k+2][l-2]==1 && a[k][l]==5) return 1;
        else if(a[k-1][l+1]==2 && a[k-2][l+2]==1) return 1;
        else if(a[k-1][l-1]==2 && a[k-2][l-2]==1) return 1;
        else return -1;
    }
}

void random_move(int a[8][8],int player)
{
    int i,j,k,l,b=0,n,m;
    for(i = 0;i < 8;i++)
    {
        for(j = 0; j < 8;j++)
        {
            if(a[i][j] == player)
            {
                if(player == 2)
                {
                    if(a[i+1][j+1] == 1)
                    {
                        swapPiece(a,i,j,i+1,j+1,player);
                        b = 1;
                    }
                    else if(a[i+1][j-1] == 1)
                    {
                        swapPiece(a,i,j,i+1,j-1,player);
                        b = 1;
                    }
                }
                else if(player == 3)
                {
                    if(a[i-1][j+1] == 1)
                    {
                        swapPiece(a,i,j,i-1,j+1,player);
                        b = 1;
                    }
                    else if(a[i-1][j-1] == 1)
                    {
                        swapPiece(a,i,j,i-1,j-1,player);
                        b = 1;
                    }
                }
            }
        if(b == 1) break;
        }
    if(b == 1) break;
    }
}

void delay(double sec)
{
    clock_t start,current;
    start = clock();
    current = clock();
    while((double)(current-start)/CLOCKS_PER_SEC < sec)
        current = clock();
}
void showWelcomeScreen()
{
    cout<<"Press any key to continue";
    string str1={"\n\n\n\t\t\tWELCOME TO CHECKERS GAME...\n\n\n\t\tDeveloped by :-\n\n\t\tSaadman Malik(154420)\n\n\t\tFardin Saad(154419) "};
    cout<<"\t\t";
    for(int run=0;run<str1.size();run++)
    {
        cout<<str1[run];
        delay(0.1);
        if(kbhit())
        {
            getch();
            system("cls");
            cout<<str1;
            break;
        }
    }
    delay(1);
}
int getChoice(int choice)
{
    char ch=10;
    while(ch!=13){
        system("cls");
        if(choice==1){
            printf("\n\n\n\n\t\t\t ---> E N T E R  T H E  G A M E \n");
        }
        else printf("\n\n\n\n\t\t\t ---> Enter the game \n");
        if(choice == 2)
            printf("\n\n\t\t\t ---> R U L E  O F  T H I S  G A M E \n");
        else printf("\n\n\t\t\t ---> Rule of this game \n");
        if(choice == 3)
            printf("\n\n\t\t\t ---> L O A D  G A M E \n");
        else printf("\n\n\t\t\t ---> Load game \n");
        if(choice == 4)
            printf("\n\n\t\t\t ---> L E A D E R B O A R D \n");
        else printf("\n\n\t\t\t ---> Leaderboard \n");
        if(choice==5)
            printf("\n\n\t\t\t ---> Q U I T \n");
        else printf("\n\n\t\t\t ---> Quit \n");
        printf("\n\n[ Use UP and DOWN arrow to select an option ]");
        ch = getch();
        if(ch == 72)
            choice--;
        else if(ch == 80)
            choice++;
        if(choice<1)
            choice = 5;
        else if(choice>5)
            choice = 1;
    }
    return choice;
}

int inMenu(int choice)
{
    char ch=10;
    while(ch!=13){
        system("cls");
        if(choice==1){
            printf("\n\n\n\n\t\t\t ---> R E S U M E  G A M E \n");
        }
        else printf("\n\n\n\n\t\t\t ---> Resume game \n");
        if(choice == 2)
            printf("\n\n\t\t\t ---> S A V E  G A M E \n");
        else printf("\n\n\t\t\t ---> Save game \n");
        if(choice == 3)
            printf("\n\n\t\t\t ---> L E A D E R B O A R D \n");
        else printf("\n\n\t\t\t ---> Leaderboard \n");
        if(choice==4)
            printf("\n\n\t\t\t ---> Q U I T \n");
        else printf("\n\n\t\t\t ---> Quit \n");
        printf("\n\n[ Use UP and DOWN arrow to select an option ]");
        ch = getch();
        if(ch == 72)
            choice--;
        else if(ch == 80)
            choice++;
        if(choice<1)
            choice = 4;
        else if(choice>4)
            choice = 1;
    }
    return choice;
}

int inMenu2(int choice,char pla1[100],char pla2[100],int player)
{
    char ch=10;
    while(ch!=13){
        system("cls");

        if(player==2) printf("Congratulations! %s won!\n",pla1);
        else if(player==3) printf("Congratulations! %s won!\n",pla2);
        printf("Do you want to play again? ");
        if(choice==1){
            printf("\n\n\n\n\t\t\t ---> Y E S \n");
        }
        else printf("\n\n\n\n\t\t\t ---> Yes \n");
        if(choice == 2)
            printf("\n\n\t\t\t ---> N O \n");
        else printf("\n\n\t\t\t ---> No \n");
        printf("\n\n[ Use UP and DOWN arrow to select an option ]");
        ch = getch();
        if(ch == 72)
            choice--;
        else if(ch == 80)
            choice++;
        if(choice<1)
            choice = 2;
        else if(choice>2)
            choice = 1;
    }
    return choice;
}

