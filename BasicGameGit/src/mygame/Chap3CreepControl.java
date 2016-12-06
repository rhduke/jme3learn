/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author Ronald
 */
public class Chap3CreepControl extends AbstractControl {
    private Chap3GameState state;
    
    public Chap3CreepControl (Chap3GameState state) {
        this.state = state;
    }
    
    @Override
    protected void controlUpdate(float tpf) {
        
    }
    
    public int getHP() {
        return spatial.getUserData(Chap3GameState.DATAINDEX_HP);
    }
    
    protected void controlRender(RenderManager rm, ViewPort vp) {}
    
    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
