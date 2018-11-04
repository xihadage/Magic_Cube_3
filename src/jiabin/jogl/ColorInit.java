package jiabin.jogl;

import jiabin.object.Block;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lize on 2018/11/4.
 */
public class ColorInit {
    public static Map<String,String> colorMap=new HashMap<String, String>();

    public static void  setColor(){
        //左边一层
        colorMap.put(Block.left+Block.down+Block.back,String.valueOf(MagicCube.left[0][0])+","+String.valueOf(MagicCube.down[0][2])+","+String.valueOf(MagicCube.back[0][0]));//"y,g,r"
        colorMap.put(Block.left+Block.down,String.valueOf(MagicCube.left[1][0])+","+String.valueOf(MagicCube.down[1][2]));//"w,r"
        colorMap.put(Block.left+Block.down+Block.front,String.valueOf(MagicCube.left[2][0])+","+String.valueOf(MagicCube.down[2][2])+","+String.valueOf(MagicCube.front[2][0]));//"r,y,b"

        colorMap.put(Block.left+Block.back,String.valueOf(MagicCube.left[0][1])+","+String.valueOf(MagicCube.back[1][0]));//"g,w"
        colorMap.put(Block.left,String.valueOf(MagicCube.left[1][1]));//"b"
        colorMap.put(Block.left+Block.front,String.valueOf(MagicCube.left[2][1])+","+String.valueOf(MagicCube.front[1][0]));//"y,r"

        colorMap.put(Block.left+Block.up+Block.back,String.valueOf(MagicCube.left[0][2])+","+String.valueOf(MagicCube.up[0][0])+","+String.valueOf(MagicCube.back[2][0]));//"o,y,g"
        colorMap.put(Block.left+Block.up,String.valueOf(MagicCube.left[1][2])+","+String.valueOf(MagicCube.up[1][0]));//"g,o"
        colorMap.put(Block.left+Block.up+Block.front,String.valueOf(MagicCube.left[2][2])+","+String.valueOf(MagicCube.up[2][0])+","+String.valueOf(MagicCube.front[0][0]));//"b,o,y"
        //中间一层
        colorMap.put(Block.down+Block.back,String.valueOf(MagicCube.down[0][1])+","+String.valueOf(MagicCube.back[0][1]));//"b,w"
        colorMap.put(Block.down,String.valueOf(MagicCube.down[1][1]));//"w"
        colorMap.put(Block.down+Block.front,String.valueOf(MagicCube.down[2][1])+","+String.valueOf(MagicCube.front[2][1]));//"y,b"

        colorMap.put(Block.back,String.valueOf(MagicCube.back[1][1]));//"o"
        colorMap.put(Block.front,String.valueOf(MagicCube.front[1][1]));//"r"

        colorMap.put(Block.up+Block.back,String.valueOf(MagicCube.up[0][1])+","+String.valueOf(MagicCube.back[2][1]));//"b,o"
        colorMap.put(Block.up,String.valueOf(MagicCube.up[1][1]));//"y"
        colorMap.put(Block.up+Block.front,String.valueOf(MagicCube.up[2][1])+","+String.valueOf(MagicCube.front[0][1]));//"y,o"
        //右边一层
        colorMap.put(Block.right+Block.down+Block.back,String.valueOf(MagicCube.right[0][2])+","+String.valueOf(MagicCube.down[0][0])+","+String.valueOf(MagicCube.back[0][2]));//"o,g,w"
        colorMap.put(Block.right+Block.down,String.valueOf(MagicCube.right[1][2])+","+String.valueOf(MagicCube.down[1][0]));//"y,g"
        colorMap.put(Block.right+Block.down+Block.front,String.valueOf(MagicCube.right[2][2])+","+String.valueOf(MagicCube.down[2][0])+","+String.valueOf(MagicCube.front[2][2]));//"b,r,w"

        colorMap.put(Block.right+Block.back,String.valueOf(MagicCube.right[0][1])+","+String.valueOf(MagicCube.back[1][2]));//"r,b"
        colorMap.put(Block.right,String.valueOf(MagicCube.right[1][1]));//"g"
        colorMap.put(Block.right+Block.front,String.valueOf(MagicCube.right[2][1])+","+String.valueOf(MagicCube.front[1][2]));//"w,o"

        colorMap.put(Block.right+Block.up+Block.back,String.valueOf(MagicCube.right[0][0])+","+String.valueOf(MagicCube.up[0][2])+","+String.valueOf(MagicCube.back[2][2]));//"w,r,g"
        colorMap.put(Block.right+Block.up,String.valueOf(MagicCube.right[1][0])+","+String.valueOf(MagicCube.up[1][2]));//"r,g"
        colorMap.put(Block.right+Block.up+Block.front,String.valueOf(MagicCube.right[2][0])+","+String.valueOf(MagicCube.up[2][2])+","+String.valueOf(MagicCube.front[0][2]));//"w,b,o"

        //左边一层
/*        colorMap.put(Block.left+Block.down+Block.back,"y,g,r");//
        colorMap.put(Block.left+Block.down,"w,r");//
        colorMap.put(Block.left+Block.down+Block.front,"r,y,b");//

        colorMap.put(Block.left+Block.back,"g,w");
        colorMap.put(Block.left,"b");
        colorMap.put(Block.left+Block.front,"y,r");

        colorMap.put(Block.left+Block.up+Block.back,"o,y,g");
        colorMap.put(Block.left+Block.up,"g,o");
        colorMap.put(Block.left+Block.up+Block.front,"b,o,y");
        //中间一层
        colorMap.put(Block.down+Block.back,"b,w");
        colorMap.put(Block.down,"w");
        colorMap.put(Block.down+Block.front,"y,b");

        colorMap.put(Block.back,"o");
        colorMap.put(Block.front,"r");

        colorMap.put(Block.up+Block.back,"b,o");
        colorMap.put(Block.up,"y");
        colorMap.put(Block.up+Block.front,"y,o");
        //右边一层
        colorMap.put(Block.right+Block.down+Block.back,"o,g,w");
        colorMap.put(Block.right+Block.down,"y,g");
        colorMap.put(Block.right+Block.down+Block.front,"b,r,w");

        colorMap.put(Block.right+Block.back,"r,b");
        colorMap.put(Block.right,"g");
        colorMap.put(Block.right+Block.front,"w,o");

        colorMap.put(Block.right+Block.up+Block.back,"w,r,g");
        colorMap.put(Block.right+Block.up,"r,g");
        colorMap.put(Block.right+Block.up+Block.front,"w,b,o");*/
    }

}
