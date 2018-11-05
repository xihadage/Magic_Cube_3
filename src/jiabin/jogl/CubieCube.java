package jiabin.jogl;

public class CubieCube {
    Corner[] cp;
    byte[] co;
    Edge[] ep;
    byte[] eo;
    private static Corner[] cpU;
    private static byte[] coU;
    private static Edge[] epU;
    private static byte[] eoU;
    private static Corner[] cpR;
    private static byte[] coR;
    private static Edge[] epR;
    private static byte[] eoR;
    private static Corner[] cpF;
    private static byte[] coF;
    private static Edge[] epF;
    private static byte[] eoF;
    private static Corner[] cpD;
    private static byte[] coD;
    private static Edge[] epD;
    private static byte[] eoD;
    private static Corner[] cpL;
    private static byte[] coL;
    private static Edge[] epL;
    private static byte[] eoL;
    private static Corner[] cpB;
    private static byte[] coB;
    private static Edge[] epB;
    private static byte[] eoB;
    static CubieCube[] moveCube;

    static {
        cpU = new Corner[]{Corner.UBR, Corner.URF, Corner.UFL, Corner.ULB, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};
        coU = new byte[8];
        epU = new Edge[]{Edge.UB, Edge.UR, Edge.UF, Edge.UL, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        eoU = new byte[12];
        cpR = new Corner[]{Corner.DFR, Corner.UFL, Corner.ULB, Corner.URF, Corner.DRB, Corner.DLF, Corner.DBL, Corner.UBR};
        coR = new byte[]{2, 0, 0, 1, 1, 0, 0, 2};
        epR = new Edge[]{Edge.FR, Edge.UF, Edge.UL, Edge.UB, Edge.BR, Edge.DF, Edge.DL, Edge.DB, Edge.DR, Edge.FL, Edge.BL, Edge.UR};
        eoR = new byte[12];
        cpF = new Corner[]{Corner.UFL, Corner.DLF, Corner.ULB, Corner.UBR, Corner.URF, Corner.DFR, Corner.DBL, Corner.DRB};
        coF = new byte[]{1, 2, 0, 0, 2, 1, 0, 0};
        epF = new Edge[]{Edge.UR, Edge.FL, Edge.UL, Edge.UB, Edge.DR, Edge.FR, Edge.DL, Edge.DB, Edge.UF, Edge.DF, Edge.BL, Edge.BR};
        eoF = new byte[]{0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0};
        cpD = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DLF, Corner.DBL, Corner.DRB, Corner.DFR};
        coD = new byte[8];
        epD = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DF, Edge.DL, Edge.DB, Edge.DR, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        eoD = new byte[12];
        cpL = new Corner[]{Corner.URF, Corner.ULB, Corner.DBL, Corner.UBR, Corner.DFR, Corner.UFL, Corner.DLF, Corner.DRB};
        coL = new byte[]{0, 1, 2, 0, 0, 2, 1, 0};
        epL = new Edge[]{Edge.UR, Edge.UF, Edge.BL, Edge.UB, Edge.DR, Edge.DF, Edge.FL, Edge.DB, Edge.FR, Edge.UL, Edge.DL, Edge.BR};
        eoL = new byte[12];
        cpB = new Corner[]{Corner.URF, Corner.UFL, Corner.UBR, Corner.DRB, Corner.DFR, Corner.DLF, Corner.ULB, Corner.DBL};
        coB = new byte[]{0, 0, 1, 2, 0, 0, 2, 1};
        epB = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.BR, Edge.DR, Edge.DF, Edge.DL, Edge.BL, Edge.FR, Edge.FL, Edge.UB, Edge.DB};
        eoB = new byte[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1};
        moveCube = new CubieCube[6];
        moveCube[0] = new CubieCube();
        moveCube[0].cp = cpU;
        moveCube[0].co = coU;
        moveCube[0].ep = epU;
        moveCube[0].eo = eoU;
        moveCube[1] = new CubieCube();
        moveCube[1].cp = cpR;
        moveCube[1].co = coR;
        moveCube[1].ep = epR;
        moveCube[1].eo = eoR;
        moveCube[2] = new CubieCube();
        moveCube[2].cp = cpF;
        moveCube[2].co = coF;
        moveCube[2].ep = epF;
        moveCube[2].eo = eoF;
        moveCube[3] = new CubieCube();
        moveCube[3].cp = cpD;
        moveCube[3].co = coD;
        moveCube[3].ep = epD;
        moveCube[3].eo = eoD;
        moveCube[4] = new CubieCube();
        moveCube[4].cp = cpL;
        moveCube[4].co = coL;
        moveCube[4].ep = epL;
        moveCube[4].eo = eoL;
        moveCube[5] = new CubieCube();
        moveCube[5].cp = cpB;
        moveCube[5].co = coB;
        moveCube[5].ep = epB;
        moveCube[5].eo = eoB;
    }

    CubieCube() {
        this.cp = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};
        this.co = new byte[8];
        this.ep = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        this.eo = new byte[12];
    }

    CubieCube(Corner[] cp, byte[] co, Edge[] ep, byte[] eo) {
        this();

        int i;
        for(i = 0; i < 8; ++i) {
            this.cp[i] = cp[i];
            this.co[i] = co[i];
        }

        for(i = 0; i < 12; ++i) {
            this.ep[i] = ep[i];
            this.eo[i] = eo[i];
        }

    }

    static int Cnk(int n, int k) {
        if (n < k) {
            return 0;
        } else {
            if (k > n / 2) {
                k = n - k;
            }

            int s = 1;
            int i = n;

            for(int j = 1; i != n - k; ++j) {
                s *= i;
                s /= j;
                --i;
            }

            return s;
        }
    }

    static void rotateLeft(Corner[] arr, int l, int r) {
        Corner temp = arr[l];

        for(int i = l; i < r; ++i) {
            arr[i] = arr[i + 1];
        }

        arr[r] = temp;
    }

    static void rotateRight(Corner[] arr, int l, int r) {
        Corner temp = arr[r];

        for(int i = r; i > l; --i) {
            arr[i] = arr[i - 1];
        }

        arr[l] = temp;
    }

    static void rotateLeft(Edge[] arr, int l, int r) {
        Edge temp = arr[l];

        for(int i = l; i < r; ++i) {
            arr[i] = arr[i + 1];
        }

        arr[r] = temp;
    }

    static void rotateRight(Edge[] arr, int l, int r) {
        Edge temp = arr[r];

        for(int i = r; i > l; --i) {
            arr[i] = arr[i - 1];
        }

        arr[l] = temp;
    }

    FaceCube toFaceCube() {
        FaceCube fcRet = new FaceCube();
        Corner[] var5 = Corner.values();
        int var3 = 0;

        int var4;
        int i;
        int j;
        byte ori;
        int n;
        for(var4 = var5.length; var3 < var4; ++var3) {
            Corner c = var5[var3];
            i = c.ordinal();
            j = this.cp[i].ordinal();
            ori = this.co[i];

            for(n = 0; n < 3; ++n) {
                fcRet.f[FaceCube.cornerFacelet[i][(n + ori) % 3].ordinal()] = FaceCube.cornerColor[j][n];
            }
        }

        Edge[] var11 = Edge.values();
        var3 = 0;

        for(var4 = var11.length; var3 < var4; ++var3) {
            Edge e = var11[var3];
            i = e.ordinal();
            j = this.ep[i].ordinal();
            ori = this.eo[i];

            for(n = 0; n < 2; ++n) {
                fcRet.f[FaceCube.edgeFacelet[i][(n + ori) % 2].ordinal()] = FaceCube.edgeColor[j][n];
            }
        }

        return fcRet;
    }

    void cornerMultiply(CubieCube b) {
        Corner[] cPerm = new Corner[8];
        byte[] cOri = new byte[8];
        Corner[] var7 = Corner.values();
        int var5 = 0;

        Corner corn;
        int var6;
        for(var6 = var7.length; var5 < var6; ++var5) {
            corn = var7[var5];
            cPerm[corn.ordinal()] = this.cp[b.cp[corn.ordinal()].ordinal()];
            byte oriA = this.co[b.cp[corn.ordinal()].ordinal()];
            byte oriB = b.co[corn.ordinal()];
            byte ori = 0;
            if (oriA < 3 && oriB < 3) {
                ori = (byte)(oriA + oriB);
                if (ori >= 3) {
                    ori = (byte)(ori - 3);
                }
            } else if (oriA < 3 && oriB >= 3) {
                ori = (byte)(oriA + oriB);
                if (ori >= 6) {
                    ori = (byte)(ori - 3);
                }
            } else if (oriA >= 3 && oriB < 3) {
                ori = (byte)(oriA - oriB);
                if (ori < 3) {
                    ori = (byte)(ori + 3);
                }
            } else if (oriA >= 3 && oriB >= 3) {
                ori = (byte)(oriA - oriB);
                if (ori < 0) {
                    ori = (byte)(ori + 3);
                }
            }

            cOri[corn.ordinal()] = ori;
        }

        var7 = Corner.values();
        var5 = 0;

        for(var6 = var7.length; var5 < var6; ++var5) {
            corn = var7[var5];
            this.cp[corn.ordinal()] = cPerm[corn.ordinal()];
            this.co[corn.ordinal()] = cOri[corn.ordinal()];
        }

    }

    void edgeMultiply(CubieCube b) {
        Edge[] ePerm = new Edge[12];
        byte[] eOri = new byte[12];
        Edge[] var7 = Edge.values();
        int var5 = 0;

        Edge e;
        int var6;
        for(var6 = var7.length; var5 < var6; ++var5) {
            e = var7[var5];
            ePerm[e.ordinal()] = this.ep[b.ep[e.ordinal()].ordinal()];
            eOri[e.ordinal()] = (byte)((b.eo[e.ordinal()] + this.eo[b.ep[e.ordinal()].ordinal()]) % 2);
        }

        var7 = Edge.values();
        var5 = 0;

        for(var6 = var7.length; var5 < var6; ++var5) {
            e = var7[var5];
            this.ep[e.ordinal()] = ePerm[e.ordinal()];
            this.eo[e.ordinal()] = eOri[e.ordinal()];
        }

    }

    void multiply(CubieCube b) {
        this.cornerMultiply(b);
    }

    void invCubieCube(CubieCube c) {
        Edge[] var5 = Edge.values();
        int var3 = 0;

        Edge edge;
        int var4;
        for(var4 = var5.length; var3 < var4; ++var3) {
            edge = var5[var3];
            c.ep[this.ep[edge.ordinal()].ordinal()] = edge;
        }

        var5 = Edge.values();
        var3 = 0;

        for(var4 = var5.length; var3 < var4; ++var3) {
            edge = var5[var3];
            c.eo[edge.ordinal()] = this.eo[c.ep[edge.ordinal()].ordinal()];
        }

        Corner[] var8 = Corner.values();
        var3 = 0;

        Corner corn;
        for(var4 = var8.length; var3 < var4; ++var3) {
            corn = var8[var3];
            c.cp[this.cp[corn.ordinal()].ordinal()] = corn;
        }

        var8 = Corner.values();
        var3 = 0;

        for(var4 = var8.length; var3 < var4; ++var3) {
            corn = var8[var3];
            byte ori = this.co[c.cp[corn.ordinal()].ordinal()];
            if (ori >= 3) {
                c.co[corn.ordinal()] = ori;
            } else {
                c.co[corn.ordinal()] = (byte)(-ori);
                if (c.co[corn.ordinal()] < 0) {
                    byte[] var10000 = c.co;
                    int var10001 = corn.ordinal();
                    var10000[var10001] = (byte)(var10000[var10001] + 3);
                }
            }
        }

    }

    short getTwist() {
        short ret = 0;

        for(int i = Corner.URF.ordinal(); i < Corner.DRB.ordinal(); ++i) {
            ret = (short)(3 * ret + this.co[i]);
        }

        return ret;
    }

    void setTwist(short twist) {
        int twistParity = 0;

        for(int i = Corner.DRB.ordinal() - 1; i >= Corner.URF.ordinal(); --i) {
            twistParity += this.co[i] = (byte)(twist % 3);
            twist = (short)(twist / 3);
        }

        this.co[Corner.DRB.ordinal()] = (byte)((3 - twistParity % 3) % 3);
    }

    short getFlip() {
        short ret = 0;

        for(int i = Edge.UR.ordinal(); i < Edge.BR.ordinal(); ++i) {
            ret = (short)(2 * ret + this.eo[i]);
        }

        return ret;
    }

    void setFlip(short flip) {
        int flipParity = 0;

        for(int i = Edge.BR.ordinal() - 1; i >= Edge.UR.ordinal(); --i) {
            flipParity += this.eo[i] = (byte)(flip % 2);
            flip = (short)(flip / 2);
        }

        this.eo[Edge.BR.ordinal()] = (byte)((2 - flipParity % 2) % 2);
    }

    short cornerParity() {
        int s = 0;

        for(int i = Corner.DRB.ordinal(); i >= Corner.URF.ordinal() + 1; --i) {
            for(int j = i - 1; j >= Corner.URF.ordinal(); --j) {
                if (this.cp[j].ordinal() > this.cp[i].ordinal()) {
                    ++s;
                }
            }
        }

        return (short)(s % 2);
    }

    short edgeParity() {
        int s = 0;

        for(int i = Edge.BR.ordinal(); i >= Edge.UR.ordinal() + 1; --i) {
            for(int j = i - 1; j >= Edge.UR.ordinal(); --j) {
                if (this.ep[j].ordinal() > this.ep[i].ordinal()) {
                    ++s;
                }
            }
        }

        return (short)(s % 2);
    }

    short getFRtoBR() {
        int a = 0;
        int x = 0;
        Edge[] edge4 = new Edge[4];

        int b;
        for(b = Edge.BR.ordinal(); b >= Edge.UR.ordinal(); --b) {
            if (Edge.FR.ordinal() <= this.ep[b].ordinal() && this.ep[b].ordinal() <= Edge.BR.ordinal()) {
                a += Cnk(11 - b, x + 1);
                edge4[3 - x++] = this.ep[b];
            }
        }

        b = 0;

        for(int j = 3; j > 0; --j) {
            int k;
            for(k = 0; edge4[j].ordinal() != j + 8; ++k) {
                rotateLeft((Edge[])edge4, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return (short)(24 * a + b);
    }

    void setFRtoBR(short idx) {
        Edge[] sliceEdge = new Edge[]{Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        Edge[] otherEdge = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB};
        int b = idx % 24;
        int a = idx / 24;
        Edge[] var10 = Edge.values();
        int k = 0;

        for(int var9 = var10.length; k < var9; ++k) {
            Edge e = var10[k];
            this.ep[e.ordinal()] = Edge.DB;
        }

        int j;
        for(j = 1; j < 4; ++j) {
            k = b % (j + 1);
            b /= j + 1;

            while(k-- > 0) {
                rotateRight((Edge[])sliceEdge, 0, j);
            }
        }

        int x = 3;

        for(j = Edge.UR.ordinal(); j <= Edge.BR.ordinal(); ++j) {
            if (a - Cnk(11 - j, x + 1) >= 0) {
                this.ep[j] = sliceEdge[3 - x];
                a -= Cnk(11 - j, x-- + 1);
            }
        }

        x = 0;

        for(j = Edge.UR.ordinal(); j <= Edge.BR.ordinal(); ++j) {
            if (this.ep[j] == Edge.DB) {
                this.ep[j] = otherEdge[x++];
            }
        }

    }

    short getURFtoDLF() {
        int a = 0;
        int x = 0;
        Corner[] corner6 = new Corner[6];

        int b;
        for(b = Corner.URF.ordinal(); b <= Corner.DRB.ordinal(); ++b) {
            if (this.cp[b].ordinal() <= Corner.DLF.ordinal()) {
                a += Cnk(b, x + 1);
                corner6[x++] = this.cp[b];
            }
        }

        b = 0;

        for(int j = 5; j > 0; --j) {
            int k;
            for(k = 0; corner6[j].ordinal() != j; ++k) {
                rotateLeft((Corner[])corner6, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return (short)(720 * a + b);
    }

    void setURFtoDLF(short idx) {
        Corner[] corner6 = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF};
        Corner[] otherCorner = new Corner[]{Corner.DBL, Corner.DRB};
        int b = idx % 720;
        int a = idx / 720;
        Corner[] var10 = Corner.values();
        int k = 0;

        for(int var9 = var10.length; k < var9; ++k) {
            Corner c = var10[k];
            this.cp[c.ordinal()] = Corner.DRB;
        }

        int j;
        for(j = 1; j < 6; ++j) {
            k = b % (j + 1);
            b /= j + 1;

            while(k-- > 0) {
                rotateRight((Corner[])corner6, 0, j);
            }
        }

        int x = 5;

        for(j = Corner.DRB.ordinal(); j >= 0; --j) {
            if (a - Cnk(j, x + 1) >= 0) {
                this.cp[j] = corner6[x];
                a -= Cnk(j, x-- + 1);
            }
        }

        x = 0;

        for(j = Corner.URF.ordinal(); j <= Corner.DRB.ordinal(); ++j) {
            if (this.cp[j] == Corner.DRB) {
                this.cp[j] = otherCorner[x++];
            }
        }

    }

    int getURtoDF() {
        int a = 0;
        int x = 0;
        Edge[] edge6 = new Edge[6];

        int b;
        for(b = Edge.UR.ordinal(); b <= Edge.BR.ordinal(); ++b) {
            if (this.ep[b].ordinal() <= Edge.DF.ordinal()) {
                a += Cnk(b, x + 1);
                edge6[x++] = this.ep[b];
            }
        }

        b = 0;

        for(int j = 5; j > 0; --j) {
            int k;
            for(k = 0; edge6[j].ordinal() != j; ++k) {
                rotateLeft((Edge[])edge6, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return 720 * a + b;
    }

    void setURtoDF(int idx) {
        Edge[] edge6 = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF};
        Edge[] otherEdge = new Edge[]{Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        int b = idx % 720;
        int a = idx / 720;
        Edge[] var10 = Edge.values();
        int k = 0;

        for(int var9 = var10.length; k < var9; ++k) {
            Edge e = var10[k];
            this.ep[e.ordinal()] = Edge.BR;
        }

        int j;
        for(j = 1; j < 6; ++j) {
            k = b % (j + 1);
            b /= j + 1;

            while(k-- > 0) {
                rotateRight((Edge[])edge6, 0, j);
            }
        }

        int x = 5;

        for(j = Edge.BR.ordinal(); j >= 0; --j) {
            if (a - Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge6[x];
                a -= Cnk(j, x-- + 1);
            }
        }

        x = 0;

        for(j = Edge.UR.ordinal(); j <= Edge.BR.ordinal(); ++j) {
            if (this.ep[j] == Edge.BR) {
                this.ep[j] = otherEdge[x++];
            }
        }

    }

    public static int getURtoDF(short idx1, short idx2) {
        CubieCube a = new CubieCube();
        CubieCube b = new CubieCube();
        a.setURtoUL(idx1);
        b.setUBtoDF(idx2);

        for(int i = 0; i < 8; ++i) {
            if (a.ep[i] != Edge.BR) {
                if (b.ep[i] != Edge.BR) {
                    return -1;
                }

                b.ep[i] = a.ep[i];
            }
        }

        return b.getURtoDF();
    }

    short getURtoUL() {
        int a = 0;
        int x = 0;
        Edge[] edge3 = new Edge[3];

        int b;
        for(b = Edge.UR.ordinal(); b <= Edge.BR.ordinal(); ++b) {
            if (this.ep[b].ordinal() <= Edge.UL.ordinal()) {
                a += Cnk(b, x + 1);
                edge3[x++] = this.ep[b];
            }
        }

        b = 0;

        for(int j = 2; j > 0; --j) {
            int k;
            for(k = 0; edge3[j].ordinal() != j; ++k) {
                rotateLeft((Edge[])edge3, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return (short)(6 * a + b);
    }

    void setURtoUL(short idx) {
        Edge[] edge3 = new Edge[]{Edge.UR, Edge.UF, Edge.UL};
        int b = idx % 6;
        int a = idx / 6;
        Edge[] var9 = Edge.values();
        int k = 0;

        for(int var8 = var9.length; k < var8; ++k) {
            Edge e = var9[k];
            this.ep[e.ordinal()] = Edge.BR;
        }

        int j;
        for(j = 1; j < 3; ++j) {
            k = b % (j + 1);
            b /= j + 1;

            while(k-- > 0) {
                rotateRight((Edge[])edge3, 0, j);
            }
        }

        int x = 2;

        for(j = Edge.BR.ordinal(); j >= 0; --j) {
            if (a - Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge3[x];
                a -= Cnk(j, x-- + 1);
            }
        }

    }

    short getUBtoDF() {
        int a = 0;
        int x = 0;
        Edge[] edge3 = new Edge[3];

        int b;
        for(b = Edge.UR.ordinal(); b <= Edge.BR.ordinal(); ++b) {
            if (Edge.UB.ordinal() <= this.ep[b].ordinal() && this.ep[b].ordinal() <= Edge.DF.ordinal()) {
                a += Cnk(b, x + 1);
                edge3[x++] = this.ep[b];
            }
        }

        b = 0;

        for(int j = 2; j > 0; --j) {
            int k;
            for(k = 0; edge3[j].ordinal() != Edge.UB.ordinal() + j; ++k) {
                rotateLeft((Edge[])edge3, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return (short)(6 * a + b);
    }

    void setUBtoDF(short idx) {
        Edge[] edge3 = new Edge[]{Edge.UB, Edge.DR, Edge.DF};
        int b = idx % 6;
        int a = idx / 6;
        Edge[] var9 = Edge.values();
        int k = 0;

        for(int var8 = var9.length; k < var8; ++k) {
            Edge e = var9[k];
            this.ep[e.ordinal()] = Edge.BR;
        }

        int j;
        for(j = 1; j < 3; ++j) {
            k = b % (j + 1);
            b /= j + 1;

            while(k-- > 0) {
                rotateRight((Edge[])edge3, 0, j);
            }
        }

        int x = 2;

        for(j = Edge.BR.ordinal(); j >= 0; --j) {
            if (a - Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge3[x];
                a -= Cnk(j, x-- + 1);
            }
        }

    }

    int getURFtoDLB() {
        Corner[] perm = new Corner[8];
        int b = 0;

        int j;
        for(j = 0; j < 8; ++j) {
            perm[j] = this.cp[j];
        }

        for(j = 7; j > 0; --j) {
            int k;
            for(k = 0; perm[j].ordinal() != j; ++k) {
                rotateLeft((Corner[])perm, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return b;
    }

    void setURFtoDLB(int idx) {
        Corner[] perm = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};

        int j;
        for(j = 1; j < 8; ++j) {
            int k = idx % (j + 1);
            idx /= j + 1;

            while(k-- > 0) {
                rotateRight((Corner[])perm, 0, j);
            }
        }

        for(j = 7; j >= 0; --j) {
            this.cp[j] = perm[j--];
        }

    }

    int getURtoBR() {
        Edge[] perm = new Edge[12];
        int b = 0;

        int j;
        for(j = 0; j < 12; ++j) {
            perm[j] = this.ep[j];
        }

        for(j = 11; j > 0; --j) {
            int k;
            for(k = 0; perm[j].ordinal() != j; ++k) {
                rotateLeft((Edge[])perm, 0, j);
            }

            b = (j + 1) * b + k;
        }

        return b;
    }

    void setURtoBR(int idx) {
        Edge[] perm = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};

        for(int j = 1; j < 12; ++j) {
            int k = idx % (j + 1);
            idx /= j + 1;

            while(k-- > 0) {
                rotateRight((Edge[])perm, 0, j);
            }
        }

        for(int j = 11; j >= 0; --j) {
            this.ep[j] = perm[j--];
        }

    }

    int verify() {
        int sum = 0;
        int[] edgeCount = new int[12];
        Edge[] var6 = Edge.values();
        int i = 0;

        int var5;
        for(var5 = var6.length; i < var5; ++i) {
            Edge e = var6[i];
            ++edgeCount[this.ep[e.ordinal()].ordinal()];
        }

        for(i = 0; i < 12; ++i) {
            if (edgeCount[i] != 1) {
                return -2;
            }
        }

        for(i = 0; i < 12; ++i) {
            sum += this.eo[i];
        }

        if (sum % 2 != 0) {
            return -3;
        } else {
            int[] cornerCount = new int[8];
            Corner[] var7 = Corner.values();
            var5 = 0;

            for(int var11 = var7.length; var5 < var11; ++var5) {
                Corner c = var7[var5];
                ++cornerCount[this.cp[c.ordinal()].ordinal()];
            }

            for(i = 0; i < 8; ++i) {
                if (cornerCount[i] != 1) {
                    return -4;
                }
            }

            sum = 0;

            for(i = 0; i < 8; ++i) {
                sum += this.co[i];
            }

            if (sum % 3 != 0) {
                return -5;
            } else {
                return (this.edgeParity() ^ this.cornerParity()) != 0 ? -6 : 0;
            }
        }
    }
}


