package jiabin.jogl;

/**
 * Created by lize on 2018/10/29.
 */
public class CubeAnalysis {

    public char[][] up = new char[3][3];
    public char[][] down = new char[3][3];
    public char[][] left = new char[3][3];
    public char[][] right = new char[3][3];
    public char[][] front = new char[3][3];
    public char[][] back = new char[3][3];

    public char[] sequence = new char[200];//
    public int count = 0;


    public CubeAnalysis(char[][] up, char[][] down, char[][] left, char[][] right, char[][] front, char[][] back) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.front = front;
        this.back = back;
    }


    private void Rotate(char[][] surface)
    {
        char t1,t2;
        t1 = surface[0][0];
        t2 = surface[0][1];
        surface[0][0] = surface[2][0];
        surface[0][1] = surface[1][0];
        surface[2][0] = surface[2][2];
        surface[1][0] = surface[2][1];
        surface[2][2] = surface[0][2];
        surface[2][1] = surface[1][2];
        surface[0][2] = t1;
        surface[1][2] = t2;
    }

    private void rotate(char[][] surface)
    {
        char t1,t2;
        t1 = surface[0][2];
        t2 = surface[0][1];
        surface[0][2] = surface[2][2];
        surface[0][1] = surface[1][2];
        surface[2][2] = surface[2][0];
        surface[1][2] = surface[2][1];
        surface[2][0] = surface[0][0];
        surface[2][1] = surface[1][0];
        surface[0][0] = t1;
        surface[1][0] = t2;
    }

    private void X(CubeAnalysis cube, int n)
    {
        char[][] surface = new char[3][3];
        surface = cube.front;
        Rotate(cube.right);
        cube.front = cube.right;
        Rotate(cube.back);
        cube.right = cube.back;
        Rotate(cube.left);
        cube.back = cube.left;
        Rotate(surface);
        cube.left = surface;
        Rotate(cube.up);
        rotate(cube.down);

        sequence[count] = 'X';
        count++;
    }

    private void x(CubeAnalysis cube, int n)
    {
        char[][] surface = new char[3][3];
        surface = cube.front;
        Rotate(cube.left);
        cube.front = cube.left;
        Rotate(cube.back);
        cube.left = cube.back;
        Rotate(cube.right);
        cube.back = cube.right;
        Rotate(surface);
        cube.right = surface;
        rotate(cube.up);
        Rotate(cube.down);

        sequence[count] = 'x';
        count++;

    }

    private void F(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[2][0];
            t2 = cube.up[2][1];
            t3 = cube.up[2][2];
            cube.up[2][0] = cube.left[2][0];
            cube.up[2][1] = cube.left[2][1];
            cube.up[2][2] = cube.left[2][2];
            cube.left[2][0] = cube.down[2][0];
            cube.left[2][1] = cube.down[2][1];
            cube.left[2][2] = cube.down[2][2];
            cube.down[2][0] = cube.right[2][0];
            cube.down[2][1] = cube.right[2][1];
            cube.down[2][2] = cube.right[2][2];
            cube.right[2][0] = t1;
            cube.right[2][1] = t2;
            cube.right[2][2] = t3;
            Rotate(cube.front);

            sequence[count] = 'F';
            count++;
        }
    }

    private void B(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][0];
            t2 = cube.up[0][1];
            t3 = cube.up[0][2];
            cube.up[0][0] = cube.right[0][0];
            cube.up[0][1] = cube.right[0][1];
            cube.up[0][2] = cube.right[0][2];
            cube.right[0][0] = cube.down[0][0];
            cube.right[0][1] = cube.down[0][1];
            cube.right[0][2] = cube.down[0][2];
            cube.down[0][0] = cube.left[0][0];
            cube.down[0][1] = cube.left[0][1];
            cube.down[0][2] = cube.left[0][2];
            cube.left[0][0] = t1;
            cube.left[0][1] = t2;
            cube.left[0][2] = t3;
            Rotate(cube.back);

            sequence[count] = 'B';
            count++;
        }
    }

    private void R(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][2];
            t2 = cube.up[1][2];
            t3 = cube.up[2][2];
            cube.up[0][2] = cube.front[0][2];
            cube.up[1][2] = cube.front[1][2];
            cube.up[2][2] = cube.front[2][2];
            cube.front[2][2] = cube.down[0][0];
            cube.front[1][2] = cube.down[1][0];
            cube.front[0][2] = cube.down[2][0];
            cube.down[0][0] = cube.back[2][2];
            cube.down[1][0] = cube.back[1][2];
            cube.down[2][0] = cube.back[0][2];
            cube.back[0][2] = t1;
            cube.back[1][2] = t2;
            cube.back[2][2] = t3;
            Rotate(cube.right);

            sequence[count] = 'R';
            count++;
        }
    }

    private void L(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][0];
            t2 = cube.up[1][0];
            t3 = cube.up[2][0];
            cube.up[0][0] = cube.back[0][0];
            cube.up[1][0] = cube.back[1][0];
            cube.up[2][0] = cube.back[2][0];
            cube.back[0][0] = cube.down[2][2];
            cube.back[1][0] = cube.down[1][2];
            cube.back[2][0] = cube.down[0][2];
            cube.down[2][2] = cube.front[0][0];
            cube.down[1][2] = cube.front[1][0];
            cube.down[0][2] = cube.front[2][0];
            cube.front[0][0] = t1;
            cube.front[1][0] = t2;
            cube.front[2][0] = t3;
            Rotate(cube.left);

            sequence[count] = 'L';
            count++;
        }
    }

    private void U(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.front[0][0];
            t2 = cube.front[0][1];
            t3 = cube.front[0][2];
            cube.front[0][2] = cube.right[0][0];
            cube.front[0][1] = cube.right[1][0];
            cube.front[0][0] = cube.right[2][0];
            cube.right[0][0] = cube.back[2][0];
            cube.right[1][0] = cube.back[2][1];
            cube.right[2][0] = cube.back[2][2];
            cube.back[2][0] = cube.left[2][2];
            cube.back[2][1] = cube.left[1][2];
            cube.back[2][2] = cube.left[0][2];
            cube.left[0][2] = t1;
            cube.left[1][2] = t2;
            cube.left[2][2] = t3;
            Rotate(cube.up);

            sequence[count] = 'U';
            count++;
        }
    }

    private void D(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.front[2][0];
            t2 = cube.front[2][1];
            t3 = cube.front[2][2];
            cube.front[2][0] = cube.left[0][0];
            cube.front[2][1] = cube.left[1][0];
            cube.front[2][2] = cube.left[2][0];
            cube.left[0][0] = cube.back[0][2];
            cube.left[1][0] = cube.back[0][1];
            cube.left[2][0] = cube.back[0][0];
            cube.back[0][0] = cube.right[0][2];
            cube.back[0][1] = cube.right[1][2];
            cube.back[0][2] = cube.right[2][2];
            cube.right[2][2] = t1;
            cube.right[1][2] = t2;
            cube.right[0][2] = t3;
            Rotate(cube.down);

            sequence[count] = 'D';
            count++;
        }
    }

    private void f(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[2][0];
            t2 = cube.up[2][1];
            t3 = cube.up[2][2];
            cube.up[2][0] = cube.right[2][0];
            cube.up[2][1] = cube.right[2][1];
            cube.up[2][2] = cube.right[2][2];
            cube.right[2][0] = cube.down[2][0];
            cube.right[2][1] = cube.down[2][1];
            cube.right[2][2] = cube.down[2][2];
            cube.down[2][0] = cube.left[2][0];
            cube.down[2][1] = cube.left[2][1];
            cube.down[2][2] = cube.left[2][2];
            cube.left[2][0] = t1;
            cube.left[2][1] = t2;
            cube.left[2][2] = t3;
            rotate(cube.front);

            sequence[count] = 'f';
            count++;
        }
    }

    private void b(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][0];
            t2 = cube.up[0][1];
            t3 = cube.up[0][2];
            cube.up[0][0] = cube.left[0][0];
            cube.up[0][1] = cube.left[0][1];
            cube.up[0][2] = cube.left[0][2];
            cube.left[0][0] = cube.down[0][0];
            cube.left[0][1] = cube.down[0][1];
            cube.left[0][2] = cube.down[0][2];
            cube.down[0][0] = cube.right[0][0];
            cube.down[0][1] = cube.right[0][1];
            cube.down[0][2] = cube.right[0][2];
            cube.right[0][0] = t1;
            cube.right[0][1] = t2;
            cube.right[0][2] = t3;
            rotate(cube.back);

            sequence[count] = 'b';
            count++;
        }
    }

    private void r(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][2];
            t2 = cube.up[1][2];
            t3 = cube.up[2][2];
            cube.up[0][2] = cube.back[0][2];
            cube.up[1][2] = cube.back[1][2];
            cube.up[2][2] = cube.back[2][2];
            cube.back[2][2] = cube.down[0][0];
            cube.back[1][2] = cube.down[1][0];
            cube.back[0][2] = cube.down[2][0];
            cube.down[2][0] = cube.front[0][2];
            cube.down[1][0] = cube.front[1][2];
            cube.down[0][0] = cube.front[2][2];
            cube.front[0][2] = t1;
            cube.front[1][2] = t2;
            cube.front[2][2] = t3;
            rotate(cube.right);

            sequence[count] = 'r';
            count++;
        }
    }

    private void l(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.up[0][0];
            t2 = cube.up[1][0];
            t3 = cube.up[2][0];
            cube.up[0][0] = cube.front[0][0];
            cube.up[1][0] = cube.front[1][0];
            cube.up[2][0] = cube.front[2][0];
            cube.front[0][0] = cube.down[2][2];
            cube.front[1][0] = cube.down[1][2];
            cube.front[2][0] = cube.down[0][2];
            cube.down[2][2] = cube.back[0][0];
            cube.down[1][2] = cube.back[1][0];
            cube.down[0][2] = cube.back[2][0];
            cube.back[0][0] = t1;
            cube.back[1][0] = t2;
            cube.back[2][0] = t3;
            rotate(cube.left);

            sequence[count] = 'l';
            count++;
        }
    }

    private void u(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.front[0][0];
            t2 = cube.front[0][1];
            t3 = cube.front[0][2];
            cube.front[0][0] = cube.left[0][2];
            cube.front[0][1] = cube.left[1][2];
            cube.front[0][2] = cube.left[2][2];
            cube.left[2][2] = cube.back[2][0];
            cube.left[1][2] = cube.back[2][1];
            cube.left[0][2] = cube.back[2][2];
            cube.back[2][0] = cube.right[0][0];
            cube.back[2][1] = cube.right[1][0];
            cube.back[2][2] = cube.right[2][0];
            cube.right[2][0] = t1;
            cube.right[1][0] = t2;
            cube.right[0][0] = t3;
            rotate(cube.up);

            sequence[count] = 'u';
            count++;
        }
    }

    private void d(CubeAnalysis cube, int n)
    {
        char t1,t2,t3;
        for (int i = 0; i < n; i++)
        {
            t1 = cube.front[2][0];
            t2 = cube.front[2][1];
            t3 = cube.front[2][2];
            cube.front[2][0] = cube.right[2][2];
            cube.front[2][1] = cube.right[1][2];
            cube.front[2][2] = cube.right[0][2];
            cube.right[2][2] = cube.back[0][2];
            cube.right[1][2] = cube.back[0][1];
            cube.right[0][2] = cube.back[0][0];
            cube.back[0][0] = cube.left[2][0];
            cube.back[0][1] = cube.left[1][0];
            cube.back[0][2] = cube.left[0][0];
            cube.left[0][0] = t1;
            cube.left[1][0] = t2;
            cube.left[2][0] = t3;
            rotate(cube.down);

            sequence[count] = 'd';
            count++;
        }
    }

    private void exp1(CubeAnalysis cube)
    {
        while ((cube.front[1][0] == cube.down[1][1]) || (cube.front[1][2] == cube.down[1][1]) || (cube.right[0][1] == cube.down[1][1]) || (cube.right[2][1] == cube.down[1][1]) || (cube.back[1][0] == cube.down[1][1]) || (cube.back[1][2] == cube.down[1][1]) || (cube.left[0][1] == cube.down[1][1]) || (cube.left[2][1] == cube.down[1][1]))
        {
            if (cube.front[1][0] == cube.down[1][1])
            {
                while (cube.up[1][0] == cube.down[1][1])
                cube.U(cube,1);
                cube.l(cube,1);
            }
            else if (cube.front[1][2] == cube.down[1][1])
            {
                while (cube.up[1][2] == cube.down[1][1])
                cube.U(cube,1);
                cube.R(cube,1);
            }
            else if (cube.right[2][1] == cube.down[1][1])
            {
                while (cube.up[2][1] == cube.down[1][1])
                cube.U(cube,1);
                cube.f(cube,1);
            }
            else if (cube.right[0][1] == cube.down[1][1])
            {
                while (cube.up[0][1] == cube.down[1][1])
                cube.U(cube,1);
                cube.B(cube,1);
            }
            else if (cube.back[1][0] == cube.down[1][1])
            {
                while (cube.up[1][0] == cube.down[1][1])
                cube.U(cube,1);
                cube.L(cube,1);
            }
            else if (cube.back[1][2] == cube.down[1][1])
            {
                while (cube.up[1][2] == cube.down[1][1])
                cube.U(cube,1);
                cube.r(cube,1);
            }
            else if (cube.left[0][1] == cube.down[1][1])
            {
                while (cube.up[0][1] == cube.down[1][1])
                cube.U(cube,1);
                cube.b(cube,1);
            }
            else
            {
                while (cube.up[2][1] == cube.down[1][1])
                cube.U(cube,1);
                cube.F(cube,1);
            }
        }
    }

    public String[] cut(CubeAnalysis cube)
    {
        String[] str = new String[200];
        int t = 1,k = 0;
        for (int i = 0; cube.sequence[i] != '\0'; i++)
        {
            if (cube.sequence[i] == cube.sequence[i + 1] + 32 || cube.sequence[i] == cube.sequence[i + 1] - 32 || cube.sequence[i] == cube.sequence[i + 1])
            {
                if (cube.sequence[i] == cube.sequence[i + 1])
                    t++;
                else
                    t--;
            }
            else
            {
                if (t == 0 || t == 4)
                {
                    t = 1;
                    continue;
                }
                else if (t % 3 == 0)
                {
                    if (cube.sequence[i] > 'Z')
                    str[k] = String.valueOf(cube.sequence[i]).toUpperCase() + String.valueOf((t - 2) * 90);
                    else
                    str[k] = String.valueOf(cube.sequence[i]).toLowerCase()  + String.valueOf((t - 2)* 90);
                }
                else
                {
                    str[k] = cube.sequence[i] + String.valueOf(t * 90);
                }
                t = 1;
                k++;
            }
        }
        return str;
    }

    public void Cross(CubeAnalysis cube)
    {

        while (!(cube.front[1][1] == cube.front[2][1] && cube.back[1][1] == cube.back[0][1] && cube.left[1][1] == cube.left[1][0] && cube.right[1][1] == cube.right[1][2] && cube.down[1][0] == cube.down[1][1] && cube.down[1][2] == cube.down[1][1] && cube.down[0][1] == cube.down[1][1] && cube.down[2][1] == cube.down[1][1]))
        {

            while ((cube.front[0][1] == cube.down[1][1]) || cube.right[1][0] == cube.down[1][1] || (cube.back[2][1] == cube.down[1][1]) || (cube.left[1][2] == cube.down[1][1]))
            {
                if (cube.front[0][1] == cube.down[1][1])
                {
                    cube.F(cube,1);
                    cube.exp1(cube);
                }
                else if (cube.right[1][0] == cube.down[1][1])
                {
                    cube.R(cube,1);
                    cube.exp1(cube);
                }
                else if (cube.back[2][1] == cube.down[1][1])
                {
                    cube.B(cube,1);
                    cube.exp1(cube);
                }
                else
                {
                    cube.L(cube,1);
                    cube.exp1(cube);
                }
            }
            cube.exp1(cube);

            while ((cube.front[2][1] == cube.down[1][1]) || (cube.right[1][2] == cube.down[1][1]) || (cube.back[0][1] == cube.down[1][1]) || (cube.left[1][0] == cube.down[1][1]))
            {
                if (cube.front[2][1] == cube.down[1][1])
                {
                    while (cube.up[2][1] == cube.down[1][1])
                    cube.U(cube,1);
                    cube.F(cube,1);
                    cube.exp1(cube);
                }
                else if (cube.right[1][2] == cube.down[1][1])
                {
                    while (cube.up[1][2] == cube.down[1][1])
                    cube.U(cube,1);
                    cube.R(cube,1);
                    cube.exp1(cube);
                }
                else if (cube.back[0][1] == cube.down[1][1])
                {
                    while (cube.up[0][1] == cube.down[1][1])
                    cube.U(cube,1);
                    cube.B(cube,1);
                    cube.exp1(cube);
                }
                else
                {
                    while (cube.up[1][0] == cube.down[1][1])
                    cube.U(cube,1);
                    cube.L(cube,1);
                    cube.exp1(cube);
                }
            }

            while ((cube.down[2][1] == cube.down[1][1] && cube.front[2][1] != cube.front[1][1]) || (cube.down[1][2] == cube.down[1][1] && cube.left[1][0] != cube.left[1][1]) || (cube.down[0][1] == cube.down[1][1] && cube.back[0][1] != cube.back[1][1]) || (cube.down[1][0] == cube.down[1][1] && cube.right[1][2] != cube.right[1][1]))
            {
                if (cube.down[2][1] == cube.down[1][1] && cube.front[2][1] != cube.front[1][1])
                {
                    cube.F(cube,1);
                    cube.exp1(cube);
                }
                if (cube.down[1][2] == cube.down[1][1] && cube.left[1][0] != cube.left[1][1])
                {
                    cube.L(cube,1);
                    cube.exp1(cube);
                }
                if (cube.down[0][1] == cube.down[1][1] && cube.back[0][1] != cube.back[1][1])
                {
                    cube.B(cube,1);
                    cube.exp1(cube);
                }
                if (cube.down[1][0] == cube.down[1][1] && cube.right[1][2] != cube.right[1][1])
                {
                    cube.R(cube,1);
                    cube.exp1(cube);
                }
            }

            while (true)
            {
                if (cube.front[0][1] == cube.front[1][1] && cube.up[2][1] == cube.down[1][1])
                cube.F(cube,2);
                else if (cube.left[1][2] == cube.left[1][1] && cube.up[1][0] == cube.down[1][1])
                cube.L(cube,2);
                else if (cube.right[1][0] == cube.right[1][1] && cube.up[1][2] == cube.down[1][1])
                cube.R(cube,2);
                else if (cube.back[2][1] == cube.back[1][1] && cube.up[0][1] == cube.down[1][1])
                cube.B(cube,2);
                else if (((cube.front[1][1] == cube.front[2][1]) && (cube.back[1][1] == cube.back[0][1]) && (cube.left[1][1] == cube.left[1][0]) && (cube.right[1][1] == cube.right[1][2])) && (cube.down[0][1] == cube.down[1][1]) && (cube.down[1][0] == cube.down[1][1]) && (cube.down[1][2] == cube.down[1][1]) && (cube.down[2][1] == cube.down[1][1]))
                break;
                else
                cube.U(cube,1);
            }
        }
    }

    public void F2L(CubeAnalysis cube)
    {

        while (!(cube.down[0][0] == cube.down[1][1] && cube.down[2][0] == cube.down[1][1] && cube.down[0][2] == cube.down[1][1] && cube.down[2][2] == cube.down[1][1] && cube.front[2][0] == cube.front[1][1] && cube.right[2][2] == cube.right[1][1] && cube.back[0][2] == cube.back[1][1] && cube.left[2][0] == cube.left[1][1]))
        {

            if (cube.up[0][0] == cube.down[1][1] || cube.up[0][2] == cube.down[1][1] || cube.up[2][0] == cube.down[1][1] || cube.up[2][2] == cube.down[1][1])
            {
                if (cube.up[2][2] == cube.down[1][1] && cube.front[0][2] == cube.right[1][1] && cube.right[2][0] == cube.front[1][1])
                {
                    cube.R(cube,1);
                    cube.u(cube,1);
                    cube.r(cube,1);
                    cube.f(cube,1);
                    cube.U(cube,2);
                    cube.F(cube,1);
                }
                else if (cube.up[2][0] == cube.down[1][1] && cube.front[0][0] == cube.left[1][1] && cube.left[2][2] == cube.front[1][1])
                {
                    cube.l(cube,1);
                    cube.U(cube,1);
                    cube.L(cube,1);
                    cube.F(cube,1);
                    cube.U(cube,2);
                    cube.f(cube,1);
                }
                else if (cube.up[0][2] == cube.down[1][1] && cube.right[0][0] == cube.back[1][1] && cube.back[2][2] == cube.right[1][1])
                {
                    cube.B(cube,1);
                    cube.u(cube,1);
                    cube.b(cube,1);
                    cube.r(cube,1);
                    cube.U(cube,2);
                    cube.R(cube,1);
                }
                else if (cube.up[0][0] == cube.down[1][1] && cube.left[0][2] == cube.back[1][1] && cube.back[2][0] == cube.left[1][1])
                {
                    cube.b(cube,1);
                    cube.U(cube,1);
                    cube.B(cube,1);
                    cube.L(cube,1);
                    cube.U(cube,2);
                    cube.l(cube,1);
                }
                else
                cube.U(cube,1);
            }

            else if (cube.front[0][0] == cube.down[1][1] || cube.front[0][2] == cube.down[1][1] || cube.back[2][0] == cube.down[1][1] || cube.back[2][2] == cube.down[1][1] || cube.left[0][2] == cube.down[1][1] || cube.left[2][2] == cube.down[1][1] || cube.right[0][0] == cube.down[1][1] || cube.right[2][0] == cube.down[1][1])
            {
                if (cube.front[0][0] == cube.down[1][1] && cube.up[2][0] == cube.front[1][1] && cube.left[2][2] == cube.left[1][1])
                {
                    cube.F(cube,1);
                    cube.U(cube,1);
                    cube.f(cube,1);
                }
                else if (cube.front[0][2] == cube.down[1][1] && cube.up[2][2] == cube.front[1][1] && cube.right[2][0] == cube.right[1][1])
                {
                    cube.f(cube,1);
                    cube.u(cube,1);
                    cube.F(cube,1);
                }
                else if (cube.back[2][0] == cube.down[1][1] && cube.up[0][0] == cube.back[1][1] && cube.left[0][2] == cube.left[1][1])
                {
                    cube.b(cube,1);
                    cube.u(cube,1);
                    cube.B(cube,1);
                }
                else if (cube.back[2][2] == cube.down[1][1] && cube.up[0][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1])
                {
                    cube.B(cube,1);
                    cube.U(cube,1);
                    cube.b(cube,1);
                }
                else if (cube.left[0][2] == cube.down[1][1] && cube.up[0][0] == cube.left[1][1] && cube.back[2][0] == cube.back[1][1])
                {
                    cube.L(cube,1);
                    cube.U(cube,1);
                    cube.l(cube,1);
                }
                else if (cube.left[2][2] == cube.down[1][1] && cube.up[2][0] == cube.left[1][1] && cube.front[0][0] == cube.front[1][1])
                {
                    cube.l(cube,1);
                    cube.u(cube,1);
                    cube.L(cube,1);
                }
                else if (cube.right[0][0] == cube.down[1][1] && cube.up[0][2] == cube.right[1][1] && cube.back[2][2] == cube.back[1][1])
                {
                    cube.r(cube,1);
                    cube.u(cube,1);
                    cube.R(cube,1);
                }
                else if (cube.right[2][0] == cube.down[1][1] && cube.up[2][2] == cube.right[1][1] && cube.front[0][2] == cube.front[1][1])
                {
                    cube.R(cube,1);
                    cube.U(cube,1);
                    cube.r(cube,1);
                }
                else
                cube.U(cube,1);
            }

            else
            {
                if (cube.front[2][2] == cube.down[1][1] || cube.right[2][2] == cube.down[1][1] || (cube.down[2][0] == cube.down[1][1] && (cube.front[2][2] != cube.front[1][1] || cube.right[2][2] != cube.right[1][1])))
                {
                    cube.R(cube,1);
                    cube.U(cube,1);
                    cube.r(cube,1);
                }
                else if (cube.front[2][0] == cube.down[1][1] || cube.left[2][0] == cube.down[1][1] || (cube.down[2][2] == cube.down[1][1] && (cube.front[2][0] != cube.front[1][1] || cube.left[2][0] != cube.left[1][1])))
                {
                    cube.l(cube,1);
                    cube.u(cube,1);
                    cube.L(cube,1);
                }
                else if (cube.left[0][0] == cube.down[1][1] || cube.back[0][0] == cube.down[1][1] || (cube.down[0][2] == cube.down[1][1] && (cube.left[0][0] != cube.left[1][1] || cube.back[0][0] != cube.back[1][1])))
                {
                    cube.b(cube,1);
                    cube.u(cube,1);
                    cube.B(cube,1);
                }
                else
                {
                    cube.B(cube,1);
                    cube.U(cube,1);
                    cube.b(cube,1);
                }
            }
        }

        while (!(cube.front[1][2] == cube.front[1][1] && cube.right[2][1] == cube.right[1][1] && cube.right[0][1] == cube.right[1][1] && cube.back[1][0] == cube.back[1][1] && cube.back[1][2] == cube.back[1][1] && cube.left[0][1] == cube.left[1][1] && cube.left[2][1] == cube.left[1][1] && cube.front[1][0] == cube.front[1][1]))
        {

            if ((cube.up[0][1] != cube.up[1][1] && cube.back[2][1] != cube.up[1][1]) || (cube.up[1][0] != cube.up[1][1] && cube.left[1][2] != cube.up[1][1]) || (cube.up[2][1] != cube.up[1][1] && cube.front[0][1] != cube.up[1][1]) || (cube.up[1][2] != cube.up[1][1] && cube.right[1][0] != cube.up[1][1]))
            {
                if (cube.up[0][1] != cube.up[1][1] && cube.back[2][1] == cube.back[1][1])
                {
                    if (cube.up[0][1] == cube.left[1][1])
                    {
                        cube.U(cube,1);
                        cube.L(cube,1);
                        cube.u(cube,1);
                        cube.l(cube,1);
                        cube.u(cube,1);
                        cube.b(cube,1);
                        cube.U(cube,1);
                        cube.B(cube,1);
                    }
                    else
                    {
                        cube.u(cube,1);
                        cube.r(cube,1);
                        cube.U(cube,1);
                        cube.R(cube,1);
                        cube.U(cube,1);
                        cube.B(cube,1);
                        cube.u(cube,1);
                        cube.b(cube,1);
                    }
                }
                else if (cube.up[1][0] != cube.up[1][1] && cube.left[1][2] == cube.left[1][1])
                {
                    if (cube.up[1][0] == cube.back[1][1])
                    {
                        cube.u(cube,1);
                        cube.b(cube,1);
                        cube.U(cube,1);
                        cube.B(cube,1);
                        cube.U(cube,1);
                        cube.L(cube,1);
                        cube.u(cube,1);
                        cube.l(cube,1);
                    }
                    else
                    {
                        cube.U(cube,1);
                        cube.F(cube,1);
                        cube.u(cube,1);
                        cube.f(cube,1);
                        cube.u(cube,1);
                        cube.l(cube,1);
                        cube.U(cube,1);
                        cube.L(cube,1);
                    }
                }
                else if (cube.up[2][1] != cube.up[1][1] && cube.front[0][1] == cube.front[1][1])
                {
                    if (cube.up[2][1] == cube.right[1][1])
                    {
                        cube.U(cube,1);
                        cube.R(cube,1);
                        cube.u(cube,1);
                        cube.r(cube,1);
                        cube.u(cube,1);
                        cube.f(cube,1);
                        cube.U(cube,1);
                        cube.F(cube,1);
                    }
                    else
                    {
                        cube.u(cube,1);
                        cube.l(cube,1);
                        cube.U(cube,1);
                        cube.L(cube,1);
                        cube.U(cube,1);
                        cube.F(cube,1);
                        cube.u(cube,1);
                        cube.f(cube,1);
                    }
                }
                else if (cube.up[1][2] != cube.up[1][1] && cube.right[1][0] == cube.right[1][1])
                {
                    if (cube.up[1][2] == cube.front[1][1])
                    {
                        cube.u(cube,1);
                        cube.f(cube,1);
                        cube.U(cube,1);
                        cube.F(cube,1);
                        cube.U(cube,1);
                        cube.R(cube,1);
                        cube.u(cube,1);
                        cube.r(cube,1);
                    }
                    else
                    {
                        cube.U(cube,1);
                        cube.B(cube,1);
                        cube.u(cube,1);
                        cube.b(cube,1);
                        cube.u(cube,1);
                        cube.r(cube,1);
                        cube.U(cube,1);
                        cube.R(cube,1);
                    }
                }
                else
                cube.U(cube,1);
            }

            else
            {
                if (cube.front[1][2] != cube.front[1][1])
                {
                    cube.R(cube,1);
                    cube.u(cube,1);
                    cube.r(cube,1);
                    cube.u(cube,1);
                    cube.f(cube,1);
                    cube.U(cube,1);
                    cube.F(cube,1);
                }
                else if (cube.right[0][1] != cube.right[1][1])
                {
                    cube.B(cube,1);
                    cube.u(cube,1);
                    cube.b(cube,1);
                    cube.u(cube,1);
                    cube.r(cube,1);
                    cube.U(cube,1);
                    cube.R(cube,1);
                }
                else if (cube.back[1][0] != cube.back[1][1])
                {
                    cube.L(cube,1);
                    cube.u(cube,1);
                    cube.l(cube,1);
                    cube.u(cube,1);
                    cube.b(cube,1);
                    cube.U(cube,1);
                    cube.B(cube,1);
                }
                else
                {
                    cube.F(cube,1);
                    cube.u(cube,1);
                    cube.f(cube,1);
                    cube.u(cube,1);
                    cube.l(cube,1);
                    cube.U(cube,1);
                    cube.L(cube,1);
                }
            }
        }
    }

    public void OLL(CubeAnalysis cube)
    {
        while (!(cube.up[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1]))
        {
            //OLL1
            if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,2);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL2
            else if (cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
                cube.B(cube,1);
                cube.U(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.b(cube,1);
            }
            //OLL3
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.B(cube,1);
                cube.U(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.b(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL4
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1])
            {
                cube.B(cube,1);
                cube.U(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.U(cube,1);
                cube.b(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
            }
            //OLL5
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
                cube.R(cube,2);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL6
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.f(cube,1);
                cube.U(cube,2);
                cube.f(cube,1);
                cube.L(cube,1);
                cube.F(cube,1);
                cube.l(cube,1);
            }
            //OLL7
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1])
            {
                cube.l(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
                cube.b(cube,1);
                cube.L(cube,1);
                cube.r(cube,2);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL8
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.l(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
                cube.b(cube,1);
                cube.L(cube,2);
                cube.r(cube,2);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            //OLL9
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.L(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            //OLL10
            else if (cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,2);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,2);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL11
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
            }
            //OLL12
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
                cube.B(cube,1);
            }
            //OLL13
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,2);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            //OLL14
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,2);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.l(cube,1);
            }
            //OLL15
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.b(cube,1);
                cube.R(cube,2);
                cube.F(cube,1);
                cube.R(cube,2);
                cube.B(cube,1);
                cube.R(cube,2);
                cube.f(cube,1);
                cube.R(cube,1);
            }
            //OLL16
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,2);
                cube.b(cube,1);
                cube.R(cube,2);
                cube.f(cube,1);
                cube.R(cube,2);
                cube.B(cube,1);
                cube.r(cube,1);
            }
            //OLL17
            else if (cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL18
            else if (cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.b(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.B(cube,1);
            }
            //OLL19
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.F(cube,2);
                cube.l(cube,1);
            }
            //OLL20
            else if (cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.l(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.B(cube,2);
                cube.L(cube,1);
            }
            //OLL21
            else if (cube.back[2][2] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.R(cube,2);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.r(cube,1);
                cube.F(cube,2);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.l(cube,1);
            }
            //OLL22
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.l(cube,1);
                cube.R(cube,2);
                cube.B(cube,1);
                cube.r(cube,1);
                cube.B(cube,1);
                cube.R(cube,1);
                cube.B(cube,2);
                cube.r(cube,1);
                cube.B(cube,1);
                cube.L(cube,1);
                cube.r(cube,1);
            }
            //OLL23
            else if (cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL24
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
            }
            //OLL25
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.l(cube,1);
                cube.B(cube,2);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
                cube.B(cube,1);
                cube.L(cube,1);
            }
            //OLL26
            else if (cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,2);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            //OLL27
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.F(cube,1);
                cube.l(cube,1);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
            }
            //OLL28
            else if (cube.back[2][2] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL29
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,1);
                cube.l(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            //OLL30
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.l(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
            }
            //OLL31
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.U(cube,2);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.f(cube,1);
            }
            //OLL32
            else if (cube.back[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL33
            else if (cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.f(cube,1);
                cube.L(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
            }
            //OLL34
            else if (cube.right[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
            }
            //OLL35
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
            }
            //OLL36
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
            }
            //OLL37
            else if (cube.back[2][2] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.R(cube,2);
                cube.u(cube,1);
                cube.R(cube,2);
                cube.u(cube,1);
                cube.R(cube,2);
                cube.u(cube,2);
                cube.R(cube,1);
            }
            //OLL38
            else if (cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
            }
            //OLL39
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.b(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
            }
            //OLL40
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.u(cube,2);
                cube.R(cube,2);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
            }
            //OLL41
            else if (cube.back[2][1] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL42
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL43
            else if (cube.back[2][1] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.left[0][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.B(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
            }
            //OLL44
            else if (cube.back[2][1] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
            }
            //OLL45
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.B(cube,1);
            }
            //OLL46
            else if (cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
            }
            //OLL47
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //OLL48
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.B(cube,1);
            }
            //OLL49
            else if (cube.back[2][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
            }
            //OLL50
            else if (cube.right[0][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
            }
            //OLL51
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][2] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,2);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL52
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.f(cube,1);
            }
            //OLL53
            else if (cube.back[2][1] == cube.up[1][1] && cube.right[2][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.left[2][2] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1])
            {
                cube.R(cube,2);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.R(cube,2);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
            }
            //OLL54
            else if (cube.back[2][0] == cube.up[1][1] && cube.right[1][0] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
            }
            //OLL55
            else if (cube.back[2][0] == cube.up[1][1] && cube.back[2][1] == cube.up[1][1] && cube.front[0][0] == cube.up[1][1] && cube.left[1][2] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][1] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.b(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
            }
            //OLL56
            else if (cube.right[1][0] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][1] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.L(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
            }
            //OLL57
            else if (cube.back[2][1] == cube.up[1][1] && cube.front[0][1] == cube.up[1][1] && cube.up[0][0] == cube.up[1][1] && cube.up[0][2] == cube.up[1][1] && cube.up[1][0] == cube.up[1][1] && cube.up[1][2] == cube.up[1][1] && cube.up[2][0] == cube.up[1][1] && cube.up[2][2] == cube.up[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
                cube.l(cube,1);
            }
            else
            cube.U(cube,1);
        }
    }

    public void PLL(CubeAnalysis cube)
    {
        int flag = 0;
        while (!(cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.front[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.right[1][1] && cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1]))
        {
            //PLL1
            if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.left[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.right[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.front[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.R(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,2);
            }
            //PLL2
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.front[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.left[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.right[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.R(cube,2);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
            }
            //PLL3
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1] && cube.right[1][0] == cube.left[1][1] && cube.front[0][1] == cube.back[1][1] && cube.left[1][2] == cube.right[1][1] && cube.back[2][1] == cube.front[1][1])
            {
                cube.R(cube,2);
                cube.L(cube,2);
                cube.D(cube,1);
                cube.R(cube,2);
                cube.L(cube,2);
                cube.D(cube,2);
                cube.R(cube,2);
                cube.L(cube,2);
                cube.D(cube,1);
                cube.R(cube,2);
                cube.L(cube,2);
            }
            //PLL4
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1] && cube.right[1][0] == cube.front[1][1] && cube.front[0][1] == cube.right[1][1] && cube.left[1][2] == cube.back[1][1] && cube.back[2][1] == cube.left[1][1])
            {
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,2);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
            }
            //PLL5
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.right[1][1] && cube.right[0][0] == cube.front[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.front[1][1] && cube.front[0][0] == cube.back[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.left[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.right[1][1])
            {
                cube.R(cube,2);
                cube.F(cube,2);
                cube.r(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.F(cube,2);
                cube.r(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
            }
            //PLL6
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.front[1][1] && cube.right[0][0] == cube.left[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.back[1][1] && cube.front[0][0] == cube.right[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.right[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.front[1][1])
            {
                cube.R(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.F(cube,2);
                cube.r(cube,1);
                cube.B(cube,1);
                cube.R(cube,1);
                cube.F(cube,2);
                cube.R(cube,2);
            }
            //PLL7
            else if (cube.back[2][0] == cube.left[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.right[1][1] && cube.right[0][0] == cube.front[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.back[1][1] && cube.front[0][0] == cube.left[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.right[1][1] && cube.left[0][2] == cube.front[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.back[1][1])
            {
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.r(cube,1);
                cube.F(cube,2);
                cube.l(cube,1);
                cube.B(cube,1);
                cube.L(cube,1);
                cube.F(cube,1);
                cube.l(cube,1);
                cube.b(cube,1);
                cube.L(cube,1);
            }
            //PLL8
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.right[1][1] && cube.right[0][0] == cube.front[1][1] && cube.right[1][0] == cube.left[1][1] && cube.right[2][0] == cube.back[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.right[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.right[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,2);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
            }
            //PLL9
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.front[1][1] && cube.back[2][2] == cube.right[1][1] && cube.right[0][0] == cube.front[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.back[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.back[1][1] && cube.front[0][2] == cube.right[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.u(cube,1);
                cube.r(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.R(cube,2);
                cube.f(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.F(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,2);
            }
            //PLL10
            else if (cube.back[2][0] == cube.front[1][1] && cube.back[2][1] == cube.right[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.back[1][1] && cube.right[2][0] == cube.left[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.back[1][1] && cube.left[0][2] == cube.right[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.r(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.b(cube,1);
                cube.D(cube,1);
                cube.b(cube,1);
                cube.d(cube,1);
                cube.B(cube,2);
                cube.r(cube,1);
                cube.b(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.R(cube,1);
            }
            //PLL11
            else if (cube.back[2][0] == cube.front[1][1] && cube.back[2][1] == cube.left[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.left[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.back[1][1] && cube.left[0][2] == cube.right[1][1] && cube.left[1][2] == cube.back[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.F(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.f(cube,1);
            }
            //PLL12
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.front[1][1] && cube.right[2][0] == cube.front[1][1] && cube.front[0][0] == cube.right[1][1] && cube.front[0][1] == cube.right[1][1] && cube.front[0][2] == cube.left[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.front[1][1])
            {
                cube.l(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,2);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.U(cube,2);
                cube.L(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
            }
            //PLL13
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.right[1][1] && cube.right[0][0] == cube.front[1][1] && cube.right[1][0] == cube.front[1][1] && cube.right[2][0] == cube.back[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.right[1][1] && cube.front[0][2] == cube.right[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,2);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
            }
            //PLL14
            else if (cube.back[2][0] == cube.right[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.left[1][1] && cube.right[0][0] == cube.back[1][1] && cube.right[1][0] == cube.front[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.right[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.back[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.r(cube,1);
                cube.U(cube,2);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
                cube.F(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.r(cube,1);
                cube.f(cube,1);
                cube.R(cube,2);
                cube.u(cube,1);
            }
            //PLL15
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.right[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.back[1][1] && cube.right[2][0] == cube.front[1][1] && cube.front[0][0] == cube.right[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.left[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.front[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,2);
                cube.r(cube,1);
                cube.U(cube,2);
                cube.R(cube,1);
                cube.b(cube,1);
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.R(cube,1);
                cube.B(cube,1);
                cube.R(cube,2);
                cube.U(cube,1);
            }
            //PLL16
            else if (cube.back[2][0] == cube.left[1][1] && cube.back[2][1] == cube.back[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.front[1][1] && cube.right[2][0] == cube.left[1][1] && cube.front[0][0] == cube.right[1][1] && cube.front[0][1] == cube.left[1][1] && cube.front[0][2] == cube.back[1][1] && cube.left[0][2] == cube.front[1][1] && cube.left[1][2] == cube.right[1][1] && cube.left[2][2] == cube.front[1][1])
            {
                cube.R(cube,2);
                cube.d(cube,1);
                cube.F(cube,1);
                cube.u(cube,1);
                cube.F(cube,1);
                cube.U(cube,1);
                cube.f(cube,1);
                cube.D(cube,1);
                cube.R(cube,2);
                cube.B(cube,1);
                cube.u(cube,1);
                cube.b(cube,1);
            }
            //PLL17
            else if (cube.back[2][0] == cube.right[1][1] && cube.back[2][1] == cube.left[1][1] && cube.back[2][2] == cube.front[1][1] && cube.right[0][0] == cube.left[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.left[1][1] && cube.front[0][1] == cube.back[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.back[1][1] && cube.left[1][2] == cube.front[1][1] && cube.left[2][2] == cube.back[1][1])
            {
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.F(cube,2);
                cube.d(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.U(cube,1);
                cube.l(cube,1);
                cube.D(cube,1);
                cube.F(cube,2);
            }
            //PLL18
            else if (cube.back[2][0] == cube.right[1][1] && cube.back[2][1] == cube.left[1][1] && cube.back[2][2] == cube.front[1][1] && cube.right[0][0] == cube.left[1][1] && cube.right[1][0] == cube.back[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.left[1][1] && cube.front[0][1] == cube.front[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.back[1][1] && cube.left[1][2] == cube.right[1][1] && cube.left[2][2] == cube.back[1][1])
            {
                cube.R(cube,2);
                cube.D(cube,1);
                cube.b(cube,1);
                cube.U(cube,1);
                cube.b(cube,1);
                cube.u(cube,1);
                cube.B(cube,1);
                cube.d(cube,1);
                cube.R(cube,2);
                cube.f(cube,1);
                cube.U(cube,1);
                cube.F(cube,1);
            }
            //PLL19
            else if (cube.back[2][0] == cube.right[1][1] && cube.back[2][1] == cube.front[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.left[1][1] && cube.front[0][0] == cube.right[1][1] && cube.front[0][1] == cube.left[1][1] && cube.front[0][2] == cube.back[1][1] && cube.left[0][2] == cube.front[1][1] && cube.left[1][2] == cube.back[1][1] && cube.left[2][2] == cube.front[1][1])
            {
                cube.r(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.B(cube,2);
                cube.D(cube,1);
                cube.l(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.L(cube,1);
                cube.d(cube,1);
                cube.B(cube,2);
            }
            //PLL20
            else if (cube.back[2][0] == cube.front[1][1] && cube.back[2][1] == cube.front[1][1] && cube.back[2][2] == cube.back[1][1] && cube.right[0][0] == cube.right[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.left[1][1] && cube.front[0][0] == cube.front[1][1] && cube.front[0][1] == cube.back[1][1] && cube.front[0][2] == cube.back[1][1] && cube.left[0][2] == cube.right[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.left[1][1])
            {
                cube.u(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.l(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.U(cube,2);
                cube.l(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
            }
            //PLL21
            else if (cube.back[2][0] == cube.back[1][1] && cube.back[2][1] == cube.front[1][1] && cube.back[2][2] == cube.front[1][1] && cube.right[0][0] == cube.left[1][1] && cube.right[1][0] == cube.right[1][1] && cube.right[2][0] == cube.right[1][1] && cube.front[0][0] == cube.back[1][1] && cube.front[0][1] == cube.back[1][1] && cube.front[0][2] == cube.front[1][1] && cube.left[0][2] == cube.left[1][1] && cube.left[1][2] == cube.left[1][1] && cube.left[2][2] == cube.right[1][1])
            {
                cube.l(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,2);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.l(cube,1);
                cube.R(cube,1);
                cube.U(cube,1);
                cube.r(cube,1);
                cube.U(cube,2);
                cube.L(cube,1);
                cube.u(cube,1);
                cube.R(cube,1);
                cube.u(cube,1);
            }
            else
            {
                if (flag < 4)
                {
                    cube.U(cube,1);
                    flag++;
                }
                else
                {
                    count -= 4;
                    cube.X(cube,1);
                    flag = 0;
                }
            }
        }
    }
}
