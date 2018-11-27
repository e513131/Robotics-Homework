public class EmmaFu implements Player{
    private char[][] mat = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
    public static void main(String[] args){
        
    }

    public String move(String lastMove){
        if(lastMove==null){
            mat[1][1]='X';
            return "11";
        }

        boolean iwon = false;
        int x = 1;
        int y = -1; // move.charAt[1];
                 
            x = Character.getNumericValue(lastMove.charAt(0));
            y = Character.getNumericValue(lastMove.charAt(1));

            playerMove(mat, x, y);

                for(int i = 0; i<mat.length; i++){      //for winning
                    if(potenVictCol(mat, i, 'X')){
                        return Integer.toString(findSpaceCol(mat, i)) + Integer.toString(i);                      
                    }

                    else if(potenVictRow(mat, i, 'X')){
                        return Integer.toString(i) + Integer.toString(findSpaceRow(mat, i));
                    }

                    else if(potenVictDiag1(mat, 'X')){
                        return Integer.toString(findSpaceDiag1(mat)) + Integer.toString(findSpaceDiag1(mat));
                    }

                    else if(potentVictDiag2(mat, 'X')){
                        return Integer.toString(findSpaceDiag2(mat)) + Integer.toString((2-findSpaceDiag2(mat)));
                    }
                }
                if (!iwon) {
                    if (potenVict(mat,'O')) //for blocking
                        return block(mat);
                    else {
                        return compMove(mat, x, y); //for placing
                    }
                }
            return "";
    }
    

    public void reset(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                mat[i][j]='_';
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
        // System.out.println("->I just went! Your turn :P");
        if(x==y && x==1){
            return putInNextEdge(mat);
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
                        if(checkL(mat)!=0){
                            return placeL(mat);
                        }
                        else{
                            return putInNextEdge(mat);
                        }
                        // System.out.println("case 1b");

                    }
            }
            else if(((x==0 && y==1) || (x==1 && y==2) || (x==2 && y==1) || (x==1 && y==0))){ //if O placed on edge
                if(checkL(mat)!=0){
                    return placeL(mat);
                }
                else if(mat[0][0]=='_' || mat[0][2]=='_' || mat[2][2]=='_' || mat[2][0]=='_'){
                    return putCorner(mat, x, y);
                }
                else{
                    return putInNextEdge(mat);
                }
                    // System.out.println("case 2");
            }
        }
        return "";
    }

    static String placeL(char[][] mat){
        if(checkL(mat)==1) {
            mat[0][0]='X';
            return "00";
        }
        else if(checkL(mat)==2) {
            mat[0][2]='X';
            return "02";
        }
        else if(checkL(mat)==3) {
            mat[2][0]='X';
            return "20";
        }
        else if(checkL(mat)==4) {
            mat[2][2]='X';
            return "22";
        }
        return "";
    }

    static int checkL (char[][] mat){
        if(((mat[1][0]=='O' && (mat[0][1]==mat[1][0] || mat[1][0]==mat[0][2])) || (mat[0][1]=='O' && mat[2][0]==mat[0][1])) && mat[0][0]=='_'){
            return 1;
        }
        if(((mat[0][1]=='O' && (mat[0][1]==mat[1][2] || mat[0][1]==mat[2][2])) || (mat[0][0]=='O' && mat[0][0]==mat[1][2])) && mat[0][2]=='_'){
            return 2;
        }
        if(((mat[2][1]=='O' && (mat[0][0]==mat[2][1] || mat[1][0]==mat[2][1])) || (mat[2][2]=='O' && mat[2][2]==mat[1][0])) && mat[2][0]=='_'){
            return 3;
        }
        if(((mat[1][2]=='O' && (mat[1][2]==mat[2][1] || mat[1][2]==mat[2][0])) || (mat[2][1]=='O' && mat[2][1]==mat[0][2])) && mat[2][2]=='_'){
            return 4;
        }
        return 0;
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
        } else if(mat[2][1]=='_'){
            return "21";
        }
        return "";
    }

   static String block(char[][] mat){
        // print(mat);
        boolean flag = false;
        // System.out.println("->I block you >:)");
        for(int i = 0; i<mat.length && flag==false;i++) {
            if(potenVictCol(mat, i, 'O') && findSpaceCol(mat, i)!=3){
                int spaceID = findSpaceCol(mat, i);
                // System.out.println("i is this " +i);
                // System.out.println("text find space "+findSpaceCol(mat, i));
                mat[spaceID][i]='X';
                flag = true;

                String a = Integer.toString(spaceID);
                String b = Integer.toString(i);
                // System.out.println("cc1"); 
                return a+b;              
            }
            else if(potenVictRow(mat, i, 'O') && findSpaceRow(mat, i)!=4){
                int spaceID = findSpaceRow(mat, i);
                mat[i][spaceID]='X';
                // System.out.println("cc2, and " + "i is " + i);
                flag = true;

                String a = Integer.toString(i);
                String b = Integer.toString(spaceID);
                return a+b;
            }

            else if(potenVictDiag1(mat, 'O') && findSpaceDiag1(mat)!=3){
                int spaceID = findSpaceDiag1(mat);
                mat[spaceID][spaceID]='X';
                // System.out.println("cc3");
                flag = true;
                String a = Integer.toString(spaceID);
                return a+a;
            }

            else if(potentVictDiag2(mat, 'O') && findSpaceDiag2(mat)!=3){
                int spaceID = findSpaceDiag2(mat);
                mat[spaceID][2-spaceID]='X';
                // System.out.println("cc4");
                flag = true;
                String a = Integer.toString(spaceID);
                String b = Integer.toString(2-spaceID);
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
        // System.out.println("************");
        // print(mat);
        // System.out.println("************");
        return 4;
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
    static void print(char[][] mat){
        for(int i = 0; i<mat.length; i++){
            System.out.print("|");
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + "|");
            }
            System.out.println();
        }
    }
}