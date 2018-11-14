import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;


public class TicTacToe{
    public static void main(String[] args){
        //play();
        // char[][] mat = {{'1', '_', '_'},{'1', '_', '_'},{'1', '_', '_'}};
        // print(mat);
        printIntruc();
        play();
    }
    
    static void play(){
        System.out.println("You go first! You are O!");

        char[][] mat = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
        Scanner s = new Scanner(System.in);
        boolean iwon = false;
        int x = -1;
        int y = -1;
        
        while(!isComplete(mat) && !iwon){            
            x = s.nextInt();
            y = s.nextInt();

            //if ( (x,y) is taken )
            //  print something
            //  continue
            if(mat[x][y]!='_'){
                System.out.println("That spot is taken! Try again >:(");
                continue;
            }

            playerMove(mat, x, y);
            //print(mat);

            if(hasWon(mat, x, y))
                System.out.println("You've won wowow");

            else if(isComplete(mat))
                System.out.println("It's a tie!");

            else {
                // computers move.
                for(int i = 0; i<mat.length; i++){      //for winning
                    if(potenVictCol(mat, i, 'X')){
                        mat[0][i]='X';
                        mat[1][i]='X';
                        mat[2][i]='X';
                        System.out.println("Ha I won col "+i);
                        iwon = true;
                    }

                    else if(potenVictRow(mat, i, 'X')){
                        mat[i][0]='X';
                        mat[i][1]='X';
                        mat[i][2]='X';
                        System.out.println("Ha I won row "+i);
                        iwon = true;
                    }

                    else if(potenVictDiag1(mat, 'X')){
                        mat[0][0]='X';
                        mat[1][1]='X';
                        mat[2][2]='X';
                        System.out.println("Ha I won diag1");
                        iwon = true;
                    }

                    else if(potentVictDiag2(mat, 'X')){
                        mat[0][2]='X';
                        mat[1][1]='X';
                        mat[2][0]='X';
                        System.out.println("Ha I won diag2!");
                        iwon = true;
                    }
                }
                if (potenVict(mat,'O')) //for blocking
                    block(mat);

                else
                    compMove(mat, x, y); //for placing
            }

            print(mat);
        } 
        s.close();
    }

    static void playerMove(char[][] mat, int x, int y){
        if(mat[x][y]=='_'){
            mat[x][y]='O';
        }
    }

    static void compMove(char[][] mat, int x, int y){
        System.out.println("->Now computer's move");
        if(x==y && x==1){
            putInNextCorner(mat);
            // System.out.println("case 0");
        }
        else{
            if(mat[1][1]=='_'){
                mat[1][1]='X';
            }
            else
                putInNextCorner(mat);
        }
        // else if(((x==0 && y==0) || (x==0 && y==2) || (x==2 && y==0) || (x==2 && y==2))){//if O placed in corner
        //     if(mat[1][1]=='_'){
        //         mat[1][1]='X';
        //         // System.out.println("case 1a");
        //     }
        //     else{
        //         putInNextCorner(mat);
        //         // System.out.println("case 1b");    
        //     }
        // }
        // else if(((x==0 && y==1) || (x==1 && y==2) || (x==2 && y==1) || (x==1 && y==0))){ //if O placed on edge
        //     putInNextCorner(mat);
        //     // System.out.println("case 2");
        // }
    }

    static void putInNextCorner(char[][] mat){
        if(mat[0][2]=='_'){
            mat[0][2]='X';
        } else if(mat[2][0]=='_'){
            mat[2][0]='X';
        } else if(mat[0][0]=='_'){
            mat[0][0]='X';
        } else if(mat[2][2]=='_'){
            mat[2][2]='X';
        }
    }

    static void block(char[][] mat){
        //print(mat);
        System.out.println("->I block you >:)");
        for(int i = 0; i<mat.length; i++){
            if(potenVictCol(mat, i, 'O') && findSpaceCol(mat, i)!=3){
                // System.out.println("i is this " +i);
                // System.out.println("text find space "+findSpaceCol(mat, i));
                mat[findSpaceCol(mat, i)][i]='X';
                //System.out.println("cc1");
            }
            else if(potenVictRow(mat, i, 'O') && findSpaceRow(mat, i)!=3){
                mat[i][findSpaceRow(mat, i)]='X';
                //System.out.println("cc2");
            }
            else if(potenVictDiag1(mat, 'O') && findSpaceDiag1(mat)!=3){
                mat[findSpaceDiag1(mat)][findSpaceDiag1(mat)]='X';
                //System.out.println("cc3");
            }
            else if(potentVictDiag2(mat, 'O') && findSpaceDiag2(mat)!=3){
                mat[findSpaceDiag2(mat)][2-findSpaceDiag2(mat)]='X';
                //System.out.println("cc4");
            }
        }
    }
    
    static int findSpaceCol(char[][] mat, int id){
        for(int i = 0; i<mat.length; i++){
            if(mat[i][id]=='_')
                return i;
        }
        return 3;
    }

    static int findSpaceRow(char[][] mat, int id){
        for(int i = 0; i<mat.length; i++){
            if(mat[id][i]=='_')
                return i;
        }
        return 3;
    }

    static int findSpaceDiag1(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            if(mat[i][i]=='_')
                return i;
        }
        return 3;
    }

    static int findSpaceDiag2(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            if(mat[i][2-i]=='_')
                return i;
        }
        return 3;
    }
    
    static boolean potenVict(char[][] mat, char piece){
        for(int i = 0; i<mat.length; i++){
            if(potenVictCol(mat, i, 'O') || potenVictRow(mat, i, 'O') || potenVictDiag1(mat, 'O') || potentVictDiag2(mat, 'O'))
                return true;
        }
        return false;
    }

    static boolean potenVictCol(char[][] mat, int x, char piece){
        int countX = 0;
        int countSpace = 0;

        for(int i=0; i<mat.length; i++){
            if(mat[i][x]==piece)
                countX++;
            else if(mat[i][x]=='_')
                countSpace++;
            
        }
        
        if(countX==2 && countSpace==1)
            return true;
        return false;   
    }

    static boolean potenVictRow(char[][] mat, int y, char piece){
        int countX = 0;
        int countSpace = 0;

        //print(mat);

        for(int i=0; i<mat.length; i++){
            if(mat[y][i]==piece)
                countX++;
            else if(mat[y][i]=='_')
                countSpace++;
            
        }

        if(countX==2 && countSpace==1){
            // print(mat);
            return true;
        }
        return false;   
    }

    static boolean potenVictDiag1(char[][] mat, char piece){
        int countX = 0;
        int countSpace = 0;

        for(int i=0; i<mat.length; i++){
            if(mat[i][i]==piece)
                countX++;
            else if(mat[i][i]=='_')
                countSpace++;
            
        }

        if(countX==2 && countSpace==1)
            return true;
        return false; 
    }

    static boolean potentVictDiag2(char[][] mat, char piece){
        int countX = 0;
        int countSpace = 0;

        for(int i=0; i<mat.length; i++){
            if(mat[i][2-i]==piece)
                countX++;
            else if(mat[i][2-i]=='_')
                countSpace++;
            
        }

        if(countX==2 && countSpace==1)
            return true;
        return false; 
    }

    static boolean hasWon(char[][] mat, int x, int y){
        if(mat[x][0]==mat[x][1] && mat[x][1]==mat[x][2] && mat[x][0]!='_') { //checking columns
            // System.out.println("case b");
            return true;
        } else if(mat[0][y]==mat[1][y] && mat[1][y]==mat[2][y]  && mat[0][y]!='_') { //checking rows
            // System.out.println("case c");
            return true;
        } else if(mat[0][0]==mat[1][1] && mat[1][1]==mat[2][2]  && mat[0][0]!='_') { //checking diagonals \ 
            // System.out.println("case d");
            return true;
        } else if(mat[0][2]==mat[1][1] && mat[1][1]==mat[2][0] && mat[0][2]!='_') { //checking diagonals / 
            // System.out.println("case e");
            return true;
        } else
            return false;   
    }

    static boolean isComplete(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
               if(mat[i][j]=='_')
                return false;
            }
        }
        return true;
    }
    
    static void print(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            System.out.print("|");
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + "|");
            }
            System.out.println();
        }
    }

    static void printIntruc(){
        String[][] mat = {{"0 0", "0 1", "0 2"},{"1 0", "1 1", "1 2"},{"2 0", "2 1", "2 2"}};
        
        for(int i = 0; i<mat.length; i++){
            System.out.print("|");
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + "|");
            }
            System.out.println();
        }

        System.out.println("Enter the pair of coordinates to place a piece in that spot! Good luckkkk >:)");
    }
}
