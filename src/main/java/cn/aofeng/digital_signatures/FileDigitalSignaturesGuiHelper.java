/**
 * 建立时间:2009-1-27
 */
package cn.aofeng.digital_signatures;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JPopupMenu;

/**
 * 图形界面辅助类：菜单操作.
 * 
 * @author 聂勇 <a href="mailto:aofengblog@163.com>aofengblog@163.com</a>
 */
public class FileDigitalSignaturesGuiHelper {

    public static ResourceBundle resourceBundle = FileDigitalSignaturesGui.resourceBundle;

    /**
     * 弹出菜单缓存池.
     */
    private static Map<String, JPopupMenu> popupMenuCache = new ConcurrentHashMap<String, JPopupMenu>();
    
    /**
     * 增加（缓存）新的弹出菜单对象.
     *  
     * @param key 关键字.
     * @param value 弹出菜单对象.
     * 
     * @return 缓存的弹出菜单对象.
     */
    public static JPopupMenu set(String key, JPopupMenu value) {
        return popupMenuCache.put(key, value);
    }
    
    /**
     * 根据关键字获取弹出菜单对象.
     * 
     * @param key 关键字.
     * @return 关键字对应的缓存弹出菜单对象.
     */
    public static JPopupMenu get(String key) {
        return popupMenuCache.get(key);
    }

}
