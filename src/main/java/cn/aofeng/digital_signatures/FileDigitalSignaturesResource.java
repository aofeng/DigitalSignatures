/**
 * 建立时间:2009-1-26
 */
package cn.aofeng.digital_signatures;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 资源文件。如国际化资源，图像等。
 * 
 * @author 聂勇 <a href="mailto:aofengblog@163.com>aofengblog@163.com</a>
 */
public class FileDigitalSignaturesResource {

    private FileDigitalSignaturesResource() {
        
    }
    
    /**
     * 关于图标.
     */
    public final static Icon aboutIcon = new ImageIcon(FileDigitalSignaturesResource.class.getResource("/icon/about_16_16.png"));
    
    /**
     * 打开图标.
     */
    public final static Icon openIcon = new ImageIcon(FileDigitalSignaturesResource.class.getResource("/icon/open_16_16.png"));
    
    /**
     * 计算图标.
     */
    public final static Icon calculateIcon = new ImageIcon(FileDigitalSignaturesResource.class.getResource("/icon/cal_16_16.png"));

     /**
     * 保存图标.
     */
    public final static Icon saveIcon = new ImageIcon(FileDigitalSignaturesResource.class.getResource("/icon/save_16_16.png"));
    
    /**
     * 比较图标.
     */
    public final static Icon compareIcon = new ImageIcon(FileDigitalSignaturesResource.class.getResource("/icon/compare_16_16.png"));
    
    /**
     * 获取国际化资源文件.
     * 
     * @param baseName 基本名称
     * @param locale 地区对象
     * @return 国际化资源信息对象
     */
    public static ResourceBundle getResource(String baseName, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        
        return bundle;
    }

}
