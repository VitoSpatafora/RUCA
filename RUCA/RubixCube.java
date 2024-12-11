public class RubixCube {
    public char[][] white = {
        {'w', 'w', 'w'},
        {'w', 'w', 'w'},
        {'w', 'w', 'w'},
    };
    public char[][] red = {
        {'r', 'r', 'r'},
        {'r', 'r', 'r'},
        {'r', 'r', 'r'},
    };
    public char[][] blue = {
        {'b', 'b', 'b'},
        {'b', 'b', 'b'},
        {'b', 'b', 'b'},
    };
    public char[][] green = {
        {'g', 'g', 'g'},
        {'g', 'g', 'g'},
        {'g', 'g', 'g'},
    };
    public char[][] orange = {
        {'o', 'o', 'o'},
        {'o', 'o', 'o'},
        {'o', 'o', 'o'},
    };
    public char[][] yellow = {
        {'y', 'y', 'y'},
        {'y', 'y', 'y'},
        {'y', 'y', 'y'},
    };
    public char[][][] rubix;
    public char[][][] sidesArray;
    public char[][][] horArray;
    public char[][][] vertArray;

    // Constructor to initialize the cube
    public RubixCube() {
        rubix = new char[][][]{
            white, red, blue, green, orange, yellow
        };
        sidesArray = new char[][][]{
            blue,red,green,orange
        };
        horArray = new char[][][]{
            blue,yellow,green,white
        };
        vertArray = new char[][][]{
            red,yellow,orange,white
        };
    }
    

    public void printCube() {
        rotateCounterClockwise(green);
        for (int i = 0; i < 3; i++) {
            System.out.printf("        %c %c %c%n", red[2-i][2], red[2-i][1], red[2-i][0]);
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%c %c %c   %c %c %c   %c %c %c   %c %c %c%n",
                    blue[2][i], blue[1][i], blue[0][i],
                    white[i][0], white[i][1], white[i][2],
                    green[i][0], green[i][1], green[i][2],
                    yellow[i][0], yellow[i][1], yellow[i][2]);
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.printf("        %c %c %c%n", orange[i][0], orange[i][1], orange[i][2]);
        }
        rotateClockwise(green);
    }
    
    public void rotateClockwise(char[][] matrix) {
        char temp = matrix[0][0];
        matrix[0][0] = matrix[2][0];
        matrix[2][0] = matrix[2][2];
        matrix[2][2] = matrix[0][2];
        matrix[0][2] = temp;

        temp = matrix[0][1];
        matrix[0][1] = matrix[1][0];
        matrix[1][0] = matrix[2][1];
        matrix[2][1] = matrix[1][2];
        matrix[1][2] = temp;
    }

    public void rotateCounterClockwise(char[][] matrix){
        for(int i=0;i<3;i++){
            rotateClockwise(matrix);
        }
    }
    
    public void moveF(){
        rotateClockwise(white);
        char[] temp1 = orange[0];
        char[] temp2 = blue[0];
        for(char[][] face : sidesArray){
            temp2 = face[0];
            face[0] = temp1;
            temp1 = temp2;
            
        }
    }
    public void moveFPrime(){
        moveF();
        moveF();
        moveF();
    }

    public void moveB(){
        rotateClockwise(yellow);
        char[] temp1 = blue[2];
        char[] temp2 = orange[2];
        for(int i =3;i>=0;i--){
            temp2 = sidesArray[i][2];
            sidesArray[i][2] = temp1;
            temp1 = temp2;
            
        }
    }

    public void moveBPrime(){
        moveB();
        moveB();
        moveB();
    }

    public void moveU(){
        rotateClockwise(red);
        char[] temp1 = white[0];
        white[0] = new char[]{green[0][2],green[1][2],green[2][2]};
        char[] temp2 = new char[]{blue[0][0],blue[1][0],blue[2][0]};
        blue[0][0] = temp1[0];
        blue[1][0] = temp1[1];
        blue[2][0] = temp1[2];
        temp1 = temp2;
        temp2 = yellow[0];
        yellow[0] = temp1;
        temp1 = temp2;
        green[0][2] = temp1[0];
        green[1][2] = temp1[1];
        green[2][2] = temp1[2];

    }

    public void moveUPrime(){
        moveU();
        moveU();
        moveU();
    }

    public void moveD(){
        rotateClockwise(orange);
        char[] temp1 = white[2];
        white[2] = new char[]{blue[0][2],blue[1][2],blue[2][2]};
        char[] temp2 = new char[]{green[0][0],green[1][0],green[2][0]};
        green[0][0] = temp1[0];
        green[1][0] = temp1[1];
        green[2][0] = temp1[2];
        temp1 = temp2;
        temp2 = yellow[2];
        yellow[2] = temp1;
        temp1 = temp2;
        blue[0][2] = temp1[0];
        blue[1][2] = temp1[1];
        blue[2][2] = temp1[2];
    }
    public void moveDPrime(){
        moveD();
        moveD();
        moveD();
    }

    public void moveR(){
        rotateClockwise(green);
        char[] temp1 = new char[]{white[0][2],white[1][2],white[2][2]};
        char[] temp2 = new char[]{red[0][0],red[1][0],red[2][0]};
        red[0][0] = temp1[0];
        red[1][0] = temp1 [1];
        red[2][0] = temp1 [2];
        temp1 = temp2;
        temp2 = new char[]{yellow[0][0],yellow[1][0],yellow[2][0]};
        yellow[0][0] = temp1[0];
        yellow[1][0] = temp1[1];
        yellow[2][0] = temp1[2];
        temp1 = temp2;
        temp2 = new char[]{orange[0][2],orange[1][2],orange[2][2]};
        orange[0][2] = temp1[0];
        orange[1][2] = temp1[1];
        orange[2][2] = temp1[2];
        temp1 = temp2;
        white[0][2] = temp1[0];
        white[1][2] = temp1[1];
        white[2][2] = temp1[2];
    }

    public void moveRPrime(){
        moveR();
        moveR();
        moveR();
    }

    public void moveL(){
        rotateClockwise(blue);
        char[] temp1 = new char[]{white[0][0],white[1][0],white[2][0]};
        char[] temp2 = new char[]{orange[0][0],orange[0][1],orange[0][2]};
        orange[0][0] = temp1[0];
        orange[1][0] = temp1[1];
        orange[2][0] = temp1[2];
        temp1 = temp2;
        temp2 = new char[]{yellow[0][0],yellow[1][0],yellow[2][0]};
        yellow[0][0] = temp1[0];
        yellow[1][0] = temp1[1];
        yellow[2][0] = temp1[2];
        temp1 = temp2;
        temp2 = new char[]{red[0][0],red[1][0],red[2][0]};
        red[0][0] = temp1[0];
        red[1][0] = temp1[1];
        red[2][0] = temp1[2];
        temp1 = temp2;
        white[0][0] = temp1[0];
        white[1][0] = temp1[1];
        white[2][0] = temp2[2];
    }

    public void moveLPrime(){
        moveL();
        moveL();
        moveL();
    }
}


