package jiabin.jogl;

public class MagicCube {

/*    public static final char[][] front = {{'y','o','o'},{'r','r','o'},{'b','b','w'}};
    public static final char[][] back = {{'r','w','w'},{'w','o','b'},{'g','o','g'}};
    public static final char[][] left = {{'y','g','o'},{'w','b','g'},{'r','y','b'}};
    public static final char[][] right = {{'w','r','o'},{'r','g','y'},{'w','w','b'}};
    public static final char[][] up = {{'y','b','r'},{'o','y','g'},{'o','y','b'}};
    public static final char[][] down = {{'g','b','g'},{'g','w','r'},{'r','y','y'}};*/

    public static final char[][] front = {{'r','o','b'},{'y','r','r'},{'g','b','o'}};
    public static final char[][] back = {{'b','y','w'},{'y','o','w'},{'y','w','g'}};
    public static final char[][] left = {{'y','o','r'},{'o','b','o'},{'o','b','w'}};
    public static final char[][] right = {{'w','g','o'},{'g','g','w'},{'o','y','y'}};
    public static final char[][] up = {{'g','r','r'},{'g','y','r'},{'b','w','w'}};
    public static final char[][] down = {{'g','g','r'},{'b','w','b'},{'b','r','y'}};

/*    private static char[][] r={{'y','b','r','o','y','g','o','y','b'},//up
            {'w','r','w','w','g','r','b','y','o'},//right
            {'y','o','o','r','r','o','b','b','w'},//front
            {'y','y','r','r','w','g','g','b','g'},//down
            {'o','g','b','g','b','y','y','w','r'},//left
            {'g','o','g','b','o','w','w','w','r'}};//back*/
    private static char[][] r={{up[0][0],up[0][1],up[0][2],up[1][0],up[1][1],up[1][2],up[2][0],up[2][1],up[2][2]},//up
            {right[2][0],right[1][0],right[0][0],right[2][1],right[1][1],right[0][1],right[2][2],right[1][2],right[0][2]},//right
            {front[0][0],front[0][1],front[0][2],front[1][0],front[1][1],front[1][2],front[2][0],front[2][1],front[2][2]},//front
            {down[2][2],down[2][1],down[2][0],down[1][2],down[1][1],down[1][0],down[0][2],down[0][1],down[0][0]},//down
            {left[0][2],left[1][2],left[2][2],left[0][1],left[1][1],left[2][1],left[0][0],left[1][0],left[2][0]},//left
            {back[2][2],back[2][1],back[2][0],back[1][2],back[1][1],back[1][0],back[0][2],back[0][1],back[0][0]}};//back
    public static Stack resStack=new Stack(500);
    public static Stack resStackReg=new Stack(500);
	public static void main(String[] args) {
        ColorInit.setColor();
        try
        {
            String resString=solveCube(r);
            String[] res={};
            if (resString!=null){
                res=resString.split(" ");
            }

            for (int i=0;i<res.length;i++){
                String curString=res[res.length-1-i];
                if (curString.contains("L")||curString.contains("B")||curString.contains("D")){
                    if (curString.contains("2")){
                        String sDiv=curString.replace("2", "90").toLowerCase();
                        resStack.push(sDiv);
                        resStack.push(sDiv);
                    }
                    else if (curString.contains("'")){
                        String sDiv=curString.replace("'", "90").toUpperCase();
                        resStack.push(sDiv);
                    }else{
                        String sDiv=curString.toLowerCase()+"90";
                        resStack.push(sDiv);
                    }
                }else{
                    if (curString.contains("2")){
                        String sDiv=curString.replace("2", "90");
                        resStack.push(sDiv);
                        resStack.push(sDiv);
                    }
                    else if (curString.contains("'")){
                        String sDiv=curString.replace("'", "90").toLowerCase();
                        resStack.push(sDiv);
                    }
                    else{
                        String sDiv=curString+"90";
                        resStack.push(sDiv);
                    }
                }
            }

 /*           CubeAnalysis mycube=new CubeAnalysis(up,down,left,right,front,back);
            mycube.count = 0;
            mycube.sequence[0] = '\0';
            //CFOP
            mycube.Cross(mycube);
            System.out.println(mycube.count);

            mycube.F2L(mycube);
            System.out.println(mycube.count);

            mycube.OLL(mycube);
            System.out.println(mycube.count);

            mycube.PLL(mycube);
            System.out.println(mycube.count);

//            char[] a=mycube.sequence;
            String[] str = mycube.cut(mycube);*/

/*            resStack=new Stack(mycube.count);
            resStackReg=new Stack(mycube.count);
            for (int i = 0; i<mycube.count; i++)
            {
                System.out.println(str[i]);
                String s=String.valueOf(str[mycube.count-1-i]);
                if((s!=null)&&(!s.equals(""))) {
                    resStack.push(s);
                }
            }*/

            //open method test
/*            String[] open={"l90","R90","F180","d180","f90","r90","D90","b180","R180","b90","D90","F90",
                    "u90","l180","u90","b180","R180","U90","l180","d90","l180","D90"};
            for (int i = 0; i<open.length; i++)
            {
                String s=open[open.length-1-i];
                if((s!=null)&&(!s.equals(""))) {
                    if (s.contains("180")){
                        String sDiv=s.replace("180", "90");
                        resStack.push(sDiv);
                        resStack.push(sDiv);
                    }else{
                        resStack.push(s);
                    }
                }
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }

		GLDisplay myGLDisplay = GLDisplay.createGLDisplay("Magic Cute");
        CubeRenderer cubeRenderer = new CubeRenderer();  

        KeyHandler keyHandler = new KeyHandler(cubeRenderer, myGLDisplay);
        MouseHandler mouseHander = new MouseHandler(cubeRenderer, myGLDisplay);

        myGLDisplay.addGLEventListener(cubeRenderer);
        myGLDisplay.addKeyListener(keyHandler); 

        myGLDisplay.addMouseMotionListener(mouseHander);
        myGLDisplay.addMouseListener(mouseHander);
        myGLDisplay.start();    
	}

    private static String solveCube(char[][] c) {
        StringBuffer s = new StringBuffer(54);

        int i;
        for(i = 0; i < 54; ++i) {
            s.insert(i, 'B');
        }

        for(i = 0; i < 6; ++i) {
            for(int j = 0; j < 9; ++j) {
                if (c[i][j]== c[0][4]) {
                    s.setCharAt(9 * i + j, 'U');
                }

                if (c[i][j]== c[1][4]) {
                    s.setCharAt(9 * i + j, 'R');
                }

                if (c[i][j] == c[2][4]) {
                    s.setCharAt(9 * i + j, 'F');
                }

                if (c[i][j]== c[3][4]) {
                    s.setCharAt(9 * i + j, 'D');
                }

                if (c[i][j] == c[4][4]) {
                    s.setCharAt(9 * i + j, 'L');
                }

                if (c[i][j]== c[5][4]) {
                    s.setCharAt(9 * i + j, 'B');
                }
            }
        }

        String cubeString = s.toString();
        System.out.println("需解码:"+cubeString);

        String result = Search.solution(cubeString, 200, 100, false);
        if (result.contains("Error")) {
            switch(result.charAt(result.length() - 1)) {
                case '1':
                    result = "颜色不完全!";
                    break;
                case '2':
                    result = "12个边缘不对";
                    break;
                case '3':
                    result = "倒装错误";
                    break;
                case '4':
                    result = "8角不对";
                    break;
                case '5':
                    result = "扭错误";
                    break;
                case '6':
                    result = "奇偶错误";
                    break;
                case '7':
                    result = "不能在限制步骤内完成";
                    break;
                case '8':
                    result = "不能在限制时间内完成";
                default:
                    break;
            }
            System.out.println("解码错误:"+result);
            return null;
        } else {
            System.out.println("解码结果:"+result);
            return result;
        }
    }
}
