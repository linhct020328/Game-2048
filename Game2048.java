package Game2048;

import java.util.Random;
import java.util.Scanner;

public class Game2048 {
    
    int a[][]=new int[4][4];//ma trận vuông cấp 4
    int score=0;//số điểm
    int best=0;//số cao nhất(max=2048)
    

    //-------------------Khởi tạo ma trận ban đầu là 0--------------------------------
    public Game2048()
    {
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                a[i][j]=0;
        
    }
    //-------------------------------------------------------------------------
  
    
  
   
    //----------------------Hiển thị ra màng hình----------------------------------------
    public void show()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(a[i][j]+"\t");
            System.out.println("");
        }
        System.out.println("");
    }
    //-------------------------------------------------------------------------
    
    
    
    
    
    
    
    //--------------trượt các số :lên ,xuống ,trái phải-----------------------------------------------
    public void slide(String dir)
    {
        switch(dir)
        {
            case "up":
                for(int j=0;j<4;j++)
                {
                    for(int k=0;k<4;k++)
                    for(int i=0;i<3;i++)
                    {
                        if(a[i][j]==0)
                        {
                            a[i][j]=a[i+1][j];
                            a[i+1][j]=0;
                        }
                    }
                }
                break;
            
            case "down":
                for(int j=0;j<4;j++)
                {
                    for(int k=0;k<4;k++)
                    for(int i=3;i>0;i--)
                    {
                        if(a[i][j]==0)
                        {
                            a[i][j]=a[i-1][j];
                            a[i-1][j]=0;
                        }
                    }
                }
                break;
            
            case "left":
                for(int i=0;i<4;i++)
                {
                    for(int k=0;k<4;k++)
                    for(int j=0;j<3;j++)
                    {
                        if(a[i][j]==0)
                        {
                            a[i][j]=a[i][j+1];
                            a[i][j+1]=0;
                        }
                    }
                }
                break;
                
            case "right":
                for(int i=0;i<4;i++)
                {
                    for(int k=0;k<4;k++)
                    for(int j=3;j>0;j--)
                    {
                        if(a[i][j]==0)
                        {
                            a[i][j]=a[i][j-1];
                            a[i][j-1]=0;
                        }
                    }
                }
                break;
                
            default:
                break;
        }
    }
    //-------------------------------------------------------------------------




    //-----------------Để thêm----------------------------------------------
    public void adding(String dir)
    {
        switch(dir)
        {
            case "down":
                for(int j=0;j<4;j++)
                {
                    for(int i=3;i>0;i--)
                    {
                        if(a[i][j]==a[i-1][j])
                        {
                            score=score+(a[i][j]*=2);
                            a[i-1][j]=0;
                            if(a[i][j]>best)
                                best=a[i][j];
                        }
                    }
                }
                
                break;
                
            case "up":
                for(int j=0;j<4;j++)
                {
                    for(int i=0;i<3;i++)
                    {
                        if(a[i][j]==a[i+1][j])
                        {
                            score=score+(a[i][j]*=2);
                            a[i+1][j]=0;
                            if(a[i][j]>best)
                                best=a[i][j];
                        }
                    }
                }
                break;
                
            case "left":
                for(int i=0;i<4;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if(a[i][j]==a[i][j+1])
                        {
                            score=score+(a[i][j]*=2);
                            a[i][j+1]=0;
                            if(a[i][j]>best)
                                best=a[i][j];
                        }
                    }
                }
                break;
                
            case "right":
                for(int i=0;i<4;i++)
                {
                    for(int j=3;j>0;j--)
                    {
                        if(a[i][j]==a[i][j-1])
                        {
                            score=score+(a[i][j]*=2);
                            a[i][j-1]=0;
                            if(a[i][j]>best)
                                best=a[i][j];
                        }
                    }
                }
                break;
                
            default:
                
                break;
        }
        
                    
    }
    


    
    //-------------------Tạo ở vị trí ngẫu nhiên-------------------------
    public boolean random()
    {
        int count=0;
        int b[]=new int[16];
        
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
            {
                if(a[i][j]==0)
                {
                    b[count]=i*10+j;
                    count++;
                }
            }
        if(count==0)
            return false;
        
        Random ran=new Random();
        int tval=ran.nextInt(count);
        int rval=b[tval];
        int aa=rval/10;
        int bb=rval%10;
        boolean bbb=ran.nextBoolean();
        if(bbb)
            a[aa][bb]=2;
        else
            a[aa][bb]=4;
        
            return true;
    }





    public static void main(String[] args) {
        
        new pr_Game2048().setVisible(true);
        
        Game2048 sam=new Game2048();
        sam.show();
            
       
        Scanner sc=new Scanner(System.in);
        int a;
        
        while(true)
        {
            sam.random();
            sam.show();
            System.out.print("Enter a move:- ");
            a=sc.nextInt();
            switch(a)
            {
                case 1:
                    sam.slide("up");
                    sam.adding("up");
                    sam.slide("up");
                    break;
                    
                case 2:
                    sam.slide("down");
                    sam.adding("down");
                    sam.slide("down");
                    break;
                    
                case 3:
                    sam.slide("left");
                    sam.adding("left");
                    sam.slide("left");
                    break;
                    
                case 4:
                    sam.slide("right");
                    sam.adding("right");
                    sam.slide("right");
                    break;  
                    
                default:
                    break;
            }
        }
    }
}
