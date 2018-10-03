#include<bits/stdc++.h>
#include<conio.h>
#include<windows.h>
#include<time.h>
#include"checkers.h"
#define de cout<<"debug"
using namespace std;

char piece;
int black,red;
int row=8,col=8;
int x,dx,dy;
char pla1[100],pla2[100];
void file(int a[8][8],char pla1[100],char pla2[100],int player)
{
    FILE *fp1;
    fp1=fopen("array.txt","w+");
    for(int i=0;i<8;i++)
    {
        for(int j=0;j<8;j++)
        {
            fprintf(fp1,"%d ",a[i][j]);
        }
        fprintf(fp1,"\n");
    }
    fprintf(fp1,"%s %s\n",pla1,pla2);
    fprintf(fp1,"%d %d %d ",player,red,black);
}

void printDisplay(int a[8][8])
{
    int r, c, x=0;
    printf("\n\n\t\t\t");
    printf("    a   b   c   d   e   f   g   h\t\t%s  %s\n",pla1,pla2);
    printf("\t\t\t");
    printf("  +...+...+...+...+...+...+...+...+\t\t%d\t%d\n",red,black);

    for (r=0; r<row; r++)
    {
        printf("\t\t\t");
        printf("%d |", r+1);
        for (c=0;c<col;c++)
        {
            printf(" %c |", giveMePiece(a[r][c]) );
        }
        printf(" %d\n",r+1);
        printf("\t\t\t");
        printf("  +...+...+...+...+...+...+...+...+\n");
    }
    printf("\t\t\t");
    printf("    a   b   c   d   e   f   g   h\n\n");
    printf("\t\t[ Use row-column coordinates to make your move ]\n\n");
    printf("\t\t[ Use escape button to access menu ]\n\n");

}
void swapPiece(int a[8][8], int i, int j, int k, int l,int player)
{
    int temp;

   if(player == 2)
    {
        printf("RED move from %d,%c to %d,%c\n", i+1, j+'a', k+1, l+'a');
    }
    else if(player == 3)
    {
        printf("BLACK move from %d,%c to %d,%c\n", i+1, j+'a', k+1, l+'a');
    }
    printf("SWAP: \tFrom row= %d, column= %d \n\tto row= %d,column= %d\n", i+1, j+1, k+1, l+1);

    if(i - k == -2 || i - k == 2)
    {
        if(j - l == -2 || j - l == 2)
        {
            if(player==2)
            {
                red++;
                printf("Black piece captured\n");
            }
            else
            {
                black++;
                printf("Red piece captured\n");
            }
        }
    }
    if(player==2)  //RED king piece
    {
        if(k==7)
        {
            a[i][j]=4;
        }
    }
    else if(player==3)  // BLACK king piece
    {
        if(k==0)
        {
            a[i][j]=5;
        }
    }
    temp = a[i][j];

    a[i][j] = a[k][l];

    a[k][l] = temp;

}
int playerMovement(int a[8][8], int player,int i,int j,int k,int l)
{
    int jmp_r;
    int jmp_c;
    int row=8,col=8;
    //de<<1;
    if(i < 0 || row <= i)
    {
        printf("Out of bounds\n");         //keeping in bounds
        return -1;
    }
    if(j < 0 || col <= j)
    {
        printf("Out of bounds\n");
        return -1;
    }

    if(k < 0 || row <= k)
    {
        printf("Out of bounds\n");
        return -1;

    }
    if(l < 0 || col<= l)
    {
        printf("Out of bounds\n");
        return -1;
    }
    //de<<2;
    // check player if its moving his own piece.
    if(player == 2)
    {
       // de<<3;
        if(a[i][j] != 2 && a[i][j]!=4)
        {
            printf("Move your own piece!\n");
            return -1;
        }
        //de<<4;
    }
    else
    {
        if(a[i][j] != 3 && a[i][j]!=5)
        {
            printf("Move your own piece!\n");
            return -1;
        }
    }
    //make sure they are jumping to a empty location
    if(a[k][l]==0) return -1;
    if(a[k][l] != 1)
    {
        printf("You must move to an empty location");
        return -1;
    }
    // make sure the vertical direction of the move is not illegal
    if(player == 2)
    {
        //make sure he moves down
        if(i >= k && a[i][j]!=4)
        {
            printf("RED player must move down\n");
            return -1;
        }
    }
    else
    {
        // make sure player moves up
        if(i <= k && a[i][j]!=5)
        {
            printf("BLACK player must move up\n");
            return -1;
        }
    }
    //de<<5;

    // checking if it's a regular move
    if(i - k == -1 || i - k == 1)
    {
        if(j - l == 1 || j - l == -1)
        {
            swapPiece(a,i,j,k,l,player);
            return 0;
        }
    }

    //checking if it's a jump move
    if(i - k == -2 || i - k == 2)
    {
        if(j - l == -2 || j - l == 2)
        {
            // checking if the jump position is enemy
            if(i < k)
            { // move down
                jmp_r = i + 1;
            }
            else
            { // move up
                jmp_r = i - 1;
            }
            if(j < l)
            { // move down
                jmp_c = j + 1;
            }
            else
            { // move up
                jmp_c = j - 1;
            }

            if(player==2 && a[jmp_r][jmp_c]!=3)
            {
                printf("Enemy is not at %d %d\n",jmp_r, jmp_c);
                printf("You can only jump over an enemy player\n");
                return -1;
            }
            if(player==3 && a[jmp_r][jmp_c] != 2)
            {
                printf("Enemy is not at %d %d\n",jmp_r, jmp_c);
                printf("You can only jump over an enemy player\n");
                return -1;
            }

            // the move is valid:
            a[jmp_r][jmp_c] = 1;
            swapPiece(a,i,j,k,l,player);
            return 0;
        }
    }

    printf("You can only move one step diagonally\n");
    return -1;

}

int main()
{
    system("mode 100,40");
    system("COLOR 3F");
    top:
    int a[8][8]={
    {0,2,0,2,0,2,0,2},
    {2,0,2,0,2,0,2,0},
    {0,2,0,2,0,2,0,2},
    {1,0,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1},
    {3,0,3,0,3,0,3,0},
    {0,3,0,3,0,3,0,3},
    {3,0,3,0,3,0,3,0}};
    int i,k,n,y,z,time;
    char j,l;
    system("cls");
    showWelcomeScreen();
    x=getChoice(1);
    start:
    if(x==1)
    {
        system("cls");
        printf("Enter First Player's Name: ");
        gets(pla1);
        printf("Enter Second Player's Name: ");
        gets(pla2);
        game_red:
        while(1)
        {
            system("cls");
            printDisplay(a);
            file(a,pla1,pla2,2);
            if(black==12 || red==12)
            {
                goto khela_shesh;
            }
            while(1)
            {
                // RED
                here:
                time=0;
                while(1)
                {
                    if(time > 30)
                    {
                        random_move(a,2);
                        goto shomoy_shesh;
                    }
                    printf("\nTime: %d\n",time%60);
                    printf("%s's turn:\n",pla1);
                    printf("from: ");
                    if(kbhit())
                    {
                        char key=getche();
                        if(key==27)
                        {
                            x=inMenu(1);
                            if(x==4) return 0;
                            else if(x==2)
                            {
                                file(a,pla1,pla2,2);
                                system("cls");
                                printf("Game Saved!\n\n");
                                printDisplay(a);
                            }
                            else if(x==3) scan_board(a);
                        }
                        else
                        {
                            i=key-48;
                            scanf("%c",&j);
                            fflush(stdin);
                            printf("\nto: ");
                            scanf("%d %c",&k,&l);
                            fflush(stdin);
                            break;
                        }
                    }
                    delay(1);
                    time++;
                    system("cls");
                    printDisplay(a);
                }

                system("cls");
                if(playerMovement(a,2,i-1,j-97,k-1,l-97) == 0)
                {
                    if((i-1) - (k-1) == -2 || (i-1) - (k-1) == 2)
                    {
                        if((j-97) - (l-97) == 2 || (j-97) - (l-97) == -2)
                        {
                            if(double_jump(a,2,k-1,l-97)==1)
                            {
                                printDisplay(a);
                                goto here;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        //printDisplay(a);
                        break;
                    }
                }
                else
                {
                    printf("\nIllegal move, try again\n");
                    printDisplay(a);
                }
            }
            printDisplay(a);
            delay(1);
            //printf("\n");
            shomoy_shesh:
            game_black:
            system("cls");
            printDisplay(a);
            file(a,pla1,pla2,3);
            if(black==12 || red==12)
            {
                goto khela_shesh;
            }

            while(1)
            {
                // BLACK
                here_again:
                time=0;
                int abcd=0;
                while(1)
                {
                    if(time > 30)
                    {
                        random_move(a,3);
                        abcd=1;
                        break;
                    }
                    printf("\nTime: %d\n",time%60);
                    printf("%s's turn:\n",pla2);
                    printf("from: ");
                    if(kbhit())
                    {
                        char key=getche();
                        if(key==27)
                        {
                            x=inMenu(1);
                            if(x==4) return 0;
                            else if(x==2)
                            {
                                file(a,pla1,pla2,3);
                                system("cls");
                                printf("Game Saved!\n\n");
                                printDisplay(a);
                            }
                            else if(x==3) scan_board(a);
                        }
                        else
                        {
                            i=key-48;
                            scanf("%c",&j);
                            fflush(stdin);
                            printf("\nto: ");
                            scanf("%d %c",&k,&l);
                            fflush(stdin);
                            break;
                        }
                    }
                    delay(1);
                    time++;
                    system("cls");
                    printDisplay(a);
                }
                system("cls");
                if(abcd==1) break;
                if(playerMovement(a,3,i-1,j-97,k-1,l-97) == 0)
                {
                    if(i - k == -2 || i - k == 2)
                    {
                        if((j-97) - (l-97) == 2 || (j-97) - (l-97) == -2)
                        {
                            if(double_jump(a,3,k-1,l-97)==1)
                            {
                                printDisplay(a);
                                goto here_again;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                        //printDisplay(a);
                        break;
                    }
                }
                else
                {
                    printf("\nIllegal move, try again\n");
                    printDisplay(a);
                }
            }
            printDisplay(a);
            delay(1);
        }
    }

        outside:
        if(x==2)
        {
            rule();
            x=getChoice(1);
            if(x!=1)
            {
                goto outside;
            }
            else goto start;
        }
        if(x==3)
        {
            FILE *fp1;
            int colour;
            fp1=fopen("array.txt","r");
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    fscanf(fp1,"%d",&a[i][j]);
                }
            }
            fscanf(fp1,"%s %s",pla1,pla2);
            fflush(stdin);
            fscanf(fp1,"%d %d %d",&colour,&red,&black);
            if(colour==2) goto game_red;
            else if(colour==3) goto game_black;
        }
        if(x==4)
        {
            scan_board(a);
            x=getChoice(1);
            if(x!=1)
            {
                goto outside;
            }
            else goto start;
        }
        if(x==5)
        {
            return 0;
        }
        khela_shesh:
        if(black==12)
        {
            leaderboard(3,pla1,pla2,red,black);
            black=0;
            red=0;
            printf("Congratulations! %s won!\n",pla2);
            x=inMenu2(1,pla1,pla2,3);
            if(x==1) goto top;
            else return 0;

        }
        else if(red==12)
        {
            leaderboard(2,pla1,pla2,red,black);
            black=0;
            red=0;
            printf("Congratulations! %s won!\n",pla1);
            x=inMenu2(1,pla1,pla2,2);
            if(x==1) goto top;
            else return 0;
        }

}
