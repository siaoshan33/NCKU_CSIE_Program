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

int main ()
{
	int x,y,bombs,i,j,temp1,temp2;
	cout<<"input the row:"; //row=��,column=�C
	cin>>x;
	cout<<"input the column:";
	cin>>y;
	cout<<"input the bombs:";
	cin>>bombs;

x=x+2;
y=y+2;

int data[y][x];

for(i=0;i<y-2;i++)
{
	cout<<' '; //�Ĥ@�ƪŮ�,�ϱƪ��n��

	for(j=0;j<x-2;j++)
	{
		cout<<'A';
	}
	cout<<endl;
}

for(j=0;j<1;j++)
{
	cout<<' '; //�a�p�a�ϻP�ѵ��ΪŮ�j�}
	cout<<endl;
}

for(int i=0;i<y;i++)
{
	for(int j=0;j<x;j++)
	{
		data[i][j]=0;
	}
}

// �üƿ�J�a�p
srand(time(NULL));
for(i=0;i<bombs;i++)
{
	temp1=rand()%(x-2)+ 1 ;
	temp2=rand()%(y-2)+ 1 ;
	if(data[temp2][temp1]==1) //�P�_�a�p�O�_���� 1:����->����,���]
	{
		i--;
	}
	else if(data[temp2][temp1]==0) // 0:������->�]���a�p
	{
		data[temp2][temp1]=1;
	}
}

// �ѵ�
for(i=1;i<y-1;i++)
{
	cout<<" " ;
	for(j=1;j<x-1;j++)
	{

		if(data[i][j]==1)
			cout<<'@'; // @��ܦa�p

		else if(data[i][j]==0) // �p��H�ۤv�����ߪ��E�c�檺�a�p�ƶq
			cout<<(data[i-1][j-1]+data[i-1][j]+data[i-1][j+1]+data[i][j-1]+data[i][j+1]+data[i+1][j-1]+data[i+1][j]+data[i+1][j+1])%100;
	}
	cout<<endl;
}

// ��бq (1,3) �}�l

char point;
gotoxy(1,3);
int x1=1,y1=3;

while(1)
{
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
				return 0;
			}
			else if (data[y1-2][x1]==0)
			{
				cout<<(data[y1-3][x1-1]+data[y1-2][x1-1]+data[y1-1][x1-1]+data[y1-3][x1]+data[y1-1][x1]+data[y1-3][x1+1]+data[y1-2][x1+1]+data[y1-1][x1+1])%100;
				gotoxy(x1,y1);
			}
		break;
		
		case f:
		case F:
//�ۤv�P�w���B���a�p
		if(data[y1-2][x1]==0||data[y1-2][x1]==1)
		{
			data[y1-2][x1]=data[y1-2][x1]+100;
			cout<<"F";
			gotoxy(x1,y1);
		}
		
		//�N�~�P���a�p���a��,�q F �ܦ^��l�� A

		else if(data[y1-2][x1]==100||data[y1-2][x1]==101)
		{
			data[y1-2][x1]=data[y1-2][x1]-100 ;
			cout<<"A";
			gotoxy(x1,y1);
		}
	}
}

return 0 ;
}

