package jiabin.object;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import jiabin.jogl.ColorInit;

public class Block {

	private Point3D centerPoint;
	private float length;
	
	/**
	 *
	 */
	private Point3D point1=new Point3D();private Point3D point2=new Point3D();
	private Point3D point3=new Point3D();private Point3D point4=new Point3D();
	private Point3D point5=new Point3D();private Point3D point6=new Point3D();
	private Point3D point7=new Point3D();private Point3D point8=new Point3D();
	
	private boolean coloredUp=false;	//�����Ƿ���ɫ
	private boolean coloredDown=false;	//�����Ƿ���ɫ
	private boolean coloredLeft=false;	//�����Ƿ���ɫ
	private boolean coloredRight=false;	//�����Ƿ���ɫ
	private boolean coloredFront=false;	//ǰ���Ƿ���ɫ
	private boolean coloredBack=false;	//�����Ƿ���ɫ
	
	public final static String up="up";
	public final static String down="down";
	public final static String left="left";
	public final static String right="right";
	public final static String front="front";
	public final static String back="back";

    private String colorStr;

    public float[] upColor=new float[3];
    public float[] downColor=new float[3];
    public float[] leftColor=new float[3];
    public float[] rightColor=new float[3];
    public float[] frontColor=new float[3];
    public float[] backColor=new float[3];

    public final static float[] redColor={1f,0f,0f};
    public final static float[] orangeColor={1f,100f/255f,0f};
    public final static float[] blueColor={0f,0f,1f};
    public final static float[] greenColor={0f,1f,0f};
    public final static float[] yellowColor={1f,1f,100f/255f};
    public final static float[] writeColor={1f,1f,1f};
	
	public Block(Point3D centerPoint,float length,String facet){
		this.centerPoint=centerPoint;
		this.length=length;
        this.colorStr= ColorInit.colorMap.get(facet);

		point1.x=centerPoint.x-length/2;
		point1.y=centerPoint.y+length/2;
		point1.z=centerPoint.z+length/2;
		
		point2.x=centerPoint.x-length/2;
		point2.y=centerPoint.y+length/2;
		point2.z=centerPoint.z-length/2;
		
		point3.x=centerPoint.x+length/2;
		point3.y=centerPoint.y+length/2;
		point3.z=centerPoint.z-length/2;
		
		point4.x=centerPoint.x+length/2;
		point4.y=centerPoint.y+length/2;
		point4.z=centerPoint.z+length/2;
		
		point5.x=centerPoint.x-length/2;
		point5.y=centerPoint.y-length/2;
		point5.z=centerPoint.z+length/2;
		
		point6.x=centerPoint.x-length/2;
		point6.y=centerPoint.y-length/2;
		point6.z=centerPoint.z-length/2;
		
		point7.x=centerPoint.x+length/2;
		point7.y=centerPoint.y-length/2;
		point7.z=centerPoint.z-length/2;
		
		point8.x=centerPoint.x+length/2;
		point8.y=centerPoint.y-length/2;
		point8.z=centerPoint.z+length/2;
        String[] cStr={};
        if (colorStr!=null&&!colorStr.equals("")){
            cStr=colorStr.split(",");
        }
        List<String> arr= Arrays.asList(cStr);
        List<String> lists = new ArrayList<String>(arr);

		if (facet.indexOf(left)!=-1) {
			coloredLeft=true;
            leftColor=getColor(lists.get(0));
            lists.remove(0);
		}
		if (facet.indexOf(right)!=-1) {
			coloredRight=true;
            rightColor=getColor(lists.get(0));
            lists.remove(0);
		}
        if (facet.indexOf(down)!=-1) {
            coloredDown=true;
            downColor=getColor(lists.get(0));
            lists.remove(0);
        }
        if (facet.indexOf(up)!=-1) {
            coloredUp=true;
            upColor=getColor(lists.get(0));
            lists.remove(0);
        }
        if (facet.indexOf(back)!=-1) {
            coloredBack=true;
            backColor=getColor(lists.get(0));
            lists.remove(0);
        }
		if (facet.indexOf(front)!=-1) {
			coloredFront=true;
            frontColor=getColor(lists.get(0));
            lists.remove(0);
		}
	}

    private float[] getColor(String c){
        float[] color={0,0,0};
        switch (c){
            case "r":
                color=redColor;
                break;
            case "o":
                color=orangeColor;
                break;
            case "b":
                color=blueColor;
                break;
            case "g":
                color=greenColor;
                break;
            case "y":
                color=yellowColor;
                break;
            case "w":
                color=writeColor;
                break;
            default:
                break;
        }
        return color;
    }
	
	public void draw(GLAutoDrawable glDrawable){
		//
        final GL2 gl2 = glDrawable.getGL().getGL2();  

        gl2.glBegin(GL2.GL_QUADS);  
        Point3D normal;

        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredFront) {
            gl2.glColor3f( frontColor[0],frontColor[1],frontColor[2]);
        }
        gl2.glVertex3f(point1.x, point1.y, point1.z);  
        gl2.glVertex3f(point4.x, point4.y, point4.z);  
        gl2.glVertex3f(point8.x, point8.y, point8.z);  
        gl2.glVertex3f(point5.x, point5.y, point5.z);
        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredBack) {
            gl2.glColor3f( backColor[0],backColor[1],backColor[2]);
        }
        gl2.glVertex3f(point6.x, point6.y, point6.z);  
        gl2.glVertex3f(point2.x, point2.y, point2.z);  
        gl2.glVertex3f(point3.x, point3.y, point3.z);  
        gl2.glVertex3f(point7.x, point7.y, point7.z);  

        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredUp) {
        	gl2.glColor3f( 1f,1f,100f/255f );
            gl2.glColor3f( upColor[0],upColor[1],upColor[2]);
        }
        gl2.glVertex3f(point4.x, point4.y, point4.z);  
        gl2.glVertex3f(point3.x, point3.y, point3.z);  
        gl2.glVertex3f(point2.x, point2.y, point2.z);  
        gl2.glVertex3f(point1.x, point1.y, point1.z);

        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredDown) {
            gl2.glColor3f( downColor[0],downColor[1],downColor[2]);
        }
        gl2.glVertex3f(point5.x, point5.y, point5.z);  
        gl2.glVertex3f(point6.x, point6.y, point6.z);  
        gl2.glVertex3f(point7.x, point7.y, point7.z);  
        gl2.glVertex3f(point8.x, point8.y, point8.z);  

        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredRight) {
            gl2.glColor3f( rightColor[0],rightColor[1],rightColor[2]);
        }
        gl2.glVertex3f(point7.x, point7.y, point7.z);  
        gl2.glVertex3f(point3.x, point3.y, point3.z);  
        gl2.glVertex3f(point4.x, point4.y, point4.z);  
        gl2.glVertex3f(point8.x, point8.y, point8.z);  

        gl2.glColor3f( 0.5f,0.5f,0.5f );
        if (coloredLeft) {
            gl2.glColor3f( leftColor[0],leftColor[1],leftColor[2]);
        }
        gl2.glVertex3f(point1.x, point1.y, point1.z);  
        gl2.glVertex3f(point2.x, point2.y, point2.z);  
        gl2.glVertex3f(point6.x, point6.y, point6.z);  
        gl2.glVertex3f(point5.x, point5.y, point5.z); 
        gl2.glEnd();  
	}
	
	private Point3D getNormal(Point3D point1,Point3D point2,Point3D point3){
		Point3D normal=new Point3D();
		float Ux=point1.x-point2.x; float Uy=point1.y-point2.y; float Uz=point1.z-point2.z;
		float Vx=point2.x-point3.x; float Vy=point2.y-point3.y; float Vz=point2.z-point3.z; 
		normal.x=Ux;
		normal.y=Uy;
		normal.z=Uz;
		return normal;
	}
	
	/**
	 *
	 * @param x
	 * @param y
	 * @param z
	 * @param angle
	 */
	public void rotateXYZ(float x,float y,float z,float angle,boolean clockWise){
		if (!clockWise) {
			point1.rotateXYZ(x, y, z, angle);
			point2.rotateXYZ(x, y, z, angle);
			point3.rotateXYZ(x, y, z, angle);
			point4.rotateXYZ(x, y, z, angle);
			point5.rotateXYZ(x, y, z, angle);
			point6.rotateXYZ(x, y, z, angle);
			point7.rotateXYZ(x, y, z, angle);
			point8.rotateXYZ(x, y, z, angle);
		} else {
			point1.rotateXYZ(x, y, z, -angle);
			point2.rotateXYZ(x, y, z, -angle);
			point3.rotateXYZ(x, y, z, -angle);
			point4.rotateXYZ(x, y, z, -angle);
			point5.rotateXYZ(x, y, z, -angle);
			point6.rotateXYZ(x, y, z, -angle);
			point7.rotateXYZ(x, y, z, -angle);
			point8.rotateXYZ(x, y, z, -angle);
		}
	}
	
	public void drawEdge(GLAutoDrawable glDrawable){
		final GL2 gl2 = glDrawable.getGL().getGL2();
		gl2.glColor3f( 1.0f,0.0f,1.0f );
		gl2.glLineWidth(5.0f);
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point1.x, point1.y, point1.z);
		gl2.glVertex3f(point2.x, point2.y, point2.z);
		gl2.glEnd(); 
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point3.x, point3.y, point3.z);
		gl2.glVertex3f(point2.x, point2.y, point2.z);
		gl2.glEnd(); 
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point1.x, point1.y, point1.z);
		gl2.glVertex3f(point4.x, point4.y, point4.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point3.x, point3.y, point3.z);
		gl2.glVertex3f(point4.x, point4.y, point4.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point1.x, point1.y, point1.z);
		gl2.glVertex3f(point5.x, point5.y, point5.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point4.x, point4.y, point4.z);
		gl2.glVertex3f(point8.x, point8.y, point8.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point3.x, point3.y, point3.z);
		gl2.glVertex3f(point7.x, point7.y, point7.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point2.x, point2.y, point2.z);
		gl2.glVertex3f(point6.x, point6.y, point6.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point5.x, point5.y, point5.z);
		gl2.glVertex3f(point6.x, point6.y, point6.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point6.x, point6.y, point6.z);
		gl2.glVertex3f(point7.x, point7.y, point7.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point7.x, point7.y, point7.z);
		gl2.glVertex3f(point8.x, point8.y, point8.z);
		gl2.glEnd();
		gl2.glBegin(GL2.GL_LINES);
		gl2.glVertex3f(point8.x, point8.y, point8.z);
		gl2.glVertex3f(point5.x, point5.y, point5.z);
		gl2.glEnd();
	}
}
