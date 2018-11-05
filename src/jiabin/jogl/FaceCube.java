package jiabin.jogl;

public class FaceCube {
    public Color[] f = new Color[54];
    static final Facelet[][] cornerFacelet;
    static final Facelet[][] edgeFacelet;
    static final Color[][] cornerColor;
    static final Color[][] edgeColor;

    static {
        cornerFacelet = new Facelet[][]{{Facelet.U9, Facelet.R1, Facelet.F3}, {Facelet.U7, Facelet.F1, Facelet.L3}, {Facelet.U1, Facelet.L1, Facelet.B3}, {Facelet.U3, Facelet.B1, Facelet.R3}, {Facelet.D3, Facelet.F9, Facelet.R7}, {Facelet.D1, Facelet.L9, Facelet.F7}, {Facelet.D7, Facelet.B9, Facelet.L7}, {Facelet.D9, Facelet.R9, Facelet.B7}};
        edgeFacelet = new Facelet[][]{{Facelet.U6, Facelet.R2}, {Facelet.U8, Facelet.F2}, {Facelet.U4, Facelet.L2}, {Facelet.U2, Facelet.B2}, {Facelet.D6, Facelet.R8}, {Facelet.D2, Facelet.F8}, {Facelet.D4, Facelet.L8}, {Facelet.D8, Facelet.B8}, {Facelet.F6, Facelet.R4}, {Facelet.F4, Facelet.L6}, {Facelet.B6, Facelet.L4}, {Facelet.B4, Facelet.R6}};
        cornerColor = new Color[][]{{Color.U, Color.R, Color.F}, {Color.U, Color.F, Color.L}, {Color.U, Color.L, Color.B}, {Color.U, Color.B, Color.R}, {Color.D, Color.F, Color.R}, {Color.D, Color.L, Color.F}, {Color.D, Color.B, Color.L}, {Color.D, Color.R, Color.B}};
        edgeColor = new Color[][]{{Color.U, Color.R}, {Color.U, Color.F}, {Color.U, Color.L}, {Color.U, Color.B}, {Color.D, Color.R}, {Color.D, Color.F}, {Color.D, Color.L}, {Color.D, Color.B}, {Color.F, Color.R}, {Color.F, Color.L}, {Color.B, Color.L}, {Color.B, Color.R}};
    }

    FaceCube() {
        String s = "UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB";
        for(int i = 0; i < 54; ++i) {
            this.f[i] = Color.valueOf(s.substring(i, i + 1));
        }
    }

    FaceCube(String cubeString) {
        for(int i = 0; i < cubeString.length(); ++i) {
            this.f[i] = Color.valueOf(cubeString.substring(i, i + 1));
        }

    }

    String to_String() {
        String s = "";

        for(int i = 0; i < 54; ++i) {
            s = s + this.f[i].toString();
        }

        return s;
    }

    CubieCube toCubieCube() {
        CubieCube ccRet = new CubieCube();

        for(int i = 0; i < 8; ++i) {
            ccRet.cp[i] = Corner.URF;
        }

        for(int i = 0; i < 12; ++i) {
            ccRet.ep[i] = Edge.UR;
        }

        Corner[] var8 = Corner.values();
        int var6 = 0;

        int var7;
        int var10;
        int var11;
        for(var7 = var8.length; var6 < var7; ++var6) {
            Corner i = var8[var6];

            byte ori;
            for(ori = 0; ori < 3 && this.f[cornerFacelet[i.ordinal()][ori].ordinal()] != Color.U && this.f[cornerFacelet[i.ordinal()][ori].ordinal()] != Color.D; ++ori) {
                ;
            }

            Color col1 = this.f[cornerFacelet[i.ordinal()][(ori + 1) % 3].ordinal()];
            Color col2 = this.f[cornerFacelet[i.ordinal()][(ori + 2) % 3].ordinal()];
            Corner[] var12 = Corner.values();
            var10 = 0;

            for(var11 = var12.length; var10 < var11; ++var10) {
                Corner j = var12[var10];
                if (col1 == cornerColor[j.ordinal()][1] && col2 == cornerColor[j.ordinal()][2]) {
                    ccRet.cp[i.ordinal()] = j;
                    ccRet.co[i.ordinal()] = (byte)(ori % 3);
                    break;
                }
            }
        }

        Edge[] var15 = Edge.values();
        var6 = 0;

        for(var7 = var15.length; var6 < var7; ++var6) {
            Edge i = var15[var6];
            Edge[] var17 = Edge.values();
            var10 = 0;

            for(var11 = var17.length; var10 < var11; ++var10) {
                Edge j = var17[var10];
                if (this.f[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][0] && this.f[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][1]) {
                    ccRet.ep[i.ordinal()] = j;
                    ccRet.eo[i.ordinal()] = 0;
                    break;
                }

                if (this.f[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][1] && this.f[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][0]) {
                    ccRet.ep[i.ordinal()] = j;
                    ccRet.eo[i.ordinal()] = 1;
                    break;
                }
            }
        }

        return ccRet;
    }
}

