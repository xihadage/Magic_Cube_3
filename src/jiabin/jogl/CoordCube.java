package jiabin.jogl;

public class CoordCube {
    static final short N_TWIST = 2187;
    static final short N_FLIP = 2048;
    static final short N_SLICE1 = 495;
    static final short N_SLICE2 = 24;
    static final short N_PARITY = 2;
    static final short N_URFtoDLF = 20160;
    static final short N_FRtoBR = 11880;
    static final short N_URtoUL = 1320;
    static final short N_UBtoDF = 1320;
    static final short N_URtoDF = 20160;
    static final int N_URFtoDLB = 40320;
    static final int N_URtoBR = 479001600;
    static final short N_MOVE = 18;
    short twist;
    short flip;
    short parity;
    short FRtoBR;
    short URFtoDLF;
    short URtoUL;
    short UBtoDF;
    int URtoDF;
    static short[][] twistMove = new short[2187][18];
    static short[][] flipMove;
    static short[][] parityMove;
    static short[][] FRtoBR_Move;
    static short[][] URFtoDLF_Move;
    static short[][] URtoDF_Move;
    static short[][] URtoUL_Move;
    static short[][] UBtoDF_Move;
    static short[][] MergeURtoULandUBtoDF;
    static byte[] Slice_URFtoDLF_Parity_Prun;
    static byte[] Slice_URtoDF_Parity_Prun;
    static byte[] Slice_Twist_Prun;
    static byte[] Slice_Flip_Prun;

    static {
        CubieCube a = new CubieCube();

        short uBtoDF;
        int i;
        int flip;
        for(uBtoDF = 0; uBtoDF < 2187; ++uBtoDF) {
            a.setTwist(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.cornerMultiply(CubieCube.moveCube[i]);
                    twistMove[uBtoDF][3 * i + flip] = a.getTwist();
                }

                a.cornerMultiply(CubieCube.moveCube[i]);
            }
        }

        flipMove = new short[2048][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 2048; ++uBtoDF) {
            a.setFlip(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.edgeMultiply(CubieCube.moveCube[i]);
                    flipMove[uBtoDF][3 * i + flip] = a.getFlip();
                }

                a.edgeMultiply(CubieCube.moveCube[i]);
            }
        }

        parityMove = new short[][]{{1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0}};
        FRtoBR_Move = new short[11880][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 11880; ++uBtoDF) {
            a.setFRtoBR(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.edgeMultiply(CubieCube.moveCube[i]);
                    FRtoBR_Move[uBtoDF][3 * i + flip] = a.getFRtoBR();
                }

                a.edgeMultiply(CubieCube.moveCube[i]);
            }
        }

        URFtoDLF_Move = new short[20160][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 20160; ++uBtoDF) {
            a.setURFtoDLF(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.cornerMultiply(CubieCube.moveCube[i]);
                    URFtoDLF_Move[uBtoDF][3 * i + flip] = a.getURFtoDLF();
                }

                a.cornerMultiply(CubieCube.moveCube[i]);
            }
        }

        URtoDF_Move = new short[20160][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 20160; ++uBtoDF) {
            a.setURtoDF(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.edgeMultiply(CubieCube.moveCube[i]);
                    URtoDF_Move[uBtoDF][3 * i + flip] = (short)a.getURtoDF();
                }

                a.edgeMultiply(CubieCube.moveCube[i]);
            }
        }

        URtoUL_Move = new short[1320][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 1320; ++uBtoDF) {
            a.setURtoUL(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.edgeMultiply(CubieCube.moveCube[i]);
                    URtoUL_Move[uBtoDF][3 * i + flip] = a.getURtoUL();
                }

                a.edgeMultiply(CubieCube.moveCube[i]);
            }
        }

        UBtoDF_Move = new short[1320][18];
        a = new CubieCube();

        for(uBtoDF = 0; uBtoDF < 1320; ++uBtoDF) {
            a.setUBtoDF(uBtoDF);

            for(i = 0; i < 6; ++i) {
                for(flip = 0; flip < 3; ++flip) {
                    a.edgeMultiply(CubieCube.moveCube[i]);
                    UBtoDF_Move[uBtoDF][3 * i + flip] = a.getUBtoDF();
                }

                a.edgeMultiply(CubieCube.moveCube[i]);
            }
        }

        MergeURtoULandUBtoDF = new short[336][336];

        for(short uRtoUL = 0; uRtoUL < 336; ++uRtoUL) {
            for(uBtoDF = 0; uBtoDF < 336; ++uBtoDF) {
                MergeURtoULandUBtoDF[uRtoUL][uBtoDF] = (short)CubieCube.getURtoDF(uRtoUL, uBtoDF);
            }
        }

        Slice_URFtoDLF_Parity_Prun = new byte[483840];

        int depth;
        for(depth = 0; depth < 483840; ++depth) {
            Slice_URFtoDLF_Parity_Prun[depth] = -1;
        }

        depth = 0;
        setPruning(Slice_URFtoDLF_Parity_Prun, 0, (byte)0);

        int slice;
        int j;
        int newSlice;
        short newFlip;
        short newURtoDF;
        short newParity;
        int done;
        for(done = 1; done != 967680; ++depth) {
            for(i = 0; i < 967680; ++i) {
                flip = i % 2;
                slice = i / 2 / 24;
                j = i / 2 % 24;
                if (getPruning(Slice_URFtoDLF_Parity_Prun, i) == depth) {
                    newSlice = 0;

                    while(newSlice < 18) {
                        switch(newSlice) {
                            case 4:
                            case 7:
                            case 9:
                            case 10:
                            case 11:
                            case 13:
                            case 16:
                            default:
                                newFlip = FRtoBR_Move[j][newSlice];
                                newURtoDF = URFtoDLF_Move[slice][newSlice];
                                newParity = parityMove[flip][newSlice];
                                if (getPruning(Slice_URFtoDLF_Parity_Prun, (24 * newURtoDF + newFlip) * 2 + newParity) == 15) {
                                    setPruning(Slice_URFtoDLF_Parity_Prun, (24 * newURtoDF + newFlip) * 2 + newParity, (byte)(depth + 1));
                                    ++done;
                                }
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                ++newSlice;
                        }
                    }
                }
            }
        }

        Slice_URtoDF_Parity_Prun = new byte[483840];

        for(depth = 0; depth < 483840; ++depth) {
            Slice_URtoDF_Parity_Prun[depth] = -1;
        }

        depth = 0;
        setPruning(Slice_URtoDF_Parity_Prun, 0, (byte)0);

        for(done = 1; done != 967680; ++depth) {
            for(i = 0; i < 967680; ++i) {
                flip = i % 2;
                slice = i / 2 / 24;
                j = i / 2 % 24;
                if (getPruning(Slice_URtoDF_Parity_Prun, i) == depth) {
                    newSlice = 0;

                    while(newSlice < 18) {
                        switch(newSlice) {
                            case 4:
                            case 7:
                            case 9:
                            case 10:
                            case 11:
                            case 13:
                            case 16:
                            default:
                                newFlip = FRtoBR_Move[j][newSlice];
                                newURtoDF = URtoDF_Move[slice][newSlice];
                                newParity = parityMove[flip][newSlice];
                                if (getPruning(Slice_URtoDF_Parity_Prun, (24 * newURtoDF + newFlip) * 2 + newParity) == 15) {
                                    setPruning(Slice_URtoDF_Parity_Prun, (24 * newURtoDF + newFlip) * 2 + newParity, (byte)(depth + 1));
                                    ++done;
                                }
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                ++newSlice;
                        }
                    }
                }
            }
        }

        Slice_Twist_Prun = new byte[541283];

        for(depth = 0; depth < 541283; ++depth) {
            Slice_Twist_Prun[depth] = -1;
        }

        depth = 0;
        setPruning(Slice_Twist_Prun, 0, (byte)0);

        for(done = 1; done != 1082565; ++depth) {
            for(i = 0; i < 1082565; ++i) {
                flip = i / 495;
                slice = i % 495;
                if (getPruning(Slice_Twist_Prun, i) == depth) {
                    for(j = 0; j < 18; ++j) {
                        newSlice = FRtoBR_Move[slice * 24][j] / 24;
                        newFlip = twistMove[flip][j];
                        if (getPruning(Slice_Twist_Prun, 495 * newFlip + newSlice) == 15) {
                            setPruning(Slice_Twist_Prun, 495 * newFlip + newSlice, (byte)(depth + 1));
                            ++done;
                        }
                    }
                }
            }
        }

        Slice_Flip_Prun = new byte[506880];

        for(depth = 0; depth < 506880; ++depth) {
            Slice_Flip_Prun[depth] = -1;
        }

        depth = 0;
        setPruning(Slice_Flip_Prun, 0, (byte)0);

        for(done = 1; done != 1013760; ++depth) {
            for(i = 0; i < 1013760; ++i) {
                flip = i / 495;
                slice = i % 495;
                if (getPruning(Slice_Flip_Prun, i) == depth) {
                    for(j = 0; j < 18; ++j) {
                        newSlice = FRtoBR_Move[slice * 24][j] / 24;
                        newFlip = flipMove[flip][j];
                        if (getPruning(Slice_Flip_Prun, 495 * newFlip + newSlice) == 15) {
                            setPruning(Slice_Flip_Prun, 495 * newFlip + newSlice, (byte)(depth + 1));
                            ++done;
                        }
                    }
                }
            }
        }

    }

    CoordCube(CubieCube c) {
        this.twist = c.getTwist();
        this.flip = c.getFlip();
        this.parity = c.cornerParity();
        this.FRtoBR = c.getFRtoBR();
        this.URFtoDLF = c.getURFtoDLF();
        this.URtoUL = c.getURtoUL();
        this.UBtoDF = c.getUBtoDF();
        this.URtoDF = c.getURtoDF();
    }

    void move(int m) {
        this.twist = twistMove[this.twist][m];
        this.flip = flipMove[this.flip][m];
        this.parity = parityMove[this.parity][m];
        this.FRtoBR = FRtoBR_Move[this.FRtoBR][m];
        this.URFtoDLF = URFtoDLF_Move[this.URFtoDLF][m];
        this.URtoUL = URtoUL_Move[this.URtoUL][m];
        this.UBtoDF = UBtoDF_Move[this.UBtoDF][m];
        if (this.URtoUL < 336 && this.UBtoDF < 336) {
            this.URtoDF = MergeURtoULandUBtoDF[this.URtoUL][this.UBtoDF];
        }

    }

    static void setPruning(byte[] table, int index, byte value) {
        if ((index & 1) == 0) {
            table[index / 2] = (byte)(table[index / 2] & (240 | value));
        } else {
            table[index / 2] = (byte)(table[index / 2] & (15 | value << 4));
        }

    }

    static byte getPruning(byte[] table, int index) {
        return (index & 1) == 0 ? (byte)(table[index / 2] & 15) : (byte)((table[index / 2] & 240) >>> 4);
    }
}

