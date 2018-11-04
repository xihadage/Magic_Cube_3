package jiabin.jogl;

public class MagicCube {

    public static final char[][] front = {{'y','o','o'},{'r','r','o'},{'b','b','w'}};
    public static final char[][] back = {{'r','w','w'},{'w','o','b'},{'g','o','g'}};
    public static final char[][] left = {{'y','g','o'},{'w','b','g'},{'r','y','b'}};
    public static final char[][] right = {{'w','r','o'},{'r','g','y'},{'w','w','b'}};
    public static final char[][] up = {{'y','b','r'},{'o','y','g'},{'o','y','b'}};
    public static final char[][] down = {{'g','b','g'},{'g','w','r'},{'r','y','y'}};

    public static Stack resStack=new Stack(500);
    public static Stack resStackReg=new Stack(500);
	public static void main(String[] args) {
        ColorInit.setColor();
        try
        {
            CubeAnalysis mycube=new CubeAnalysis(up,down,left,right,front,back);
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
            String[] str = mycube.cut(mycube);

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
            String[] open={"l90","R90","F180","d180","f90","r90","D90","b180","R180","b90","D90","F90",
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
            }
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
}
