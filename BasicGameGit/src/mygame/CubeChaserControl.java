/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.renderer.*;
import com.jme3.scene.*;
import com.jme3.scene.control.*;

/**
 *
 * @author Ronald
 */
public class CubeChaserControl extends AbstractControl {
    
    @Override
    protected void controlUpdate(float tpf) { 
        spatial.rotate(tpf, tpf, tpf);
    }
    protected void controlRender(RenderManager rm, ViewPort vp) {}
    
    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String hello() {
        return "Hello, my name is " + spatial.getName();
    }
}
