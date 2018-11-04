package jiabin.jogl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import jiabin.object.Selected;

public class KeyHandler extends KeyAdapter{

	private CubeRenderer renderer;  
	  
    public KeyHandler(CubeRenderer renderer, GLDisplay glDisplay) {  
        this.renderer = renderer;  
    }  

    public void keyPressed(KeyEvent e) {  
        processKeyEvent(e, true);  
    }  

    private void processKeyEvent(KeyEvent e, boolean pressed) {  
        switch (e.getKeyCode()) {

            case KeyEvent.VK_A:
                if (!renderer.isRotating()) {
                    renderer.ratate90(false, renderer.getSelected());
                }
                break;

            case KeyEvent.VK_D:
                if (!renderer.isRotating()) {
                    renderer.ratate90(true, renderer.getSelected());
                }
                break;
            case KeyEvent.VK_W:
                if (renderer.getSelected().axis == Selected.X) {
                    renderer.setSelected(
                            new Selected(Selected.Y, renderer.getSelected().index));
                } else if (renderer.getSelected().axis == Selected.Y) {
                    renderer.setSelected(
                            new Selected(Selected.Z, renderer.getSelected().index));
                } else if (renderer.getSelected().axis == Selected.Z) {
                    renderer.setSelected(
                            new Selected(Selected.X, renderer.getSelected().index));
                }
                break;
            case KeyEvent.VK_S:
                renderer.setSelected(
                        new Selected(renderer.getSelected().axis, (renderer.getSelected().index + 1) % 3));
                break;
            case KeyEvent.VK_SPACE:
                break;
            case KeyEvent.VK_UP:
                if (!renderer.isRotating()) {
                    if (!MagicCube.resStack.isEmpty()) {
                        String s = MagicCube.resStack.pop();
                        System.out.println(s);
                        judjeAndRun(s, true);
                        MagicCube.resStackReg.push(s);
                    } else {
                        System.out.println("game over");
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!renderer.isRotating()) {
                    if (!MagicCube.resStackReg.isEmpty()) {
                        String s = MagicCube.resStackReg.pop();
                        System.out.println(s);
                        judjeAndRun(s, false);
                        MagicCube.resStack.push(s);
                    } else {
                        System.out.println("plase start up");
                    }
                }
                break;
        }

    }

    private void judjeAndRun(String s, boolean isNormal) {
        if (s.contains("F")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("f")){
            rMagc(s,false,isNormal);
        }

        else  if (s.contains("B")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("b")){
            rMagc(s,false,isNormal);
        }

        else if (s.contains("L")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("l")){
            rMagc(s,false,isNormal);
        }

        else if (s.contains("R")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("r")){
            rMagc(s,false,isNormal);
        }

        else if (s.contains("U")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("u")){
            rMagc(s,false,isNormal);
        }

        else if (s.contains("D")) {
            rMagc(s,true,isNormal);
        }else if(s.contains("d")){
            rMagc(s,false,isNormal);
        }else if (s.contains("X")) {
/*            renderer.ratate90(true, new Selected(Selected.Y,0));
            renderer.ratate90(true, new Selected(Selected.Y, 1));
            renderer.ratate90(true, new Selected(Selected.Y, 2));
            if(s.contains("180")){
                renderer.ratate90(true, new Selected(Selected.Y, 0));
                renderer.ratate90(true, new Selected(Selected.Y, 1));
                renderer.ratate90(true, new Selected(Selected.Y, 2));
            }*/
            System.out.println("special:"+s);
        }else if(s.contains("x")){
/*            renderer.ratate90(false, new Selected(Selected.Z, 0));
            renderer.ratate90(false, new Selected(Selected.Z, 1));
            renderer.ratate90(false, new Selected(Selected.Z, 2));
            if(s.contains("180")){
                renderer.ratate90(false, new Selected(Selected.Z, 0));
                renderer.ratate90(false, new Selected(Selected.Z, 1));
                renderer.ratate90(false, new Selected(Selected.Z, 2));
            }*/
            System.out.println("special:"+s);
        }
    }

    private void rMagc(String s,boolean dir,boolean isNormal){
        if (dir){
            if (isNormal) {
                if (s.contains("90")){
                    realRotate(s,true);
                }
            } else {
                if (s.contains("90")){
                    realRotate(s, false);
                }
            }
        }else{
            if (isNormal) {
                if (s.contains("90")){
                    realRotate(s,false);
                }
            } else {
                if (s.contains("90")){
                    realRotate(s, true);
                }
            }
        }
    }

    private void realRotate(String s,boolean dir){
        if (s.toUpperCase().contains("F")){
            renderer.ratate90(dir, new Selected(Selected.Z, 2));
        }

        else if(s.toUpperCase().contains("B")){
            renderer.ratate90(dir, new Selected(Selected.Z, 0));
        }

        else if(s.toUpperCase().contains("L")){
            renderer.ratate90(dir, new Selected(Selected.X, 0));
        }

        else if(s.toUpperCase().contains("R")){
            renderer.ratate90(dir, new Selected(Selected.X, 2));
        }

        else if(s.toUpperCase().contains("U")){
            renderer.ratate90(dir, new Selected(Selected.Y, 2));
        }

        else if(s.toUpperCase().contains("D")){
            renderer.ratate90(dir, new Selected(Selected.Y, 0));
        }
    }
}
