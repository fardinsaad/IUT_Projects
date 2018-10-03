#ifndef __CHECKERS_HEADER_
#define __CHECKERS_HEADER_

char giveMePiece(int n);
//void printDisplay(int a[8][8]);
void swapPiece(int a[8][8], int i, int j, int k, int l,int player);
//int playerMovement(int a[8][8], int player,int i,int j,int k,int l);
int double_jump(int a[8][8],int player,int k,int l);
void delay(double sec);
void showWelcomeScreen();
int getChoice(int choice);
int inMenu(int choice);
void leaderboard(int player,char pla1[100],char pla2[100],int red,int black);
void scan_board(int a[8][8]);
int inMenu2(int choice,char pla1[100],char pla2[100],int player);
void random_move(int a[8][8],int player);
void rule();

#endif // __CHECKERS_HEADER_


