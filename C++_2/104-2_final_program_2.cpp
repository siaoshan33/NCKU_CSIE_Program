#include<math.h>
#include<windows.h>
#include<iostream>
#include<stdlib.h>
#include<conio.h>
#include<time.h>
#define DIRECTION_KEY 224
#define UP 72
#define DOWN 80
#define LEFT 75
#define RIGHT 77
#define SPACE 32
#define F 70
#define f 102

using namespace std;
void gotoxy(int, int);

void gotoxy(int x, int y)
{
	COORD loc;
	HANDLE hOuput = GetStdHandle(STD_OUTPUT_HANDLE);
	loc.X = x; 
	loc.Y = y;
	SetConsoleCursorPosition(hOuput,loc);
}

class CK
{
public:
	int temp1,temp2,i,j;
	static int data[20][20];
	void PrintCK(int,int);
	void SetBomb(int,int,int);
	void Result(int,int);
	void ChangeValue(int,int);
};

CK D(CK); //用來回傳arrayData的值 
CK D(CK arrayData)
{
	return arrayData;
}

int CK::data[20][20]={0};  //初始化 

void CK::PrintCK(int x,int y)
{
	x=x+2;
	y=y+2;

 	for(i=0;i<y-2;i++)
	{
		cout<<' '; //第一排空格,使排版好看

		for(j=0;j<x-2;j++)
		{
			cout<<'A';
		}
	cout<<endl;
	}
		
}

void CK::SetBomb(int x,int y,int bombs)
{
	x=x+2;
	y=y+2;
	srand(time(NULL));
	for(i=0;i<bombs;i++)
	{
		temp1=rand()%(x-2)+ 1 ;
		temp2=rand()%(y-2)+ 1 ;
		if(data[temp2][temp1]==1) //判斷地雷是否重複 1:重複->不算,重跑
		{
			i--;
		}
		else if(data[temp2][temp1]==0) // 0:不重複->設為地雷
		{
			data[temp2][temp1]=1;
		}
	}
	
	Result(x,y);
}

void CK::Result(int x,int y)
{
	for(j=0;j<1;j++)
	{
		cout<<' '; //地雷地圖與解答用空格隔開
		cout<<endl;
	}
	
	for(i=1;i<y-1;i++)
	{
		cout<<" " ;
		for(j=1;j<x-1;j++)
		{

			if(data[i][j]==1)
				cout<<'@'; // @表示地雷
	
			else if(data[i][j]==0) // 計算以自己為中心的九宮格的地雷數量
				cout<<(data[i-1][j-1]+data[i-1][j]+data[i-1][j+1]+data[i][j-1]+data[i][j+1]+data[i+1][j-1]+data[i+1][j]+data[i+1][j+1])%100;
		}
		cout<<endl;
	}	

}

void CK::ChangeValue(int x1,int y1)
{
	if(data[y1-2][x1]==0||data[y1-2][x1]==1)
	{
		data[y1-2][x1]=data[y1-2][x1]+100;
	}
	else if(data[y1-2][x1]==100||data[y1-2][x1]==101)
	{
		data[y1-2][x1]=data[y1-2][x1]-100 ;
	}
}



class Player
{
public:
	CK g;
	CK N;
	char point;
	int data[20][20];
public:
	void array(){
 		
		g=D(g);  //把回傳的arrayData存入g內 (g類似一個位置) 
		for(int i=0;i<20;i++){
			for(int j=0;j<20;j++){
				data[i][j]=g.data[i][j]; //再用g呼叫g裡面的data存入原本的data，但不會改變原本的data因為data是static 
			}
		}
	}
	void Step(int,int);
};

void Player::Step(int x,int y)
{
	x=x+2;
	y=y+2;
	gotoxy(1,3);
	int x1=1,y1=3;

	while(1)
	{
		array();
		
		switch (point=getch())
		{
			case UP :
				if(y1>3)
				{
					y1--;
				}
				gotoxy(x1,y1);
			break;

			case DOWN :
				if(y1<y)
				{
					y1++;
				}
				gotoxy(x1,y1);
			break;

			case LEFT:
				if(x1>1)
				{
					x1--;
				}
				gotoxy(x1,y1);
			break;
		
			case RIGHT:
				if(x1<x-2)
				{
					x1++;
				}
				gotoxy(x1,y1);
			break;
		
			case SPACE:
				if(data[y1-2][x1]==1)
				{
					gotoxy(x1,y1);
					cout<<"B";
					gotoxy(20,20);
					cout<<"---BOMB!---"<<endl;
					gotoxy(20,21);
					cout<<"---GAME OVER---" ;
					return;
				}
				else if (data[y1-2][x1]==0)
				{
					cout<<(data[y1-3][x1-1]+data[y1-2][x1-1]+data[y1-1][x1-1]+data[y1-3][x1]+data[y1-1][x1]+data[y1-3][x1+1]+data[y1-2][x1+1]+data[y1-1][x1+1])%100;
					gotoxy(x1,y1);
				}
			break;
			
			case f:
			case F:
//自己判定此處為地雷
			if(data[y1-2][x1]==0||data[y1-2][x1]==1)
			{
				data[y1-2][x1]=data[y1-2][x1]+100;
				cout<<"F";
				gotoxy(x1,y1);
				N.ChangeValue(x1,y1);
			}
		
		//將誤判為地雷的地方,從 F 變回原始值 A

			else if(data[y1-2][x1]==100||data[y1-2][x1]==101)
			{
				data[y1-2][x1]=data[y1-2][x1]-100 ;
				cout<<"A";
				gotoxy(x1,y1);
				N.ChangeValue(x1,y1);
			}
		}
	}
}



int main()
{
	int row,column,b;
	cout<<"Input the row:"; //row=行,column=列
	cin>>row;
	cout<<"Input the column:";
	cin>>column;
	cout<<"Input the bombs:";
	cin>>b;
	
	CK MM;
	MM.PrintCK(row,column);
	MM.SetBomb(row,column,b);
	
	Player Amy;
	Amy.Step(row,column);
}

