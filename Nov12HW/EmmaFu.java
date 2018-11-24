public class EmmaFu implements Player{
    private char[][] mat = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
    public static void main(String[] args){
        
    }

    public String move(String lastMove){
        if(lastMove=null){
            mat[1][1]='X';
            return "11";
        }

        //System.out.println("You go first! You are O!");

        //char[][] mat = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
        //Scanner s = new Scanner(System.in);

        boolean iwon = false;
        int x = 1;
        int y = -1; // move.charAt[1];
        
        while(!isComplete(mat) && !iwon){            
            x = Character.getNumericValue(lastMove.charAt(0));
            y = Character.getNumericValue(lastMove.charAt(1));

            playerMove(mat, x, y);
            //print(mat);

            if(hasWon(mat, x, y)){
                System.out.println("You've won wowow");
                iwon=true;
            }

            else if(isComplete(mat))
                System.out.println("It's a tie!");

            else {
                // computers move.
                for(int i = 0; i<mat.length; i++){      //for winning
                    if(potenVictCol(mat, i, 'X')){
                        mat[0][i]='X';
                        mat[1][i]='X';
                        mat[2][i]='X';
                        System.out.println("Ha I won!");
                        iwon = true;
                    }

                    else if(potenVictRow(mat, i, 'X')){
                        mat[i][0]='X';
                        mat[i][1]='X';
                        mat[i][2]='X';
                        System.out.println("Ha I won!");
                        iwon = true;
                    }

                    else if(potenVictDiag1(mat, 'X')){
                        mat[0][0]='X';
                        mat[1][1]='X';
                        mat[2][2]='X';
                        System.out.println("Ha I won!");
                        iwon = true;
                    }

                    else if(potentVictDiag2(mat, 'X')){
                        mat[0][2]='X';
                        mat[1][1]='X';
                        mat[2][0]='X';
                        System.out.println("Ha I won!");
                        iwon = true;
                    }
                }
                if (!iwon) {
                    if (potenVict(mat,'O')) //for blocking
                        block(mat);
                    else
                        compMove(mat, x, y); //for placing
                }
            }

            print(mat);
        } 
    }
    

    public void reset(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                mat[i][j]="_";
            }
        }
    }

    public String getName(){
        return "Emma Fu";
    }

    static void playerMove(char[][] mat, int x, int y){
        if(mat[x][y]=='_'){
            mat[x][y]='O';
        }
    }

    static String compMove(char[][] mat, int x, int y){
        System.out.println("->I just went! Your turn :P");
        if(x==y && x==1){
            putInNextCorner(mat);
            // System.out.println("case 0");
        }
        else{
            if(mat[1][1]=='_'){
                mat[1][1]='X';
                return "11";
            }
            else if(((x==0 && y==0) || (x==0 && y==2) || (x==2 && y==0) || (x==2 && y==2))){//if O placed in corner
                    if(mat[1][1]=='_'){
                        mat[1][1]='X';
                        // System.out.println("case 1a");
                        return "11";
                    }
                    else{
                        return putInNextEdge(mat);
                        // System.out.println("case 1b");

                    }
            }
            else if(((x==0 && y==1) || (x==1 && y==2) || (x==2 && y==1) || (x==1 && y==0))){ //if O placed on edge
                    return putCorner(mat, x, y);
                    // System.out.println("case 2");
            }
        }
        return "";
    }

    static String putCorner(char[][] mat, int x, int y) { //anti-Darren
        if(x==2 && y==1) {
            mat[0][2]='X';
            return "02";
        }
        else if(x==0 && y==1) {
            mat[0][0]='X';
            return "00";
        }
        else if(x==1 && y==2) {
            mat[2][2]='X';
            return "22";
        }
        else if(x==1 && y==0) {
            mat[2][0]='X';
            return "20";
        }
        return "";
    }

    static String putInNextCorner(char[][] mat){
        // print(mat);
        if(mat[0][2]=='_'){
            mat[0][2]='X';
            return "02";
        } else if(mat[0][0]=='_'){
            mat[0][0]='X';
            return "00";
        } else if(mat[2][0]=='_'){
            mat[2][0]='X';
            return "20";
        } else if(mat[2][2]=='_'){
            mat[2][2]='X';
            return "22";
        }
        return "";
    }

    static String putInNextEdge(char[][] mat){
        if(mat[1][2]=='_'){
            mat[1][2]='X';
            return "12";
        } else if(mat[0][1]=='_'){
            mat[0][1]='X';
            return "01";
        } else if(mat[1][0]=='_'){
            return "10";
        } else if(mat[2][2]=='_'){
            return "22";
        }
        return "";
    }

   static String block(char[][] mat){
        // print(mat);
        boolean flag = false;
        System.out.println("->I block you >:)");
        for(int i = 0; i<mat.length && flag==false;i++) {
            if(potenVictCol(mat, i, 'O') && findSpaceCol(mat, i)!=3){
                // System.out.println("i is this " +i);
                // System.out.println("text find space "+findSpaceCol(mat, i));
                mat[findSpaceCol(mat, i)][i]='X';
                flag = true;

                String a = Integer.toString(findSpaceCol(mat, i));
                String b = Integer.toString(i);
                return a+b;
                //System.out.println("cc1");               
            }
            else if(potenVictRow(mat, i, 'O') && findSpaceRow(mat, i)!=3){
                mat[i][findSpaceRow(mat, i)]='X';
                //System.out.println("cc2");
                flag = true;

                String a = Integer.toString(i);
                String b = Integer.toString(findSpaceRow(mat, i));
                return a+b;
            }
            else if(potenVictDiag1(mat, 'O') && findSpaceDiag1(mat)!=3){
                mat[findSpaceDiag1(mat)][findSpaceDiag1(mat)]='X';
                //System.out.println("cc3");
                flag = true;
                String a = Integer.toString(findSpaceDiag1(mat));
                return a+a;
            }
            else if(potentVictDiag2(mat, 'O') && findSpaceDiag2(mat)!=3){
                mat[findSpaceDiag2(mat)][2-findSpaceDiag2(mat)]='X';
                //System.out.println("cc4");
                flag = true;
                String a = Integer.toString(findSpaceDiag1(mat));
                String b = Integer.toString(2-findSpaceDiag2(mat));
                return a+b;
            }
        }
        return "";
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
}