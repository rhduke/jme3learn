package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.math.Quaternion;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;

/**
 * test
 * @author normenhansen
 */
public class Chap2 extends SimpleApplication {

    public static void main(String[] args) {
        Chap2 app = new Chap2();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        Vector3f v = new Vector3f(2.0f, 1.0f,-3.0f);
        float r = FastMath.DEG_TO_RAD * 45f;
        Node pivot = new Node("pivot node");
        
        Quaternion roll040 = new Quaternion();
        Quaternion roll045 = new Quaternion();
        Quaternion roll050 = new Quaternion();
        Quaternion q3 = new Quaternion();
        roll040.fromAngleAxis(40*FastMath.DEG_TO_RAD, Vector3f.UNIT_X);
        roll045.fromAngleAxis(45*FastMath.DEG_TO_RAD, Vector3f.UNIT_X);
        roll050.fromAngleAxis(50*FastMath.DEG_TO_RAD, Vector3f.UNIT_X);
        
        q3.slerp(roll040, roll050, 0.5f);
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        geom.move(0,0,1);
        geom.setLocalScale(0.5f, 1.2f, 0.75f);
        //geom.rotate(r, 0.0f, 0.0f);
        
        
        Box b2 = new Box(1, 1, 1);
        Geometry geom2 = new Geometry("Box", b2);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Yellow);
        geom2.setMaterial(mat2);
        geom2.setLocalTranslation(v);
        geom2.setLocalScale(2.0f);
        //geom2.rotate(0.0f, r, 0.0f);
        //geom2.setLocalRotation(q3);
        
       
        
        rootNode.attachChild(geom);
        rootNode.attachChild(geom2);
        rootNode.attachChild(pivot);
        
        pivot.attachChild(geom);
        pivot.attachChild(geom2);
        pivot.rotate(00, 0, FastMath.DEG_TO_RAD * 45);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
