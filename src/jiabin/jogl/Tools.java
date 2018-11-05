package jiabin.jogl;

import java.util.Random;

/**
 * @author Administrator
 * @version 1.0
 * @className Tools
 * @description TODO
 * @date 2018/11/5 14:28
 **/
public class Tools {
    public static int verify(String s)
    {
        int[] count = new int[6];
        try
        {
            for (int i = 0; i < 54; i++) {
                count[Color.valueOf(s.substring(i, i + 1)).ordinal()] += 1;
            }
        }
        catch (Exception e)
        {
            return -1;
        }
        for (int i = 0; i < 6; i++) {
            if (count[i] != 9) {
                return -1;
            }
        }
        FaceCube fc = new FaceCube(s);
        CubieCube cc = fc.toCubieCube();
        return cc.verify();
    }

    public static String randomCube()
    {
        CubieCube cc = new CubieCube();
        Random gen = new Random();
        cc.setFlip((short)gen.nextInt(2048));
        cc.setTwist((short)gen.nextInt(2187));
        do
        {
            cc.setURFtoDLB(gen.nextInt(40320));
            cc.setURtoBR(gen.nextInt(479001600));
        } while ((cc.edgeParity() ^ cc.cornerParity()) != 0);
        FaceCube fc = cc.toFaceCube();
        return fc.to_String();
    }
}
