public class Moderator {
    public static void main(String[] args){
        char[][] mat = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
        Player player1 = new EmmaFu();
        Player player2 = new EmmaFu();
        int x, y;
        boolean player2Moved = false;
        String m;

        player1.reset();
        player2.reset();
        
        // String m = player1.move(null);
        // x = Character.getNumericValue(m.charAt(0));
        // y = Character.getNumericValue(m.charAt(1));
        // mat[x][y]='X';        

        // print(mat);
/////////////////////////////////////////
m = player2.move(null);
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'O';
print(mat);

//m = player1.move(m);
m = "02";
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'X';
print(mat);

m = player2.move(m);
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'O';            
print(mat);

//m = player1.move(m);
m = "10";
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'X';
print(mat);

m = player2.move(m);
System.out.println("m->" + m);
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'O';            
print(mat);

// m = player1.move(m);
m = "22";
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'X';
print(mat);

m = player2.move(m);
System.out.println("m->" + m);
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'O';            
print(mat);

m = "01";
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'X';
print(mat);

m = player2.move(m);
System.out.println("m->" + m);
x = Character.getNumericValue(m.charAt(0));
y = Character.getNumericValue(m.charAt(1));
mat[x][y] = 'O';            
print(mat);
/////////////////////////////////////////

        /*
        while(moreThanOneSpace(mat) && !hasWon(mat, m)) {
            if (player2Moved) 
                m = player1.move(m);
            else 
                m = player2.move(m);
            x = Character.getNumericValue(m.charAt(0));
            y = Character.getNumericValue(m.charAt(1));
            if (player2Moved)
                mat[x][y] = 'X';
            else
                mat[x][y] = 'O';            
            print(mat);
            player2Moved = !player2Moved;
        }

        if (player2Moved && hasWon(mat, m)) {
            System.out.println("Player2 won!");
            // has player2 won after he placed last move?
        } else if(!player2Moved && hasWon(mat, m)) {
            System.out.println("Player1 won!");
            // has player1 won afer he placed last move?
        } else {
            System.out.println("It's a tie :P");
        }
        */
    }

    static boolean hasWon(char[][] mat, String m){
        int x = Character.getNumericValue(m.charAt(0));
        int y = Character.getNumericValue(m.charAt(1));

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

    static boolean moreThanOneSpace(char[][] mat){
        int countSpace = 0;

        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j]=='_')
                    countSpace++;
            }
        }
        if(countSpace==1)
            return false;
        else
            return true;
    }

    static void print(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            System.out.print("|");
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    } 
}