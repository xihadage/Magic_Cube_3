package jiabin.jogl;

public class Search {
    static int[] ax = new int[31];
    static int[] po = new int[31];
    static int[] flip = new int[31];
    static int[] twist = new int[31];
    static int[] slice = new int[31];
    static int[] parity = new int[31];
    static int[] URFtoDLF = new int[31];
    static int[] FRtoBR = new int[31];
    static int[] URtoUL = new int[31];
    static int[] UBtoDF = new int[31];
    static int[] URtoDF = new int[31];
    static int[] minDistPhase1 = new int[31];
    static int[] minDistPhase2 = new int[31];

    public Search() {
    }

    static String solutionToString(int length) {
        String s = "";

        for(int i = 0; i < length; ++i) {
            switch(ax[i]) {
                case 0:
                    s = s + "U";
                    break;
                case 1:
                    s = s + "R";
                    break;
                case 2:
                    s = s + "F";
                    break;
                case 3:
                    s = s + "D";
                    break;
                case 4:
                    s = s + "L";
                    break;
                case 5:
                    s = s + "B";
            }

            switch(po[i]) {
                case 1:
                    s = s + " ";
                    break;
                case 2:
                    s = s + "2 ";
                    break;
                case 3:
                    s = s + "' ";
            }
        }

        return s;
    }

    static String solutionToString(int length, int depthPhase1) {
        String s = "";

        for(int i = 0; i < length; ++i) {
            switch(ax[i]) {
                case 0:
                    s = s + "U";
                    break;
                case 1:
                    s = s + "R";
                    break;
                case 2:
                    s = s + "F";
                    break;
                case 3:
                    s = s + "D";
                    break;
                case 4:
                    s = s + "L";
                    break;
                case 5:
                    s = s + "B";
            }

            switch(po[i]) {
                case 1:
                    s = s + " ";
                    break;
                case 2:
                    s = s + "2 ";
                    break;
                case 3:
                    s = s + "' ";
            }

            if (i == depthPhase1 - 1) {
                s = s + ". ";
            }
        }

        return s;
    }

    public static String solution(String facelets, int maxDepth, long timeOut, boolean useSeparator) {
        int[] count = new int[6];

        int i;
        try {
            for(i = 0; i < 54; ++i) {
                ++count[Color.valueOf(facelets.substring(i, i + 1)).ordinal()];
            }
        } catch (Exception var16) {
            return "Error 1";
        }

        for(i = 0; i < 6; ++i) {
            if (count[i] != 9) {
                return "Error 1";
            }
        }

        FaceCube fc = new FaceCube(facelets);
        CubieCube cc = fc.toCubieCube();
        int s;
        if ((s = cc.verify()) != 0) {
            return "Error " + Math.abs(s);
        } else {
            CoordCube c = new CoordCube(cc);
            po[0] = 0;
            ax[0] = 0;
            flip[0] = c.flip;
            twist[0] = c.twist;
            parity[0] = c.parity;
            slice[0] = c.FRtoBR / 24;
            URFtoDLF[0] = c.URFtoDLF;
            FRtoBR[0] = c.FRtoBR;
            URtoUL[0] = c.URtoUL;
            UBtoDF[0] = c.UBtoDF;
            minDistPhase1[1] = 1;
            int n = 0;
            boolean busy = false;
            int depthPhase1 = 1;
            long tStart = System.currentTimeMillis();

            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    if (depthPhase1 - n > minDistPhase1[n + 1] && !busy) {
                                        if (ax[n] != 0 && ax[n] != 3) {
                                            ++n;
                                            ax[n] = 0;
                                        } else {
                                            ++n;
                                            ax[n] = 1;
                                        }

                                        po[n] = 1;
                                    } else if (++po[n] > 3) {
                                        do {
                                            if (++ax[n] > 5) {
                                                if (System.currentTimeMillis() - tStart > timeOut << 10) {
                                                    return "Error 8";
                                                }

                                                if (n == 0) {
                                                    if (depthPhase1 >= maxDepth) {
                                                        return "Error 7";
                                                    }

                                                    ++depthPhase1;
                                                    ax[n] = 0;
                                                    po[n] = 1;
                                                    busy = false;
                                                } else {
                                                    --n;
                                                    busy = true;
                                                }
                                                break;
                                            }

                                            po[n] = 1;
                                            busy = false;
                                        } while(n != 0 && (ax[n - 1] == ax[n] || ax[n - 1] - 3 == ax[n]));
                                    } else {
                                        busy = false;
                                    }
                                } while(busy);

                                int mv = 3 * ax[n] + po[n] - 1;
                                flip[n + 1] = CoordCube.flipMove[flip[n]][mv];
                                twist[n + 1] = CoordCube.twistMove[twist[n]][mv];
                                slice[n + 1] = CoordCube.FRtoBR_Move[slice[n] * 24][mv] / 24;
                                minDistPhase1[n + 1] = Math.max(CoordCube.getPruning(CoordCube.Slice_Flip_Prun, 495 * flip[n + 1] + slice[n + 1]), CoordCube.getPruning(CoordCube.Slice_Twist_Prun, 495 * twist[n + 1] + slice[n + 1]));
                            } while(minDistPhase1[n + 1] != 0);
                        } while(n < depthPhase1 - 5);

                        minDistPhase1[n + 1] = 10;
                    } while(n != depthPhase1 - 1);
                } while((s = totalDepth(depthPhase1, maxDepth)) < 0);
            } while(s != depthPhase1 && (ax[depthPhase1 - 1] == ax[depthPhase1] || ax[depthPhase1 - 1] == ax[depthPhase1] + 3));

            return useSeparator ? solutionToString(s, depthPhase1) : solutionToString(s);
        }
    }

    static int totalDepth(int depthPhase1, int maxDepth) {
        int maxDepthPhase2 = Math.min(10, maxDepth - depthPhase1);

        int depthPhase2;
        int mv;
        for(depthPhase2 = 0; depthPhase2 < depthPhase1; ++depthPhase2) {
            mv = 3 * ax[depthPhase2] + po[depthPhase2] - 1;
            URFtoDLF[depthPhase2 + 1] = CoordCube.URFtoDLF_Move[URFtoDLF[depthPhase2]][mv];
            FRtoBR[depthPhase2 + 1] = CoordCube.FRtoBR_Move[FRtoBR[depthPhase2]][mv];
            parity[depthPhase2 + 1] = CoordCube.parityMove[parity[depthPhase2]][mv];
        }

        byte d1;
        if ((d1 = CoordCube.getPruning(CoordCube.Slice_URFtoDLF_Parity_Prun, (24 * URFtoDLF[depthPhase1] + FRtoBR[depthPhase1]) * 2 + parity[depthPhase1])) > maxDepthPhase2) {
            return -1;
        } else {
            for(depthPhase2 = 0; depthPhase2 < depthPhase1; ++depthPhase2) {
                mv = 3 * ax[depthPhase2] + po[depthPhase2] - 1;
                URtoUL[depthPhase2 + 1] = CoordCube.URtoUL_Move[URtoUL[depthPhase2]][mv];
                UBtoDF[depthPhase2 + 1] = CoordCube.UBtoDF_Move[UBtoDF[depthPhase2]][mv];
            }

            URtoDF[depthPhase1] = CoordCube.MergeURtoULandUBtoDF[URtoUL[depthPhase1]][UBtoDF[depthPhase1]];
            byte d2;
            if ((d2 = CoordCube.getPruning(CoordCube.Slice_URtoDF_Parity_Prun, (24 * URtoDF[depthPhase1] + FRtoBR[depthPhase1]) * 2 + parity[depthPhase1])) > maxDepthPhase2) {
                return -1;
            } else if ((minDistPhase2[depthPhase1] = Math.max(d1, d2)) == 0) {
                return depthPhase1;
            } else {
                depthPhase2 = 1;
                int n = depthPhase1;
                boolean busy = false;
                po[depthPhase1] = 0;
                ax[depthPhase1] = 0;
                minDistPhase2[depthPhase1 + 1] = 1;

                while(true) {
                    if (depthPhase1 + depthPhase2 - n > minDistPhase2[n + 1] && !busy) {
                        if (ax[n] != 0 && ax[n] != 3) {
                            ++n;
                            ax[n] = 0;
                            po[n] = 1;
                        } else {
                            ++n;
                            ax[n] = 1;
                            po[n] = 2;
                        }
                    } else {
                        label107: {
                            label112: {
                                if (ax[n] != 0 && ax[n] != 3) {
                                    if ((po[n] += 2) <= 3) {
                                        break label112;
                                    }
                                } else if (++po[n] <= 3) {
                                    break label112;
                                }

                                while(++ax[n] <= 5) {
                                    if (ax[n] != 0 && ax[n] != 3) {
                                        po[n] = 2;
                                    } else {
                                        po[n] = 1;
                                    }

                                    busy = false;
                                    if (n == depthPhase1 || ax[n - 1] != ax[n] && ax[n - 1] - 3 != ax[n]) {
                                        break label107;
                                    }
                                }

                                if (n == depthPhase1) {
                                    if (depthPhase2 >= maxDepthPhase2) {
                                        return -1;
                                    }

                                    ++depthPhase2;
                                    ax[n] = 0;
                                    po[n] = 1;
                                    busy = false;
                                } else {
                                    --n;
                                    busy = true;
                                }
                                break label107;
                            }

                            busy = false;
                        }
                    }

                    if (!busy) {
                        mv = 3 * ax[n] + po[n] - 1;
                        URFtoDLF[n + 1] = CoordCube.URFtoDLF_Move[URFtoDLF[n]][mv];
                        FRtoBR[n + 1] = CoordCube.FRtoBR_Move[FRtoBR[n]][mv];
                        parity[n + 1] = CoordCube.parityMove[parity[n]][mv];
                        URtoDF[n + 1] = CoordCube.URtoDF_Move[URtoDF[n]][mv];
                        minDistPhase2[n + 1] = Math.max(CoordCube.getPruning(CoordCube.Slice_URtoDF_Parity_Prun, (24 * URtoDF[n + 1] + FRtoBR[n + 1]) * 2 + parity[n + 1]), CoordCube.getPruning(CoordCube.Slice_URFtoDLF_Parity_Prun, (24 * URFtoDLF[n + 1] + FRtoBR[n + 1]) * 2 + parity[n + 1]));
                        if (minDistPhase2[n + 1] == 0) {
                            return depthPhase1 + depthPhase2;
                        }
                    }
                }
            }
        }
    }
}
